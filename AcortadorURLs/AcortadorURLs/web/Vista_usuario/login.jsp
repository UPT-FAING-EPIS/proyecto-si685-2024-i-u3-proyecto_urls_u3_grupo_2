<%-- 
    Document   : login
    Created on : 07/08/2024, 2:07:59 a. m.
    Author     : dales
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #333;
            font-family: Arial, sans-serif;
        }
        .login-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
            width: 350px;
            animation:tracking-in-expand-forward-top 0.4s linear both;
        }
        .login-container h1 {
            margin-bottom: 20px;
        }
        .login-container form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .login-container label {
            margin: 10px 0 5px;
            text-align: left;
            width: 100%;
        }
        .login-container input[type="email"],
        .login-container input[type="password"] {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 15px;
            width: calc(100% - 40px); 
        }
        .login-container input[type="submit"] {
            padding: 10px;
            background-color: #2353B2;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-transform: uppercase;
            width: 100%;
        }
        .login-container input[type="submit"]:hover {
            background-color: #1b469a;
        }
        .input-icon {
            display: flex;
            align-items: center;
            width: 100%;
            margin-bottom: 15px;
        }
        .input-icon i {
            margin-right: 10px;
            color: #999;
        }
        .error-message {
            color: red;
            margin-bottom: 15px;
        }
        @keyframes tracking-in-expand-forward-top
        {
            0%
            {letter-spacing:-.2em;transform:translateZ(-700px) translateY(-100px);opacity:0
            }
            40%
            {opacity:.6
            }
            100%
            {transform:translateZ(0) translateY(0);opacity:1}
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h1>Login</h1>
        <%-- Mostrar mensaje de error si existe --%>
        <c:if test="${not empty mensajeError}">
            <p class="error-message">${mensajeError}</p>
        </c:if>
        
        <form action="ControladorUsuario" method="GET">
            <div class="input-icon">
                <i class="fas fa-envelope"></i>
                <input type="email" id="txtcorreo" name="txtcorreo" placeholder="Correo Electrónico" required>
            </div>
            <div class="input-icon">
                <i class="fas fa-lock"></i>
                <input type="password" id="txtcontraseña" name="txtcontraseña" placeholder="Contraseña" required>
            </div>
            <input type="submit" name="accion" value="Ingresar">
        </form>
    </div>
</body>
</html>

