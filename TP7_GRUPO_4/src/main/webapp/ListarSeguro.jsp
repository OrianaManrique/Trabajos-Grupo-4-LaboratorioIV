<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ListarSeguros</title>

<style>
   a{ 
     margin-right: 10px;
   }


</style>

</head>
<body>
    <a href= "Inicio.jsp">  Inicio  </a>
    <a href = "AgregarSeguro.jsp" >  Agregar Seguro  </a>
    <a href = "ListarSeguro.jsp" >  Listar  Seguro  </a>

    <hr>

    <h2> Tipo de seguros en la base de datos</h2>

    <form>

    <p>Busqueda por tipo de seguros: 
    <select name = "tipoSeguro"> 
    <option> Seleccione... </option>
    </select>

    <input type = "submit"  name="Filtrar" value="Filtrar">

    </p>

    <table border= "1">

    <tr> <th> ID <br> Seguro </th>  <th> Descripción Seguro </th> <th> Descripción <br> Tipo seguro </th> <th>Costo <br> contratacion </th> <th>Costo Maximo <br> Asegurado </th> </tr>

    <tr>
       <td></td>
       <td></td>
       <td></td>
       <td></td>
       <td></td>
    </tr>

    </table>



    </form>

</body>
</html>
