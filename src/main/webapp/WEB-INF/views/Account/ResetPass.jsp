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
  	<title>Restablecer contraseña</title>
	
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
    <br>
    <br>
    <br>
	<div class="container">
		<div class="row justify-content-center mt-5">
			<div class="col-md-6">
				<div class="card">
					<div class="card-body">
						<h3 class="card-title text-center">Restablecimiento de Contraseña</h3>
						<form:form modelAttribute="passreset" method="post">
							<c:if test="${param.invalid != null}">
								<div class="alert alert-warning mt-2" role="alert">
									El correo no existe. Inténtelo de nuevo.
								</div>
							</c:if>
							<div class="alert alert-danger mt-2" role="alert" id="passwordMismatch" style="display: none;">
							    Las contraseñas no coinciden. Por favor, inténtelo de nuevo.
							</div>
							<div class="form-group">
								<label for="correo">Correo electrónico :</label> 
								<form:input type="email" required="true" path="correo" cssClass="form-control col"/>
							</div>
							<div class="form-group">
								<label for="correo">Nueva Contraseña :</label>
								<form:input type="password" required="true" path="contrasena" cssClass="form-control col"/>	
							</div>
							<div class="form-group">
								<label for="email">Confirmar Nueva Contraseña :</label>
								<form:input type="password" required="true" path="confirmarContrasena" cssClass="form-control col"/>
							</div>
							
							
							<div class="row mt-3 p-2">
							<div class="col"></div>
							<button type="submit" class="btn btn-primary">Reestablecer Contraseña</button>
							<div class="col-1"></div>
							<button type="button" onclick="location.href='/borabora/account/login'" class="btn btn-secondary">Cancelar</button>
							<div class="col"></div>
							</div>	
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

<!-- Bootstrap core JavaScript -->
<script src="/borabora/styles/vendor/jquery/jquery.min.js"></script>
<script src="/borabora/styles/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Script -->
<script>
    const passwordInput = document.querySelector('input[name="contrasena"]');
    const confirmPasswordInput = document.querySelector('input[name="confirmarContrasena"]');
    const mismatchMessage = document.getElementById('passwordMismatch');

    function checkPasswordMatch() {
        if (passwordInput.value !== confirmPasswordInput.value) {
            mismatchMessage.style.display = 'block';
        } else {
            mismatchMessage.style.display = 'none';
        }
    }

    passwordInput.addEventListener('input', checkPasswordMatch);
    confirmPasswordInput.addEventListener('input', checkPasswordMatch);
</script>
</body>

</html>