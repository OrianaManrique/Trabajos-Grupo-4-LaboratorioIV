<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="entidad.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar cliente</title>

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
	width: auto;
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
	color: black;
	padding: 10px;
	text-align: left;
}

tbody tr:nth-child(odd) {
	background-color: #f2f2f2;
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

	<br />
	<br />

	<%
	ArrayList<Cliente> ListaClientes = new ArrayList<Cliente>();
	if (request.getAttribute("Lista") != null) {
		ListaClientes = (ArrayList<Cliente>) request.getAttribute("Lista");

	}
	%>
	<table id="table_id" class="display">
		<thead>
			<tr>
				<th>Dni</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Cuil</th>
				<th>Correo</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Cliente cliente : ListaClientes) {
			%>
			<tr>
				<td><%=cliente.getDni_cliente()  %></td>
				<td><%=cliente.getNombre_cliente() %></td>
				<td><%=cliente.getApellido_cliente() %></td>
				<td><%=cliente.getCuil_cliente() %></td>
				<td><%=cliente.getCorreo_electronico_cliente() %></td>
				<td><a href="ServletClientes?Param=CargarModificarCliente&Param2=<%=cliente.getDni_cliente()%>"> Modificar </a> <br /></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

</body>
</html>