SELECT name,
       score,
       CASE
           WHEN score >= 90 THEN 'A'
           WHEN score BETWEEN 80 AND 89 THEN 'B'
           WHEN score BETWEEN 70 AND 79 THEN 'C'
           ELSE 'F'
       END AS grade
FROM student;