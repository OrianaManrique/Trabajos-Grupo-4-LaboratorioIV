<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="entidad.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PedirPrestamo</title>
<style>
/* Estilos igual que antes, los dejé tal como estaban */
/* Agregué algunos detalles para asegurarnos que el input no tenga flechas */
input[type=number]::-webkit-inner-spin-button, input[type=number]::-webkit-outer-spin-button
	{
	-webkit-appearance: none;
	margin: 0;
}

input[type=number] {
	-moz-appearance: textfield;
}
</style>
</head>
<body>

	<%
	Usuario usuario = new Usuario();
	if (session.getAttribute("usuarioLogueado") != null) {
		usuario = (Usuario) session.getAttribute("usuarioLogueado");
	}
	%>

	<div class="header">
		<%=usuario.getNombre_us()%>
		<%=usuario.getApellido_us()%>
		- Cliente
	</div>

	<div class="container">
		<div class="panel-izquierdo">
			<div class="monto">
				Monto $ <input type="number" id="inputMonto" />
			</div>

			<div class="Contenedor-cuotas">
				<div class="opcion">
					<input type="radio" name="cuotas" value="1" id="cuota1"
						class="radio-cuota"> <label for="cuota1"
						class="contenido-opcion"> <span class="texto-cuota">1
							cuota</span>
					</label>
				</div>
				<div class="opcion">
					<input type="radio" name="cuotas" value="3" id="cuota3"
						class="radio-cuota"> <label for="cuota3"
						class="contenido-opcion"> <span class="texto-cuota">3
							cuotas</span>
					</label>
				</div>
				<div class="opcion">
					<input type="radio" name="cuotas" value="6" id="cuota6"
						class="radio-cuota"> <label for="cuota6"
						class="contenido-opcion"> <span class="texto-cuota">6
							cuotas</span>
					</label>
				</div>
			</div>
		</div>

		<div class="panel-derecho">
			<div class="resumen">
				<h3>Datos de tu Préstamo</h3>
				<div class="item">
					Recibís <span id="recibis">$0</span>
				</div>
				<div class="item">
					Pagás <span id="pagas">0x $0</span>
				</div>
				<div class="item"
					style="margin-top: 20px; border-top: 1px solid #ccc; padding-top: 10px;">
					En total a pagar <span id="total">$0</span>
				</div>
			</div>
		</div>
		
		</div>

		<!-- Script funcional -->
<script>
  let monto = 0;
  let cuotas = 0;

  function actualizarResumen() {
    const recibis = document.getElementById("recibis");
    const pagas = document.getElementById("pagas");
    const total = document.getElementById("total");

    if (monto <= 0 || cuotas <= 0) {
      recibis.textContent = "$0";
      pagas.textContent = "0x $0";
      total.textContent = "$0";
      return;
    }

    const interes = 0.3;
    const totalAPagar = monto + (monto * interes);
    const valorCuota = totalAPagar / cuotas;

    recibis.textContent = `$${monto.toLocaleString("es-AR")}`;
    pagas.textContent = `${cuotas}x $${valorCuota.toFixed(2)}`;
    total.textContent = `$${totalAPagar.toFixed(2)}`;
  }

  document.getElementById("inputMonto").addEventListener("input", function () {
    monto = parseFloat(this.value) || 0;
    actualizarResumen();
  });

  document.querySelectorAll(".radio-cuota").forEach(radio => {
    radio.addEventListener("change", function () {
      cuotas = parseInt(this.value);
      actualizarResumen();
    });
  });
</script>
</body>
</html>