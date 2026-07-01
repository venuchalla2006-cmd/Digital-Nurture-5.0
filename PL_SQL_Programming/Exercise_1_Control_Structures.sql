-- Exercise 1: Control Structures

-- Scenario 1: Apply 1% discount to loan interest rates for customers above 60 years old.
DECLARE
    CURSOR c_loans IS
        SELECT l.LoanID, l.InterestRate, c.DOB, c.Name
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID;
    
    v_age NUMBER;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Running Scenario 1 (Loan Interest Discount for Over 60) ---');
    FOR r_loan IN c_loans LOOP
        v_age := MONTHS_BETWEEN(SYSDATE, r_loan.DOB) / 12;
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = r_loan.LoanID;
            
            DBMS_OUTPUT.PUT_LINE('Applied 1% discount to Loan ID: ' || r_loan.LoanID || ' for customer: ' || r_loan.Name);
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 2: Promote customers to VIP based on balance.
-- Iterate through all customers and set IsVIP to 'TRUE' for those with balance over $10,000.
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Running Scenario 2 (VIP Status Promotion) ---');
    FOR r_cust IN (SELECT CustomerID, Balance, Name FROM Customers) LOOP
        IF r_cust.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = r_cust.CustomerID;
            
            DBMS_OUTPUT.PUT_LINE('Promoted customer ' || r_cust.Name || ' (ID: ' || r_cust.CustomerID || ') to VIP status.');
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 3: Send reminders to customers whose loans are due within the next 30 days.
DECLARE
    CURSOR c_due_loans IS
        SELECT l.LoanID, c.Name, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Running Scenario 3 (Upcoming Loan Due Reminders) ---');
    FOR r_due IN c_due_loans LOOP
        DBMS_OUTPUT.PUT_LINE('REMINDER: Loan ID ' || r_due.LoanID || ' for customer ' || r_due.Name || ' is due on ' || TO_CHAR(r_due.EndDate, 'YYYY-MM-DD'));
    END LOOP;
END;
/
