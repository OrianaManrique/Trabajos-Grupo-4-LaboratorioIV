<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ page import = "entidad.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HistorialMovimientos</title>
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
    font-size: 20px;
    color: #44107a;
    margin-bottom: 20px;
    margin-top: 20px;
    font-weight: bold;
}

.table-container {
    width: 95%;
    margin: auto;
    overflow-x: auto;
    font-size: 20px;
}

/* Estilos de la tabla */
.movements-table {
    width: 100%;
    border-collapse: collapse;
    text-align: center;
    font-size: 20px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.05);
}

.movements-table thead {
    /*background-color: #bc9fd6;*/
    background: linear-gradient(to right, #bc9fd6, #44107a);
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

<%

Usuario usuario = new Usuario();

if(session.getAttribute("usuarioLogueado") != null){

    usuario = (Usuario)session.getAttribute("usuarioLogueado");

//}else {
//    response.sendRedirect("InicioLogin.jsp");
}
 %>

<div class="header">
<%=usuario.getNombre_us()%> <%=usuario.getApellido_us()%> - Cliente
</div>
  
<form>
			<div class ="subtitulo"> Historial de Movimientos </div>

<div class="table-container">
    <table class="movements-table">
      <thead>
        <tr>
          <th>FECHA</th>
          <th>DESCRIPCIÓN</th>
          <th>IMPORTE</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td> <p>00/00/2025 00:00:00</p></td>
          <td><p>RENDIMIENTO ARS</p></td>
          <td class="mov-positivo"><p>$ 0,01</p></td>
        </tr>
      </tbody>
    </table>
  </div>
</form>

</body>
</html>