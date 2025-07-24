<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "entidad.*" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet"><meta charset="UTF-8">
<title>InicioReportes</title>
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
<p>REPORTES</p>
<br/>

<a class="link-light link-offset-2 link-underline link-underline-opacity-0 link-opacity-50-hover" href = "ReporteCondicion.jsp" > 1. Comparativo mensual solicitudes de préstamos Aprobados y Rechazados </a> <br/>
<a class="link-light link-offset-2 link-underline link-underline-opacity-0 link-opacity-50-hover" href = "ReporteImporte.jsp" > 2. Comparativo mensual importe de préstamos aprobados </a> <br/>
</div>

</div>

</body>
</html>