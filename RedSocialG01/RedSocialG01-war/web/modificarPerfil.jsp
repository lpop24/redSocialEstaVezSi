<%-- 
    Document   : modificar
    Created on : 24-abr-2017, 15:03:28
    Author     : Alvaro Medina Martinez
--%>

<%@page import="entity.Experiencialaboral"%>
<%@page import="entity.Estudios"%>
<%@page import="entity.Usuario"%>
<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar perfil</title>
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
    </head>
    <body>
        Modificar perfil de: <%= usuario.getNombre() %> <%= usuario.getApellidos() %><br/><br/>
        <form method="post" action="ActualizarPerfil">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Nombre:</td>
                        <td><input type="text" name="nombre" value="<%= usuario.getNombre() %>"></td>
                    </tr>
                    <tr>
                        <td>Apellidos:</td>
                        <td><input type="text" name="apellidos" value="<%= usuario.getApellidos() %>"></td>
                    </tr>
                    <tr>
                        <td>Instagram:</td>
                        <td><input type="text" name="instagram" value="<%= usuario.getInstagram()%>"></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input type="text" name="email" value="<%= usuario.getCorreoElectronico()%>"></td>
                    </tr>
                    <tr>
                        <td>Twitter:</td>
                        <td><input type="text" name="twitter" value="<%= usuario.getTwitter()%>"></td>
                    </tr>
                    <tr>
                        <td>Telefono:</td>
                        <td><input type="text" name="telefono" value="<%= usuario.getTelefono()%>"></td>
                    </tr>
                    <tr>
                        <td>Fecha de nacimiento:</td>
                        <td><input type="text" name="fecha_nacimiento" value="<%= usuario.getFechaNacimiento()%>"></td>
                    </tr>
                    <tr>
                        <td>Pagina web:</td>
                        <td><input type="text" name="pagina_web" value="<%= usuario.getPaginaWebUsuario()%>"></td>
                    </tr>
                    <tr>
                        <td>Aficiones:</td>
                        <td><input type="text" name="aficiones" value="<%= usuario.getAficiones()%>"></td>
                    </tr>
                    <tr>
                        <td>Ciudad:</td>
                        <td><input type="text" name="ciudad" value="<%= usuario.getCiudad()%>"></td>
                    </tr>
                </tbody>
            </table>
                    <!--
            <table>
                <th>Estudios</th>
                    <%for(Estudios est: usuario.getEstudiosCollection()){ %>
                    <tr><td><input type="hidden" name="idEstudio" value="<%= est.getIdEstudios() %>"></td></tr>
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
                    <tr>
                    <td> <br/></td>
                    </tr>
                    <br/>
                    <%}%>
              </table><br/>
              <table>
                <th>Experiencia Laboral</th>
                    <%for(Experiencialaboral exp: usuario.getExperiencialaboralCollection()){ %>
                    <tr><td><input type="hidden" name="idLaboral" value="<%= exp.getIdExperienciaLaboral() %>"></td></tr>
                    <tr>
                    <td><b>Nombre: </b></td><td><input type="text" name="nombreEmpresa" value="<%= exp.getNombreEmpresa() %>"><br/></td>
                    </tr>
                    <tr>
                    <td><b>Puesto: </b></td><td><input type="text" name="puesto" value="<%= exp.getPuesto() %>"><br/></td>
                    </tr>
                    <tr>
                    <td><b>Fecha de inicio: </b></td><td>
                    <input type="text" name="fechaInicioLaboral" value="<%= exp.getFechaInicioLaboral() %>"><br/></td>
                    </tr>
                    <tr>
                    <td><b>Fecha de finalización: </b></td><td>
                    <input type="text" name="fechaFinLaboral" value="<%= exp.getFechaFinLaboral() %>"><br/></td>
                    </tr>
                    <tr>
                    <td><b>Web: </b></td><td><input type="text" name="paginaWebEmpresa" value="<%= exp.getPaginaWebEmpresa() %>"><br/></td>
                    </tr>
                    <tr>
                    <td><b>Ubicación: </b></td><td><input type="text" name="ubicacionEmpresa" value="<%= exp.getUbicacionEmpresa() %>"><br/></td>
                    </tr>
                    <tr>
                    <td><b>Descripción: </b></td><td><input type="text" name="descripcionEmpresa" value="<%= exp.getDescripcionEmpresa() %>"><br/></td>
                    </tr>
                    <tr>
                    <td> <br/></td>
                    </tr>
                    <br/>
                    <%}%>
              </table>
                    -->
            <button>Guardar</button>
        </form>
    </body>
</html>