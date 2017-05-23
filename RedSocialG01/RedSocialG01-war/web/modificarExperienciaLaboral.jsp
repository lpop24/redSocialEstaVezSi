<%-- 
    Document   : modificarExperienciaLaboral
    Created on : 22-may-2017, 17:06:36
    Author     : RetailAdmin
--%>

<%@page import="entity.Experiencialaboral"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% Experiencialaboral exp = (Experiencialaboral) request.getAttribute("experiencia"); %>
<html>
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
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar experiencia</title>
    </head>
    <body>
        <h1>Modificar experiencia</h1>
        <form name="formularioExperiencia" method="post" action="ActualizarExperiencia">
            <table>
                <th>Experiencia</th>  
                    <tr>
                    <td><b>Nombre: </b></td><td><input type="text" name="nombreEmpresa" value="<%= exp.getNombreEmpresa() %>"><br/></td>
                    </tr>
                    <tr>
                    <td><b>Puesto: </b></td><td><input type="text" name="puesto" value="<%= exp.getPuesto() %>"><br/></td>
                    </tr>
                    <tr>
                    <td><b>Fecha de inicio: </b></td><td>
                    <input type="text" name="fechaInicioExp" value="<%= exp.getFechaInicioLaboral()%>"><br/></td>
                    </tr>
                    <tr>
                    <td><b>Fecha de finalización: </b></td><td>
                    <input type="text" name="fechaFinExp" value="<%= exp.getFechaFinLaboral()%>"><br/></td>
                    </tr>
                    <tr>
                    <td><b>Ubicación: </b></td><td><input type="text" name="ubicacionEmpresa" value="<%= exp.getUbicacionEmpresa() %>"><br/></td>
                    </tr>
                    <tr>
                    <td><b>Página Web: </b></td><td><input type="text" name="web" value="<%= exp.getPaginaWebEmpresa() %>"><br/></td>
                    </tr>
                    <tr>
                    <td><b>Descripción: </b></td><td><input type="text" name="descripcionEmpresa" value="<%= exp.getDescripcionEmpresa() %>"><br/></td>
                    </tr>
             </table>
             <br/>
             <input type="hidden" name="idExperienciaLaboral" value="<%= exp.getIdExperienciaLaboral() %>">
             <button>Guardar</button>
             </form>
    </body>
</html>
