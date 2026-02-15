<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="item.model.Item" %>

<!DOCTYPE html>
<html>
<head>
    <title>All Items</title>
    <style>
        body { font-family: Arial; margin: 30px; }
        table { border-collapse: collapse; width: 70%; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: center; }
        th { background-color: #f2f2f2; }
        a { margin: 0 5px; text-decoration: none; }
    </style>
</head>
<body>

<h2>Items List</h2>

<a href="http://localhost:8080/lecture26/ItemController?action=add-item&name=&price=&totalnumber=">Add New Item</a>
<br><br>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Total Number</th>
        <th>Actions</th>
    </tr>

<%
    List<Item> items = (List<Item>) request.getAttribute("allItems");

    if (items != null && !items.isEmpty()) {
        for (Item item : items) {
%>
    <tr>
        <td><%= item.getId() %></td>
        <td><%= item.getName() %></td>
        <td><%= item.getPrice() %></td>
        <td><%= item.getTotalNumber() %></td>
        <td>
            <a href="ItemController?action=show-item&id=<%= item.getId() %>">Edit</a>
            |
            <a href="ItemController?action=delete-item&id=<%= item.getId() %>"
               onclick="return confirm('Are you sure?');">Delete</a>
        </td>
    </tr>
<%
        }
    } else {
%>
    <tr>
        <td colspan="5">No items found</td>
    </tr>
<%
    }
%>

</table>

</body>
</html>
