<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Cliente</title>

 <style>
  .Contenedor {
  background-color: #4A217C; 
  width: 700px; 
  height: 300px; 
  border-radius: 8px;
  }
  
  .ContenedorTitulo {
  background-color: #1D1B1B; 
  width: 260px; 
  margin: 0 auto;
  text-align: center;
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
  
  .ContenedorControles {
  }
  
</style>

</head>
<body>
   <a href="InicioLogin.jsp"> Inicio </a>
   
   <div class="Contenedor" >
        <div class="ContenedorTitulo">
           <h2>
			<strong style="color:#5F1AB4 ">AGREGAR CLIENTE</strong>
		   </h2>
        </div>
        
         
		<br/> <br/>
	   
	   <div class="ContenedorControles">
	       
	       <input type="text" id="txtDniCliente" name="txtDniCliente" placeholder="Ingrese su Dni...">
		
		<select id="ddlSexo" name="tipoSeguro" style="width: 177px;">
		
				<option value="">Seleccione su sexo...</option>
					
		</select>
						
		<input type="text" id="txtLocalidad" name="txtLocalidad" placeholder="Ingrese su Localidad..."> <br/> <br/>
		
		<input type="text" id="txtCuil" name="txtCuil" placeholder="Ingrese su Cuil...">
		
		<input type="text" id="txtNacionalidad" name="txtNacionalidad" placeholder="Ingrese su Nacionalidad...">
		
		<input type="text" id="txtProvincia" name="txtProvincia" placeholder="Ingrese su Provincia..."> <br/> <br/>
		
		<input type="text" id="txtNombre" name="txtNombre" placeholder="Ingrese su Nombre...">
		
		<input type="date" id="txtFechaNacimiento" name="txtFechaNacimiento">
		
		<input type="text" id="txtCorreo" name="txtCorreo" placeholder="Ingrese su Correo..."> <br/> <br/>
		
		<input type="text" id="txtApellido" name="txtApellido" placeholder="Ingrese su Apellido...">
		
		<input type="text" id="txtDireccion" name="txtDireccion" placeholder="Ingrese su Dirección...">
		
		<input type="text" id="txtDireccion" name="txtDireccion" placeholder="Ingrese su Teléfono..."> <br/> <br/> 
	   
	   </div>
		
		
		<div class="ContenedorBoton">
		 <input type="submit" style="color:#5F1AB4 "  class="btnAgregar" name="btnAgregar" value="AGREGAR"/>
		</div>
		
		
	</div>		
                
         
         
</body>
</html>