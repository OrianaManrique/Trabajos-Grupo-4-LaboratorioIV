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
    background: linear-gradient(to right, #A178C1, #A14C6F);, 
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
      font-size: 16px;
      text-align:;

  }

</style>

<body>

<form>

<div class="header">
Usuario logueado - Cuenta Banco
</div>


<div class = "balance-container">

<div class = "balance-box">
<p>ABML Clientes</p>
<br/>

<a href = "ServletClientes?Param=CargarAgregarCliente" > Agregar Cliente </a> <br/>
<a href = "ServletClientes?Param=ListarClientes" > Modificar Clientes </a> <br/>
<a href = "EliminarCliente.jsp" > Eliminar Clientes </a> <br/>
<a href = "ServletClientes?Param=ListarClientes" > Listar Clientes </a> <br/>

</div>

<div class = "balance-box">
<p>ABML Cuentas</p>
<br/>
<a href = "ServletCuentas?Param=CargarAgregar" > Agregar Cuenta </a> <br/>
<a href = "ServletCuentas?Param=Listar" > Modificar Cuentas </a> <br/>
<a href = "ServletClientes?Param=ListarClientes" > Eliminar Cuentas </a> <br/>
<a href = "ServletCuentas?Param=Listar" > Listar Cuentas </a> <br/>

</div>

<div class = "balance-box">

<p>Otros</p>
<br/>
<a href = "AutorizarPrestamo.jsp" > Autorizar Prestamo </a> <br/>
<a href = "Reportes.jsp" > Reportes </a> <br/>


</div>

</div>

</form>

</body>
</html>