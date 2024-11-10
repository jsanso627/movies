<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Eliminar Película</title>
</head>
<body>

<h1>Eliminar Película</h1>

<c:if test="${not empty movies}">
  <table border="1">
    <thead>
    <tr>
      <th>Título</th>
      <th>Descripción</th>
      <th>Año</th>
      <th>Acción</th>
    </tr>
    </thead>
    <tbody>
    <!-- Itera sobre la lista de películas -->
    <c:forEach var="movie" items="${movies}">
      <tr>
        <td>${movie.title}</td>
        <td>${movie.description}</td>
        <td>${movie.year}</td>
        <td>
          <!-- Botón para eliminar, pasa el id de la película -->
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
  <p>No hay películas para mostrar.</p>
</c:if>

</body>
</html>