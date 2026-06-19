-- 1. Insert Employee Procedure
DELIMITER //
CREATE PROCEDURE sp_insert_employee(
    IN p_username VARCHAR(30),
    IN p_password VARCHAR(30),
    IN p_fullname VARCHAR(100),
    IN p_address VARCHAR(200),
    IN p_salary INT
)
BEGIN
    INSERT INTO employee(username, password, full_name, address, salary) 
    VALUES (p_username, p_password, p_fullname, p_address, p_salary);
END //
DELIMITER ;

-- 2. Read/Verify Employee Procedure
DELIMITER //
CREATE PROCEDURE sp_read_employee(
    IN p_username VARCHAR(30),
    IN p_password VARCHAR(30)
)
BEGIN
    SELECT * FROM employee WHERE username = p_username AND password = p_password;
END //
DELIMITER ;

-- 3. Update Employee Salary Procedure
DELIMITER //
CREATE PROCEDURE sp_update_employee_salary(
    IN p_username VARCHAR(30),
    IN p_salary INT,
    OUT p_rows_affected INT
)
BEGIN
    UPDATE employee SET salary = p_salary WHERE username = p_username;
    SET p_rows_affected = ROW_COUNT();
END //
DELIMITER ;

-- 4. Delete Employee Procedure
DELIMITER //
CREATE PROCEDURE sp_delete_employee(
    IN p_username VARCHAR(30),
    OUT p_rows_affected INT
)
BEGIN
    DELETE FROM employee WHERE username = p_username;
    SET p_rows_affected = ROW_COUNT();
END //
DELIMITER ;

-- 5. Display All Employees Procedure
DELIMITER //
CREATE PROCEDURE sp_display_all_employees()
BEGIN
    SELECT * FROM employee;
END //
DELIMITER ;