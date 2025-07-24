<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="entidad.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet">
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
	String visibilidadTablaCuentas = "display: none;";
	String visibilidadTablaModificar = "display: none;";
	int DniBusqueda=0;
	int TipoSeleccionado=0;
	TipoCuenta tipoCuenta = new TipoCuenta();
	Cliente cliente = new Cliente();
	Cuenta cuenta = new Cuenta();
	
	ArrayList<Cuenta> ListaCuentas = new ArrayList<Cuenta>();
	if (request.getAttribute("ListaCuentas") != null) {
		ListaCuentas = (ArrayList<Cuenta>) request.getAttribute("ListaCuentas");	
	}
	
	ArrayList<TipoCuenta> ListaTipoCuentas = new ArrayList<TipoCuenta>();
	if (request.getAttribute("ListaTipoCuentas") != null) {
		ListaTipoCuentas = (ArrayList<TipoCuenta>) request.getAttribute("ListaTipoCuentas");	
	}
	
	if (request.getAttribute("Cliente") != null) {
		cliente = (Cliente) request.getAttribute("Cliente");
		visibilidadTablaCuentas = "";
	}
	
	if (request.getAttribute("Cuenta") != null) {
		cuenta = (Cuenta) request.getAttribute("Cuenta");
		visibilidadTablaModificar = "";
		TipoSeleccionado = cuenta.getTipo_cuenta().getId_tipoCuenta();
	}else{
		//SI SACAS ESTA DECLARACION EXPLOTA TODO
		cuenta.setSaldo_cuenta(1f);
	}
	
	if (request.getAttribute("DniBusqueda") != null) {
		DniBusqueda = (int)request.getAttribute("DniBusqueda");
	}

	
	%>

	<%

Usuario usuario = new Usuario();

if(session.getAttribute("usuarioLogueado") != null){

    usuario = (Usuario)session.getAttribute("usuarioLogueado");

//}else {
//	response.sendRedirect("InicioLogin.jsp");
}
 %>

<div class="header">
<%=usuario.getNombre_us()%> <%=usuario.getApellido_us()%> - Administrador - <a Style="color: white" href="InicioLogin.jsp"> Cerrar sesión </a>
</div>

	<form action="ServletCuentas?Param=BuscarCuentasModificar"
		method="post">
		
		 <p style="Color: purple; font-weight: bold; font-size: 50px"> MODIFICAR CUENTA</p>
		 
		<input style="width: 25%; margin-top: 20px;" type="search"
			name="txtBusqueda" placeholder="Ingrese un Dni..." required /> 
			<input class="btn btn-outline-success" name="BuscarCuentasDni" type="submit" >
	</form>

	<form action="ServletCuentas?Param=GuardarModificacionCuenta&dnibusqueda=<%=DniBusqueda%>"  method="post">
		<div class="table-container">
			<table class="movements-table">

				<thead>
					<tr>
						<th style="<%=visibilidadTablaCuentas%>" colspan="4"><%=cliente.getNombre_cliente()%> - <%=cliente.getDni_cliente()%></th>
					</tr>
					<tr>
						<th style="width: 25%">NUMERO CUENTA</th>
						<th style="width: 50%">TIPO</th>
						<th style="width: 25%">ACCIÓN</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (Cuenta cuentaCliente : ListaCuentas) {
				    %>
					<tr>
						<td><p><%=cuentaCliente.getNroCuenta_cuenta()%></p></td>					
						<td><p><%=cuentaCliente.getTipo_cuenta().getDescripcion_tipoCuenta()%></p></td>
						<td><a href="ServletCuentas?Param=SeleccionModificar&NumeroCuenta=<%=cuentaCliente.getNroCuenta_cuenta()%>&dnibusqueda=<%=DniBusqueda%>"> Seleccionar </a> <br /></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>

		<div class="table-container">
			<table class="movements-table2">
				<thead>
					<tr>
						<th>NUMERO CUENTA</th>
						<th>DNI CLIENTE</th>
						<th>FECHA DE CREACIÓN</th>
						<th>CBU</th>
						<th>TIPO</th>
						<th>SALDO</th>
						<th>ACCION</th>
					</tr>
				</thead>
				<tbody>
					<tr style="<%=visibilidadTablaModificar%>">
						<th><p><%=cuenta.getNroCuenta_cuenta()%></p>
						<input type="hidden" name="nroCuenta" value="<%=cuenta.getNroCuenta_cuenta()%>">					
						</th>
						
						<th><p><%=cuenta.getDni_Cliente()%></p></th>
						<th><p><%=cuenta.getFechaCreacion_cuenta()%></p></th>
						<th><p>	<input type="text" name="txtCBU" value="<%=cuenta.getCbu_cuenta()%>"></p></th>
						<th><select id="ddlTipoCuenta" name="ddlTipoCuenta">
						<option value="">Seleccione El tipo...</option>
					     <%
					     for (TipoCuenta tipocuenta : ListaTipoCuentas) {
				         %>				
						 <option value="<%=tipocuenta.getId_tipoCuenta()%>" <%=tipocuenta.getId_tipoCuenta() == TipoSeleccionado ? "selected" : "" %>> <%= tipocuenta.getDescripcion_tipoCuenta()%></option>											     			
						<%
					     }
					    %>    
					     </select></th>
					     
						<th><p>	<input type="number" name="txtSaldo" value="<%=cuenta.getSaldo_cuenta()%>">	</p></th>
						<th><input class="btn btn-success" type="submit" value="GUARDAR"></th>
					</tr>
				</tbody>
			</table>

			<br /> <br />
			    
			    <%  
			      
			    if(request.getAttribute("Exito")!=null){
			    	
			    	if(((Boolean)request.getAttribute("Exito"))==true){
			    		
			    		%>		    		
			    		
			    		<p><label id="lblMensajeExito"	style="Color: green; font-weight: bold; font-size: 20px"> ¡SE MODIFICO LA CUENTA CON ÉXITO!</label></p>
			    				
			    		<%
			    		
			    	}else{
			    		
			    		
                        %>		    		
			    		
			    		<label id="lblMensajeError"	style="Color: red; font-weight: bold; font-size: 20px">NO SE HA PODIDO MODIFICAR LA CUENTA</label>
			    				
			    		<%
			    		
			    	}
			    }
			    
			    %>
			    
		</div>

	</form>
</body>
</html>