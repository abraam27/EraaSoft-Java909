<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Food</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 40px;
        }
        .box {
            background: #fff;
            width: 300px;
            margin: auto;
            padding: 20px;
            border-radius: 6px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            text-align: center;
        }
        input[type="text"] {
            width: 90%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            padding: 8px 15px;
            border: none;
            background-color: #4CAF50;
            color: white;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        a {
            display: block;
            margin-top: 15px;
            text-decoration: none;
            color: #0066cc;
        }
    </style>
</head>
<body>

<div class="box">
    <h2>Order Food</h2>

    <form action="order.jsp" method="post">
        <input type="text" name="food" placeholder="Enter food name">
        <br>
        <input type="submit" value="Add Order">
    </form>

    <%
        String food = request.getParameter("food");

        List<String> orders = (List<String>) session.getAttribute("orders");
        if (orders == null) {
            orders = new ArrayList<>();
            session.setAttribute("orders", orders);
        }

        if (food != null && !food.trim().isEmpty()) {
            orders.add(food);
        }
    %>

    <a href="allorders.jsp">View All Orders</a>
</div>

</body>
</html>
