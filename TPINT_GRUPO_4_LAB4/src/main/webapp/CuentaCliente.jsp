<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CuentaCliente</title>
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

/* Contenedor de saldos */
.balance-container {
    display: flex;
    justify-content: center;
    gap: 40px;
    margin: 30px 0;
    flex-wrap: wrap;
}

.balance-box {
    background-color: #44107a;
    color: white;
    padding: 25px 35px;
    border-radius: 12px;
    font-size: 26px;
    font-weight: bold;
    text-align: center;
    box-shadow: 0 4px 10px rgba(204, 0, 143, 0.3);
    min-width: 200px;
}
 
.subtitulo {
    text-align: center;
    color: #704be7;
    font-size: 24px;
    margin-bottom: 20px;
    font-weight: bold;
}

.table-container {
    width: 95%;
    margin: auto;
    overflow-x: auto;
}

/* Estilos de la tabla */
.movements-table {
    width: 100%;
    border-collapse: collapse;
    text-align: center;
    font-size: 15px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.05);
}

.movements-table thead {
    background-color: #bc9fd6;
    color: white;
}

.movements-table th,
.movements-table td {
    padding: 12px;
    border: 1px solid #ddd;
}

/* gris claro */
.alternarfilas{
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

p {
      
      font-size: 16px;
      text-align: center;
      
    }



</style>
<body>

  <div class="header">
    USUARIO LOGUEADO - CUENTA: xxxxxxxx
  </div>

  <div class="balance-container">
    <div class="balance-box">
      $ 0,00
      <p>Disponible en pesos argentinos</p>
    </div>
    <div class="balance-box">
      U$S 0,00
      <p>Disponible en dólares</p>
    </div>
  </div>

  <div class="table-container">
    <a href="HistorialMovimientos.jsp"> Movimientos </a> 
    <br/>
    <a href="NuevaTransferencia.jsp"> Nueva Transferencia </a>
    <br/>
    <a href="PedirPrestamo.jsp"> Solicitar Préstamo </a>
    <br/>
    <a href="PagosPrestamo.jsp"> Pago de Préstamos </a>
    <br/>
    <a href="DatosCliente.jsp"> Mi cuenta </a>

  </div>

</body>
</html>