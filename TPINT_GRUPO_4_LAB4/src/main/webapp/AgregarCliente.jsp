<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Cliente</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
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
            margin: 30px 0;
            flex-wrap: wrap;
        }

        .balance-box {
            background: linear-gradient(to right, #A178C1, #A14C6F);
            color: white;
            padding: 25px 35px;
            border-radius: 12px;
            font-size: 26px;
            font-weight: bold;
            text-align: center;
            box-shadow: 0 4px 10px rgba(204, 0, 143, 0.3);
            min-width: 200px;
        }

        .ContenedorColumna {
            display: flex;
            justify-content: center;
            gap: 15px;
            flex-wrap: wrap;
        }

        .input-uniforme {
            width: 100%;
            max-width: 250px;
            min-width: 200px;
        }

        .ContenedorBoton {
            margin: 0 auto;
            width: 260px;
        }

        .btn-pay {
            background-color: #4C0026;
            color: white;
        }

        .btn-pay:hover {
            background-color: #A14C6F;
        }
    </style>
</head>

<body>

<%
    ArrayList<Provincia> ListaProvincias = new ArrayList<Provincia>();
    if (request.getAttribute("listaProvincias") != null) {
        ListaProvincias = (ArrayList<Provincia>) request.getAttribute("listaProvincias");
    }

    ArrayList<Localidad> ListaLocalidades = new ArrayList<Localidad>();
    if (request.getAttribute("listaLocalidades") != null) {
        ListaLocalidades = (ArrayList<Localidad>) request.getAttribute("listaLocalidades");
    }

    Usuario usuario = new Usuario();
    if(session.getAttribute("usuarioLogueado") != null){
        usuario = (Usuario)session.getAttribute("usuarioLogueado");
    } else {
        response.sendRedirect("InicioLogin.jsp");
    }
%>

<div class="header">
    <%=usuario.getNombre_us()%> <%=usuario.getApellido_us()%> - Administrador - 
    <a style="color: white" href="InicioLogin.jsp">Cerrar sesión</a>
</div>

<a href = "InicioAdministrador.jsp" > Atrás </a> <br/>

<form action="ServletClientes?Param=CargarUsuario" method="post">
    <div class="balance-container">
        <div class="balance-box">
            <p><strong>AGREGAR CLIENTE</strong></p><br>

            <div class="ContenedorColumna">
                <input type="number" max="99999999" id="txtDniCliente" name="txtDniCliente" 
                    placeholder="Ingrese su Dni..." required class="input-uniforme">

                <select id="txtProvincia" name="txtProvincia" onchange="actualizarLocalidades()" 
                    required class="input-uniforme">
                    <option value="">Seleccione su Provincia...</option>
                    <% for (Provincia p : ListaProvincias) { %>
                        <option value="<%=p.getId_provincia()%>"><%=p.getDescripcion_provincia()%></option>
                    <% } %>
                </select>

                <select id="txtLocalidad" name="txtLocalidad" required class="input-uniforme">
                    <option value="">Seleccione su Localidad...</option>
                </select>
            </div><br><br>

            <div class="ContenedorColumna">
                <input type="number" max="999999999999" id="txtCuil" name="txtCuil" 
                    placeholder="Ingrese su Cuil..." required class="input-uniforme">

                <input type="text" id="txtNacionalidad" name="txtNacionalidad" 
                    placeholder="Ingrese su Nacionalidad..." required class="input-uniforme">

                <select id="ddlSexo" name="tiposexo" required class="input-uniforme">
                    <option value="">Seleccione su sexo...</option>
                    <option value="F">Femenino</option>
                    <option value="M">Masculino</option>
                    <option value="O">Otro/s</option>
                </select>
            </div><br><br>

            <div class="ContenedorColumna">
                <input type="text" id="txtNombre" name="txtNombre" 
                    placeholder="Ingrese su Nombre..." required class="input-uniforme">

                <input type="date" id="txtFechaNacimiento" name="txtFechaNacimiento" 
                    required class="input-uniforme">

                <input type="text" id="txtCorreo" name="txtCorreo" 
                    placeholder="Ingrese su Correo..." required class="input-uniforme">
            </div><br><br>

            <div class="ContenedorColumna">
                <input type="text" id="txtApellido" name="txtApellido" 
                    placeholder="Ingrese su Apellido..." required class="input-uniforme">

                <input type="text" id="txtDireccion" name="txtDireccion" 
                    placeholder="Ingrese su Dirección..." required class="input-uniforme">

                <input type="text" id="txtTelefono" name="txtTelefono" 
                    placeholder="Ingrese su Teléfono..." required class="input-uniforme">
            </div><br><br>

            <div class="ContenedorBoton">
                <button type="submit" class="btn btn-pay">Seleccionar</button>
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
