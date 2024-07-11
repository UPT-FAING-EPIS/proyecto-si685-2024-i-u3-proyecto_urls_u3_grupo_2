<%-- 
    Document   : resultado
    Created on : 07/08/2024, 8:57:12 p. m.
    Author     : dales
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultado de Acortar URL</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        body {
            display: flex;
            justify-content: flex-start;
            align-items: flex-start;
            min-height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
            color: #333; /* Texto oscuro */
            background-color: #fff; /* Fondo blanco */
        }
        .sidebar {
            list-style-type: none;
            padding: 0;
            background-color: #444; /* Fondo gris oscuro para la barra de opciones */
            width: 200px;
            height: 100%;
            position: fixed;
            overflow: auto;
        }
        .sidebar li {
            padding: 10px 15px;
        }
        .sidebar li a {
            color: #fff; /* Texto blanco */
            text-decoration: none;
            font-size: 18px;
            display: flex;
            align-items: center;
        }
        .sidebar li a:hover {
            background-color: #555; /* Cambio de color al pasar el cursor */
        }
        .sidebar li a i {
            margin-right: 10px;
        }
        .container {
            margin-left: 220px; /* Margen para evitar solapamiento con la barra de opciones */
            padding: 20px;
            margin-top: 50px; /* Espacio para la barra de navegación */
        }
        h2 {
            margin-top: 20px;
            color: #2353B2; /* Color azul */
            display: flex;
            align-items: center;
        }
        .result-container {
            margin-top: 20px;
            border: 1px solid #ccc;
            padding: 20px;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .label {
            font-weight: bold;
            margin-bottom: 5px;
        }
        p {
            margin: 0;
        }
    </style>
</head>
<body>
    <ul class="sidebar">
        <li><a href="ControladorMenu?accion=inicio"><i class="fas fa-home"></i> Inicio</a></li>
        <li><a href="ControladorPerfil?accion=listar"><i class="fas fa-user"></i> Perfil</a></li>
        <li><a href="ControladorMenu?accion=suscripciones"><i class="fas fa-heart"></i> Suscripciones</a></li>
        <li><a href="ControladorUsuario?accion=logear"><i class="fas fa-sign-out-alt"></i> Cerrar sesión</a></li>
    </ul>

    <div class="container">
        <h2><i class="fas fa-link"></i> Resultado de Acortar URL</h2>

        <div class="result-container">
            <p class="label">URL Original:</p>
            <p>${param.txturlOriginal}</p>

            <p class="label">URL Acortada:</p>
            <p>${shortUrl}</p>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>


