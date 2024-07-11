<%@page import="Modelo.URLS"%>
<%@page import="Modelo.Usuarioss"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil</title>
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
        .card {
            margin-bottom: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .card-body {
            padding: 20px;
        }
        .card-title {
            font-size: 28px;
            font-weight: bold;
            color: #2353B2; /* Color azul */
        }
        .card-subtitle {
            font-size: 20px;
            color: #777; /* Color gris */
            margin-bottom: 10px;
        }
        .list-unstyled {
            text-align: left;
            margin-bottom: 20px;
        }
        .list-unstyled li {
            padding: 5px 0;
        }
        .btn-primary {
            background-color: #2353B2; /* Fondo azul */
            color: #fff; /* Texto blanco */
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            text-transform: uppercase;
        }
        .btn-primary:hover {
            background-color: #1b469a; /* Cambio de color al pasar el cursor */
        }
        table {
            width: 100%;
            margin-top: 20px;
            border-collapse: collapse;
        }
        table th, table td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        table th {
            background-color: #f2f2f2; /* Color de fondo gris claro para encabezados */
            color: #333; /* Color de texto oscuro */
        }
        table td {
            vertical-align: middle;
        }
        .row {
            margin-bottom: 20px;
        }
        h2 {
            margin-bottom: 20px;
            color: #2353B2; /* Color azul */
            display: flex;
            align-items: center;
        }
        h2 i {
            margin-right: 10px;
        }
        p {
            margin-bottom: 10px;
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

    <div class="container mt-5">
        <div class="row">
            <!-- Sección de Datos Personales -->
            <div class="col-md-6">
                <h2><i class="fas fa-user"></i> Datos Personales</h2>
                <p><strong>Nombre:</strong> <%= request.getAttribute("nombre") %></p>
                <p><strong>Correo:</strong> <%= request.getAttribute("correo") %></p>
            </div>

            <!-- Sección de Tipo de Suscripción -->
            <div class="col-md-6">
                <h2><i class="fas fa-heart"></i> Suscripción</h2>
                <p><strong>Tipo:</strong> <%= request.getAttribute("suscripcion") %></p>
            </div>
        </div>

        <!-- Sección de URLs Acortados -->
        <div class="row mt-5">
            <div class="col-md-12">
                <h2><i class="fas fa-link"></i> URLs Acortados</h2>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>URL Original</th>
                            <th>URL Acortada</th> 
                            <th>Fecha de Creación</th>                             
                            <th>Estado de Validez</th>                            
                        </tr>
                    </thead>
                    <tbody>
                        <% 
                            List<URLS> urls = (List<URLS>) request.getAttribute("urls");
                            if (urls != null) {
                                for(URLS url : urls) {
                        %>
                        <tr>
                            <td><%= url.getUrl_original() %></td>
                            <td><a href="<%= url.getUrl_acortada() %>"><%= url.getUrl_acortada() %></a></td>
                            <td><%= url.getFecha_creacion() %></td>
                            <td><%= url.getEstado_validez() %></td>
                        </tr>
                        <% 
                                }
                            } else {
                        %>
                        <tr>
                            <td colspan="4">No se encontraron URLs</td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>

        <!-- Sección de Contador de Links -->
        <div class="row mt-5">
            <div class="col-md-12">
                <h2><i class="fas fa-chart-line"></i> Contador de Links Restantes</h2>
                <% 
                    String suscripcion = (String) request.getAttribute("suscripcion");
                    int contadorLinks = (int) request.getAttribute("contadorLinks");

                    if (suscripcion != null) {  // Verificar que suscripcion no sea nulo
                        if (suscripcion.equals("VIP")) {
                            int limite = 100; // Cambiar según el límite de VIP
                            int restantes = limite - contadorLinks;
                %>
                            <p><%= restantes %> links restantes de <%= limite %> (Plan VIP)</p>
                <% 
                        } else if (suscripcion.equals("PRO")) { 
                %>
                            <p>Plan PRO (ilimitado)</p>
                <% 
                        } else if (suscripcion.equals("Free")) {
                            int limite = 10;
                            int restantes = limite - contadorLinks;
                %>
                            <p><%= restantes %> links restantes de <%= limite %> (Plan Free)</p>
                <% 
                        } else {
                %>
                            <p>No se reconoce el tipo de suscripción: <%= suscripcion %></p>
                <% 
                        }
                    } else {
                %>
                        <p>No se pudo obtener el tipo de suscripción.</p>
                <% } %>

            </div>
        </div>


    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
