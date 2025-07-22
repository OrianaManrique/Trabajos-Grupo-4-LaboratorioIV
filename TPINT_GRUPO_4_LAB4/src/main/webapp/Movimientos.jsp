<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="entidad.*"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>HistorialMovimientos</title>
</head>

<style>
body {
	background-color: white;
	font-family: 'Segoe UI', sans-serif;
	margin: 0;
	padding: 0;
	color: #333;
	justify-content: center;
	text-align: center;
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

.balance-container {
	display: flex;
	justify-content: center;
	gap: 40px;
	margin: 30px 0;
	flex-wrap: wrap;
}

.balance-box {
	background-color: #44107a;
	color: white;
	padding: 25px 35px;
	border-radius: 12px;
	font-size: 26px;
	font-weight: bold;
	text-align: center;
	box-shadow: 0 4px 10px rgba(204, 0, 143, 0.3);
	min-width: 200px;
}

.subtitulo {
	text-align: center;
	font-size: 30px;
	color: #44107a;
	margin-bottom: 20px;
	margin-top: 40px;
	font-weight: bold;
}

.table-container {
	width: 95%;
	margin: auto;
	overflow-x: auto;
	font-size: 20px;
}

/* Estilos de la tabla */
.movements-table {
	width: 100%;
	border-collapse: collapse;
	text-align: center;
	font-size: 20px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.05);
}

.movements-table thead {
	/*background-color: #bc9fd6;*/
	background: linear-gradient(to right, #bc9fd6, #44107a);
	color: white;
}

.movements-table th, .movements-table td {
	padding: 12px;
	border: 1px solid #ddd;
}

/* gris claro */
.alternarfilas {
	background-color: #f9f9f9;
}

.mov-positivo {
	color: #1ca51c;
	font-weight: bold;
}

.mov-negativo {
	color: #e6324b;
	font-weight: bold;
}

.info-icon {
	color: #44107a;
	font-weight: bold;
	font-size: 16px;
	cursor: pointer;
}

p {
	font-size: 16px;
	text-align: center;
}
</style>

<body>

	<%
	Usuario usuario = new Usuario();

	if (session.getAttribute("usuarioLogueado") != null) {

		usuario = (Usuario) session.getAttribute("usuarioLogueado");

		//}else {
		//    response.sendRedirect("InicioLogin.jsp");
	}
	
	ArrayList<Cuenta> ListaCuentas = new ArrayList<Cuenta>();
	if (request.getAttribute("ListaCuentas") != null) {
		ListaCuentas = (ArrayList<Cuenta>) request.getAttribute("ListaCuentas");
	}
	
	ArrayList<Movimiento> ListaMovimientos = new ArrayList<Movimiento>();
	if (request.getAttribute("ListaMovimientos") != null) {
		ListaMovimientos = (ArrayList<Movimiento>) request.getAttribute("ListaMovimientos");
	}
	%>
	
	
	
	<div class="header">
		<%=usuario.getNombre_us()%>
		<%=usuario.getApellido_us()%>
		- Cliente
	</div>

	<form action="ServletMovimientos?Param=ActualizarTablaMovimientos" method="get">
		<div class="subtitulo">HISTORIAL DE MOVIMIENTOS</div>
		
		<br /> 
		<div style="width: 250px; margin: auto;">
		      <select class="form-select form-select-lg mb-3" id="ddlCuentas" name="ddlCuentas" onchange="this.form.submit()">
				<option value="">Seleccione una cuenta</option>
					<%
					for (Cuenta c : ListaCuentas) {
					%>
					<option value="<%=c.getNroCuenta_cuenta()%>">CTA N° -
					<%=c.getNroCuenta_cuenta()%></option>
					<%
					}
					%>
				<option value="TodasCuentas">Todas las cuentas</option>
			</select>
		</div>
		<br/>
		<br/>
		<br/>
		<div class="table-container">
			<table class="movements-table">
				<thead>
					<tr>
						<th>NÚMERO DE CUENTA</th>
						<th>FECHA</th>
						<th>DETALLE</th>
						<th>TIPO DE MOVIMIENTO</th>
						<th>IMPORTE</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (Movimiento listaMovimiento : ListaMovimientos) {
				    %>
					<tr>
						<td><p><%=listaMovimiento.getNroCuenta_movimiento()%></p></td>					
						<td><p><%=listaMovimiento.getFecha_movimiento()%></p></td>
						<td><p><%=listaMovimiento.getDetalle_movimiento()%></p></td>
						<td><p><%=listaMovimiento.getId_tipoMovimiento().getDescripcion_tipomovimiento()%></p></td>
						<td><p><%=listaMovimiento.getImporte_movimiento()%></p></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</form>

</body>
</html>