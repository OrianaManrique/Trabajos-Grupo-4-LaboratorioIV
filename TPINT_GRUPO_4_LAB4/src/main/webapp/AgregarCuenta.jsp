<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="entidad.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmar Usuario</title>
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
  
  .ContenedorVentana{
  background-color: #4A217C; 
  width: 700px; 
  height: 450px; 
  border-radius: 8px;
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
    
  .btnAsignar {
  width: 260px; 
  height: 30%;
  }
  
  .FormularioUsuario{
  display: flex;
  flex-direction: column; 
  justify-content: center;
  align-items: center;
  gap: 10px;
  margin-right:12%;
  }
  
  .FormularioUsuario input{
    border-radius: 8px;
  }
  
  input::placeholder {
  font-size: 13px;
  text-align: center;
  }
   
  .inputBloqueado{
   color: grey;
  }
  
  .inputFechaActual{
   width:157px; 
  }
  
  .inputddlTipoCuenta{
  width:166px; 
  }
  
  .ContenedorControles{
    display: flex; 
    justify-content: space-around; 
    align-items: flex-start; 
    gap: 20px;
  }
  
  .form-columns {
            display: flex;
            gap: 40px;
        }

  .form-columna {
            flex: 1;
            display: flex;
            flex-direction: column;
            gap: 15px;
        }
        
  .inputSegundaColumna{
   margin-top: 34px;
  }
  
  .lblinput{
  color: white;
  }
  
</style>


<body>

	<%
	ArrayList<Tipo_Cuenta> ListaTipoCuentas = new ArrayList<Tipo_Cuenta>();
	if (request.getAttribute("listaTipoCuentas") != null) {
		ListaTipoCuentas = (ArrayList<Tipo_Cuenta>) request.getAttribute("listaTipoCuentas");
	}
	%>

<div class="header">
Usuario logueado - Cuenta Banco
</div>

   <a href="InicioLogin.jsp"> Inicio </a>
   
   <div class="ContenedorVentana" >
        <div class="ContenedorTitulo">
           <h2>
			<strong style="color:#5F1AB4 ">AGREGAR CUENTA</strong>
		   </h2>
        </div>
               
		<br/> <br/>
	   
	   <div class="ContenedorControles">	   
	   
	  <form action="ServletCuentas?Param=Asignar" method="post">
	  
	  <div class="form-columna"> 
	     	  	   
	    <label class="lblinput">Numero de Cuenta </label>  
	    
	    <input class="inputBloqueado" type="text" id="txtNumeroCuenta" name="txtNumeroCuenta" placeholder="A12345678" readonly > 
		
		<label class="lblinput"> CBU </label>  
				
		<input class="inputBloqueado" type="text" id="txtNumeroCuenta" name="txtNumeroCuenta" placeholder="7654321" readonly > 
		
				 <label class="lblinput"> Saldo </label>  
		
		<input class="inputBloqueado" type="text" id="txtNumeroCuenta" name="txtNumeroCuenta" placeholder="$10.000" readonly > 	
					   	   
	   </div>
	   
	   <br/> <br/>
	   
	   <div class="form-columna"> 
	   
	    <input class="inputSegundaColumna" type="text" id="txtDniCliente" name="txtDniCliente" placeholder="Ingrese el dni del cliente...">
	     	  	   		
		<input class="inputSegundaColumna" type="date" id="txtFechaActual" name="txtFechaActual">
		
		<select class="inputSegundaColumna" id="ddTipoCuenta" name="ddTipoCuenta" style="width: 177px;">

                <option value="">Seleccione un tipo...</option>

        </select>
        	      
	   </div>
	   
	   <br/> <br/>

	   </form>
	   
	   	 </div>
	   	       
		<br/> <br/>
		
			
		
		<div class="ContenedorBoton">
		<br/> <br/>
		 <input type="submit" style="color:#5F1AB4 "  class="btnAsignar" name="btnAsignar" value="ASIGNAR"/>
		</div>
		
			
	</div>		         
         
</body>
</html>