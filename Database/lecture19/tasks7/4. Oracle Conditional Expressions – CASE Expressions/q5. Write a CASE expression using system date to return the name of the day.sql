SELECT CASE TO_CHAR(SYSDATE, 'DY')
           WHEN 'MON' THEN 'Today is Monday'
           WHEN 'TUE' THEN 'Today is Tuesday'
           WHEN 'WED' THEN 'Today is Wednesday'
           WHEN 'THU' THEN 'Today is Thursday'
           WHEN 'FRI' THEN 'Today is Friday'
           WHEN 'SAT' THEN 'Today is Saturday'
           WHEN 'SUN' THEN 'Today is Sunday'
       END AS today_day
FROM dual;