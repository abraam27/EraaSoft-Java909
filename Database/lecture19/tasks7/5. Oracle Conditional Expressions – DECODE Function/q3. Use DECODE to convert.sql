SELECT status_code,
       DECODE(status_code,
              'N', 'New',
              'I', 'In Progress',
              'C', 'Completed',
              'Unknown') AS status_full
FROM status_log;