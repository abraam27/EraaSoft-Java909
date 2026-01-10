SELECT TRIM('*' FROM full_name) AS trimmed_star,
       TRIM('$' FROM full_name) AS trimmed_dollar
FROM customers;