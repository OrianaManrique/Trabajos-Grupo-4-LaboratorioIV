<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="entidad.*"%>
<%@page import="java.time.LocalDate"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pago de Cuotas</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.header {
	background: linear-gradient(to right, #bc9fd6, #44107a);
	color: white;
	padding: 20px;
	text-align: center;
	font-weight: bold;
	font-size: 20px;
}

.subtitulo {
	text-align: center;
	font-size: 35px;
	color: #44107a;
	margin: 30px 0;
	font-weight: bold;
}

.table th {
	background-color: #8e5cc4;
	color: white;
	text-align: center;
}

.table td {
	text-align: center;
	vertical-align: middle;
}

.btn-pay {
	background-color: #44107a;
	color: white;
}

.btn-pay:hover {
	background-color: #5e2b91;
}

.estado-pagado {
	color: green;
	font-weight: bold;
}
</style>
</head>
<body>

	<%
	Usuario usuario = new Usuario();
	Cuenta cuenta = new Cuenta();
	Cuota cuota = new Cuota();
	Prestamo prestamoSeleccionado = new Prestamo();
	Float Saldo = 0f;
	int cantCuotas = -1;
	String VisibilidadCuotas="display: none";
	String VisibilidadDesplegable="display: none";
	String VisibilidadPrestamoPagado="display: none";
	
	if (session.getAttribute("usuarioLogueado") != null) {

		usuario = (Usuario) session.getAttribute("usuarioLogueado");

		//}else {
		//    response.sendRedirect("InicioLogin.jsp");
	}

	ArrayList<Cuenta> ListaCuentas = new ArrayList<Cuenta>();
	if (request.getAttribute("ListaCuentas") != null) {
		ListaCuentas = (ArrayList<Cuenta>) request.getAttribute("ListaCuentas");
	}

	if (request.getAttribute("CuentaSeleccionada") != null) {
		cuenta = (Cuenta) request.getAttribute("CuentaSeleccionada");
		Saldo = cuenta.getSaldo_cuenta();
	}
	
	ArrayList<Prestamo> ListaPrestamos = new ArrayList<Prestamo>();
	if (request.getAttribute("ListaPrestamos") != null) {
		ListaPrestamos = (ArrayList<Prestamo>) request.getAttribute("ListaPrestamos");
	}
	
	ArrayList<Cuota> ListaCuotas = new ArrayList<Cuota>();
	if (request.getAttribute("ListaCuotas") != null) {
		ListaCuotas = (ArrayList<Cuota>) request.getAttribute("ListaCuotas");
	}	

	if (request.getAttribute("PrestamoSeleccionado") != null) {
		prestamoSeleccionado = (Prestamo)request.getAttribute("PrestamoSeleccionado");
	}
	
	if (request.getAttribute("CantidadCuotasPagadas") != null) {
		cantCuotas = (int)request.getAttribute("CantidadCuotasPagadas");
		
		VisibilidadCuotas = "display: table-cell";
		VisibilidadDesplegable = "display: block";
	}
	
	if (request.getAttribute("EstadoPagoPrestamo") != null) {
		
		if ((boolean)request.getAttribute("EstadoPagoPrestamo") == true) {
		  
			VisibilidadCuotas = "display: none";
			VisibilidadDesplegable = "display: none";
			VisibilidadPrestamoPagado = "display: block";
		  
		   }else{
			   
			VisibilidadPrestamoPagado = "display: none"; 
		   }	
	
	}
	
	%>


	<div class="header"> <%= usuario.getNombre_us() %> <%= usuario.getApellido_us() %> - Cliente</div>
	

	<div class="container">
		<div class="subtitulo">Préstamos</div>

		

		<table class="table table-bordered table-hover">
		<thead>
			<tr>
				<th>Cuenta</th>
				<th>Importe Solicitado</th>
				<th>Importe A Pagar</th>
				<th>Plazo de pago</th>
				<th>Cantidad de Cuotas</th>
				<th>Fecha Creación</th>
				<th>Monto Mensual</th>
				<th>Acción</th>
			</tr>
		</thead>
		<tbody>
		
		<%
			for (Prestamo prestamo : ListaPrestamos) {
		%>
					
			<tr>
				
				<td><%= prestamo.getNroCuenta_prestamo().getNroCuenta_cuenta() %></td>
				<td><%= prestamo.getImporteSolicitado_prestamo() %></td>
				<td><%= prestamo.getImporteApagar_prestamo() %></td>
				<td><%= prestamo.getPlazoDePago_prestamo()%> - Meses</td>
				<td><%= prestamo.getCuotas_prestamo() %></td>
				<td><%= prestamo.getFechaCreacion_prestamo() %></td>
				<td><%= prestamo.getMontoMensual_prestamo() %></td>
						
				<td>	
				
				 <form action="ServletMovimientos?Param=SeleccionarPrestamoPagar" method="post">	
				 
				 <input type="hidden" id="Id_Prestamo" name="Id_Prestamo" value="<%=prestamo.getId_prestamo()%>">				 
				 <input type="hidden" id="ImporteSolicitado_Prestamo" name="ImporteSolicitado_Prestamo" value="<%=prestamo.getImporteSolicitado_prestamo() %>">
		    				
				<button type="submit" class="btn btn-pay">Seleccionar</button>

				 
			    </form>	
			    </td>
							
			</tr>
				
										
			<%
			}
			%>
		</tbody>
		</table>
		
		<br>
		<br>
		
		<div class="subtitulo">Pago de Cuotas</div>
		<div style="font-size: 20px;" class="subtitulo">Cuenta a debitar</div>
		
	<form action="ServletMovimientos?Param=PagarCuotaPrestamo" method="post">
	
		<div style="width: 250px ; <%=VisibilidadDesplegable%>; margin: auto;">
				<select class="form-select form-select-lg mb-3"
					id="ddlCuentasPagoPrestamo" name="ddlCuentasPagoPrestamo">
					<option value="">Seleccione una cuenta</option>
					<%
					for (Cuenta c : ListaCuentas) {
					%>
					<option value="<%=c.getNroCuenta_cuenta()%>">CTA N° -
						<%=c.getNroCuenta_cuenta()%></option>
					<%
					}
					%>
				</select>
		</div>
		
		<table class="table table-bordered table-hover">
		<thead>
			<tr>
				<th>Monto a abonar</th>
				<th>Fecha de pago</th>
				<th>Corresponde a Cuota</th>
				<th>Acciónes</th>
			</tr>
		</thead>
		<tbody>

			<tr>		
				<td style="<%=VisibilidadCuotas%>"><%=prestamoSeleccionado.getMontoMensual_prestamo() %></td>
				<td style="<%=VisibilidadCuotas%>"><%=LocalDate.now()%></td>
				<td style="<%=VisibilidadCuotas%>"><%=cantCuotas+1%>/<%=prestamoSeleccionado.getCuotas_prestamo() %></td>
				<td style="<%=VisibilidadCuotas%>">	
				

				 
				 <input type="hidden" id="Id_PrestamoSeleccionado" name="Id_PrestamoSeleccionado" value="<%=prestamoSeleccionado.getId_prestamo()%>">	
				 			 		    				
				<button type="submit" name="BotonCuotas" Value="PagarCuota" class="btn btn-pay">Pagar Cuota</button>
				<button type="submit" name="BotonCuotas" Value="VerAnterioresCuotas" class="btn btn-pay">Cuotas Anteriores</button>
			  
			    
			    </td>
							
			</tr>

		</tbody>
		</table>
		
          <div style="color: green; <%=VisibilidadPrestamoPagado%>" class="subtitulo">¡Felicidades, Prestamo Pagado!</div>
		
		</form>
		
		<br>
		<br>
		
		<div class="subtitulo"> Cuotas Anteriores</div>
		
		<table class="table table-bordered table-hover">
		<thead>
			<tr>
				<th>Monto abonado</th>
				<th>Fecha de pago</th>
			</tr>
		</thead>
		<tbody>

			<%
			for (Cuota cuotas : ListaCuotas) {
		    %>
					
			<tr>
			
				<td><%= cuotas.getMonto_cuota()%></td>
				<td><%= cuotas.getFechaPago_cuota()%></td>
							
			</tr>
														
			<%
			}
			%>

		</tbody>
		</table>
	</div>

</body>
</html>