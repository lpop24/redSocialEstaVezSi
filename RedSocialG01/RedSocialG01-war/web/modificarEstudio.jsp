<%-- 
    Document   : modificarEstudio
    Created on : 22-may-2017, 14:19:20
    Author     : Alberto Cazorla Suarez
--%>

<%@page import="java.util.List"%>
<%@page import="facade.EstudiosFacade"%>
<%@page import="entity.Estudios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% Estudios est = (Estudios) request.getAttribute("estudio"); %>
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
        <title>Modificar estudio</title>
    </head>
    <body>
        <h1>Modificar estudio</h1>
        <form name="formularioEstudio" method="post" action="ActualizarELyEstudio">
            <table>
                <th>Estudio</th>  
                    <tr>
                    <td><b>Nombre: </b></td><td><input type="text" name="nombreCentro" value="<%= est.getNombreCentro() %>"><br/></td>
                    </tr>
                    <tr>
                    <td><b>Fecha de inicio: </b></td><td>
                    <input type="text" name="fechaInicioEstudio" value="<%= est.getFechaInicioEstudios() %>"><br/></td>
                    </tr>
                    <tr>
                    <td><b>Fecha de finalización: </b></td><td>
                    <input type="text" name="fechaFinEstudio" value="<%= est.getFechaFinEstudios() %>"><br/></td>
                    </tr>
                    <tr>
                    <td><b>Ubicación: </b></td><td><input type="text" name="ubicacionCentro" value="<%= est.getUbicacionCentro() %>"><br/></td>
                    </tr>
                    <tr>
                    <td><b>Descripción: </b></td><td><input type="text" name="descripcionCentro" value="<%= est.getDescripcionCentro() %>"><br/></td>
                    </tr>
             </table>
             <br/>
             <input type="hidden" name="idEstudio" value="<%= est.getIdEstudios() %>">
             <button>Guardar</button>
             </form>
    </body>
</html>
