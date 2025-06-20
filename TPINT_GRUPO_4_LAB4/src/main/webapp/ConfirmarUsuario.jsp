<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmar Usuario</title>

 <style>
  
  .ContenedorVentana{
  background-color: #4A217C; 
  width: 700px; 
  height: 350px; 
  border-radius: 8px;
  } 
  
  .ContenedorTitulo {
  background-color: #E5E5E5; 
  width: 300px; 
  margin: 0 auto;
  text-align: center;
  border-radius: 8px;
  }
  
  .ContenedorBoton {
  margin: 0 auto;
  width: 260px; 
  }
    
  .btnConfirmar {
  width: 260px; 
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
  }
  
</style>

</head>
<body>
   <a href="InicioLogin.jsp"> Inicio </a>
   
   <div class="ContenedorVentana" >
        <div class="ContenedorTitulo">
           <h2>
			<strong style="color:#5F1AB4 ">DATOS DE USUARIO</strong>
		   </h2>
        </div>
               
		<br/> <br/>
	   
	   <div class="ContenedorControles">	   
	   
	   <form class="FormularioUsuario">
	   
	   
	    <label class="lblUsuario"> USUARIO </label>
	    
	    <input class="inputUsuario" type="text" id="txtDniCliente" name="txtDniCliente" placeholder="12345678.BANCO" readonly > <br/> <br/>
						
		<input type="password" id="txtContraseña" name="txtContraseña" placeholder="Ingrese una contraseña..."> <br/> <br/>
		
		<input type="password" id="txtContraseña2" name="txtContraseña2" placeholder="repita la contraseña...">  <br/> <br/>
	   
	   </form>
	   		       
		<br/> <br/>
				
		<div class="ContenedorBoton">
		<br/> <br/>
		 <input type="submit" style="color:#5F1AB4 "  class="btnConfirmar" name="btnConfirmar" value="CONFIRMAR"/>
		</div>
		
		</div>	
	</div>		         
         
</body>
</html>