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
	background: linear-gradient(to right, #602A80, #4C0026);
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
	background: linear-gradient(to right, #A178C1, #A14C6F); ,
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
    
	<%
	
	Cliente cliente = new Cliente();
	
	ArrayList<Provincia> ListaProvincias = new ArrayList<Provincia>();
	if (request.getAttribute("listaProvincias") != null) {
		ListaProvincias = (ArrayList<Provincia>) request.getAttribute("listaProvincias");
	}
	
	ArrayList<Localidad> ListaLocalidades = new ArrayList<Localidad>();
	if (request.getAttribute("listaLocalidades") != null) {
		ListaLocalidades = (ArrayList<Localidad>) request.getAttribute("listaLocalidades");
	}
	
	if (request.getAttribute("Cliente") != null) {
		
		cliente = (Cliente)request.getAttribute("Cliente");
		
	}
	%>
	
	

	<form action="ServletModificarClientes?Param=ConfirmarEditarCliente" method="post">

		<div class="header">Usuario logueado - Cuenta Banco</div>

		<a href="InicioLogin.jsp"> Inicio </a>

		<div class="balance-container">
			<div class="balance-box">
				<p>
					<strong>MODIFICAR CLIENTE</strong> <br /> <br /> <br />
				</p>

				<div class="ContenedorColumna">
				
                 
					<input type="text" id="txtDniCliente" name="txtDniCliente"
						value="<%=cliente.getDni_cliente()%>" readonly> <select id="txtProvincia"
						name="txtProvincia" onchange="actualizarLocalidades()" style="width: 177px;">
                        
                        <option value="">Seleccione su Provincia...</option>                                                  
                        
						<%
						String idProvinciaSeleccionada = "";
						
						for (Provincia p : ListaProvincias) {
						%>
						<option value="<%=p.getId_provincia()%>"><%=p.getDescripcion_provincia()%></option>
						
						<%
						}
						%>

					</select> 
					
					
					<select id="txtLocalidad" name="txtLocalidad"
						style="width: 177px;" required>

						<option value="">Seleccione su Localidad...</option>
					</select>

				</div>

				<br /> <br />

				<div class="ContenedorColumna">

					<input type="text" id="txtCuil" name="txtCuil"
						placeholder="Ingrese su Cuil..." value="<%=cliente.getCuil_cliente()%>" > <input
						class="inputNacionalidad" type="text" id="txtNacionalidad"
						name="txtNacionalidad" placeholder="Ingrese su Nacionalidad..." value="<%=cliente.getNacionalidad_cliente()%>">


					<select id="ddlSexo"  name="tiposexo" style="width: 177px;">

						<option value="">Seleccione su sexo...</option>
						<option value="F">Femenino</option>
						<option value="M">Masculino</option>
						<option value="O">Otro/s</option>

					</select>

				</div>

				<br /> <br />

				<div class="ContenedorColumna">

					<input type="text" id="txtNombre" name="txtNombre"
						placeholder="Ingrese su Nombre..." value="<%=cliente.getNombre_cliente()%>"> <input
						class="inputFechaNac" type="date" id="txtFechaNacimiento"
						name="txtFechaNacimiento" value="<%=cliente.getFecha_nacimiento_cliente()%>"> <input type="text"
						id="txtCorreo" name="txtCorreo" value="<%=cliente.getCorreo_electronico_cliente()%>" placeholder="Ingrese su Correo...">

				</div>

				<br /> <br />

				<div class="ContenedorColumna">

					<input type="text" id="txtApellido" name="txtApellido"
						value="<%=cliente.getApellido_cliente()%>" placeholder="Ingrese su Apellido..."> <input
						class="inputDireccion" value="<%=cliente.getDireccion_cliente()%>" type="text" id="txtDireccion"
						name="txtDireccion" placeholder="Ingrese su Dirección...">
					<input type="text" id="txtTelefono" name="txtTelefono"
						placeholder="Ingrese su Teléfono..." value="<%=cliente.getTelefono_cliente()%>">

				</div>

				<br /> <br />


				<div class="ContenedorBoton">
					<input type="submit" style="color: #5F1AB4" class="btnModificar"
						name="btnModificar" value="ACEPTAR" />
				</div>

			</div>
		</div>
	</form>


<script>

const localidades = [
    <%for (Localidad l : ListaLocalidades) {%>
        {
            id: "<%=l.getId_localidad()%>",
            Descripcion: "<%=l.getDescripcion_localidad()%>",
            idProvincia: "<%=l.getIdProvincia()%>"
        },
    <%}%>
];   
  
const ultimaLocalidad = localidades.at(-1);

if (ultimaLocalidad?.id === "") {
    localidades.pop();
}

    function actualizarLocalidades() {
        var idProvincia = document.getElementById("txtProvincia").value;
        var selectLocalidad = document.getElementById("txtLocalidad");

        selectLocalidad.innerHTML = '<option value="">Seleccione su Localidad...</option>';

        var localidadesFiltradas = localidades.filter(function(localidad) {
            return localidad.idProvincia === idProvincia;
        });

        if (localidadesFiltradas.length > 0) {
            localidadesFiltradas.forEach(function(localidad) {
                var option = document.createElement("option");
                option.value = localidad.id;
                option.textContent = localidad.Descripcion;
                selectLocalidad.appendChild(option);
            });
        } else {   	
            var option = document.createElement("option");
            option.value = "";
            option.textContent = "Esta provincia no tiene localidades cargadas";
            selectLocalidad.appendChild(option);
        }

    }
    
</script>

</body>
</html>