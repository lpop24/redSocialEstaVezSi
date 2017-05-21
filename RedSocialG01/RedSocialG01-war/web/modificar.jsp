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
        Modificar perfil de: <br/><br/>
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
            <table>
                <th>Estudios</th>
                    <%for(Estudios est: usuario.getEstudiosCollection()){ %>
                    <tr>
                    <td><b>Nombre: </b></td><td><%= est.getNombreCentro() %><br/></td>
                    </tr>
                    <tr>
                    <td><b>Fecha de inicio: </b></td><td>
                    <%java.util.Date fechaInicioEst=est.getFechaInicioEstudios();%>
                    <%=fechaInicioEst%><br/></td>
                    </tr>
                    <tr>
                    <td><b>Fecha de finalización: </b></td><td>
                    <%java.util.Date fechaFinEst=est.getFechaFinEstudios();%>
                    <%=fechaFinEst%><br/></td>
                    </tr>
                    <tr>
                    <td><b>Ubicación: </b></td><td><%= est.getUbicacionCentro() %><br/></td>
                    </tr>
                    <tr>
                    <td><b>Descripción: </b></td><td><%= est.getDescripcionCentro() %><br/></td>
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
                    <tr>
                    <td><b>Nombre: </b></td><td><%= exp.getNombreEmpresa() %><br/></td>
                    </tr>
                    <tr>
                    <td><b>Puesto: </b></td><td><%= exp.getPuesto() %><br/></td>
                    </tr>
                    <tr>
                    <td><b>Fecha de inicio: </b></td><td>
                    <%java.util.Date fechaInicioEst=exp.getFechaInicioLaboral();%>
                    <%=fechaInicioEst%><br/></td>
                    </tr>
                    <tr>
                    <td><b>Fecha de finalización: </b></td><td>
                    <%java.util.Date fechaFinEst=exp.getFechaFinLaboral();%>
                    <%=fechaFinEst%><br/></td>
                    </tr>
                    <tr>
                    <td><b>Web: </b></td><td><%= exp.getPaginaWebEmpresa() %><br/></td>
                    </tr>
                    <tr>
                    <td><b>Ubicación: </b></td><td><%= exp.getUbicacionEmpresa() %><br/></td>
                    </tr>
                    <tr>
                    <td><b>Descripción: </b></td><td><%= exp.getDescripcionEmpresa() %><br/></td>
                    </tr>
                    <tr>
                    <td> <br/></td>
                    </tr>
                    <br/>
                    <%}%>
              </table>
            <button>Guardar</button>
        </form>
    </body>
</html>