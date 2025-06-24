<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MODIFICAR CLIENTE</title>

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
	height: 500px;
	padding: 40px;
	border-radius: 8px;
}

.ContenedorTitulo {
	background-color: #E5E5E5;
	width: 350px;
	margin: 0 auto;
	text-align: center;
	border-radius: 8px;
}

.ContenedorBoton {
	margin: 0 auto;
	width: 260px;
}

.ContenedorColumna {
	display: flex;
	margin-top: 15px;
	margin-left: 90px;
	gap: 10px;
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

.ContenedorVentana h2 {
	color: white;
	margin-bottom: 30px;
	font-size: 24px;
}

.ContenedorVentana input[type="submit"] {
	width: 100%;
	padding: 10px;
	margin-bottom: 10px;
	margin-top: 10px;
	border: none;
	border-radius: 8px;
	background-color: #e5e5e5;
	color: #44107a;
	font-weight: bold;
	cursor: pointer;
}

.ContenedorVentana input[type="submit"] {
	background-color: #d4d4d4;
}

.barraDeBusqueda {
	width: 150px;
	margin-left: 53px;
	margin-bottom: 50px;
}
</style>

</head>
<body>

	<div class="header">Usuario logueado - Cuenta Banco</div>
	
	<a href="InicioLogin.jsp"> Inicio </a>

	<div class="ContenedorVentana">
		<div class="ContenedorTitulo">
			<h2>
				<strong style="color: #5F1AB4">MODIFICAR CLIENTE</strong>
			</h2>
		</div>

		<input class="barraDeBusqueda" type="search"
			placeholder="Ingrese el dni del cliente..." style="width: 606px;">
		<br />

		<div class="ContenedorControles">

			<form class="FormularioAgregarCLiente">



				<div class="ContenedorColumna">

					<input type="text" id="txtDniCliente" name="txtDniCliente"
						placeholder="12345678"> <select id="ddlSexo"
						name="ddlSexo" style="width: 177px;">

						<option value="">Femenino</option>

					</select> <input type="text" id="txtLocalidad" name="txtLocalidad"
						placeholder="Escobar">

				</div>

				<br /> <br />

				<div class="ContenedorColumna">

					<input type="text" id="txtCuil" name="txtCuil"
						placeholder="01234567820"> <input
						class="inputNacionalidad" type="text" id="txtNacionalidad"
						name="txtNacionalidad" placeholder="Argentina"> <input
						type="text" id="txtProvincia" name="txtProvincia"
						placeholder="Buenos Aires">

				</div>

				<br /> <br />

				<div class="ContenedorColumna">

					<input type="text" id="txtNombre" name="txtNombre"
						placeholder="Carla"> <input class="inputFechaNac"
						type="date" id="txtFechaNacimiento" name="txtFechaNacimiento">
					<input type="text" id="txtCorreo" name="txtCorreo"
						placeholder="Correo@hotmail.com">

				</div>

				<br /> <br />

				<div class="ContenedorColumna">

					<input type="text" id="txtApellido" name="txtApellido"
						placeholder="Fernandez"> <input class="inputDireccion"
						type="text" id="txtDireccion" name="txtDireccion"
						placeholder="Calle 123"> <input type="text"
						id="txtTelefono" name="txtTelefono" placeholder="12346789">

				</div>

				<br /> <br />

			</form>

		</div>

		<div class="ContenedorBoton">
			<input type="submit" style="color: #5F1AB4" class="btnAgregar"
				name="btnAgregar" value="ACEPTAR" />
		</div>


	</div>



</body>
</html>