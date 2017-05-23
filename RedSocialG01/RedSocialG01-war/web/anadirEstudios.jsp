<%-- 
    Document   : anadirEstudios
    Created on : 23-may-2017, 19:58:22
    Author     : Loubna Channouf Cherradi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%    
    int idUsuario = (Integer) session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            table {
                width: 25%;
            }
            td {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }
            th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
                background-color: #dddddd;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estudios</title>
    </head>
    <body>
        <h1>Añadir Estudios</h1>
        <form method="post" action="CrearExperienciaLaboralYEstudios">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Nombre del Centro </td>
                        <td><input type="text" name="nombreCentro" /></td>
                    </tr>
                    <tr>
                        <td>Fecha de Inicio</td>
                        <td><input type="date" name="fechaInicioEstudios" /></td>
                    </tr>
                    <tr>
                        <td>Fecha de finalización</td>
                        <td><input type="date" name="fechaFinEstudios" ></td>
                    </tr>
                    <tr>
                        <td>Ubicación del Centro</td>
                        <td><input type="text" name="ubicacionCentro" ></td>
                    </tr>
                    <tr>
                        <td>Descripción</td>
                        <td><input type="text" name="descripcionCentro" ></td>
                    </tr>
                </tbody>
            </table>
                    
            <button>Guardar</button>
        </form>
    </body>
</html>
