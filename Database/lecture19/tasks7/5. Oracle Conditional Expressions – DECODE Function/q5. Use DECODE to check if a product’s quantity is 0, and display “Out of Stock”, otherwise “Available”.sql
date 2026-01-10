SELECT product_name,
       DECODE(quantity, 0, 'Out of Stock', 'Available') AS availability
FROM products;