<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Variable and Function Example</title>
</head>
<body>
    <h1>JSP Example - Variables and Function</h1>
    
    <%!
        public String concatenateIdName(int id, String name) {
            return "ID: " + id + " - Name: " + name;
        }
    %>
    
    <%
        int id = 100;
        String name = "Abraam";
        
        String result = concatenateIdName(id, name);
    %>
    
    <h2>Result:</h2>
    <p><%= result %></p>
    
</body>
</html>