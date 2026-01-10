SELECT name,
       score,
       CASE
           WHEN score >= 60 THEN 'Pass'
           ELSE 'Fail'
       END AS pass_fail
FROM student;