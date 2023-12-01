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
	<title>Crear cuenta</title>
	
	<!-- Bootstrap core CSS -->
	<link href="/borabora/styles/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	 <!-- Custom styles for this template -->
	<link href="/borabora/styles/css/heroic-features.css" rel="stylesheet">

</head>
<body>
	<!-- Encabezado-->
  	<nav class="navbar navbar-expand-lg navbar-dark fixed-top" style="background-color: #f8f9fa">
    <div class="container">
        <a class="navbar-brand text-dark" href="/borabora/home" style="text-align: center; font-size: 1.6em">
            <img src="/borabora/images/icons/logo-banner.png" alt="Logo" style="height: 50px; margin-right: 10px;">
        </a>
    </div>
    </nav>
	<div class="container d-flex justify-content-center"> 
		<div class="card mt-5">
			<h3 class="card-title text-center mt-3 mb-2">Crea una nueva cuenta</h3>			
			<!-- Formulario Spring -->
			
			<form:form method="post" modelAttribute="usuario">
				<div class="card-body">
					<div class="form-group">
					    <label for="nombre">Usted se registrará como:</label>
					    <form:input type="text" readonly="true" path="rol" cssClass="form-control" value="cliente"/>	
					</div>

					<div class="form-group">
						<label for="nombre">Nombre :</label>
						<form:input type="text" required="true" path="nombre" cssClass="form-control" placeholder="Ingresar nombre"/>
					</div>
					<div class="form-group">
						<label for="correo">Correo :</label>
						<form:input type="email" required="true" path="correo" cssClass="form-control" placeholder="Ingresar correo"/>
					</div>
					<div class="form-group">
						<label for="telefono">Telefono :</label>
						<form:input type="number" min="900000000" max="999999999" maxlength="9" required="true" path="telefono" cssClass="form-control" placeholder="Ingresar n° de teléfono"/>
					</div>
					<div class="form-group">
						<label for="usuario">Usuario :</label>
						<form:input type="text" required="true" path="usuario" cssClass="form-control" placeholder="Ingresar usuario"/>
					</div>
					<div class="form-group">
						<label for="contrasena" aria-describedby="passwordRecordatorio">Contraseña :</label>
						<small id="passwordRecordatorio" class="form-text text-muted">Incluir 1 letra mayúscula, caracter especial y un número.*</small>					
						<form:input type="password" required="true" path="contrasena" cssClass="form-control mt-1" placeholder="Ingresar contraseña"/>
					</div>
				</div>
				<div class="card-title text-center">
					<button type="submit" class="btn btn-primary">Crear Cuenta</button>
					<button type="button" onclick="location.href='/borabora/account/login'" class="btn btn-secondary">Cancelar</button>
				</div>				
			</form:form>
		</div>
	</div>

<!--  ----  ---- ---- ---- -->	

<!-- Bootstrap core JavaScript -->
<script src="/borabora/styles/vendor/jquery/jquery.min.js"></script>
<script src="/borabora/styles/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>
