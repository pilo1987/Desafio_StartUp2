<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Permisos Insuficientes</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        color: #333;
        text-align: center;
        margin: 0;
        padding: 0;
    }
    .container {
        width: 80%;
        max-width: 600px;
        margin: 50px auto;
        padding: 20px;
        background: #fff;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }
    h1 {
        color: #e74c3c;
    }
    p {
        font-size: 16px;
        line-height: 1.5;
    }
    a {
        color: #3498db;
        text-decoration: none;
    }
    a:hover {
        text-decoration: underline;
    }
    .error-icon {
            font-size: 100px; /* Tamaño grande para la "X" */
            color: red;       /* Color rojo para llamar la atención */
            text-align: center; /* Centrar la "X" */
            margin: 20px 0;   /* Espacio alrededor de la "X" */
        }
</style>
</head>
<body>
<div class="container">
    <h1>Permisos Insuficientes</h1>
    <p>Lo siento, pero no tienes los permisos necesarios para acceder a esta página.</p>
        <div class="error-icon">X</div> <!-- La "X" grande y roja -->
    <p><a href="index.jsp">Volver a la página principal</a></p>
</div>
</body>
</html>