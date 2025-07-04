<%@page import="dominio.TipoSeguroDao"%>
<%@page import="dominio.TipoSeguro"%>
<%@page import="dominio.SegurosDao"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dominio.Seguro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ListarSeguros</title>

<style>
a {
	margin-right: 10px;
}

.ocultarTabla {
            display: none; / Oculta la tabla y no ocupa espacio */
}
   
</style>

</head>
<body>
	<a href="Inicio.jsp"> Inicio </a>
	<a href="AgregarSeguro.jsp"> Agregar Seguro </a>
	<a href="ServletListarSeguro?Param=1"> Listar Seguro </a>

	<hr>

	<h2>Tipo de seguros en la base de datos</h2>

	<form action="ServletListarSeguro" method="post">

		<%
		
		String VisibilidadErrorFiltro = "hidden";
		String VisibilidadTabla = "visible";
		
		TipoSeguroDao tsdao = new TipoSeguroDao();
		ArrayList<TipoSeguro> tipos = tsdao.obtenerTipoSeguros();

		ArrayList<Seguro> ListaSeguros = null;
		
		if (request.getAttribute("listaSeguros") != null) {
			ListaSeguros = (ArrayList<Seguro>) request.getAttribute("listaSeguros");
		}
		
		if (request.getAttribute("VisibilidadErrorFiltro") != null) {
			VisibilidadErrorFiltro = (String)request.getAttribute("VisibilidadErrorFiltro");
		}
		
		if (request.getAttribute("VisibilidadTabla") != null) {
			VisibilidadTabla = (String)request.getAttribute("VisibilidadTabla");
		}
		
		%>

		<p>
			Busqueda por tipo de seguros: <select name="tipoSeguro"
				style="width: 177px;">
				<option value = "" >Seleccione...</option>
				<%
				for (TipoSeguro tipo : tipos) {
				%>
				<option value="<%=tipo.getIdTipo()%>"><%=tipo.getDescripcion()%></option>

				<%
				}
				%>
				
			</select> <input type="submit" name="btnFiltrar" value="Filtrar"> <label id="lblErrorDescripcion" style="visibility:<%=VisibilidadErrorFiltro%>; color: red;" > *Seleccione un tipo de seguro </label>

		</p>

		<table style="visibility:<%=VisibilidadTabla%>" id = "tablaSeguros "border="1">

			<tr>
				<th>ID <br> Seguro
				</th>
				<th>Descripción Seguro</th>
				<th>Descripción <br> Tipo seguro
				</th>
				<th>Costo <br> contratacion
				</th>
				<th>Costo Maximo <br> Asegurado
				</th>
			</tr>

			<%
			TipoSeguroDao tiposegurodao = new TipoSeguroDao();
			if (ListaSeguros != null && !ListaSeguros.isEmpty() ) {
			for (Seguro seg : ListaSeguros) {
			%>

			<tr>
				<td><%=seg.getId()%></td>
				<td><%=seg.getDescripcion()%></td>
				<td><%=tiposegurodao.obtenerTipoSeguroporID(seg.getIdTipo())%></td>
				<td><%=seg.getCostoContratacion()%></td>
				<td><%=seg.getCostoAsegurado()%></td>

			</tr>
			<%
			}
			}else
			{
			%>
			
		</table>
		<%
			}
		%>
		<!-- <h2 style="color: red;">No hay registros de ese tipo de seguro.</h2>  -->
	
	</form>

</body>
</html>
