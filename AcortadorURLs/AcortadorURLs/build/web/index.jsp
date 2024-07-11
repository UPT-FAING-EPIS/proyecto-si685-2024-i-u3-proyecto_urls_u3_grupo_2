<%@page import="ModeloDAO.UsuariosDAO"%>
<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <style>
        *{
            margin: 0;
            padding:0;
            box-sizing: border-box;
            font-family: 'poppins',sans-serif;
            
        }
        .banner img {
            max-width: 100%;
            height: auto;
            display: block;
        }

        .banner .clouds{
            position:absolute;
            top:0;
            left:0;
            width: 100%;
            height: 100%;
            overflow:hidden;
        }

        .banner .clouds img{
            position:absolute;
            bottom: 0;
            max-width: 100%;
            animation: animate calc(8s * var(--i)) linear infinite;
        }

        @keyframes animate
        {
            0%
            {
                transform: translateX(-100%);
            }
            100%
            {
                transform: translateX(100%);
            }
        }
        
        .logo-container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: auto; 
            margin-top: 100px; 
            animation:tracking-in-expand-forward-top 0.4s linear both;
        }

        .logo-container img {
            max-width: 50%;
            height: auto;
        }
        
        .buttons a {
            text-decoration: none;
        }

        .btn {
            background: none;
            border: 2px solid #000;
            font-family: "montserrat", sans-serif;
            text-transform: uppercase;
            text-decoration: none;
            padding: 12px 20px;
            min-width: 200px;
            margin: 15px auto; /* Auto para centrar horizontalmente */
            cursor: pointer;
            transition: color 0.4s linear;
            position: relative;
            text-align: center;
            display: block;
            animation:tracking-in-expand-forward-top 0.4s linear both;
        }

        .btn:hover {
            color: #fff;
        }

        .btn::before {
            content: "";
            position: absolute;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background: #2353b2;
            z-index: -1;
            transition: transform 0.5s;
            transform-origin: 0 0;
            transform: scaleX(0); 
            transition-timing-function: cubic-bezier(0.5, 1.6, 0.4, 0.7);
        }

        .btn:hover::before {
            transform: scaleX(1);
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
        <div class="banner">
            <div class="clouds">
                <img src="img/1.png" style="--i:1;">
                <img src="img/2.png" style="--i:2;">
                <img src="img/3.png" style="--i:3;">
                <img src="img/5.png" style="--i:4;">
            </div>
        </div>
        
        <div class="logo-container">
            <img src="img/logo LinkEasy.png" alt="LinkEase Logo">
        </div>

        <div class="buttons">
            <a href="ControladorUsuario?accion=logear"><button class="btn">Iniciar sesión</button></a>
            <a href="ControladorUsuario?accion=add"><button class="btn">Regístrate</button></a>
        </div>

    </body>

</html>
