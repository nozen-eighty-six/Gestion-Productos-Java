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
   <jsp:include page="../Template/ClienteEncabezado.jsp" />
  
    <div class="container">
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
              <form action="carrito.jsp" method="POST">
                <ul class="list-group">
                  <li class="list-group-item"><h5>Precio: S/.${producto.precio} </h5></li>
                  <li class="list-group-item">
                    <p>Descripción: ${producto.descripcion}</p>
                  </li>
                  <li class="list-group-item"><h6>
                    Cantidad: <input type="number" id="cantidad" name="cantidad" autocomplete="off"
                    min="1" max="5" value="1">
                  </h6></li>
                </ul>
				<button type="button" id="btnAgregarCarrito" class="btn btn-dark mt-3" onclick="mostrarVentanaConfirmacion()">Añadir al carrito </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    
	<div class="modal fade" id="modalConfirmacion" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLongTitle">Confirmar</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				<span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	          <p>¿Estás seguro de agregar al carrito?</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" id="cerrarModal" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
	        <button type="button" class="btn btn-success" onclick="agregarProductoAlCarrito(${producto.productoId})">Sí, agregar</button>
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
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="/borabora/styles/vendor/jquery/jquery.min.js"></script>
	<script src="/borabora/styles/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<script src="/borabora/js/scriptCarrito.js" type="text/javascript"></script>
</body>

</html>