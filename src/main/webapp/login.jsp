<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jsans
  Date: 05/11/2024
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

  <c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
  </c:if>

  <form method="post" action="/helloweb/movies/login">
    <label for="username">Usuari:</label>
    <input type="text" id="username" required>
    <br>

    <label for="password">Contrasenya:</label>
    <input type="password" id="password" name="password" required>
    <br>

    <input type="submit" value="Entrar">

  </form>
</body>
</html>
