SELECT 
    name,
    marks,
    DECODE(
        TRUNC(marks/10),
        10, 'A',
        9, 'A',
        8, 'B',
        7, 'C',
        'F'
    ) AS grade
FROM students;
