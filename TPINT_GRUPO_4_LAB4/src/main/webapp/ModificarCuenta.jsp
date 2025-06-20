<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MODIFICAR CUENTA</title>

<style>
.ContenedorVentana {
	background-color: #4A217C;
	width: 700px;
	height: 400px;
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

.FormularioModificarCuenta input {
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
	<a href="InicioLogin.jsp"> Inicio </a>

	<div class="ContenedorVentana">
		<div class="ContenedorTitulo">
			<h2>
				<strong style="color: #5F1AB4">MODIFICAR CUENTA</strong>
			</h2>
		</div>

		<input class="barraDeBusqueda" type="search"
			placeholder="Ingrese el numero de cuenta..." style="width: 606px;">
		<br />

		<div class="ContenedorControles">

			<form class="FormularioModificarCuenta">

				<div class="ContenedorColumna">

					<input type="text" id="txtNumeroCuenta" name="txtNumeroCuenta"
						placeholder="CTA-1234567"> <input type="text"
						id="txtDniCuenta" name="txtDniCuenta" placeholder="12345678">

					<input type="date" id="txtFechaDeCreacion" name="txtLocalidad">

				</div>

				<br /> <br />

				<div class="ContenedorColumna">

					<input type="text" id="txtCbu" name="txtCbu"
						placeholder="01234567820"> <select
						class="inputSegundaColumna" id="ddTipoCuenta" name="ddTipoCuenta"
						style="width: 177px;">

						<option value="">Tipo de cuenta...</option>
											
					</select>
					
					<input type="text" id="txtSaldo" name="txtSaldo"
						placeholder="$10.000">

				</div>

				<br /> <br />

			</form>

		</div>

		<div class="ContenedorBoton">
			<input type="submit" style="color: #5F1AB4" class="btnAgregar"
				name="btnAgregar" value="MODIFICAR" />
		</div>


	</div>



</body>
</html>