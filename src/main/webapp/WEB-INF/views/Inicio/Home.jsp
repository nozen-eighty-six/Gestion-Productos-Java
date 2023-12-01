<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="shortcut icon" href="/borabora/images/icons/logo-icono.png">
    <title>Bodega Bora Bora</title>

    <!-- Bootstrap core CSS -->
    <link href="/borabora/styles/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Agrega la ruta al archivo de estilos personalizados -->
    <link href="/borabora/styles/css/styles.css" rel="stylesheet">
</head>
<body>
    <!-- Encabezado-->
    <nav class="navbar navbar-expand-lg navbar-dark minimal-navbar">
        <div class="container">
            <div class="navbar-brand-container">
                <div class="logo-container">
                    <a class="navbar-brand" href="/borabora/home">
                        <img src="/borabora/images/icons/logo-banner.png" alt="Logo" class="logo">
                    </a>
                </div>
            </div>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="btn btn-primary btn-lg btn-vintage" href="/borabora/account/login">Iniciar sesión</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="contenido-header">
        <!-- Add a GIF here -->
        <img src="/borabora/images/TIENDA.gif" alt="GIF Animado" class="imagen-gif">
    </div>

    <!-- About Us Section -->
    <section id="about-us-section" class="about-section">
        <div class="container">
            <!-- Add content about your company here -->
            <div class="about-content">
                <div class="about-text">
                    <h2 class="vintage-text">Sobre Nosotros</h2>
                    <p></p><br><br>
                    <p class="vintage-text">
                        Somos BORABORA, una encantadora bodega de abarrotes, ubicados en Asia-Lima, durante más de una década.<br>
                        Descubre un mundo de sabores meticulosamente elegidos con nuestros productos, encontrarás elementos esenciales,
                        que despertarán tu paladar y tus sentidos. Nuestro amigable equipo te guiará a través de una selección que 
                        abarca desde productos locales frescos hasta delicias importadas, todo con el objetivo de llevar autenticidad
                        y diversidad a tu mesa. Sumérgete en esta experiencia y explora más en nuestra página.
                    </p>
                </div>
                <img src="/borabora/images/nosotros.jpg" alt="Imagen de Sobre Nosotros" class="about-image">
            </div>
        </div>
    </section>

    <!-- Footer -->
    <%@ include file="../Template/Footer.jsp" %>

    <!-- Bootstrap core JavaScript -->
    <script src="/borabora/styles/vendor/jquery/jquery.min.js"></script>
    <script src="/borabora/styles/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>

