<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="entidad.*"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr"
	crossorigin="anonymous">
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

.table-container {
	width: 95%;
	margin: auto;
	margin-top: 20px;
	overflow-x: auto;
	font-size: 20px;
}

.table-container2 {
	width: 95%;
	margin: auto;
	margin-top: 40px;
	overflow-x: auto;
	font-size: 20px;
}

/* Estilos de la tabla */
.movements-table {
	width: 100%;
	border-collapse: collapse;
	text-align: center;
	font-size: 20px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.05);
}

.movements-table th {
	text-align: center;
	vertical-align: middle;
}

.movements-table thead {
	background: linear-gradient(to right, #602A80, #4C0026);
	color: white;
}

.movements-table th, .movements-table td {
	padding: 12px;
	border: 20px solid #ddd;
}

.movements-table2 {
	width: 100%;
	border-collapse: collapse;
	text-align: center;
	font-size: 20px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.3);
}

.movements-table2 thead {
	background: linear-gradient(to right, #03c57e, #1eac04);
	color: white;
}

.movements-table2 th, .movements-table2 td {
	padding: 12px;
	border: 1px solid black;
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
</style>


<body>
	<%
	String nombreCliente = "Oriana Manrique";
	int dniCliente = 41200035;
	int NroCuenta = 11001;
	float Saldo = 10000;
	String Fecha = "2/7/2077";
	String CBU = "1234567891123456789123";
	TipoCuenta tipoCuenta = new TipoCuenta();
	%>


	<div class="header">Usuario logueado - Cuenta Banco</div>

	<form action="ServletCuentas?Param=GuardarModificacion" method="post">
		<input style="width: 25%" type="search" name="txtBusqueda"
			placeholder="Ingrese un Dni..." />
		<button class="btn btn-outline-success" type="submit">Buscar</button>

		<div class="table-container">
			<table class="movements-table">

				<thead>
					<tr>
						<th colspan="4"><%=nombreCliente%> - <%=dniCliente%></th>
					</tr>
					<tr>
						<th style="width: 25%">NUMERO CUENTA</th>
						<th style="width: 50%;">TIPO</th>
						<th style="width: 25%">ACCIÓN</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><p><%=NroCuenta%></p></td>
						<td><p><%=tipoCuenta.getDescripcion_tipoCuenta()%></p></td>
						<td><a href="ServletClientes?Param="> Seleccionar </a> <br /></td>
					</tr>
					<tr>
						<td><p><%=NroCuenta%></p></td>
						<td><p><%=tipoCuenta.getDescripcion_tipoCuenta()%> </p></td>
						<td><a href="ServletClientes?Param="> Seleccionar </a> <br /></td>
					</tr>
					<tr>
						<td><p><%=NroCuenta%></p></td>
						<td><p><%=tipoCuenta.getDescripcion_tipoCuenta()%></p></td>
						<td><a href="ServletClientes?Param="> Seleccionar </a> <br /></td>
					</tr>
				</tbody>
			</table>
		</div>

		<div class="table-container2">
			<table class="movements-table2">
				<thead>
					<tr>
						<th>NUMERO CUENTA</th>
						<th>DNI CLIENTE</th>
						<th>CBU</th>
						<th>TIPO</th>
						<th>SALDO</th>
						<th>FECHA DE CREACIÓN</th>
						<th>ACCION</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th><p><%=NroCuenta%></p></th>
						<th><p><%=dniCliente%></p></th>
						<th><p>
								<input type="text" value="<%=CBU%>">
							</p></th>
						<th><select id="miDesplegable">
								<option value="1">Caja de ahorro</option>
								<option value="2">Cuenta Corriente</option>
						</select></th>
						<th><p>
								<input type="number" value="<%=Saldo%>">
							</p></th>
						<th><p><%=Fecha%></p></th>
						<th><input class="btn btn-success" type="submit"
							value="GUARDAR"></th>
					</tr>
				</tbody>
			</table>

			<br /> <br /> <label id="lblMensajeExito"
				style="visibility: visible; Color: green">EXITO ! SE
				MODIFICO LA CUENTA</label> <br /> <br /> <label id="lblMensajeError"
				style="visibility: visible; Color: red">ERROR ! NO SE PUDO
				MODIFICAR LA CUENTA</label>

		</div>

	</form>
</body>
</html>