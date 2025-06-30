<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Cliente</title>
</head>
<style>
body {
	font-family: 'Segoe UI', sans-serif;
	margin: 0;
	padding: 0;
	background: #E0E0E0;
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
	/*background: linear-gradient(to right, #602A80, #4C0026);*/
	background: #44107a;
	color: white;
	padding: 25px 35px;
	border-radius: 12px;
	font-size: 26px;
	font-weight: bold;
	text-align: center;
	box-shadow: 0 4px 10px rgba(204, 0, 143, 0.3);
	min-width: 200px;
}

.boton-submit {
	color: black;
	background-color: #BDBDBD;
	border: none;
	padding: 10px 20px;
	cursor: pointer;
	font-weight: bold;
	border-radius: 8px;
}

.subtitulo {
	text-align: center;
	font-size: 20px;
	color: #44107a;
	margin-bottom: 20px;
	margin-top: 20px;
	font-weight: bold;
}

p {
	font-size: 22px;
	text-align:;
}

.ContenedorTitulo {
	background-color: #E5E5E5;
	width: 260px;
	margin: 0 auto;
	text-align: center;
	border-radius: 8px;
}

.ContenedorBoton {
	margin: 0 auto;
	width: 260px;
}

.btnAgregar {
	width: 180px;
}

.ContenedorColumna {
	display: flex;
	margin: 0;
	padding: 0;
	gap: 10px;
	justify-content: center;
}

.FormularioAgregarCLiente input {
	border-radius: 8px;
}

.inputFechaNac {
	width: 167px;
}

.inputNacionalidad {
	width: 167px;
}

.inputDireccion {
	width: 167px;
}
</style>

<body>

	<form method="post">

		<div class="header">USUARIO LOGUEADO - CUENTA: xxxxxxxx</div>

		<a href="InicioLogin.jsp"> Inicio </a>

		<div class="balance-container">
			<div class="balance-box">
				<p>
					<strong>DATOS CLIENTE</strong> <br /> <br /> <br />
				</p>

				<div class="ContenedorColumna">

					<input type="number" max="99999999" id="txtDniCliente"
						name="txtDniCliente" placeholder="12345" required>
					<select id="txtProvincia" name="txtProvincia"
						onchange="actualizarLocalidades()" style="width: 177px;" required>

						<option value="">La pampa</option>


					</select> <select id="txtLocalidad" name="txtLocalidad"
						style="width: 177px;" required>

						<option value="">Localidad1</option>
					</select>


				</div>

				<br /> <br />

				<div class="ContenedorColumna">

					<input type="number" max="999999999999" id="txtCuil" name="txtCuil"
						placeholder="20123460" required> <input
						class="inputNacionalidad" type="text" id="txtNacionalidad"
						name="txtNacionalidad" placeholder="Argentino"
						required> <select id="ddlSexo" name="tiposexo"
						style="width: 177px;" required>

						<option value="">Masculino</option>
						<option value="F">Femenino</option>
						<option value="M">Masculino</option>
						<option value="O">Otro/s</option>

					</select>

				</div>

				<br /> <br />

				<div class="ContenedorColumna">

					<input type="text" id="txtNombre" name="txtNombre"
						placeholder="Carlos" required> <input
						class="inputFechaNac"  placeholder="1/1/2000" type="date" id="txtFechaNacimiento"
						name="txtFechaNacimiento" required> <input type="text"
						id="txtCorreo" name="txtCorreo" placeholder="Correo@correo.com"
						required>

				</div>

				<br /> <br />

				<div class="ContenedorColumna">

					<input type="text" id="txtApellido" name="txtApellido"
						placeholder="Santana" required> <input
						class="inputDireccion" type="text" id="txtDireccion"
						name="txtDireccion" placeholder="Direccion 123" required>

					<input type="text" id="txtTelefono" name="txtTelefono"
						placeholder="112333545" required>

				</div>

				<br /> <br />

				<div class="ContenedorBoton">
					<input type="submit" style="color: #5F1AB4" class="btnAgregar"
						name="btnAgregar" value="VOLVER" />
				</div>

			</div>
		</div>
	</form>


</body>

</html>