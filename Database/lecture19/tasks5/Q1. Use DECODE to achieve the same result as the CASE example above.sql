SELECT 
    NAME,
    MARKS,
    DECODE(
        TRUNC(MARKS/10),
        9, 'A',
        8, 'B',
        7, 'C',
        'F'
    ) AS GRADE
FROM STUDENTS;
