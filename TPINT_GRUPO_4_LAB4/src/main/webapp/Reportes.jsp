<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "entidad.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reportes</title>
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
      text-align: center;

    }
    
    .balance-container {
    display: flex;
    justify-content: center;
    gap: 40px;
    margin: 30px 0;
    flex-wrap: wrap;
}

.balance-box {
    background: #44107a; 
    color: white;
    padding: 25px 35px;
    border-radius: 12px;
    font-size: 26px;
    font-weight: bold;
    text-align: center;
    box-shadow: 0 4px 10px rgba(204, 0, 143, 0.3);
    min-width: 200px;
    width: 500px;
    height: 500px;
}
 
    table {
      width: 60%;
      border-collapse: collapse;
      margin: auto;
      background-color: #f9f6ff;
      box-shadow: 0 0 10px rgba(128, 0, 128, 0.1);
    }

    th, td {
      padding: 12px 15px;
      text-align: left;
      border-bottom: 1px solid #ddd;
    }

    th {
      background-color: #dcd0ff;
      color: #4b0082;
    }

    tr:hover {
      background-color: #eee4ff;
    }   

</style>
<body>
<%

Usuario usuario = new Usuario();

if(session.getAttribute("usuarioLogueado") != null){

    usuario = (Usuario)session.getAttribute("usuarioLogueado");

//}else {
//	response.sendRedirect("InicioLogin.jsp");
}
 %>

<div class="header">
<%=usuario.getNombre_us()%> <%=usuario.getApellido_us()%> - Administrador
</div>

<form>

<div class="subtitulo">Reportes</div>

<div class="balance-container" >

<div class="balance-box" >


<p>Filtrar</p>
   
   <br/>
   <br/>
	<table id="table_id" class="display">
		<thead>
			<tr>
				<th>%</th>
				<th>%</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>x</td>
				<td>x</td>
			</tr>
		</tbody>
	</table>
  
   <br/>
   <br/>
   
   <input type="submit" value="Filtrar" name="btnFiltrar" />
   
</div>

</div>
</form>


</body>
</html>