<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Cliente</title>

 <style>
  .ContenedorVentana{
  background-color: #4A217C; 
  width: 700px; 
  height: 500px; 
  border-radius: 8px;
  }  
  
  .ContenedorTitulo {
  background-color: #E5E5E5; 
  width: 260px; 
  margin: 0 auto;
  text-align: center;
  border-radius: 8px;
  }
  
  .ContenedorBoton {
  margin: 0 auto;
  width: 260px; 
  }
    
  .btnAgregar {
  width: 260px; 
  }
  
  .ContenedorColumna { 
  display: flex;
  margin-top: 15px;
  margin-left: 90px;
  gap:10px;
  }
  
  .FormularioAgregarCLiente input{
  border-radius: 8px;
  }
  
  .inputFechaNac{
  width:167px; 
  }
  
  .inputNacionalidad{
  width:167px; 
  }
   
  .inputDireccion{
  width:167px; 
  }
  
</style>

</head>
<body>
   <a href="InicioLogin.jsp"> Inicio </a>
   
   <div class="ContenedorVentana" >
        <div class="ContenedorTitulo">
           <h2>
			<strong style="color:#5F1AB4 ">AGREGAR CLIENTE</strong>
		   </h2>
        </div>
        
         
		<br/> <br/>
	   	  
	   <div class="ContenedorControles">
	   
	   <form class="FormularioAgregarCLiente">
	  	   
	   <div class="ContenedorColumna"> 
	    
	    <input type="text" id="txtDniCliente" name="txtDniCliente" placeholder="Ingrese su Dni...">
		
		<select id="ddlSexo" name="tipoSeguro" style="width: 177px;">
		
				<option value="">Seleccione su sexo...</option>
					
		</select>
						
		<input type="text" id="txtLocalidad" name="txtLocalidad" placeholder="Ingrese su Localidad..."> 
		
	   </div>
	       
	       <br/> <br/>
		
		<div class="ContenedorColumna"> 
		
		<input type="text" id="txtCuil" name="txtCuil" placeholder="Ingrese su Cuil...">
		
		<input class="inputNacionalidad" type="text" id="txtNacionalidad" name="txtNacionalidad" placeholder="Ingrese su Nacionalidad...">
		
		<input type="text" id="txtProvincia" name="txtProvincia" placeholder="Ingrese su Provincia..."> 
		
		</div>
		
		<br/> <br/>
		
		<div class="ContenedorColumna"> 
		
		<input type="text" id="txtNombre" name="txtNombre" placeholder="Ingrese su Nombre...">
		
		<input class="inputFechaNac" type="date" id="txtFechaNacimiento" name="txtFechaNacimiento">
		
		<input type="text" id="txtCorreo" name="txtCorreo" placeholder="Ingrese su Correo..."> 
		
		</div>
		
		<br/> <br/>
		
		<div class="ContenedorColumna"> 
		
		<input type="text" id="txtApellido" name="txtApellido" placeholder="Ingrese su Apellido...">
		
		<input class="inputDireccion" type="text" id="txtDireccion" name="txtDireccion" placeholder="Ingrese su Dirección...">
		
		<input type="text" id="txtDireccion" name="txtDireccion" placeholder="Ingrese su Teléfono..."> 
		
		</div>
		
		<br/> <br/> 
	   
	   
	    </form>
	    
	   </div>
		
		
		<div class="ContenedorBoton">
		 <input type="submit" style="color:#5F1AB4 " class="btnAgregar" name="btnAgregar" value="AGREGAR"/>
		</div>
		
		
	</div>		
                
         
         
</body>
</html>