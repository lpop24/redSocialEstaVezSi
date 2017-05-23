<%-- 
    Document   : anadirExperienciaLaboral
    Created on : 23-may-2017, 18:16:27
    Author     : Loubna Channouf Cherradi
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Experiencialaboral"%>

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
        <title>Nueva Experiencia Laboral</title>
    </head>
    <body>
        <h1>Añadir Experiencia Laboral</h1>
        <form method="post" action="CrearExperienciaLaboralYEstudios">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Nombre de la Empresa </td>
                        <td><input type="text" name="nombreEmpresa" /></td>
                    </tr>
                    <tr>
                        <td>Fecha de Inicio</td>
                        <td><input type="date" name="fechaInicioLaboral" /></td>
                    </tr>
                    <tr>
                        <td>Fecha de finalización</td>
                        <td><input type="date" name="fechaFinLaboral" ></td>
                    </tr>
                    <tr>
                        <td>Ubicación de la Empresa</td>
                        <td><input type="text" name="ubicacionEmpresa" ></td>
                    </tr>
                    <tr>
                        <td>Página Web</td>
                        <td><input type="text" name="paginaWebEmpresa" ></td>
                    </tr>
                    <tr>
                        <td>Descripción</td>
                        <td><input type="text" name="descripcionEmpresa" ></td>
                    </tr>
                    <tr>
                        <td>Puesto</td>
                        <td><input type="text" name="puesto" ></td>
                    </tr> 
                </tbody>
            </table>
                    
            <button>Guardar</button>
        </form>
    </body>
</html>
