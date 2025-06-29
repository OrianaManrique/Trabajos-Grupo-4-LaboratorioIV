<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.*"%>
<!DOCTYPE html>
<html>
<head>
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

.ContenedorVentana {
	background-color: #4A217C;
	width: 700px;
	height: 450px;
	border-radius: 8px;
}

.ContenedorTitulo {
	background-color: #E5E5E5;
	width: 300px;
	margin: 0 auto;
	text-align: center;
	border-radius: 8px;
}

.ContenedorColumna {
	display: flex;
	flex-direction: column;
	margin-top: 15px;
	margin-left: 90px;
	gap: 10px;
}

.ContenedorBoton {
	margin: 0 auto;
	width: 260px;
	height: 100px;
}

.btnModificar {
	width: 260px;
	height: 30%;
}

.FormularioUsuario {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	gap: 10px;
	margin-right: 12%;
}

.FormularioUsuario input {
	border-radius: 8px;
}

input::placeholder {
	font-size: 13px;
	text-align: center;
}

.inputBloqueado {
	color: grey;
}

.inputFechaActual {
	width: 157px;
}

.inputddlTipoCuenta {
	width: 166px;
}

.ContenedorControles {
	display: flex;
	justify-content: space-around;
	align-items: flex-start;
	gap: 20px;
}

.form-columns {
	display: flex;
	gap: 40px;
}

.form-columna {
	flex: 1;
	display: flex;
	flex-direction: column;
	gap: 15px;
}

.form-columna2 {
	flex: 1;
	display: flex;
	flex-direction: column;
	gap: 15px;
	margin-top: 20px;
}

.lblinput {
	color: white;
}
</style>
  
  
<% 

Cuenta cuenta = new Cuenta();
int TipoSeleccionado = 0;

if (request.getAttribute("CuentaEditar") != null) {
	cuenta = (Cuenta) request.getAttribute("CuentaEditar");
   }

ArrayList<Tipo_Cuenta> ListaTipoCuentas = new ArrayList<Tipo_Cuenta>();
if (request.getAttribute("Tipos") != null) {
	ListaTipoCuentas = (ArrayList<Tipo_Cuenta>) request.getAttribute("Tipos");
}


if (request.getAttribute("TipoSeleccionado") != null) {
	TipoSeleccionado = (int)request.getAttribute("TipoSeleccionado");
   }

%>

<body>

<div class="header">Usuario logueado - Cuenta Banco</div>
	
	<form action="ServletCuentas?Param=Modificar" method="post">

	<a href="InicioLogin.jsp"> Inicio </a>

	<div class="ContenedorVentana">
		<div class="ContenedorTitulo">
			<h2>
				<strong style="color: #5F1AB4">MODIFICAR CUENTA</strong>
			</h2>
		</div>

		<br /> <br />

		<div class="ContenedorControles">

			<div class="form-columns">

				<div class="form-columna">

					    <label class="lblinput"> Numero de Cuenta - Bloqueado</label> 
					    <input class="inputBloqueado" value="<%=cuenta.getNroCuenta_cuenta()%>" type="text" id="txtNumeroCuenta" name="txtNumeroCuenta" readonly>
					    <label class="lblinput"> CBU </label> 
					    <input value="<%=cuenta.getCbu_cuenta()%>" type="text" id="txtCBU" name="txtCBU"> 
						<label class="lblinput">Saldo </label> 
						<input value="<%=cuenta.getSaldo_cuenta()%>" type="text" id="txtSaldo" name="txtSaldo" placeholder="$10.000">

				</div>

				<br /> <br />

				<div class="form-columna2">			
				
                    <label class="lblinput"> Dni cliente - Bloqueado</label> 
					<input class="inputBloqueado" type="text" id="txtDniCliente"
						name="txtDniCliente" value="<%=cuenta.getDni_Cliente()%>" readonly>
                    
                    <label class="lblinput"> Fecha Creación </label> 
					<input  type="date" value="<%=cuenta.getFecha_creacion_cuenta()%>"  id="txtFechaActual" name="txtFechaActual"> 
						 
						 
						 <label class="lblinput"> Tipo de cuenta </label>
						 
						<select 	id="ddlTipoCuenta" name="ddlTipoCuenta" style="width: 177px;">                                        
						<option value="">Seleccione un tipo...</option>					
						<%				
						
						for (Tipo_Cuenta tipo : ListaTipoCuentas) {	
						%>
                             <option value="<%= tipo.getId_tipoCuenta() %>" <%= (tipo.getId_tipoCuenta() == TipoSeleccionado) ? "selected" : "" %>>     
                             <%= tipo.getDescripcion_tipoCuenta() %>      
                             </option>		
                             <%
						}
						%>

					</select>

				</div>

				<br /> <br />s

			</div>

		</div>

		<br /> <br />



		<div class="ContenedorBoton">
			<br /> <br /> <input type="submit" style="color: #5F1AB4"
				class="btnModificar" name="btnModificar" value="Modificar" />
		</div>

	</div>
	
</form>

</body>
</html>