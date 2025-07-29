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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"rel="stylesheet"> 
<meta charset="UTF-8">

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

}else {
	response.sendRedirect("InicioLogin.jsp");
}

ArrayList<Prestamo> ListaPrestamos = new ArrayList<Prestamo>();
if (request.getAttribute("ListaPrestamos") != null) {
	ListaPrestamos = (ArrayList<Prestamo>) request.getAttribute("ListaPrestamos");
}
 %>

<div class="header">
<%=usuario.getNombre_us()%> <%=usuario.getApellido_us()%> - Administrador - <a Style="color: white" href="InicioLogin.jsp"> Cerrar sesión </a>
</div>

	<br />
	<br />

	<p>
		<Strong>AUTORIZAR PRESTAMOS</Strong> <br /> <br /> <br />
	</p>




      <table id="table_id" class="display">
		<thead>
			<tr>
				<th>Dni</th>
				<th>Cuenta</th>
				<th>Importe Solicitado</th>
				<th>Importe A Pagar</th>
				<th>Plazo de pago</th>
				<th>Cuotas</th>
				<th>Fecha Creación</th>
				<th>Monto Mensual</th>
				<th>Condición</th>
				<th>	</th>
			</tr>
		</thead>
		<tbody>
		
		<%
			for (Prestamo prestamo : ListaPrestamos) {
		%>
			<tr>
				
				<td><%= prestamo.getDniCliente_prestamo().getDni_cliente()%></td>
				<td><%= prestamo.getNroCuenta_prestamo().getNroCuenta_cuenta() %></td>
				<td><%= prestamo.getImporteSolicitado_prestamo() %></td>
				<td><%= prestamo.getImporteApagar_prestamo() %></td>
				<td><%= prestamo.getPlazoDePago_prestamo()%> - Meses</td>
				<td><%= prestamo.getCuotas_prestamo() %></td>
				<td><%= prestamo.getFechaCreacion_prestamo() %></td>
				<td><%= prestamo.getMontoMensual_prestamo() %></td>
				<td><%= prestamo.getCondicion_prestamo()%></td>
						
				<td>	
				
				 <form action="ServletMovimientos?Param=Autorizar-RechazarPrestamo" method="post">
				 
				 <input type="hidden" id="Id_Prestamo" name="Id_Prestamo" value="<%=prestamo.getId_prestamo()%>">				 
				 <input type="hidden" id="DniCliente_Prestamo" name="DniCliente_Prestamo" value="<%=prestamo.getDniCliente_prestamo().getDni_cliente()%>">
				 <input type="hidden" id="NumeroCuenta_Prestamo" name="NumeroCuenta_Prestamo" value="<%=prestamo.getNroCuenta_prestamo().getNroCuenta_cuenta()%>">
				 <input type="hidden" id="ImporteSolicitado_Prestamo" name="ImporteSolicitado_Prestamo" value="<%=prestamo.getImporteSolicitado_prestamo() %>">
		    				
				 <button type="submit" name="Condicion" value="A" class="btn btn-success btn-sm">Autorizar</button>
				 <button type="submit" name="Condicion" value="R" class="btn btn-danger btn-sm">Rechazar</button>
				  
			     </form>	
			    </td>
							
			</tr>
				
										
			<%
			}
			%>
		</tbody>
	</table>

	
</body>
</html>