<%-- 
    Document   : Contraincorrecta
    Created on : 07/11/2024, 3:42:38 a. m.
    Author     : dales
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mensaje Flotante</title>
    <style>
        .mensaje-flotante {
            display: none;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: #fff;
            border: 1px solid #ccc;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            z-index: 1000;
        }
        .mensaje-flotante.active {
            display: block;
        }
        .overlay {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
            z-index: 999;
            display: none;
        }
        .overlay.active {
            display: block;
        }
    </style>
</head>
<body>
    <div class="mensaje-flotante" id="mensajeFlotante">
        <h2>Mensaje Flotante</h2>
        <p>Este es un mensaje flotante en la página.</p>
        <button onclick="cerrarMensaje()">Cerrar</button>
    </div>
    <div class="overlay" id="overlay"></div>

    <!-- Botón para simular iniciar sesión -->
    <button onclick="mostrarMensaje()">Iniciar Sesión</button>

    <script>
        function mostrarMensaje() {
            var mensaje = document.getElementById('mensajeFlotante');
            var overlay = document.getElementById('overlay');
            mensaje.classList.add('active');
            overlay.classList.add('active');
        }

        function cerrarMensaje() {
            var mensaje = document.getElementById('mensajeFlotante');
            var overlay = document.getElementById('overlay');
            mensaje.classList.remove('active');
            overlay.classList.remove('active');
        }
    </script>
</body>
</html>

