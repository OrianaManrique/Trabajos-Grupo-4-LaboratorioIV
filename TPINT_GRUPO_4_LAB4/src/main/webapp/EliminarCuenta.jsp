<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EliminarCuenta</title>
</head>
<style>
body {
	margin: 0;
	padding: 0;
	background-color: #e5e5e5;
	font-family: Arial, sans-serif;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.Eliminar-container {
	background-color: #44107a;
	padding: 40px;
	border-radius: 10px;
	width: 300px;
	text-align: center;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
}

.Eliminar-container h2 {
	color: white;
	margin-bottom: 30px;
	font-size: 24px;
}

.Eliminar-container input[type="text"] {
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

.Eliminar-container input[type="submit"] {
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

.Eliminar-container input[type="submit"] {
	background-color: #d4d4d4;
}

.table-container {
	margin-left: 5%;
	color: white;
	margin-top: 5%;
	margin-bottom: 5%;
}

</style>
</head>
<body>
	<div class="Eliminar-container">
		<h2>ELIMINAR CUENTA</h2>
		<div class="form-body">
			<form>
				<input type="text" name="dni" placeholder="Dni del cliente..."
					required> <input type="text" name="Cuenta"
					placeholder="Numero de cuenta..." required>

				<div class="table-container">
					<table class="movements-table">
						<thead>
							<tr>
								<th>| DNI | </th>
								<th>| N DE CUENTA |</th>
								<th>| CBU |</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>12345678</td>
								<td>CTA-12345678</td>
								<td>78932499</td>
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