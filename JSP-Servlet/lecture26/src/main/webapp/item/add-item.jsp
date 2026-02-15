<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Item</title>
    <style>
        body { font-family: Arial; margin: 30px; }
        form { width: 300px; }
        label { display: block; margin-top: 10px; }
        input { width: 100%; padding: 6px; margin-top: 5px; }
        button { margin-top: 15px; padding: 8px 15px; }
        a { display: inline-block; margin-top: 15px; }
    </style>
</head>
<body>

<h2>Add New Item</h2>

<form action="../lecture26/ItemController" method="POST">
    <input type="hidden" name="action" value="add-item"/>

    <label>Name:</label>
    <input type="text" name="name" required />

    <label>Price:</label>
    <input type="number" step="0.01" name="price" required />

    <label>Total Number:</label>
    <input type="number" name="totalNumber" required />

    <button type="submit">Add Item</button>
</form>

<a href="../ItemController?action=show-items">Back to List</a>

</body>
</html>
