<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Librería Spring Form -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="shortcut icon" href="/borabora/images/icons/logo-icono.png">
	<title>Proceso de pago</title>
<!--     <link href="/borabora/styles/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"> -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<style>	
	form {
	   border: solid 1px #ccc;
	   padding: 40px;
	   width: 480px;
	   border-radius: 5px;
	   background-color: #e2e2e2;
	   margin-top: 15px; 
	   margin-bottom: 15px;
	   }
	input { 
	   width: 400px;
	   }
</style>
<body>
	<div align="center">
		<form:form method="post" modelAttribute="detalle">
			<h2>Ingrese sus datos</h2><br>
				<div align="left">
					Nombre: <br><form:input type="text" path="nombre" required="true" placeholder="Ingrese su nombre"/> <br>
					Apellido: <br><form:input type="text" path="apellido" required="true" placeholder="Ingrese su apellido"/> <br>
					Correo: <br><form:input type="email" path="correo" required="true" placeholder="Ingrese su correo"/> <br>
					Telefono: <br><form:input type="text" path="telefono" required="true" placeholder="Ingrese su teléfono"/> <br>
					Nombre de condominio: <br><form:input type="text" path="condominio" required="true" placeholder="Ingrese el condominio"/> <br>
					Bloque: <br><form:input type="number" required="true" path="bloque" placeholder="Ingrese el número de bloque"/> <br>
					Nro. de departamento: <br><form:input type="number" path="departamento" required="true" placeholder="Ingrese el nro. de departamento"/> <br><br>
					
					<b>Realizar pago:</b><br>
					<div align="center">
						<a class="logo"> <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/MasterCard_early_1990s_logo.svg/200px-MasterCard_early_1990s_logo.svg.png" 
								width="95" height="60" alt=""></a> 
						<a class="logo"> <img src="https://www.visa.com.pe/dam/VCOM/regional/lac/SPA/Default/Partner%20With%20Us/Info%20for%20Partners/Info%20for%20Small%20Business/visa-pos-800x400.jpg" 
								width="80" height="60" alt=""></a><br>
					</div>
				</div>
				<div align="left">
					Nro. de tarjeta: <br><input type="text" required="true" placeholder="0000-0000-0000-0000"/> <br>
					Fecha de caducidad: <br><input type="text" required="true" placeholder="00/00"/> <br>
					Código de seguridad: <br><input type="number" required="true" placeholder="000"/> <br><br>
				</div>
			<button class="btn btn-success" type="submit">Procesar</button>
			<button class="btn btn-secondary" type="button" onclick="location.href='/borabora/catalogo'">Cancelar</button>
		</form:form>
	</div>
</body>
</html>