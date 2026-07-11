DECLARE
  
    CURSOR c_senior_customers IS
        SELECT c.CustomerID, c.DateOfBirth, l.LoanID, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID;
        
    v_age NUMBER;
BEGIN
    FOR r_cust IN c_senior_customers LOOP
        -- Calculate current age based on Date of Birth
        v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, r_cust.DateOfBirth) / 12);
        
        -- Check if the customer is above 60 years old
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = r_cust.LoanID;
            
            DBMS_OUTPUT.PUT_LINE('Applied 1% discount to Loan ID: ' || r_cust.LoanID || ' for Customer ID: ' || r_cust.CustomerID);
        END IF;
    END LOOP;
    
    -- Commit the changes to the database
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error updating interest rates: ' || SQLERRM);
        ROLLBACK;
END;
/