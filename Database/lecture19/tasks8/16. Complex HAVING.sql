SELECT department_id,
       AVG(salary) AS avg_salary,
       COUNT(*) AS total_employees
FROM employees
GROUP BY department_id
HAVING AVG(salary) > 8000
   AND COUNT(*) < 10;
