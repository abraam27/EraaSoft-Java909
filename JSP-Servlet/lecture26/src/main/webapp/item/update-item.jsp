<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="item.model.Item" %>

<%
    Item item = (Item) request.getAttribute("item");
    if(item == null) {
        response.sendRedirect("../ItemController?action=show-items");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Update Item</title>
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

<h2>Update Item</h2>

<form action="../ItemController" method="get">
    <input type="hidden" name="action" value="update-item"/>
    <input type="hidden" name="id" value="<%= item.getId() %>" />

    <label>Name:</label>
    <input type="text" name="name" value="<%= item.getName() %>" required />

    <label>Price:</label>
    <input type="number" step="0.01" name="price" value="<%= item.getPrice() %>" required />

    <label>Total Number:</label>
    <input type="number" name="totalNumber" value="<%= item.getTotalNumber() %>" required />

    <button type="submit">Update Item</button>
</form>

<a href="../ItemController?action=show-items">Back to List</a>

</body>
</html>
