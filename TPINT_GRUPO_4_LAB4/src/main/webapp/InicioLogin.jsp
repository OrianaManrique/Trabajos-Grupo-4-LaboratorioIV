<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InicioLogin</title>
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

.header {
	background: linear-gradient(to right, #bc9fd6, #44107a);
	color: white;
	padding: 15px;
	text-align: center;
	font-weight: bold;
	font-size: 20px;
	letter-spacing: 1px;
}

.login-container {
	background-color: #44107a;
	padding: 40px;
	border-radius: 10px;
	width: 300px;
	text-align: center;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
}

.login-container h2 {
	color: white;
	margin-bottom: 30px;
	font-size: 24px;
}

.login-container input[type="text"] {
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

.login-container input[type="submit"] {
	width: 100%;
	padding: 10px;
	margin-bottom: 10px;
	border: none;
	border-radius: 8px;
	background-color: #e5e5e5;
	color: #44107a;
	font-weight: bold;
	cursor: pointer;
}

.login-container input[type="submit"] {
	background-color: #d4d4d4;
}
</style>

<body>

	<div class="login-container">
		<h2>Iniciar Sesión</h2>
		<div class="form-body">
			<form method="post" action="ServletLogin">
				<input type="text" name="usuario" placeholder="Usuario" required>
				<input type="password" name="clave" placeholder="Contraseña" required>
				<input type="submit" value="Ingresar">
			</form>
			<form action="AgregarCliente.jsp">
				<input type="submit" value="Registrarme">
			</form>
		</div>
		<% if (request.getAttribute("error") != null) { %>
			<p style="color:red;"><%= request.getAttribute("error") %></p>
		<% } %>
	</div>

</body>
</html>