<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="entidad.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PedirPrestamo</title>
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

.container {
	display: flex;
	justify-content: space-around;
	padding: 40px;
}

.panel-izquierdo, .panel-derecho {
	background-color: #f9f9f9;
	padding: 30px;
	border-radius: 12px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.05);
}

.panel-izquierdo {
	width: 60%;
	font-family: 'Segoe UI', sans-serif;
}

.panel-derecho {
	width: 30%;
	font-family: 'Segoe UI', sans-serif;
}

.monto {
	font-size: 36px;
	font-weight: bold;
	text-align: center;
	margin-bottom: 10px;
	color: #44107a;
}

.monto-sub {
	text-align: center;
	font-size: 14px;
	color: gray;
	margin-bottom: 30px;
}

.Contenedor-cuotas {
	display: flex;
	flex-direction: column;
	gap: 15px;
	text-align: left;
}

.opcion {
	display: flex;
	justify-content: space-between;
	align-items: center;
	background-color: white;
	border: 2px solid #bc9fd6;
	padding: 0;
	border-radius: 10px;
	cursor: pointer;
	transition: all 0.3s ease;
}

.opcion:hover, .opcion.selected {
	border-color: #44107a;
	background-color: #f1e8ff;
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

.resumen {
	font-size: 16px;
	color: #333;
}

.resumen h3 {
	font-size: 18px;
	color: #44107a;
	border-bottom: 1px solid #ccc;
	padding-bottom: 10px;
	margin-bottom: 20px;
}

.resumen .item {
	margin-bottom: 10px;
	font-family: 'Segoe UI', sans-serif;
}

.resumen .item span {
	float: right;
	font-weight: bold;
}

.texto-cuota {
	font-size: 18px;
	color: #44107a;
	font-weight: 500;
}

.monto-cuota {
	font-size: 22px;
	font-weight: bold;
	color: #44107a;
}

input[type="radio"] {
	display: none;
}

input[type="radio"]:checked + label {
	background-color: #f1e8ff;
}

input[type=number]::-webkit-inner-spin-button,
input[type=number]::-webkit-outer-spin-button {
  -webkit-appearance: none;
  margin: 0;
}

input[type=number] {
  -moz-appearance: textfield;
}

.contenido-opcion {
	display: flex;
	justify-content: space-between;
	align-items: center;
	width: 100%;
	padding: 12px 20px;
	cursor: pointer;
	transition: all 0.3s ease;
	border: none;
	border-radius: 0;
	background: none;
}

</style>
</head>
<body>

	<%
	Usuario usuario = new Usuario();
	String VisibilidadDatos = "display: none;";
	float BaseRecibis=0;
	float Recibis = 0;
	int Cuotas=0;
	float BaseValorCuotas=0;
	float ValorCuotas=0;
	float BaseTotal=0;
	float Total=0;
	float Cuota1=0;
	float Cuota3=0;
	float Cuota6=0;
	float Cuota9=0;
	float Cuota12=0;
	

	if (session.getAttribute("usuarioLogueado") != null) {

		usuario = (Usuario) session.getAttribute("usuarioLogueado");

		//}else {
		//    response.sendRedirect("InicioLogin.jsp");
	}
	
	if (request.getAttribute("VisibilidadDatos") != null) {
		VisibilidadDatos = (String)request.getAttribute("VisibilidadDatos");
	}
	
	if (request.getAttribute("Recibis") != null) {
		BaseRecibis = (float)request.getAttribute("Recibis");
		Recibis = Math.round(BaseRecibis * 100)/100f;
	}
	
	if (request.getAttribute("Cuotas") != null) {
		Cuotas = (int)request.getAttribute("Cuotas");
	}
	
	if (request.getAttribute("ValorCuotas") != null) {
		BaseValorCuotas = (float)request.getAttribute("ValorCuotas");
		ValorCuotas = Math.round(BaseValorCuotas * 100)/100f;
		Total=0;
		Cuota1=0;
		Cuota3=0;
		Cuota6=0;
		Cuota9=0;
		Cuota12=0;
	}
	
	if (request.getAttribute("Total") != null) {
		BaseTotal = (float)request.getAttribute("Total");
		Total = Math.round(BaseTotal * 100)/100f;
	}
		
	%>
	<div class="header"> <%=usuario.getNombre_us()%> <%=usuario.getApellido_us()%>	- Cliente </div>

<form action="ServletMovimientos?Param=CalcularPrestamo" method="post">

	<div class="container">
		<div class="panel-izquierdo">

			<div class="monto">
				Monto $  <input class="monto" type="number" id="txtMonto" name="txtMonto" required> <input type="submit" class="btn-siguiente" value="Calcular">
			</div>

			<div class="Contenedor-cuotas">
			
				<div class="opcion" >
					<input type="radio" name="cuotas" value="1" id="cuota1" required> <label
						for="cuota1" class="contenido-opcion"> <span
						class="texto-cuota">1 cuota</span> <span class="monto-cuota">$<%=ValorCuotas%></span>
					</label>
				</div>
				<div class="opcion">
					<input type="radio" name="cuotas" value="3" id="cuota3" required> <label
						for="cuota3" class="contenido-opcion"> <span
						class="texto-cuota">3 cuotas</span> <span class="monto-cuota">$<%=ValorCuotas%></span>
					</label>
				</div>
				<div class="opcion">
					<input type="radio" name="cuotas" value="6" id="cuota6" required> <label
						for="cuota6" class="contenido-opcion"> <span
						class="texto-cuota">6 cuotas</span> <span class="monto-cuota">$<%=ValorCuotas%></span>
					</label>
				</div>
				<div class="opcion">
					<input type="radio" name="cuotas" value="9" id="cuota9" required> <label
						for="cuota9" class="contenido-opcion"> <span
						class="texto-cuota">9 cuotas</span> <span class="monto-cuota">$<%=ValorCuotas%></span>
					</label>
				</div>
				<div class="opcion">
					<input type="radio" name="cuotas" value="12" id="cuota12" required>
					<label for="cuota12" class="contenido-opcion"> <span
						class="texto-cuota">12 cuotas</span> <span class="monto-cuota">$<%=ValorCuotas%></span>
					</label>
				</div>
			</div>

		</div>

		<div class="panel-derecho">
			<div class="resumen">
				<h3>Datos de tu Préstamo</h3>
				<div class="item">
					Recibís <span style="<%=VisibilidadDatos%>"><%=Recibis%></span>
				</div>
				<div class="item">
					Pagás <span style="<%=VisibilidadDatos%>"> <%=Cuotas%>x $<%=ValorCuotas%></span>
				</div>
				<div class="item"
					style="margin-top: 20px; border-top: 1px solid #ccc; padding-top: 10px;">
					En total pagás <span style="<%=VisibilidadDatos%>"> $<%=Total%></span>
				</div>

				<div class="Contenedor-cuotas">
					<input type="button" class="btn-siguiente" value="Siguiente">
				</div>
				
				
			</div>
		</div>
	</div>
	
</form>

</body>
</html>