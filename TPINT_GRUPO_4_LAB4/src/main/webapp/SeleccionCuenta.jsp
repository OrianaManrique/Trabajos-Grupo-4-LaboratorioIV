<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SeleccionCuenta</title>
</head>
<style>
body {
	background-color: white;
	font-family: 'Segoe UI', sans-serif;
	margin: 0;
	padding: 0;
	color: #333;
}

.header {
	background: linear-gradient(to right, #bc9fd6, #44107a);
	color: white;
	padding: 20px;
	text-align: center;
	font-weight: bold;
	font-size: 20px;
	letter-spacing: 1px;
}

.container {
	background-color: #44107a;
	padding: 40px;
	border-radius: 10px;
	width: 300px;
	height: 300px;
	text-align: center;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
}

.texto-container {
	width: 93%;
	padding: 5px;
	margin-bottom: 40px;
	border: none;
	border-radius: 8px;
	background-color: #e5e5e5;
	font-weight: bold;
	text-align: center;
	font-size: 14px;
}

.style-submit {
	margin-top: 160px;
	text-align: center;
}
</style>
<body>

	<form action="ServletLogin?Param=CargarCuenta" method="post">

		<div class="header">USUARIO LOGUEADO - CUENTA: xxxxxxxx</div>


		<div class="container">
			<div class="texto-container">
				<p>
					<strong style="color: #5F1AB4">SELECCIONE UNA CUENTA</strong>
				</p>
			</div>

			<select id="ddlCuentas" name="Cuenta" style="width: 177px;">

				<option value="">SELECCIONE CUENTA</option>
				<option value="1">CTA- 27415698</option>

			</select> <br />
			<div class="style-submit">
				<input type="submit" value="Aceptar">
			</div>
		</div>

	</form>

</body>
</html>