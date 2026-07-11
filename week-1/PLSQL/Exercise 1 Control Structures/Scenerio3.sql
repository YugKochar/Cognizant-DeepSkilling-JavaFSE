DECLARE
    -- Cursor to fetch loans due within the next 30 days
    CURSOR c_due_loans IS
        SELECT c.CustomerID, c.CustomerName, l.LoanID, l.DueDate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND (SYSDATE + 30);
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- LOAN DUE REMINDERS (NEXT 30 DAYS) ---');
    
    FOR r_loan IN c_due_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder sent to ' || r_loan.CustomerName || 
                             ' (ID: ' || r_loan.CustomerID || '). ' ||
                             'Your Loan ID: ' || r_loan.LoanID || 
                             ' is due on ' || TO_CHAR(r_loan.DueDate, 'YYYY-MM-DD') || '.');
    END LOOP;
END;
/