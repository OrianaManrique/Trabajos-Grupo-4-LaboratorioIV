<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "entidad.*" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

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
    font-size: 35px;
    color: #44107a;
    margin-bottom: 20px;
    margin-top: 20px;
    font-weight: bold;
}

p {

      font-size: 20px;
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
    
     .barra-grande {
    height: 100px; 
    font-size: 1.1rem;
  }
  
  h3{
  
 font-size: 25px;
 text-align: center;
  
  }

</style>
<body>
<%

Usuario usuario = new Usuario();
int aprobados = 0;
int rechazados = 0;
Float importe1 = 0f;
Float importe2 = 0f;

if(session.getAttribute("usuarioLogueado") != null){

    usuario = (Usuario)session.getAttribute("usuarioLogueado");

}else {
	response.sendRedirect("InicioLogin.jsp");
}

if (request.getAttribute("aprobados") != null) {
	aprobados = (int)request.getAttribute("aprobados");
}

if (request.getAttribute("rechazados") != null) {
	rechazados = (int)request.getAttribute("rechazados");
}

if (request.getAttribute("importe1") != null) {
	importe1 = (Float)request.getAttribute("importe1");
}

if (request.getAttribute("importe2") != null) {
	importe2 = (Float)request.getAttribute("importe2");
}

 %>

<div class="header">
<%=usuario.getNombre_us()%> <%=usuario.getApellido_us()%> - Administrador - <a Style="color: white" href="InicioLogin.jsp"> Cerrar sesión </a>
</div>

<form action="ServletReportes?Param=ReporteMensual" method="get">

  <div class="subtitulo">REPORTES</div>

  <div class="container mt-4">
    <h3>Reporte: Comparativo mensual importe de préstamos aprobados.</h3>
    <br/>
    <p>Seleccione mes a comparar</p><br/>

    <select class="form-select form-select-lg mb-3" id="ddlMes1" name="ddlMes1">
      <option value="">Seleccione un mes</option>
      <% for (int i = 1; i <= 12; i++) { %>
        <option value="<%= i %>"><%= i %></option>
      <% } %>
    </select>

    <div class="mb-4">
      <label>
        <i class="bi bi-currency-dollar"></i>
        Importe (<%=importe1%>)
      </label>
      <div class="progress">
        <div class="progress-bar bg-success barra-grande progress-bar-striped progress-bar-animated"
             role="progressbar"
             style="width: <%=importe1%>%"
             aria-valuemin="0"
             aria-valuemax="100">
          <%= importe1 %> %
        </div>
      </div>
    </div>

    <p>Seleccione mes a comparar</p><br/>

    <select class="form-select form-select-lg mb-3" id="ddlMes2" name="ddlMes2" onchange="this.form.submit()">
      <option value="">Seleccione un mes</option>
      <% for (int i = 1; i <= 12; i++) { %>
        <option value="<%= i %>"><%= i %></option>
      <% } %>
    </select>

    <div class="mb-4">
      <label>
        <i class="bi bi-currency-dollar"></i>
        Importe (<%=importe2%>)
      </label>
      <div class="progress">
        <div class="progress-bar bg-success barra-grande progress-bar-striped progress-bar-animated"
             role="progressbar"
             style="width: <%=importe2%>%"
             aria-valuenow="<%=importe2%>"
             aria-valuemin="0"
             aria-valuemax="100">
          <%= importe2 %> %
        </div>
      </div>
    </div>
  </div>

</form>
</body>
</html>