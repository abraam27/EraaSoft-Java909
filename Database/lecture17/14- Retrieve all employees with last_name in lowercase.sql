SELECT EMPLOYEE_ID ,
       FIRST_NAME,
       LOWER(LAST_NAME) AS LAST_NAME,
       SALARY,
       MANAGER_ID,
       JOB_ID,
       HIRE_DATE,
       COMMISSION_PCT,
       Department_ID
FROM Employees;