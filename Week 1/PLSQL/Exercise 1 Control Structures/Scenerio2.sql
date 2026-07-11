DECLARE
   
    CURSOR c_customer_balances IS
        SELECT CustomerID, Balance
        FROM Customers;
BEGIN
    FOR r_cust IN c_customer_balances LOOP
        IF r_cust.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = r_cust.CustomerID;
            
            DBMS_OUTPUT.PUT_LINE('Customer ID: ' || r_cust.CustomerID || ' promoted to VIP status.');
        END IF;
    END LOOP;
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error updating VIP status: ' || SQLERRM);
        ROLLBACK;
END;
/