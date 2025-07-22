<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="entidad.Usuario"%>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>DatosPersonales</title>
<style>
/* ... Reutilizamos el mismo estilo de tu código original ... */
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
	display: flex;
	justify-content: center;
	padding: 30px;
}
.card-datos {
	background-color: #f9f9f9;
	padding: 30px;
	border-radius: 12px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.05);
	width: 60%;
}
.card-datos h2 {
	color: #44107a;
	margin-bottom: 25px;
	font-weight: bold;
}
.dato {
	font-size: 18px;
	margin-bottom: 15px;
	font-weight: bold;
	color: #44107a;
}

.label {
	font-weight: bold;
	color: #44107a;
}
</style>
</head>
<body>
<%

Usuario usuario = new Usuario();

if(session.getAttribute("usuarioLogueado") != null){

    usuario = (Usuario)session.getAttribute("usuarioLogueado");

//}else {
//    response.sendRedirect("InicioLogin.jsp");
}
 %>

<div class="header">
<%=usuario.getNombre_us()%> <%=usuario.getApellido_us()%> - Cliente
</div>

<div class="container">
	<div class="card-datos">
		<h2>Datos Personales</h2>

		<div class="dato">Nombre <span style= "float: right; color: black; font-weight: normal">Oriana</span></div>
		<div class="dato">Apellido <span style= "float: right; color: black; font-weight: normal">Manrique</span></div>
		<div class="dato">DNI <span style= "float: right; color: black; font-weight: normal">41200035</span></div>
		<div class="dato">Email <span style= "float: right; color: black; font-weight: normal">oriana@hotmail.com</span></div>
		<div class="dato">Teléfono <span style= "float: right; color: black; font-weight: normal">1164507877</span></div>
		<div class="dato">Dirección <span style= "float: right; color: black; font-weight: normal">Lavalleja 2804</span></div>
	</div>
</div>

</body>
</html>