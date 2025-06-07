<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dominio.SegurosDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title></title>

<style>
        body {
            font-family: Arial;
        }

        input, select {
            margin-bottom: 5px;
            max-width: 250px;
        }
        
        bloque {
        
        display: block;
        
        }

        label {
            font-weight: bold;
        }

        a {
            margin-right: 10px;
        }
        
        .fila-formulario {
    	display: flex; 
    	text-align: left;
    	margin-left: 20;
   		
		}

		.bloque-etiquetas {
    	flex: 0 0 auto; /* No crece ni se encoge, toma solo el ancho necesario */
    	padding-right: 20px; /* Espacio entre las etiquetas y los campos de entrada */
    	text-align: left; /* Alinea las etiquetas a la derecha */
    	margin-bottom: 0px;
    	line-height: 1.57;
    	
		}

    </style>

</head>

<body>

<form action = "ServletAgregarSeguro" method = "post">

	<a href= "Inicio.jsp">  Inicio  </a>
    <a href = "AgregarSeguro.jsp" >  Agregar Seguro  </a>
    <a href = "ListarSeguro.jsp" >  Listar  Seguro  </a>
    
<br>

<hr>
    
<h2><strong>Agregar Seguros</strong></h2>

<%

	SegurosDao sDao = new SegurosDao();
	int proxID = sDao.ObtenerProxId();

 %>

<div class="fila-formulario">
        <div class="bloque-etiquetas">
            Id Seguro:    <br>
			Descripción: <br>
			Tipo de Seguro: <br>
			Costo contratación: <br>
			Costo Máximo Asegurado: <br>
        </div>
        <div class="bloque-entradas">
            <%= proxID %><br>
            <input type="text" id="descripcion" name="descripcion"> <br>
            <select id="tipoSeguro" name="tipoSeguro" style= "width: 177px;"> 
                <option>Seleccione...</option>
                <option value="1">Seguro de Casas</option>
                <option value="2">Seguro de Vida</option>
                <option value="3">Seguro de Auto</option>
                </select> <br>
            <input type="text" id="costoContratacion" name="costoContratacion"> <br>
            <input type="text" id="costoMaximoAsegurado" name="costoMaximoAsegurado"> <br>
            <input type = "submit" name = btnAceptar value= "Aceptar" /> <br>
        </div>
    </div>

<br>
<input type = "submit" name = "Aceptar2" value= "Aceptar" />
<br>


</form>

</body>
</html>