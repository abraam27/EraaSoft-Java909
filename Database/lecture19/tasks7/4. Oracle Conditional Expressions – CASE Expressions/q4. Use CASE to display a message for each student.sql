SELECT name,
       score,
       CASE
           WHEN score >= 90 THEN 'Excellent'
           WHEN score BETWEEN 80 AND 89 THEN 'Good'
           WHEN score BETWEEN 70 AND 79 THEN 'Average'
           ELSE 'Needs Improvement'
       END AS performance
FROM student;