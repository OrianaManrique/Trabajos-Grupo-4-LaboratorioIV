<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "entidad.*" %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>CuentaCliente</title>
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
    color: #704be7;
    font-size: 24px;
    margin-bottom: 20px;
    font-weight: bold;
}

.table-container {
    width: 95%;
    margin: auto;
    overflow-x: auto;
}

/* Estilos de la tabla */
.movements-table {
    width: 100%;
    border-collapse: collapse;
    text-align: center;
    font-size: 15px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.05);
}

.movements-table thead {
    background-color: #bc9fd6;
    color: white;
}

.movements-table th,
.movements-table td {
    padding: 12px;
    border: 1px solid #ddd;
}

/* gris claro */
.alternarfilas{
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
Cuenta cuenta = new Cuenta();
Float Saldo = 0f;

if(session.getAttribute("usuarioLogueado") != null){

    usuario = (Usuario)session.getAttribute("usuarioLogueado");

//}else {
//    response.sendRedirect("InicioLogin.jsp");
}

ArrayList<Cuenta> ListaCuentas = new ArrayList<Cuenta>();
if (request.getAttribute("ListaCuentas") != null) {
	ListaCuentas = (ArrayList<Cuenta>) request.getAttribute("ListaCuentas");
}

if(request.getAttribute("CuentaSeleccionada")!= null){
	cuenta = (Cuenta) request.getAttribute("CuentaSeleccionada");
	Saldo = cuenta.getSaldo_cuenta();	
}

 %>


<div class="header"> <%=usuario.getNombre_us()%> <%=usuario.getApellido_us()%> - Cliente </div> - <a Style="color: white" href="InicioLogin.jsp"> Cerrar sesión </a>

<form action="ServletCuentas"  method="get">
  		<div style="width: 250px; margin: auto;">
		      <select class="form-select form-select-lg mb-3" id="ddlCuentasInicioCliente" name="ddlCuentasInicioCliente" onchange="this.form.submit()">
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
</form>		
  <div class="balance-container">
    <div class="balance-box">
      $<%=Saldo%>
      <p>Disponible en pesos argentinos</p>
    </div>
  </div>

  <div class="table-container">
    <a href="ServletMovimientos?Param=CargarCuentasMovimientos"> Movimientos </a> 
    <br/>
    <a href="ServletMovimientos?Param=CargarCuentasTransferencias"> Nueva Transferencia </a>
    <br/>
    <a href="ServletMovimientos?Param=CargarJSPSolicitudPrestamo"> Solicitar Préstamo </a>
    <br/>
    <a href="ServletMovimientos?Param=CargarJSPPagoPrestamo"> Pago de Préstamos </a>
    <br/>
    <a href="ServletClientes?Param=CargarDatosCliente"> Mi cuenta </a>

  </div>

</body>
</html>