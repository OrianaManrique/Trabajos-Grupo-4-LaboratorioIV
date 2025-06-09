<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dominio.SegurosDao"%>
<%@ page import="dominio.TipoSeguroDao"%>
<%@ page import="dominio.TipoSeguro"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title></title>

<style>
body {
	/*font-family: Arial;*/
}

input, select {
	margin-bottom: 5px;
	max-width: 250px;
}

bloque {
	display: block;
}

label {
	font-weight: bold;
}

a {
	margin-right: 10px;
}

.fila-formulario {
	display: flex;
	text-align: left;
	margin-left: 20;
}

.bloque-etiquetas {
	flex: 0 0 auto;
	padding-right: 20px;
	text-align: left; 
	margin-bottom: 0px;
	line-height: 1.57;
}
</style>

</head>

<body>

	<form action="ServletAgregarSeguro?Param2=1" method="post">

		<a href="Inicio.jsp"> Inicio </a> <a href="AgregarSeguro.jsp">
			Agregar Seguro </a> <a href="ServletListarSeguro?Param=1"> Listar Seguro </a> <br>

		<hr>

		<h2>
			<strong>Agregar Seguros</strong>
		</h2>

		<%
		SegurosDao sDao = new SegurosDao();
		int proxID = sDao.ObtenerProxId();

		TipoSeguroDao dao = new TipoSeguroDao();
		ArrayList<TipoSeguro> tipos = dao.obtenerTipoSeguros();
		%>

		<div class="fila-formulario">
			<div class="bloque-etiquetas">
				Id Seguro: <br> Descripción: <br> Tipo de Seguro: <br>
				Costo contratación: <br> Costo Máximo Asegurado: <br>
			</div>
			<div class="bloque-entradas">
				<%=proxID%><br> <input type="text" id="descripcion"
					name="descripcion"> <br> <select id="tipoSeguro"
					name="tipoSeguro" style="width: 177px;">
					<option>Seleccione...</option>
					<%
					for (TipoSeguro tipo : tipos) {
					%>
					<option value="<%=tipo.getIdTipo()%>"><%=tipo.getDescripcion()%></option>

					<%
					}
					%>
				</select> <br> <input type="text" id="costoContratacion"
					name="costoContratacion"> <br> <input type="text"
					id="costoMaximoAsegurado" name="costoMaximoAsegurado"> <br>
				
			</div>
			
			</div>
			
			<% 
			if (request.getAttribute("CantFilas") != null){
				int filas = (int) request.getAttribute("CantFilas");
				if (filas > 0) {
			%>
			
			<h2 style="color: green;">Seguro agregado con éxito.</h2>
			
			<%	
			}else{
			 %>
			<h2 style="color: red;">El Seguro no pudo ser agSegado.</h2>
			<%
			}
			%>
			<%
			}
			%>
		<br> <input type="submit" name="btnAceptar" value="Aceptar" /> <br>


	</form>

</body>
</html>