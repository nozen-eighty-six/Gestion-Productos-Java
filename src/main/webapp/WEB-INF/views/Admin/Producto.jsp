<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>

  	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="shortcut icon" href="/borabora/images/icons/logo-icono.png">
  	<title>${producto.descripcion}</title>

  	<!-- Bootstrap core CSS -->
    <link href="/borabora/styles/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/borabora/styles/css/heroic-features.css" rel="stylesheet">

</head>

<body>

  <!-- Navigation -->
   <jsp:include page="../Template/AdminEncabezado.jsp" />
  
    <div class="container">
    <br>
    <h1 class="mt-4 mb-4">
    	<small>${producto.descripcion}</small>
  	</h1>
      <div class="card mb-4">
        <div class="card-body">
          <div class="row">
            <div class="col-lg-6">
              <a href="#"> <img class="img-fluid rounded"
                src="/borabora/images/products/${producto.imagen}"  alt="">
              </a>
            </div>
            <div class="col-lg-6">
                <ul class="list-group">
                  <li class="list-group-item"><p>Nombre: ${producto.nombre} </p></li>
                  <li class="list-group-item"><p>Descripción: ${producto.descripcion}</p></li>
                  <li class="list-group-item"><p>Marca: ${producto.marca} </p></li>
                  <li class="list-group-item"><p>Categoria: ${producto.categoria.nombre} </p></li>
                  <li class="list-group-item"><p>Precio: ${producto.precio} </p></li>
                  <li class="list-group-item"><p>Stock: ${producto.stock} </p></li>
                  <li class="list-group-item"><p>Fecha vencimiento: ${producto.fvencimiento} </p></li>
                </ul>
            </div>
          </div>
        </div>
      </div>
    </div>

<!--  ----  ---- ---- ---- -->
<!-- Footer -->
<div style="margin-top: 120px;">
  <jsp:include page="../Template/Footer.jsp" />
</div>

<!-- Bootstrap core JavaScript -->
<script src="/borabora/styles/vendor/jquery/jquery.min.js"></script>
<script src="/borabora/styles/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>