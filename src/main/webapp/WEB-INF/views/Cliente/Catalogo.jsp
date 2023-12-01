<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<!-- Libreria Spring Form -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Libreria JSTL Core -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="shortcut icon" href="/borabora/images/icons/logo-icono.png">
    <title>Catálogo de productos</title>

    <!-- Bootstrap core CSS -->
    <link href="/borabora/styles/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
   	<link href="/borabora/styles/css/heroic-features.css" rel="stylesheet">
    
    
    <style>
        .search-form {
            text-align: center;
            margin-bottom: 30px;
        }

        .product-card { 
            border: none;
            border-radius: 10px;
            box-shadow: 0px 3px 6px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s;
            background-color: white;
        }

        .product-card:hover {
            transform: translateY(-5px);
        }

        .product-img {
            border-radius: 10px 10px 0 0;
            max-height: 300px;
            object-fit: cover;
        }

        .product-description {
            padding: 15px;
        }

        .product-price {
            color: #dc3545;
            font-size: 1.2rem;
        }

        .product-footer {
            padding: 10px 15px;
            text-align: center;
            background-color: #f8f9fa;
        }
        
    </style>
</head>

<body>
    <!-- Encabezado -->
    <%@ include file="../Template/ClienteEncabezado.jsp" %>

    <div class="container">
        <h1 class="mt-4 mb-4">
		    <small><b>Catálogo de productos</b></small>
		</h1>

        <form class="search-form" action="/borabora/catalogobusquedad" method="post">
            <div class="input-group mb-3">
                <select name="categoriaId" class="form-control">
                    <option value="">Todos los productos</option>
                    <c:forEach items="${categorias}" var="categoria">
                        <option value="${categoria.categoriaId}">${categoria.nombre}</option>
                    </c:forEach>
                </select>
                <div class="input-group-append">
                    <button class="btn btn-primary" type="submit">Buscar</button>
                </div>
            </div>
        </form>

        <div class="row">
            <c:forEach var="producto" items="${productos}">
                <div class="col-lg-3 col-md-4 col-sm-6 mb-4">
                    <div class="card product-card">
                        <img class="card-img-top product-img"
                            src="/borabora/images/products/${producto.imagen}" alt="">
                        <div class="card-body product-description">
                            <p class="card-text">${producto.descripcion}</p>
                            <p class="card-text product-price"><strong>Precio: S/.${producto.precio}</strong></p>
                        </div>
                        <div class="card-footer product-footer">
                            <a href="/borabora/producto/${producto.productoId}" class="btn btn-info btn-sm">+ Ver más</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>


    <!-- Footer -->
    <jsp:include page="../Template/Footer.jsp" />

    <!-- Bootstrap core JavaScript -->
    <script src="/borabora/styles/vendor/jquery/jquery.min.js"></script>
    <script src="/borabora/styles/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>

</html>

