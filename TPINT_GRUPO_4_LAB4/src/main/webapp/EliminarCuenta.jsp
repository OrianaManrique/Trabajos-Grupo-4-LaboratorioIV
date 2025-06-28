<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="entidad.Cliente"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EliminarCliente</title>
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

.balance-container {
	display: flex;
	justify-content: center;
	gap: 40px;
	margin: 30px 0;
	flex-wrap: wrap;
}

.balance-box {
	
	background: linear-gradient(to right, #A178C1, #A14C6F); ,
	color: white;
	padding: 25px 35px;
	border-radius: 12px;
	font-size: 26px;
	font-weight: bold;
	text-align: center;
	box-shadow: 0 4px 10px rgba(204, 0, 143, 0.3);
	min-width: 200px;
	width: 500px;
	height: 400px;
	/**/
	display: flex;
	flex-direction: column;
	justify-content: space-between;
	align-items: center;
}

.btn input[type="submit"] {
	background-color: #4C0026;
	color: white;
	border: none;
	border-radius: 8px;;
	font-size: 1rem;
	padding: 10px 20px;
	cursor: pointer;
	margin-top: 15px;
	display: inline-block;
	text-align: center;
	text-decoration: none;
}

.btn:hover {
	background-color: #602A80;
}

.contenedor {
	display: flex;
	flex-direction: column;
	justify-content: flex-end; 
	align-items: center; 
}

p {
	font-size: 22px;
	text-align: center;
	color: white;
	font-weight: bold;
	text-align: center;
}

.form-group input[type="text"] {
	width: 100%;
	padding: 10px;
	background-color: #ddd;;
	border: 1px solid #ccc;
	border-radius: 8px;
	font-size: 1rem;
	box-sizing: border-box;
}

table {
	table-layout: auto;
	font-size: 18px;
	justify-content: center;
	text-align: center;
}
</style>
</head>
<body>

	<%
	Cliente cliente = new Cliente();
	String VisibilidadTabla = "none";
	String VisibilidadBoton = "none";

	if (request.getAttribute("Cliente") != null) {
		cliente = (Cliente) request.getAttribute("Cliente");

		VisibilidadTabla = "table";
		VisibilidadBoton = "inline";

	}
	%>

	<form action="ServletCuentas?Param=Buscar" method="post">
		<div class="header">Usuario logueado - Cuenta Banco</div>

		<div class="balance-container">
			<div class="balance-box">

				<p>ELIMINAR CUENTA</p>


				<input type="text" name="NumeroDeCuenta" placeholder="Numero de cuenta..."
					required>

				<table class="table" style="display:<%=VisibilidadTabla%>">
					<thead>
						<tr>
							<th>| DNI |</th>
							<th>| NOMBRE |</th>
							<th>| APELLIDO |</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><%=cliente.getDni_cliente()%></td>
							<td><%=cliente.getNombre_cliente()%></td>
							<td><%=cliente.getApellido_cliente()%></td>
						</tr>
					</tbody>
				</table>

				<%

				if (request.getAttribute("Exito") != null) {
					Boolean exito = (Boolean) request.getAttribute("Exito"); 

					if (exito != null && exito) { 
				%>
				<p style="color: green;">Cuenta Eliminada</p>
				<%
				} else { 
				%>
				<p style="color: red;">ERROR - no se encuentra la Cuenta</p>
				<%
				}
				}
				%>

				<div class="contenedor">
					<input type="submit" value="Eliminar" name="btnEliminarCuenta" />

				</div>
			</div>
		</div>

	</form>



</body>
</html>