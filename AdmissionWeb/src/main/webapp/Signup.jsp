<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2/18/2024
  Time: 3:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignUp</title>
    <link rel="stylesheet" href="Style.css">
</head>
<body>

<div class="container">
    <h1>Sign Up Student </h1>
    <form action="SignupServlet" method="post">

        <label for="fullName">Full Name:</label>
        <input type="text" id="fullName" name="fullName" required>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>

        <button type="submit">Sign Up</button>
    </form>
</div>
</body>
</html>
