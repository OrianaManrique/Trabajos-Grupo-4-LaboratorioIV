<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import = "entidad.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificar Cuenta</title>
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
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.05);
}

.movements-table thead {
    background: linear-gradient(to right, #602A80, #4C0026);
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

</style>


<body>
<%String nombreCliente = "Oriana Manrique"; 
int dniCliente = 41200035;
int NroCuenta = 11001;
String CBU = "1234567891123456789123";
TipoCuenta tipoCuenta = new TipoCuenta();
%>


	<div class="header">Usuario logueado - Cuenta Banco</div>

	<form>
		<input type="search" name="txtBusqueda"
			placeholder="Ingrese un Dni..." />
		<button type="submit">Buscar</button>

		<div class="table-container">
    <table class="movements-table">
      <thead>
        <tr>
          <th><%=nombreCliente%></th>
          <th>NUMERO CUENTA</th>
          <th>CBU</th>
          <th>TIPO CUENTA</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td><p><%=dniCliente%></p></td>
          <td><p><%=NroCuenta%></p></td>
          <td><p><%=CBU%></p></td>
          <td><p><%=tipoCuenta.getDescripcion_tipoCuenta()%></p></td>
          <td><a href = "ServletClientes?Param=" > Seleccionar </a> <br/></td>
        </tr>
        <tr>
        <td></td>
          <td><p><%=NroCuenta%></p></td>
          <td><p><%=CBU%></p></td>
          <td><p><%=tipoCuenta.getDescripcion_tipoCuenta()%></p></td>
          <td><a href = "ServletClientes?Param=" > Seleccionar </a> <br/></td>  
         </tr>
         <tr>
        <td></td>
          <td><p><%=NroCuenta%></p></td>
          <td><p><%=CBU%></p></td>
          <td><p><%=tipoCuenta.getDescripcion_tipoCuenta()%></p></td>
          <td><a href = "ServletClientes?Param=" > Seleccionar </a> <br/></td>   
         </tr>
      </tbody>
    </table>
  </div>
	</form>
</body>
</html>