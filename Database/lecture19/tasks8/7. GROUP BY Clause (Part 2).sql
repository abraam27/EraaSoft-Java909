SELECT job_id,
       COUNT(*) AS total_employees
FROM employees
GROUP BY job_id;
