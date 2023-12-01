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
  	<title>Agregar nuevo producto</title>

  	<!-- Bootstrap core CSS -->
  	<link href="/borabora/styles/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
   	<link href="/borabora/styles/css/heroic-features.css" rel="stylesheet">
	
</head>
<!--  ----  ---- ---- ---- -->

   <style>
    body {
        font-family: "Pacifico", cursive;
        background-color: #f8f2ec;
        margin: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
    }

    .form-container {
        display: flex;
        flex-direction: column;
        align-items: center;
        background-color: #fff;
        border: 2px solid #e07a5f;
        border-radius: 12px;
        box-shadow: 4px 4px 6px rgba(0, 0, 0, 0.1);
        padding: 20px;
        width: 550px;
    }

    .titulo {
        text-align: center;
        font-size: 48px;
        margin-bottom: 20px;
        color: #e07a5f;
    }

    .contenido-form {
        width: 100%;
        max-width: 400px;
        margin: 0 auto;
    }

    .texto {
        border: solid 2px #e07a5f;
        padding: 12px;
        width: 100%;
        border-radius: 8px;
        color: #e07a5f;
        font-family: "Pacifico", cursive;
        font-size: 18px;
        margin-bottom: 15px;
    }

    select.texto {
        color: #e07a5f;
        font-family: "Pacifico", cursive;
        font-size: 18px;
        margin-bottom: 15px;
    }

    .botones {
        cursor: pointer;
        padding: 12px 24px;
        font-size: 20px;
        border: none;
        border-radius: 6px;
        color: #fff;
        text-align: center;
        background-color: #e07a5f;
    }

    .botones.btn-secondary {
        background-color: #d89b7b;
    }

    .text-center {
        text-align: center;
        margin-top: 20px;
    }
</style>
   
<body>
	<!-- Encabezado-->
  	<jsp:include page="../Template/AdminEncabezado.jsp" />
	<br>
	<br>
	<div class="custom-container">
	<div class="form mt-4">
		<form:form method="post" modelAttribute="producto" enctype="multipart/form-data"> 
			<br><br><br>
			<h3 class="titulo"> Agregar nuevo producto </h3>
			<br>
			<div class="contenido-form">
			Nombre: <form:input required="true" class="texto" type="text" path="nombre" placeholder="Ingresar nombre"/> <br><br>
			Descripcion:<br><form:textarea required="true" class="texto" type="text" path="descripcion" placeholder="Ingresar descripción"/> <br><br>
			Marca: <form:input required="true" class="texto" type="text" path="marca" placeholder="Ingresar marca"/> <br><br>
			Precio: <form:input required="true" class="texto" type="number" step="any" path="precio" placeholder="Ingresar precio"/> <br><br>
			Stock: <form:input required="true" class="texto" type="number" path="stock" placeholder="Ingresar stock"/> <br><br>
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
			<br><br>
			Imagen:<input type="file" class="form-control-file" id="img" name="img">
			<br><br>
			</div>
		    <div class= "text-center">
			<button class="botones btn-primary " type="submit">Guardar</button>
			<button class="botones btn-secondary" type="button" onclick="location.href='/borabora/admin/inventario'">Cancelar</button>
		    </div>
		</form:form>
	</div>
	</div>


<!--  ----  ---- ---- ---- -->	
<!-- Footer -->

<!-- Bootstrap core JavaScript -->
<script src="/borabora/styles/vendor/jquery/jquery.min.js"></script>
<script src="/borabora/styles/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>