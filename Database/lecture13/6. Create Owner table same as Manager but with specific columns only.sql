CREATE TABLE Owner AS 
SELECT id, full_name AS name, birth_date 
FROM Manger
WHERE 1=0;