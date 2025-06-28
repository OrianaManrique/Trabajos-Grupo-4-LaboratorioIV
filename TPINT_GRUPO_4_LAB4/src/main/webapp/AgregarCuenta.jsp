<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="entidad.*"%>
<%@page import="negocio.*"%>
<%@page import="negocioImpl.*"%>

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

.balance-container {
	display: flex;
	justify-content: center;
	gap: 40px;
	margin: 30px 0;
	flex-wrap: wrap;
}

.balance-box {
	/*background: linear-gradient(to right, #602A80, #4C0026);*/
	background: linear-gradient(to right, #A178C1, #A14C6F); ,
	color: white;
	padding: 25px 35px;
	border-radius: 12px;
	font-size: 26px;
	font-weight: bold;
	text-align: center;
	box-shadow: 0 4px 10px rgba(204, 0, 143, 0.3);
	min-width: 200px;
	width: 700px;
	height: 800px;
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
  
  p {
	font-size: 30px;
	text-align: center;
	color: black;
	font-weight: bold;
	text-align: center;
	background-color: #E5E5E5;
	border-radius: 8px;
}
  
</style>


<body>

	<%
	ArrayList<Tipo_Cuenta> ListaTipoCuentas = new ArrayList<Tipo_Cuenta>();
	if (request.getAttribute("Tipos") != null) {
		ListaTipoCuentas = (ArrayList<Tipo_Cuenta>) request.getAttribute("Tipos");
	}
	
	if (request.getAttribute("Tipos") != null) {
		ListaTipoCuentas = (ArrayList<Tipo_Cuenta>) request.getAttribute("Tipos");
	}
	
	%>

<div class="header">
Usuario logueado - Cuenta Banco
</div>

   <a href="InicioLogin.jsp"> Inicio </a>
   
   <form action="ServletCuentas?Param=Asignar" method="post">
   
   <div class="balance-container" >
      <div class="balance-box" >
			<p> AGREGAR CUENTA</p>
               
	  <div class="form-columna"> 
	     	  	   
	    <label class="lblinput">Numero de Cuenta </label>  
	    
	    <input class="inputBloqueado" type="text" id="txtNumeroCuenta" name="txtNumeroCuenta" placeholder="A12345678"> 
		
		<label class="lblinput"> CBU </label>  
				
		<input class="inputBloqueado" type="text" id="txtCBU" name="txtCBU" placeholder="7654321"> 
		
				 <label class="lblinput"> Saldo </label>  
		
		<input class="inputBloqueado" type="text" id="txtSaldo" value = 10000 name="txtSaldo" placeholder="$10.000" ReadOnly> 	
					   	   
	   </div>
	   <div class="form-columna"> 
	   
	    <input class="inputSegundaColumna" type="text" id="txtDniCliente" name="txtDniCliente" placeholder="Ingrese el dni del cliente...">
	     	  	   		
		<input class="inputSegundaColumna" type="date" id="txtFechaActual" name="txtFechaActual">
		
		<select class="inputSegundaColumna" id="ddlTipoCuenta" name="ddlTipoCuenta" style="display: flex;">

                <option value="">Seleccione un tipo...</option>
				<%
						for (Tipo_Cuenta tipo : ListaTipoCuentas) {
						%>
						<option value="<%= tipo.getId_tipoCuenta() %>"><%= tipo.getDescripcion_tipoCuenta() %></option>
						<%
						}
						%>
        </select>
        	      
	   </div>

		<div class="ContenedorBoton">
		 <input type="submit" style="color:#5F1AB4 " name="btnAsignar" value="Asignar"/>
		</div>
	   	 </div>
	</div>	
	</form>
	   	         
         
</body>
</html>