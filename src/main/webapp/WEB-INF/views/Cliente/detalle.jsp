<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Librería JSTL Core -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="shortcut icon" href="/borabora/images/icons/logo-icono.png">
	<title>Detalles</title>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<style>
	body{
		background-color: white;
	}
	
	table{
		background-color: white;
		text-align: left;
		border-collapse: collapse;
		width: 90%;
	}
	tr, td, th {
		padding: 10;
	}
	thead {
		background-color: #246355;
		border-bottom: solid 2px;
		color: white;
	}
	tr:hover td{
		background-color: #e1e1e1;
	}
</style>
<body>
	<div align="center">
		<br>
		<h2>Detalle de Compra</h2>
		<br>
		<table>
			<thead>
			<tr>
				<th><b>ID</b></th>
				<th><b>Nombre</b></th>
				<th><b>Apellido</b></th>
				<th><b>Correo</b></th>
				<th><b>Teléfono</b></th>
				<th><b>Condominio</b></th>
				<th><b>Bloque</b></th>
				<th><b>Departamento</b></th>
				<th><b>Total</b></th>
			</tr>
			</thead>
			<c:forEach var="detalle" items="${aDetalle}">
				<tr>
					<td>${detalle.idCompra}</td>
					<td>${detalle.nombre}</td>
					<td>${detalle.apellido}</td>
					<td>${detalle.correo}</td>
					<td>${detalle.telefono}</td>
					<td>${detalle.condominio}</td>
					<td>${detalle.bloque}</td>
					<td>${detalle.departamento}</td>
					<td>${detalle.total}</td>
				</tr>
			</c:forEach>
		</table><br><br>
		<button class="btn btn-primary" type="button" onclick="location.href='/borabora/catalogo'">Volver</button>
		<br><br>
	</div>
	<script src="/borabora/js/scriptCarrito.js" type="text/javascript"></script>
</body>
</html>