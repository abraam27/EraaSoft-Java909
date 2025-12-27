<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background-color: #f4f4f4;
        }
        .form-container {
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        h2 {
            color: #333;
            text-align: center;
        }
        .form-group {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #555;
        }
        input[type="text"],
        input[type="password"],
        input[type="number"],
        select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 14px;
        }
        .radio-group {
            margin-top: 5px;
        }
        .radio-group label {
            display: inline-block;
            margin-right: 15px;
            font-weight: normal;
        }
        input[type="radio"] {
            margin-right: 5px;
        }
        input[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            font-weight: bold;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>User Form</h2>
        
        <form action="display.jsp" method="post">
            
            <div class="form-group">
                <label for="fullName">Full Name:</label>
                <input type="text" id="fullName" name="fullName" required>
            </div>
            
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            
            <div class="form-group">
                <label for="age">Age:</label>
                <input type="number" id="age" name="age" min="1" max="120" required>
            </div>
            
            <div class="form-group">
                <label>Address (Radio):</label>
                <div class="radio-group">
                    <label>
                        <input type="radio" name="addressRadio" value="Cairo" required>
                        Cairo
                    </label>
                    <label>
                        <input type="radio" name="addressRadio" value="Alex">
                        Alex
                    </label>
                    <label>
                        <input type="radio" name="addressRadio" value="Menofia">
                        Menofia
                    </label>
                </div>
            </div>
            
            <div class="form-group">
                <label for="addressSelect">Address (Select):</label>
                <select id="addressSelect" name="addressSelect" required>
                    <option value="">-- Choose Address --</option>
                    <option value="Cairo">Cairo</option>
                    <option value="Alex">Alex</option>
                    <option value="Menofia">Menofia</option>
                </select>
            </div>
            
            <input type="submit" value="Submit">
            
        </form>
    </div>
</body>