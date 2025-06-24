<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar cliente</title>

<style>

body {
	font-family: 'Segoe UI', sans-serif;
	margin: 0;
	padding: 0;
	background: #E0E0E0;
}

.header {
	background: linear-gradient(to right, #602A80, #4C0026);
	color: white;
	padding: 20px;
	text-align: center;
	font-weight: bold;
	font-size: 20px;
	letter-spacing: 1px;
}

.ContenedorVentana {
	background-color: #4A217C;
	width: 900px;
	margin: 40px auto;
	padding: 30px;
	border-radius: 20px;
}

.ContenedorColumna {
	display: flex;
	justify-content: center;
	gap: 20px;
	margin-bottom: 40px;
}

.ContenedorColumna input {
	padding: 15px;
	border-radius: 15px;
	border: none;
	font-size: 20px;
	width: 60%;
}

.ContenedorColumna input {
	padding: 15px 30px;
	border-radius: 15px;
	border: none;
	font-size: 20px;
	background-color: #DCDCDC;
	font-weight: bold;
	cursor: pointer;
}

table {
	background-color: #E5E5E5;
	width: 100%;
	border-collapse: collapse;
	padding: 20px;
	font-size: 18px;
	border-radius: 5px;
}

th {
	color: white;
	padding: 10px;
	text-align: left;
}

td {
	padding: 10px;
	font-weight: bold;
}
</style>

</head>
<body>

	<div class="header">Usuario logueado - Cuenta Banco</div>

	<a href="InicioLogin.jsp"> Inicio </a>

	<div class="ContenedorVentana">

		<div class="ContenedorColumna">
			<input type="text" placeholder="Buscar por Dni o Nombre" /> <input
				type="submit" value="Buscar" />
		</div>


		<div
			style="display: flex; justify-content: space-between; color: white; font-weight: bold; padding: 0 10px;">
			<div>DNI</div>
			<div>Nombre</div>
			<div>Apellido</div>
			<div>Correo</div>
			<div>Usuario</div>
		</div>

		<br />
	</div>

</body>
</html>