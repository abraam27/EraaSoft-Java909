<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 40px;
        }

        .box {
            background: #fff;
            width: 350px;
            margin: auto;
            padding: 20px;
            border-radius: 6px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            text-align: center;
        }

        .place {
            font-size: 18px;
            color: #333;
            margin: 15px 0;
        }

        a {
            display: inline-block;
            margin-top: 15px;
            text-decoration: none;
            color: #0066cc;
        }
    </style>
</head>
<body>

<%
    String favPlace = request.getParameter("favPlace");
    String savedPlace = null;

    if (favPlace != null && !favPlace.trim().isEmpty()) {
        Cookie cookie = new Cookie("favPlace", favPlace);
        cookie.setMaxAge(60 * 60 * 24 * 30);
        response.addCookie(cookie);

        savedPlace = favPlace;
    } else {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("favPlace".equals(c.getName())) {
                    savedPlace = c.getValue();
                    break;
                }
            }
        }
    }
%>


<div class="box">
    <h2>Home Page</h2>

    <%
        if (savedPlace != null) {
    %>
        <div class="place">
            Your favorite place is:
            <strong><%= savedPlace %></strong>
        </div>
    <%
        } else {
    %>
        <div class="place">
            No favorite place saved yet.
        </div>
    <%
        }
    %>

    <a href="start.html">Change Favorite Place</a>
</div>

</body>
</html>
