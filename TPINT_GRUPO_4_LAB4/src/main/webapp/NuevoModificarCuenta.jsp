<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificar Cuenta</title>
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

form {
	text-align: center;
	margin-top: 20px;
}

.ContenedorLista {
	text-align: center;
	margin-top: 20px;
}

table {
	margin: 20px auto;
	border-collapse: collapse;
}
</style>


<body>

	<div class="header">Usuario logueado - Cuenta Banco</div>

	<form>
		<input type="search" name="txtBusqueda"
			placeholder="Ingrese un Dni..." />
		<button type="submit">Buscar</button>

		<div class="ContenedorLista">

			<table>
				<thead>
					<tr>
						<th>Numero de cuenta</th>
						<th>Fecha de creación</th>
						<th>Saldo</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Laptop</td>
						<td>$1200</td>
						<td>5</td>
					</tr>
					<tr>
						<td>Mouse</td>
						<td>$25</td>
						<td>100</td>
					</tr>
				</tbody>
			</table>


		</div>
	</form>





</body>
</html>