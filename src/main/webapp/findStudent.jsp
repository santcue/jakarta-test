<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 27/04/2024
  Time: 03:42 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find Student</title>
</head>
<body>
<h1>Buscar Estudiante por ID</h1>
<form action="findStudent" method="get">
    <label for="id">ID del Estudiante:</label>
    <input type="text" id="id" name="id" required>
    <button type="submit">Buscar</button>
</form>
</body>
</html>
