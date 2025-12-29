<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Orders</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            padding: 40px;
        }

        .container {
            background: #ffffff;
            width: 350px;
            margin: auto;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 15px;
        }

        ul {
            padding-left: 20px;
        }

        li {
            background: #eef2f5;
            margin-bottom: 8px;
            padding: 8px;
            border-radius: 4px;
        }

        p {
            text-align: center;
            color: #666;
        }

        a {
            display: block;
            text-align: center;
            margin-top: 15px;
            text-decoration: none;
            color: #007bff;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>All Orders</h2>

        <%
            List<String> orders =
                (List<String>) session.getAttribute("orders");

            if (orders == null || orders.isEmpty()) {
        %>
            <p>No orders yet.</p>
        <% } else { %>
            <ul>
                <%for (String order : orders) {%>
                    <li><%= order %></li>
                <%}%>
            </ul>
        <%}%>

        <a href="order.jsp">Back to Order</a>
    </div>

</body>
</html>
