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
	<link rel="shortcut icon" href="../images/logo.png">
  	<title>Editar producto</title>

  	<!-- Bootstrap core CSS -->
  	<link href="/borabora/styles/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
   	<link href="/borabora/styles/css/heroic-features.css" rel="stylesheet">
	
</head>
<!--  ----  ---- ---- ---- -->


<style>
	body {
    font-family: "Segoe UI";
	}
	
	.titulo {
    text-align: center;
  	}
  	
  	.contenido-form {
    margin-left: 15px; 
  	}
  	
	.form {
		width: 400px;
		margin: 30px auto;
		padding: 20px;
		background-color: #fff;
		border: 1px solid #ccc;
		box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
		border-radius: 5px;
	}
	
	.botones{
		cursor: pointer;
		padding: 10px 20px;
		font-size: 16px;
		border: none;
		border-radius: 4px;
		color: #fff;
		text-align: center;
	}
	
	.texto {
	border: solid 1px #ccc;
    padding: 10px;
    width: 200px;
    border-radius: 5px;
	}

</style>
<body>
	<!-- Encabezado-->
  	<jsp:include page="../Template/AdminEncabezado.jsp" />
  	<br>
  	<br>
  	<div class="custom-container">	
	<div class="form mt-4">	
		<form:form method="post" modelAttribute="producto"> 
			<h3 class="titulo"> Editar producto </h3>
			<br>
			<c:choose>
		        <c:when test='${producto.stock > 0}'> <div class="alert alert-success mt-2" role="alert">Stock disponible.</div></c:when>
		        <c:when test='${producto.stock == 0}'> <div class="alert alert-danger mt-2" role="alert">Stock agotado</div></c:when>
		   	</c:choose>
		   	<div class="contenido-form">
			Producto ID: <form:input readonly="true"  class="texto" type="text" path="productoId"/> <br><br>
			Nombre: <form:input required="true"  class="texto" type="text" path="nombre"/> <br><br>
			Descripcion:<br><form:textarea required="true" class="texto" type="text" path="descripcion"/><br><br>
			Marca: <form:input required="true" class="texto" type="text" path="marca"/> <br><br>
			Precio: <form:input required="true" class="texto" type="number" step="any" path="precio"/> <br><br>
			Stock: <form:input required="true" class="texto" type="number" path="stock"/> <br><br>
			Fecha de Vencimiento: <form:input required="true" id="fecha" class="texto" type="date" step="any" path="fvencimiento"/> <br><br>
			Categoria: 
			<form:select required="true" class="texto" path="categoria">
				<form:option value="1">Aceites</form:option>
				<form:option value="2">Granos y cereales</form:option>
				<form:option value="3">Menestras</form:option>
				<form:option value="4">Lacteos</form:option>
				<form:option value="5">Licores</form:option>
				<form:option value="6">Enlatados</form:option>
			</form:select>
			</div>
			<br><br>
			<div class="text-center">
			<button class="botones btn-primary" type="submit">Guardar</button>
			<button class="botones btn-secondary" type="button" onclick="location.href='/borabora/admin/inventario'">Cancelar</button>
			</div>
		</form:form>
	</div>
	</div>
	
	
<!--  ----  ---- ---- ---- -->
<!-- Footer -->
<jsp:include page="../Template/Footer.jsp" />

<!-- Bootstrap core JavaScript -->
<script src="/borabora/styles/vendor/jquery/jquery.min.js"></script>
<script src="/borabora/styles/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>