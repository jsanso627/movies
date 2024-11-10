<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Película</title>
</head>
<body>
<h1>Formulario para Crear una Película</h1>

<form action="/helloweb/movies/create" method="post">
    <label for="title">Título:</label>
    <input type="text" id="title" name="title" required>
    <br><br>

    <label for="description">Descripción:</label>
    <textarea id="description" name="description" rows="4" cols="50" required></textarea>
    <br><br>

    <label for="year">Año:</label>
    <input type="number" id="year" name="year" min="1900" max="2100" required>
    <br><br>

    <input type="submit" value="Crear Película">
</form>

</body>
</html>