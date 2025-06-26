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

<a href = "ServletClientes?Param=1" > Agregar Cliente </a> <br/>
<input type="submit" name="btnModificarCliente" value="Modificar Cliente" onclick="location.href='ModificarCliente.jsp'"/> <br/>
<input type="submit" name="btnEliminarCliente" value="Eliminar Cliente" onclick="location.href='EliminarCliente.jsp'"/> <br/>
<input type="submit" name="btnListarCliente" value="Listar Cliente" onclick="location.href='ListarCliente.jsp'"/> <br/>

</div>

<div class = "balance-box">
<p>ABML Cuentas</p>
<br/>
<input type="submit" name="btnAgregarCuenta" value="Nueva Cuenta" onclick="location.href='AgregarCuenta.jsp'"/> <br/>
<input type="submit" name="btnModificarCuenta" value="Modificar Cuenta" onclick="location.href='ModificarCuenta.jsp'"/> <br/>
<input type="submit" name="btnEliminarCuenta" value="Eliminar Cuenta" onclick="location.href='EliminarCuenta.jsp'"/> <br/>
<input type="submit" name="btnListarCuenta" value="Listar Cuenta" onclick="location.href='ListarCuenta.jsp'"/> <br/>

</div>

<div class = "balance-box">

<p>Otros</p>
<br/>
<input type="submit" name="btnAutorizarPrestamo" value="Autorizar Prestamo" onclick="location.href='AutorizarPrestamo.jsp'"/> <br/>
<input type="submit" name="btnReportes" value="Reportes" onclick="location.href='Reportes.jsp'"/> <br/>

</div>

</div>

</form>

</body>
</html>