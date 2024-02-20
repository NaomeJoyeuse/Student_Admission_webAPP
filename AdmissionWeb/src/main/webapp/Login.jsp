<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2/18/2024
  Time: 3:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>
  <link rel="stylesheet" href="Style.css">
</head>
<body>
<div class="container">
  <h1>Login </h1>
  <form action="LoginServlet" method="post">

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>

    <button type="submit">Login</button>

  </form>
  <h3>
          <% Object resultAttribute = request.getAttribute("result");
  if (resultAttribute != null){
    %>
  <%= resultAttribute%>

<%
  }
  %>
  </h3>
</div>
</body>
</html>
