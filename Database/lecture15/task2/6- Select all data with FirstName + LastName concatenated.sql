SELECT
    EmployeeID,
    FirstName || ' ' || LastName AS FullName,
    Department,
    Salary
FROM Employees;