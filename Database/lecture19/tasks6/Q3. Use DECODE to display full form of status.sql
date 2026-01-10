SELECT 
    STATUS,
    DECODE(
        STATUS,
        'P', 'Pending',
        'S', 'Shipped',
        'D', 'Delivered',
        'Unknown'
    ) AS STATUS_FULL
FROM ORDERS;
