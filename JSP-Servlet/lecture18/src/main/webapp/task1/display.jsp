<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Information</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            padding: 40px;
        }

        .card {
            background: #ffffff;
            width: 300px;
            margin: auto;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        p {
            font-size: 16px;
            margin: 10px 0;
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

    <div class="card">
        <h2>User Information</h2>

        <%
            String fullName = request.getParameter("fullName");
            String age = request.getParameter("age");
        %>

        <p><strong>Full Name:</strong> <%= fullName %></p>
        <p><strong>Age:</strong> <%= age %></p>

        <a href="form.html">Back</a>
    </div>

</body>
</html>
