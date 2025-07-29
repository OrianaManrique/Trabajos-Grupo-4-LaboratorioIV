<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="entidad.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"rel="stylesheet"> 
<meta charset="UTF-8">
	
<title>Modificar Cliente</title>
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

form {
	text-align: center;
	margin-top: 20px;
}

.table-container {
	width: 95%;
	margin: auto;
	margin-top: 20px;
	overflow-x: auto;
	font-size: 20px;
}

/* Estilos de la tabla */
.movements-table {
	width: 100%;
	border-collapse: collapse;
	text-align: center;
	font-size: 20px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.05);
}

.movements-table th {
	text-align: center;
	vertical-align: middle;
	width: 13%;
}

.movements-table thead {
	background: linear-gradient(to right, #602A80, #4C0026);
	color: white;
}

.movements-table th, .movements-table td {
	padding: 12px;
	border: 20px solid #ddd;
}

.movements-table2 {
	width: 100%;
	border-collapse: collapse;
	text-align: center;
	font-size: 20px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.3);
}

.movements-table2 thead {
	background: linear-gradient(to right, #03c57e, #1eac04,  #03c57e , #03c57e, #1eac04,  #03c57e);
	color: white;
}

.movements-table2 th, .movements-table2 td {
	padding: 12px;
	border: 1px solid black;
	width: 13%;
}

/* gris claro */
.alternarfilas {
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


</style>


<body>
	<%
	String visibilidadTablaCuentas = "display: none;";
	//String visibilidadTablaModificar = "display: none;";
	String visibilidadTablaModificar = "";
	
	Cliente cliente = new Cliente();
	Cuenta cuenta = new Cuenta();
	int DniBusqueda=0;
    String sexoSeleccionado = "";
    int ProvinciaSeleccionada = 0;
    int localidadSeleccionada = 0;
    
	
	if (request.getAttribute("Cliente") != null) {
		cliente = (Cliente) request.getAttribute("Cliente");
		visibilidadTablaCuentas = "";
        sexoSeleccionado = cliente.getSexo_cliente();
        ProvinciaSeleccionada = cliente.getProvincia().getId_provincia();
        localidadSeleccionada = cliente.getLocalidad().getId_localidad();
	}
	
	if (request.getAttribute("DniBusqueda") != null) {
		DniBusqueda = (int)request.getAttribute("DniBusqueda");
	}
	
	ArrayList<Provincia> ListaProvincias = new ArrayList<Provincia>();
	if (request.getAttribute("listaProvincias") != null) {
		ListaProvincias = (ArrayList<Provincia>) request.getAttribute("listaProvincias");
	}

	ArrayList<Localidad> ListaLocalidades = new ArrayList<Localidad>();
	if (request.getAttribute("listaLocalidades") != null) {
		ListaLocalidades = (ArrayList<Localidad>) request.getAttribute("listaLocalidades");
	}
	
	int DniBusquedaModificarCliente=0;
	if (request.getAttribute("DniBusquedaModificarCliente") != null) {
		DniBusquedaModificarCliente = (int)request.getAttribute("DniBusquedaModificarCliente");
	}
	
	%> 

	<%

Usuario usuario = new Usuario();

if(session.getAttribute("usuarioLogueado") != null){

    usuario = (Usuario)session.getAttribute("usuarioLogueado");

}else {
	response.sendRedirect("InicioLogin.jsp");
}
 %>

<div class="header">
<%=usuario.getNombre_us()%> <%=usuario.getApellido_us()%> - Administrador - <a Style="color: white" href="InicioLogin.jsp"> Cerrar sesión </a>
</div>
    
	<form action="ServletClientes?Param=BuscarClienteModificar"	method="post">
		    
    <p style="Color: purple; font-weight: bold; font-size: 50px"> MODIFICAR CLIENTE</p>
    
		<input style="width: 30%; margin-top: 20px;" type="search" name="txtBusquedaModificarCliente" placeholder="Ingrese un Dni..." required/> 
			<input class="btn btn-outline-success" name="BuscarClienteDni" type="submit">
	</form>

	<form action="ServletClientes?Param=GuardarModificacionCliente&DniBusquedaModificarCliente=<%=DniBusquedaModificarCliente%>"  method="post">

		<div class="table-container">
			<table class="movements-table2">
				<thead>
					<tr>
						<th>DNI</th>
						<th>NOMBRE</th>
						<th>APELLIDO</th>
						<th>FECHA DE NACIMIENTO</th>
						<th>CUIL</th>
						<th>SEXO</th>
						<th>NACIONALIDAD</th>		
					</tr>
				</thead>
				<tbody>
					<tr style="<%=visibilidadTablaCuentas%>">
						<th><p><%=cliente.getDni_cliente()%></p></th>			
						<th><p><input type="text"  name="txtNombre" value="<%=cliente.getNombre_cliente()%>"></p></th>
						<th><p><input type="text"  name="txtApellido" value="<%=cliente.getApellido_cliente()%>"></p>  </th>
						<th><p><input type="date" name="txtNacimiento" value="<%=cliente.getFecha_nacimiento_cliente()%>"></p>  </th>
						<th><p><%=cliente.getCuil_cliente()%></p>  </th>
						
						<th><select id="ddlSexo" name="ddlSexo">
							 <option value="">Seleccione su sexo...</option>
                             <option value="F" <%= "F".equals(sexoSeleccionado) ? "selected" : "" %>>Femenino</option>
                             <option value="M" <%= "M".equals(sexoSeleccionado) ? "selected" : "" %>>Masculino</option>
                             <option value="O" <%= "O".equals(sexoSeleccionado) ? "selected" : "" %>>Otro/s</option>
						</select></th>
						<th><p><input type="text" name="txtNacionalidad" value="<%=cliente.getNacionalidad_cliente()%>"></p>
					</tr>
				</tbody>		
				
			</table>
			
			<table class="movements-table2">
				<thead>
					<tr>
						<th>DIRECCIÓN</th>
						<th>PROVINCIA</th>
						<th>LOCALIDAD</th>
						<th>CORREO</th>
						<th>TELÉFONO</th>
						<th>USUARIO</th>
						<th>CONTRASEÑA</th>			
					</tr>
				</thead>
					<tr style="<%=visibilidadTablaCuentas%>">
						<th><p><input type="text" name="txtDireccion" value="<%=cliente.getDireccion_cliente()%>"></p>
						
						<th><p><select id="ddlProvincia" name="ddlProvincia" onchange="actualizarLocalidades()" style="width: 177px;" required>
						
						<option value="">Seleccione su Provincia...</option>

						<%
						String idProvinciaSeleccionada = "";

						for (Provincia p : ListaProvincias) {
						%>
                          <option value="<%=p.getId_provincia()%>" <%= p.getId_provincia() == ProvinciaSeleccionada ? "selected" : "" %>> <%= p.getDescripcion_provincia() %></option>
						<%
						}
						%>

					</select> 
					
					</p></th>
					
					<th><p>	<select id="ddlLocalidad" name="ddlLocalidad" style="width: 177px;" required>
				    	<option value="">Seleccione su Localidad...</option>
					</select>						
						<th><p><input type="email" name="txtCorreo" value="<%=cliente.getCorreo_electronico_cliente()%>"></p></th>
						<th><p><input type="text" name="txtTelefono" value="<%=cliente.getTelefono_cliente()%>"></p></th>
						<th><p><%=cliente.getUsuario_cliente()%></p></th>
						<th><p><input type="text" name="txtcontra" value="<%=cliente.getContraseña_cliente()%>"></p></th>

					</tr>
				</tbody>
				
										
				
			</table>
			
			<br /> <br />
                 
              <input class="btn btn-success btn btn-primary btn-lg" type="submit" value="GUARDAR">
			

			<br /> <br />
			
			<%  
			      
			    if(request.getAttribute("Exito")!=null){
			    	
			    	if(((Boolean)request.getAttribute("Exito"))==true){
			    		
			    		%>		    		
			    		
			    		<p><label id="lblMensajeExitoCliente"	style="Color: green; font-weight: bold; font-size: 20px"> ¡SE MODIFICO EL CLIENTE CON ÉXITO!</label></p>
			    				
			    		<%
			    		
			    	}else{
			    		
			    		
                        %>		    		
			    		
			    		<label id="lblMensajeErrorCliente"	style="Color: red; font-weight: bold; font-size: 20px">NO SE HA PODIDO MODIFICAR EL CLIENTE</label>
			    				
			    		<%
			    		
			    	}
			    }
			    
			    %>
		
			    
		</div>

	</form>

<script>

const localidades = [
    <% for (Localidad l : ListaLocalidades) { %>
        {
            id: "<%= l.getId_localidad() %>",
            descripcion: "<%= l.getDescripcion_localidad() %>",
            idProvincia: "<%= l.getIdProvincia() %>"
        },
    <% } %>
];

const localidadSeleccionada = "<%= localidadSeleccionada %>";

function actualizarLocalidades() {
    var idProvincia = document.getElementById("ddlProvincia").value;
    var selectLocalidad = document.getElementById("ddlLocalidad");

    selectLocalidad.innerHTML = '<option value="">Seleccione su Localidad...</option>';

    var localidadesFiltradas = localidades.filter(function(localidad) {
        return String(localidad.idProvincia).trim() === String(idProvincia).trim();
    });

    localidadesFiltradas.forEach(function(localidad) {
        var option = document.createElement("option");
        option.value = localidad.id;
        option.textContent = localidad.descripcion;
        if (localidad.id === localidadSeleccionada) {
            option.selected = true;
        }
        selectLocalidad.appendChild(option);
    });

    if (localidadesFiltradas.length === 0) {
        var option = document.createElement("option");
        option.value = "";
        option.textContent = "Seleccione una Provincia...";
        selectLocalidad.appendChild(option);
    }
}

window.onload = function() {
    actualizarLocalidades();
};
</script>
</body>

</html>