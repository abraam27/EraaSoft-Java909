SELECT manager_id,
       SUM(salary) AS total_salary
FROM employees
GROUP BY manager_id;
