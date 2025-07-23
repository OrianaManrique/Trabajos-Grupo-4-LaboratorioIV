<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "entidad.*" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet"><meta charset="UTF-8">
<title>InicioAdministrador</title>
</head>
<style>

body{
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
     /*display: flex;
    background-color: transparent;
    justify-content: center;
    gap: 40px;
    margin: 30px 0;
    flex-wrap: wrap;*/
    
    display: flex;
    justify-content: center;    
    align-items: center;        
    height: 50vh;              
    gap: 40px; 
}

.balance-box {
    background: linear-gradient(to right, #602A80, #4C0026);
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
     font-size: 25px;
     text-align:;

  }

</style>

<body>
<%

Usuario usuario = new Usuario();

if(session.getAttribute("usuarioLogueado") != null){
	
	usuario = (Usuario)session.getAttribute("usuarioLogueado");

	//}else {
//		response.sendRedirect("InicioLogin.jsp");
	}
	 %>

	<div class="header">
	<%=usuario.getNombre_us()%> <%=usuario.getApellido_us()%> - Administrador
	</div>
}


<div class = "balance-container">

<div class = "balance-box">
<p>ABML CLIENTES</p>
<br/>

<a class="link-light link-offset-2 link-underline link-underline-opacity-0 link-opacity-50-hover" href = "ServletClientes?Param=CargarAgregarCliente" > Agregar Cliente </a> <br/>
<a class="link-light link-offset-2 link-underline link-underline-opacity-0 link-opacity-50-hover" href = "ModificarCliente.jsp" > Modificar Clientes </a> <br/>
<a class="link-light link-offset-2 link-underline link-underline-opacity-0 link-opacity-50-hover" href = "ServletClientes?Param=ListarEliminarCliente" > Eliminar Clientes </a> <br/>
<a class="link-light link-offset-2 link-underline link-underline-opacity-0 link-opacity-50-hover" href = "ServletClientes?Param=ListarClientes" > Listar Clientes </a> <br/>

</div>

<div class = "balance-box">
<p>ABML CUENTAS</p>
<br/>
<a class="link-light link-offset-2 link-underline link-underline-opacity-0 link-opacity-50-hover" href = "ServletCuentas?Param=CargarAgregarCuenta" > Agregar Cuenta </a> <br/>
<a class="link-light link-offset-2 link-underline link-underline-opacity-0 link-opacity-50-hover" href = "ModificarCuenta.jsp" > Modificar Cuentas </a> <br/>
<a class="link-light link-offset-2 link-underline link-underline-opacity-0 link-opacity-50-hover" href = "ServletCuentas?Param=ListarEliminar" > Eliminar Cuentas </a> <br/>
<a class="link-light link-offset-2 link-underline link-underline-opacity-0 link-opacity-50-hover" href = "ServletCuentas?Param=ListarCuentas" > Listar Cuentas </a> <br/>

</div>

<div class = "balance-box">

<p>OTROS</p>
<br/>
<a class="link-light link-offset-2 link-underline link-underline-opacity-0 link-opacity-50-hover" href = "ServletMovimientos?Param=CargarAutorizarPrestamos" > Autorizar Prestamo </a> <br/>
<a class="link-light link-offset-2 link-underline link-underline-opacity-0 link-opacity-50-hover" href = "Reportes.jsp" > Reportes </a> <br/>


</div>

</div>

</body>
</html>