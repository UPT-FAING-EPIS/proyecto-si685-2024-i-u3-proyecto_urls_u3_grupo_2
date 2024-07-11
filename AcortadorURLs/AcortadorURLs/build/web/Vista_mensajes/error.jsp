<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style>
        /* Estilos para el mensaje flotante */
        .floating-message {
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: rgba(0, 0, 0, 0.8);
            color: white;
            padding: 20px;
            border-radius: 5px;
            z-index: 1000; /* Asegura que esté sobre otros elementos */
            display: none; /* Inicialmente oculto */
        }
    </style>
</head>
<body>
    <!-- Mensaje flotante de acortamiento de URL -->
    <div id="floatingMessage" class="floating-message">
        Acortando URL, por favor espere...
    </div>

    <!-- Script para mostrar el mensaje flotante y recargar la página -->
    <script>
        document.addEventListener("DOMContentLoaded", function() {
            // Mostrar el mensaje flotante al cargar la página
            var floatingMessage = document.getElementById("floatingMessage");
            floatingMessage.style.display = "block";

            // Recargar la página después de un breve retraso (ejemplo: 2 segundos)
            setTimeout(function() {
                location.reload();
            }, 2000); // 2000 milisegundos = 2 segundos
        });
    </script>
</body>
</html>
