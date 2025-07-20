<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
    
<%@ page import = "entidad.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PagarPrestamo</title>
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

<div class="subtitulo">Pagar Préstamos</div>

</form>

</body>
</html>