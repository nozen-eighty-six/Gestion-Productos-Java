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
  	<title>Inventario de productos</title>

  	<!-- Bootstrap core CSS -->
  	<link href="/borabora/styles/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
   	<link href="/borabora/styles/css/heroic-features.css" rel="stylesheet">
	
</head>
<!--  ----  ---- ---- ---- -->


<body>
	<!-- Encabezado-->
  	<jsp:include page="../Template/AdminEncabezado.jsp" />


    <div class="container">
        <h1 class="mt-4 mb-4">
		    <small><b>Inventario de productos</b></small>
		</h1>

  		
        <div class="d-flex justify-content-between">
	    <form action="/borabora/admin/inventariobusquedad" method="post" class="d-flex align-items-center">
	        <div class="form-group mb-0 me-2">
	            <select name="categoriaId" class="form-control">
	                <option value="">Todas las categorías</option>
	                <c:forEach items="${categorias}" var="categoria">
	                    <option value="${categoria.categoriaId}">${categoria.nombre}</option>
	                </c:forEach>
	            </select>
	        </div>
	        <input type="submit" value="Buscar" class="btn btn-primary" />
	    </form>
	    
	    <a class="btn btn-success mt-2" href="/borabora/producto/agregar">Crear Producto</a>
		</div>
		<br>
        <c:if test="${not empty productos}">
            <table class="table">
    			<thead>
      				<tr>
				        <th scope="col">Nombre</th>
				        <th scope="col">Descripción</th>
				        <th scope="col">Marca</th>
				        <th scope="col">Precio</th>
				        <th scope="col">Stock</th>
				        <th scope="col">Fecha de vencimiento</th>
				        <th scope="col">Acción</th>
				        <th scope="col">Acción</th>
			      </tr>
			    </thead>
			    <tbody>
			      <c:forEach var="producto" items="${productos}">
			        <tr>
				        <td>${producto.nombre}</td>
                        <td>${producto.descripcion}</td>
                        <td>${producto.marca}</td>
                        <td>${producto.precio}</td>
                        <td>${producto.stock}</td>
                        <td>${producto.fvencimiento}</td>
	
	        
				        <td><a  class="btn btn-warning"  href="/borabora/producto/editar-${producto.productoId}">Editar</a> </td>
				        <td><a  class="btn btn-danger" href="/borabora/producto/eliminar/${producto.productoId}">Eliminar</a> </td>
        			<tr>
      			  </c:forEach>     
    			</tbody>
  			</table>
        </c:if>
    </div>


<!--  ----  ---- ---- ---- -->
<!-- Footer -->
<div style="margin-top: 140px;">
  <jsp:include page="../Template/Footer.jsp" />
</div>

<!-- Bootstrap core JavaScript -->
<script src="/borabora/styles/vendor/jquery/jquery.min.js"></script>
<script src="/borabora/styles/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>