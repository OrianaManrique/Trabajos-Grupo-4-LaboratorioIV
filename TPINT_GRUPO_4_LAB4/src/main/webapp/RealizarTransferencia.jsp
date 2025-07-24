<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>
<%@page import="entidad.*"%>


<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="UTF-8">
<meta charset="UTF-8">
<title>Realizar transferencia</title>
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

.subtitulo {
	text-align: center;
	font-size: 20px;
	color: #44107a;
	margin-bottom: 20px;
	margin-top: 20px;
	font-weight: bold;
}

.table-container {
	justify-content: center;
	width: 40%;
	margin-left: 36%;
	font-size: 20px;
	align-items: center;
}

/* Estilos de la tabla */
.movements-table {
	width: 70%;
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
	border: 1px solid #bc9fd6;
}

.form-columna input {
	width: 93%;
	padding: 10px;
	margin-bottom: 10px;
	border: none;
	border-radius: 8px;
	font-weight: bold;
	text-align: center;
	font-size: 12px;
}

input::placeholder {
	font-size: 13px;
	text-align: center;
}

.form-columns {
	display: flex;
}

.form-columna {
	flex: 1;
	display: flex;
	flex-direction: column;
	gap: 15px;
	text-align: center;
}

.lblinput {
	color: white;
}

input, select, textarea {
	text-align: center;
}

.ContenedorBoton {
	display: flex;
	justify-content: center;
	margin-top: 20px;
	margin-right: 251px;
}

.btn-siguiente {
            margin-top: 30px;
            background: linear-gradient(to right, #bc9fd6, #44107a);
            color: white;
            padding: 12px 25px;
            font-size: 16px;
            border: none;
            border-radius: 8px;
            cursor: pointer;
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
	%>


	<div class="header"><%=usuario.getNombre_us()%>	<%=usuario.getApellido_us()%>	- Cliente - <a Style="color: white" href="InicioLogin.jsp"> Cerrar sesión </a>	</div>

	<form action="ServletMovimientos?Param=ConfirmarTransferencia"
		method="post">
		<div class="subtitulo">TRANSFERENCIAS</div>
		<div class="table-container">
			<table class="movements-table">
				<thead>
					<tr>
						<th>CUENTA ORIGEN</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><select class="form-select form-select-lg mb-3"
							id="ddlCuentas" name="ddlCuentas" required>
								<option value="" >Seleccione una cuenta</option >
								<%
								for (Cuenta c : ListaCuentas) {
								%>
								<option value="<%=c.getCbu_cuenta()%>">CTA N° -
									<%=c.getNroCuenta_cuenta()%></option>
								<%
								}
								%>
						</select></td>
					</tr>
				</tbody>
			</table>

			<table class="movements-table">
				<thead>
					<tr>
						<th>DESTINO</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input class="form-control" type="text"
							id="txtCBUdestino" name="txtCBUdestino"
							placeholder="Ingrese el CBU a transferir..." required></td>
					</tr>
				</tbody>
			</table>

			<table class="movements-table">
				<thead>
					<tr>
						<th>MONTO</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input class="form-control" type="number" max="99999999"
							id="txtMonto" name="txtMonto" placeholder="$$$" required></td>
					</tr>
				</tbody>
			</table>

			<table class="movements-table">
				<thead>
					<tr>
						<th>MOTIVO</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><select class="form-select form-select-lg mb-3"
							id="ddlMotivo" name="ddlMotivo">
								<option value="">Seleccione un motivo</option>
								<option value="Haberes">Haberes</option>
								<option value="Facturas">Facturas</option>
								<option value="Expensas">Expensas</option>
								<option value="Prestamos">Préstamos</option>
								<option value="Seguros">Seguros</option>
								<option value="Varios">Varios</option>
						</select></td>
					</tr>
				</tbody>
			</table>

			<div class="ContenedorBoton">
				<input class="btn-siguiente" type="submit"
					value="ACEPTAR">
			</div>
			<%
			if (request.getAttribute("Exito") != null) {
				if (((Boolean) request.getAttribute("Exito")) == true) {
			%>
			<div class="ContenedorBoton">
				<label id="lblMensajeExito"
					style="color: green; font-weight: bold; font-size: 20px; justify-content: center;">
					¡TRANSFERENCIA REALIZADA CON ÉXITO! </label>
			</div>
			<%
			} else {
			%>
			<div class="ContenedorBoton">
				<label id="lblMensajeError"
					style="color: red; font-weight: bold; font-size: 20px; justify-content: center;">
					ERROR AL REALIZAR LA TRANSFERENCIA. </label>
			</div>
			<%
			}
			}
			%>

		</div>
	</form>

</body>
</html>