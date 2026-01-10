SELECT emp_name,
       department,
       DECODE(department,
              'HR', 500,
              'IT', 1000,
              'Sales', 1500,
              300) AS bonus
FROM emp;