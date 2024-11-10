<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Lista de Películas</title>
</head>
<body>

<h1>Lista de Películas</h1>


<c:if test="${not empty movies}">
  <table border="1">
    <thead>
    <tr>
      <th>Título</th>
      <th>Descripción</th>
      <th>Año</th>
    </tr>
    </thead>
    <tbody>
    <!-- Iteramos sobre las películas y las mostramos -->
    <c:forEach var="movie" items="${movies}">
      <tr>
        <td>${movie.title}</td>
        <td>${movie.description}</td>
        <td>${movie.year}</td>
        <td>
          <form action="/helloweb/movies/update" method="get" style="display:inline;">
            <input type="hidden" name="id" value="${movie.id}" />
            <input type="submit" value="Actualitzar" />
          </form>
          <form action="/helloweb/movies/delete" method="post" style="display:inline;">
            <input type="hidden" name="id" value="${movie.id}"/>
            <input type="submit" value="Eliminar" onclick="return confirm('¿Estás seguro de eliminar esta película?');"/>
          </form>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</c:if>

<c:if test="${empty movies}">
  <p>No se encontraron películas.</p>
</c:if>

<a href="/helloweb/movies/create">Crear nueva película</a>

</body>
</html>