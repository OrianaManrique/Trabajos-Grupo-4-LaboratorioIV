<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InicioAdministrador</title>
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


</style>



<body>

<form>

<div class="header">
Usuario logueado - Cuenta Banco
</div>

<div>
	<a href="AgregarCliente.jsp"> Nuevo Cliente </a> 
    <br/>
    <a href="ModificarCliente.jsp"> Modificar Cliente </a>
    <br/>
    <a href="EliminarCliente.jsp"> Eliminar Cliente </a>
    <br/>
    <a href="ListarCliente.jsp"> Listar Cliente </a>
    <br/>
    <br/>
    <a href="AgregarCuenta.jsp"> Nueva Cuenta </a> 
    <br/>
    <a href="ModificarCuenta.jsp"> Modificar Cuenta </a>
    <br/>
    <a href="EliminarCuenta.jsp"> Eliminar Cuenta </a>
    <br/>
    <a href="ListarCuenta.jsp"> Listar Cuenta </a>
    <br/>
    <br/>
    <a href="Reportes.jsp"> Reportes </a>
    <br/>
</div>

</form>

</body>
</html>