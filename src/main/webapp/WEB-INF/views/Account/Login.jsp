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
  	<title>Iniciar sesión</title>

  	<!-- Bootstrap core CSS -->
  	<link href="/borabora/styles/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
   	<link href="/borabora/styles/css/heroic-features.css" rel="stylesheet">
	
	<style>
  body {
    background-color: #f8f9fa;
  }
  
  .card {
    background-color: #fff;
    border: none;
    box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
  }
  
  .card-title {
    color: #333;
    font-size: 24px;
  }
  
  .form-control {
    border: none;
    border-bottom: 1px solid #aaa;
    border-radius: 0;
  }
  
  .btn-primary {
    background-color: #8b572a;
    border-color: #8b572a;
  }
  
  .btn-secondary {
    background-color: #aaa;
    border-color: #aaa;
  }
  
  .btn-info {
    background-color: #333;
    border-color: #333;
  }
  
  a {
    color: #8b572a;
    text-decoration: none;
  }
</style>
	
</head>
<!--  ----  ---- ---- ---- -->

<body>
	<!-- Encabezado-->
  	<nav class="navbar navbar-expand-lg navbar-dark fixed-top" style="background-color: #f8f9fa">
    <div class="container">
        <a class="navbar-brand text-dark" href="/borabora/home" style="text-align: center; font-size: 1.6em">
            <img src="/borabora/images/icons/logo-banner.png" alt="Logo" style="height: 50px; margin-right: 10px;">
        </a>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
        	<a class="btn btn-info" href="/borabora/account/create" style="margin-left: 10px;">Crear Cuenta</a>
        </li>
      </ul>
    </div>
    </div>
    </nav>
    <br>
    <br>
    <br>
	<div class="container">
		<div class="row justify-content-center mt-5">
			<div class="col-md-6">
    			<img src="/borabora/images/LOGIN.jpg" alt="Vintage Image" class="img-fluid" style="max-width: 100%;">
				<div class="card">
					<div class="card-body">
						<h3 class="card-title text-center">Iniciar sesión</h3>
						<form:form cssClass="m-3" method="post" modelAttribute="usuarioL">
							<c:if test="${param.invalid != null}">
								<div class="alert alert-warning mt-2" role="alert">
									Usuario y/o contraseña inválidos.
								</div>
							</c:if>
							<div class="form-group">
								<label for="usuario">Usuario :</label> 
								<form:input type="text" required="true" path="usuario" cssClass="form-control col"/>
							</div>
							<div class="form-group">
								<label for="contraseña">Contraseña :</label> 
								<form:input type="password" required="true" path="contrasena" cssClass="form-control col"/>
							</div>
							<div class="row mt-3 p-2">
								<button type="submit" class="btn btn-primary col mr-5">Iniciar Sesión</button>
								<button type="button" class="btn btn-secondary col" onclick="location.href='/borabora/home'">Cancelar</button>
							</div>
							<div class="row mt-3 p-2">
								<div class="col"></div>
									<a href="/borabora/account/reset" class="text-center">Restablecer Contraseña</a>
								<div class="col"></div>
							</div>	
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>  	
  	
<!--  ----  ---- ---- ---- -->	

<!-- Bootstrap core JavaScript -->
<script src="/borabora/styles/vendor/jquery/jquery.min.js"></script>
<script src="/borabora/styles/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>