SELECT EMPLOYEE_ID ,
       INITCAP(FIRST_NAME) AS FIRST_NAME,
       INITCAP(LAST_NAME) AS LAST_NAME,
       SALARY,
       MANAGER_ID,
       JOB_ID,
       HIRE_DATE,
       COMMISSION_PCT,
       Department_ID
FROM Employees;