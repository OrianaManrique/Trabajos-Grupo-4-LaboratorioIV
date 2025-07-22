<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="entidad.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pago de Cuotas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .header {
            background: linear-gradient(to right, #bc9fd6, #44107a);
            color: white;
            padding: 20px;
            text-align: center;
            font-weight: bold;
            font-size: 20px;
        }
        .subtitulo {
            text-align: center;
            font-size: 35px;
            color: #44107a;
            margin: 30px 0;
            font-weight: bold;
        }
        .table th {
            background-color: #8e5cc4;
            color: white;
            text-align: center;
        }
        .table td {
            text-align: center;
            vertical-align: middle;
        }
        .btn-pay {
            background-color: #44107a;
            color: white;
        }
        .btn-pay:hover {
            background-color: #5e2b91;
        }
        .estado-pagado {
            color: green;
            font-weight: bold;
        }
    </style>
</head>
<body>


<div class="header">
     - Cliente
</div>

<div class="container">
    <div class="subtitulo">Préstamos</div>

    <table class="table table-bordered table-hover">
        <thead>
            <tr>
                <th>Cuotas</th>
                <th>Monto a abonar</th>
                <th>Cuenta debitada</th>
                <th>Fecha de pago</th>
                <th>Estado</th>
            </tr>
        </thead>
        <tbody>
           
                <tr>
                    <td>Cuota nrocuota</td>
                    <td>$ 121212%></td>
                    <td>N° 11000 %></td>
                    <td>22/05/2024 </td>
                    <td>
                        
                            <span class="estado-pagado">Pagado</span>
                        
                            <form method="post" action="ServletPagoCuota">
                                <input type="hidden" name="idCuota" value="">
                                <button type="submit" class="btn btn-pay">Pagar ahora</button>
                            </form>
                        
                    </td>
                </tr>
            
                <tr>
                    <td colspan="5">No hay cuotas disponibles.</td>
                </tr>
            
        </tbody>
    </table>
</div>

</body>
</html>