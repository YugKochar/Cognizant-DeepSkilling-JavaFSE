
SET SERVEROUTPUT ON;


-- SCENARIO 1: Process Monthly Interest for Savings Accounts

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
    -- Cursor to select all savings accounts
    CURSOR c_savings_accounts IS
        SELECT AccountID, Balance
        FROM Accounts
        WHERE AccountType = 'Savings';
        
    v_interest_amount NUMBER;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- PROCESSING MONTHLY INTEREST ---');
    
    FOR r_acc IN c_savings_accounts LOOP
        -- Calculate 1% interest
        v_interest_amount := r_acc.Balance * 0.01;
        
        -- Update the account balance with the interest added
        UPDATE Accounts
        SET Balance = Balance + v_interest_amount
        WHERE AccountID = r_acc.AccountID;
        
        DBMS_OUTPUT.PUT_LINE('Processed 1% interest for Account ID: ' || r_acc.AccountID || 
                             '. Added Amount: $' || TO_CHAR(v_interest_amount, '9999.99'));
    END LOOP;
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error processing monthly interest: ' || SQLERRM);
        ROLLBACK;
END ProcessMonthlyInterest;
/


-- SCENARIO 2: Update Employee Bonus Based on Department

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_DepartmentID IN VARCHAR2,
    p_BonusPercentage IN NUMBER
) IS
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- UPDATING EMPLOYEE BONUSES ---');
    
    -- Update employee salaries by adding the bonus percentage
    UPDATE Employees
    SET Salary = Salary * (1 + (p_BonusPercentage / 100))
    WHERE DepartmentID = p_DepartmentID;
    
    -- Check if any rows were modified
    IF SQL%ROWCOUNT > 0 THEN
        DBMS_OUTPUT.PUT_LINE('Successfully applied a ' || p_BonusPercentage || 
                             '% bonus to all employees in Department: ' || p_DepartmentID);
    ELSE
        DBMS_OUTPUT.PUT_LINE('No employees found in Department: ' || p_DepartmentID);
    END IF;
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error updating employee bonuses: ' || SQLERRM);
        ROLLBACK;
END UpdateEmployeeBonus;
/


-- SCENARIO 3: Secure Fund Transfer Between Accounts

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_SourceAccountID IN VARCHAR2,
    p_DestAccountID IN VARCHAR2,
    p_Amount IN NUMBER
) IS
    v_SourceBalance NUMBER;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- INITIATING FUNDS TRANSFER ---');

    -- Validate that transfer amount is positive
    IF p_Amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Transfer amount must be greater than zero.');
    END IF;

    -- Fetch and lock the source account row to prevent race conditions
    SELECT Balance INTO v_SourceBalance
    FROM Accounts
    WHERE AccountID = p_SourceAccountID
    FOR UPDATE;
    
    -- Step 1: Check for sufficient balance
    IF v_SourceBalance < p_Amount THEN
        RAISE_APPLICATION_ERROR(-20002, 'Insufficient funds in the source account. Available: $' || v_SourceBalance);
    END IF;
    
    -- Step 2: Debit the source account
    UPDATE Accounts
    SET Balance = Balance - p_Amount
    WHERE AccountID = p_SourceAccountID;
    
    -- Step 3: Credit the destination account
    UPDATE Accounts
    SET Balance = Balance + p_Amount
    WHERE AccountID = p_DestAccountID;
    
    -- Verify if destination account exists
    IF SQL%ROWCOUNT = 0 THEN
        RAISE_APPLICATION_ERROR(-20003, 'Destination account does not exist.');
    END IF;
    
    -- Complete the unit of work successfully
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Successfully transferred $' || p_Amount || ' from Account ' || 
                         p_SourceAccountID || ' to Account ' || p_DestAccountID);
                         
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: Source account ID ' || p_SourceAccountID || ' not found.');
        ROLLBACK;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Transaction failed and rolled back: ' || SQLERRM);
        ROLLBACK;
END TransferFunds;
/