<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Display User Information</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background-color: #f4f4f4;
        }
        .display-container {
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        h2 {
            color: #333;
            text-align: center;
            margin-bottom: 30px;
        }
        .info-row {
            padding: 15px;
            margin-bottom: 10px;
            background-color: #f9f9f9;
            border-left: 4px solid #4CAF50;
            border-radius: 4px;
        }
        .info-label {
            font-weight: bold;
            color: #555;
            display: inline-block;
            width: 180px;
        }
        .info-value {
            color: #333;
        }
        .back-link {
            display: block;
            text-align: center;
            margin-top: 30px;
            padding: 10px;
            background-color: #2196F3;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }
        .back-link:hover {
            background-color: #0b7dda;
        }
    </style>
</head>
<body>
    <div class="display-container">
        <h2>User Information Received</h2>
        
        <%
            // Receive all input parameters from the form
            String fullName = request.getParameter("fullName");
            String password = request.getParameter("password");
            String age = request.getParameter("age");
            String addressRadio = request.getParameter("addressRadio");
            String addressSelect = request.getParameter("addressSelect");
        %>
        
        <div class="info-row">
            <span class="info-label">Full Name:</span>
            <span class="info-value"><%= fullName %></span>
        </div>
        
        <div class="info-row">
            <span class="info-label">Password:</span>
            <span class="info-value"><%= password %></span>
        </div>
        
        <div class="info-row">
            <span class="info-label">Age:</span>
            <span class="info-value"><%= age %></span>
        </div>
        
        <div class="info-row">
            <span class="info-label">Address (Radio Button):</span>
            <span class="info-value"><%= addressRadio %></span>
        </div>
        
        <div class="info-row">
            <span class="info-label">Address (Select Input):</span>
            <span class="info-value"><%= addressSelect %></span>
        </div>
        
        <a href="form.jsp" class="back-link">← Back to Form</a>
    </div>
</body>