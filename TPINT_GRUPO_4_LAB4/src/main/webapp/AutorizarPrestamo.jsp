<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="entidad.*"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta charset="UTF-8">
<title>Autorizar Prestamos</title>

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#table_id').DataTable();
	});
</script>

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

p{
 text-align: center;
}

th {
	color: black;
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

<%

Usuario usuario = new Usuario();

if(session.getAttribute("usuarioLogueado") != null){

    usuario = (Usuario)session.getAttribute("usuarioLogueado");

//}else {
//	response.sendRedirect("InicioLogin.jsp");
}
 %>

<div class="header">
<%=usuario.getNombre_us()%> <%=usuario.getApellido_us()%> - Administrador
</div>

	<a href="InicioLogin.jsp"> Inicio </a>
	<br />
	<br />

	<p>
		<strong>AUTORIZAR PRESTAMOS</strong> <br /> <br /> <br />
	</p>


	<form>

		<table id="table_id" class="display">
			<thead>
				<tr>
					<th>Dni Cliente</th>
					<th>Numero de Cuenta</th>
					<th>Importe Solicitado</th>
					<th>Cuotas</th>
					<th>fecha de creación</th>
				</tr>
			</thead>
			<tbody>

				<tr>
					<td>35789478</td>
					<td>A200</td>
					<td>200.000</td>
					<td>5</td>
					<td>2/7/2025</td>
					<td></td>
					<td><a href=""> Aceptar </a> <br /></td>
					<td><a href=""> Rechazar </a> <br /></td>
				</tr>

			</tbody>
		</table>

	</form>
</body>
</html>