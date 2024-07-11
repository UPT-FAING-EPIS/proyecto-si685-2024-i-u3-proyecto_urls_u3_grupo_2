<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Suscripciones</title>
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
            display: block;
        }
        .sidebar li a:hover {
            background-color: #555; /* Cambio de color al pasar el cursor */
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
        <div class="row">
            <!-- Tarjeta 1 -->
            <div class="col-md-4">
                <div class="card text-center">
                    <div class="card-body">
                        <h2 class="card-title">$0</h2>
                        <h5 class="card-subtitle mb-2 text-muted">Free</h5>
                        <ul class="list-unstyled">
                            <li>Acceso limitado</li>
                            <li>Cantidad de urls: 10</li>
                            <li>Publicidad</li>
                            <li>Soporte básico</li>
                        </ul>
                        <form action="ControladorSuscripcion" method="GET">
                            <input type="hidden" name="accion" value="suscribir">
                            <input type="hidden" name="idSuscripcion" value="1">
                            <button type="submit" class="btn btn-primary">Suscríbete</button>
                        </form>
                    </div>
                </div>
            </div>
            <!-- Tarjeta 2 -->
            <div class="col-md-4">
                <div class="card text-center">
                    <div class="card-body">
                        <h2 class="card-title">$20</h2>
                        <h5 class="card-subtitle mb-2 text-muted">VIP</h5>
                        <ul class="list-unstyled">
                            <li>Acceso completo</li>
                            <li>Cantidad de urls: 100</li>
                            <li>Sin publicidad</li>
                            <li>Soporte prioritario</li>
                        </ul>
                        <form action="ControladorSuscripcion" method="GET">
                            <input type="hidden" name="accion" value="suscribir">
                            <input type="hidden" name="idSuscripcion" value="2">
                            <button type="submit" class="btn btn-primary">Suscríbete</button>
                        </form>
                    </div>
                </div>
            </div>
            <!-- Tarjeta 3 -->
            <div class="col-md-4">
                <div class="card text-center">
                    <div class="card-body">
                        <h2 class="card-title">$30</h2>
                        <h5 class="card-subtitle mb-2 text-muted">PRO</h5>
                        <ul class="list-unstyled">
                            <li>Acceso premium</li>
                            <li>Cantidad de urls: ∞ </li>
                            <li>Experiencia sin anuncios</li>
                            <li>Soporte dedicado</li>
                        </ul>
                        <form action="ControladorSuscripcion" method="GET">
                            <input type="hidden" name="accion" value="suscribir">
                            <input type="hidden" name="idSuscripcion" value="3">
                            <button type="submit" class="btn btn-primary">Suscríbete</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JavaScript -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
