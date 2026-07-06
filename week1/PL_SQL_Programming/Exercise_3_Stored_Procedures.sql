-- Exercise 3: Stored Procedures

-- Scenario 1: Stored procedure ProcessMonthlyInterest.
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01
    WHERE AccountType = 'Savings';

    DBMS_OUTPUT.PUT_LINE('ProcessMonthlyInterest success: Applied 1% interest to all savings accounts.');
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error processing monthly interest: ' || SQLERRM);
END;
/

-- Scenario 2: Stored procedure UpdateEmployeeBonus.
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department VARCHAR2,
    p_bonus_percent NUMBER
) AS
BEGIN
    UPDATE Employees
    SET Salary = Salary * (1 + p_bonus_percent/100)
    WHERE Department = p_department;

    DBMS_OUTPUT.PUT_LINE('UpdateEmployeeBonus success: Applied ' || p_bonus_percent || '% bonus to department ' || p_department);
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating employee bonus: ' || SQLERRM);
END;
/

-- Scenario 3: Stored procedure TransferFunds.
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account NUMBER,
    p_to_account   NUMBER,
    p_amount       NUMBER
) AS
    v_balance NUMBER;
BEGIN
    -- Check balance
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from_account;

    IF v_balance < p_amount THEN
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in Account ' || p_from_account);
        RETURN;
    END IF;

    -- Debit source
    UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from_account;
    
    -- Credit destination
    UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to_account;

    DBMS_OUTPUT.PUT_LINE('TransferFunds success: Transferred $' || p_amount || ' from ' || p_from_account || ' to ' || p_to_account);
    COMMIT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: Account ID not found.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error transferring funds: ' || SQLERRM);
END;
/
