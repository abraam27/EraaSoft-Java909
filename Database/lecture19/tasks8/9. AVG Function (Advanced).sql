SELECT AVG(commission_pct) AS avg_commission
FROM employees
WHERE commission_pct IS NOT NULL;
