<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Crear Registro</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<header>
    <h1>Crear Nuevo Registro</h1>
</header>
<main>
    <form id="createForm">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required>
        <br>
        <label for="descripcion">Descripción:</label>
        <input type="text" id="descripcion" name="descripcion" required>
        <br>
        <button type="submit">Crear</button>
    </form>
    <div id="response"></div>
</main>
<script src="js/create.js"></script>
</body>
</html>
