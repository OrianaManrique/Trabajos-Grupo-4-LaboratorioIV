<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmar Usuario</title>

 <style>
 
  body {
    background-color: #DCDCDC;
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
  }
  
  .ContenedorVentana{
  background-color: #4A217C; 
  width: 500px; 
  height: auto; 
  margin: 40px auto;
  padding: 15px;
  padding-bottom: 20px;
  border-radius: 8px;
  text-align: center;
  } 
  
  .ContenedorTitulo {
  background-color: white; 
  margin-top: 200px;
  width: 280px;
  margin: 0 auto;
  text-align: center;
  border-radius: 8px;
  padding: 2px;
  }
  
  .ContenedorBoton {
  margin: 0 auto;
  width: 260px; 
  }
    
  .btnConfirmar {
  width: 230px; 
  margin-top: 4px;
  margin-bottom: 5px;
  }
  
  .FormularioUsuario{
  display: flex;
  flex-direction: column; 
  justify-content: center;
  align-items: center;
  gap: 10px;
  }
  
  .FormularioUsuario input{
    border-radius: 8px;
  }
  
  input::placeholder {
  font-size: 13px;
  text-align: center;
  }
  
  .inputUsuario{
  background-color: grey; 
  }
  
  .lblUsuario{
   color: white;
   font-size: 21px;
  }
  
  .ContenedorControles input{
  	padding: 15px;
    border-radius: 15px;
    border: none;
    font-size: 15px;
  	padding: 15px 30px;
    border-radius: 15px;
    border: none;
    font-size: 18px;
    background-color: #DCDCDC;
    font-weight: bold;
    cursor: pointer;
    text-align: center;
  }
  
</style>

</head>
<body>
       
    <%
        String dni_cliente = null;
    
		if (request.getAttribute("Dni") != null) {
			dni_cliente = request.getAttribute("Dni").toString();
			
			
		}
	%>

   <a href="InicioLogin.jsp"> Inicio </a>
   
   <div class="ContenedorVentana" >
        <div class="ContenedorTitulo">
           <h2>
			<strong style="color:#5F1AB4 ">DATOS DE USUARIO</strong>
		   </h2>
        </div>
               
		<br/> <br/>
	   
	   <div class="ContenedorControles">	   
	   
	   <form class="FormularioUsuario" action="ServletConfirmarUsuario?Param=ConfirmarCliente" method="post">   
	   
	    <label class="lblUsuario"> USUARIO </label>
	    
	    <input class="inputUsuario" type="text" id="txtUsuarioCliente" name="txtUsuarioCliente" value="<%=dni_cliente + ".Banco" %>" readonly > <br/> 
						
		<input class="inputPassword" type="password" id="txtContra" name="txtContra" placeholder="Ingrese una contraseña..."> <br/> 
		
		<input class="inputPassword" type="password" id="txtContra" name="txtContra" placeholder="repita la contraseña...">  <br/> <br/>
	      				
		<div class="ContenedorBoton">
		 <input type="submit" style="color:#5F1AB4 " class="btnConfirmarUsuario" name="btnConfirmarUsuario" value="CONFIRMAR"/>
		</div>
		</form>
		</div>
	</div>


	<%
	if (request.getAttribute("Exito") != null) {
		Boolean exito = (Boolean) request.getAttribute("Exito");

		if (exito != null && exito) {
	%>
	<p style="color: green;">EXITO - Cliente Agregado</p>
	<%
	} else {
	%>
	<p style="color: red;">ERROR - Cliente no agregado</p>
	<%
	}
	}
	%>
	
</body>
</html>