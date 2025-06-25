<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EliminarCliente</title>
</head>
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

.eliminar-container {
	background-color: #44107a;
	padding: 40px;
	border-radius: 10px;
	width: 300px;
	text-align: center;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
}

.eliminar-container h2 {
	color: white;
	margin-bottom: 30px;
	font-size: 24px;
}

.eliminar-container input[type="text"] {
	width: 93%;
	padding: 10px;
	margin-bottom: 10px;
	border: none;
	border-radius: 8px;
	background-color: #e5e5e5;
	font-weight: bold;
	text-align: center;
	font-size: 12px;
}

.eliminar-container input[type="submit"] {
	width: 100%;
	padding: 10px;
	margin-bottom: 10px;
	margin-top: 10px;
	border: none;
	border-radius: 8px;
	background-color: #e5e5e5;
	color: #44107a;
	font-weight: bold;
	cursor: pointer;
}

.table-container {
	margin-left: 5%;
	color: white;
	margin-top: 5%;
	margin-bottom: 5%;
}

.eliminar-container input[type="submit"] {
	background-color: #d4d4d4;
}
</style>
</head>
<body>

	<div class="header">Usuario logueado - Cuenta Banco</div>

	<div class="eliminar-container">
		<h2>ELIMINAR CLIENTE</h2>
		<div class="form-body">
			<form>
				<input type="text" name="dni" placeholder="Dni del cliente..."
					required>

				<div class="table-container">
					<table class="movements-table">
						<thead>
							<tr>
								<th>| DNI |</th>
								<th>| NOMBRE |</th>
								<th>| APELLIDO |</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>12345678</td>
								<td>Carlos</td>
								<td>Perez</td>
							</tr>
						</tbody>
					</table>
				</div>

				<input type="submit" value="BUSCAR"> <input type="submit"
					value="CANCELAR">

			</form>
		</div>
	</div>
</body>
</html>