<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Realizar transferencia</title>
<style>

body {
	margin: 0;
	padding: 0;
	background-color: #e5e5e5;
	font-family: Arial, sans-serif;
	justify-content: center;
	align-items: center;
	height: 100vh;
  }
  .ContenedorVentana{
  background-color: #4A217C; 
  width: 600px;
  height: 500px;
  padding-top: 5px;
  border-radius: 8px;
  text-align: center;
  } 
  
  .ContenedorTitulo {
  background-color: #E5E5E5; 
  width: 300px; 
  margin: 0 auto;
  text-align: center;
  border-radius: 8px;
  }
  
  .ContenedorColumna { 
  display: flex;
  flex-direction: column;
  margin-top: 15px;
  margin-left: 90px;
  gap:10px;
  }
  
  .ContenedorBoton {
  margin: 0 auto;
  width: 260px; 
  height: 100px; 
  }
    
  .btnTransferir {
  width: 260px; 
  height: 30%;
  font-weight: bold;
  }
  
  .form-columna input{
  width: 93%;
  padding: 10px;
  margin-bottom: 10px;
  border: none;
  border-radius: 8px;
  font-weight: bold;
  text-align: center;
  font-size: 12px;
  }
  
  input::placeholder {
  font-size: 13px;
  text-align: center;
  }
  
  .ContenedorControles{
    display: flex; 
    justify-content: space-around; 
    align-items: flex-start; 
    gap: 20px;
  }
  
  .form-columns {
            display: flex;
        }

  .form-columna {
            flex: 1;
            display: flex;
            flex-direction: column;
            gap: 15px;
            text-align: center;
        }
  
  .lblinput{
  color: white;
  }
  
</style>

</head>
<body>
   <a class="btnInicio" href="InicioLogin.jsp"> Inicio </a>
   
   <div class="ContenedorVentana" >
        <div class="ContenedorTitulo">
           <h2>
			<strong style="color:#5F1AB4 ">REALIZAR TRNSFERENCIA</strong>
		   </h2>
        </div>
               
		<br/> <br/>
	   
	  <div class="ContenedorControles">
	  <form class="form-columns">
	  <div class="form-columna"> 
	     	  	   
	    <label class="lblinput">¿A QUIEN LE VAS A TRNSFERIR? </label>
	    <input class="inputCBU" type="text" id="txtCBU" name="txtCBU" placeholder="CBU" > 
		<label class="lblinput"> IMPORTE </label>  
		<input class="inputImporte" type="text" id="txtImporte" name="txtImporte" placeholder="$">
		<label class="lblinput"> MOTIVO </label>
		<input class="inputMotivo" type="text" id="txtMotivo" name="txtMotivo" placeholder="Ej: Alquiler" > 	
					   	   
	   </div>
	   <br/> <br/>
	   </form>
	   	 </div>
		<br/> <br/>
		<div class="ContenedorBoton"> 
		
		 <input type="submit" class="btnTransferir" name="btnAsignar" value="TRANSFERIR"/>
		</div>
		
			
	</div>		         
         
</body>
</html>