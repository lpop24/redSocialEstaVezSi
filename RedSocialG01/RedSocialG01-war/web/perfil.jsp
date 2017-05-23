<%-- 
    Document   : newjsp
    Created on : 21-abr-2017, 9:58:21
    Author     : Alberto Cazorla Suarez
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@page import="entity.Estudios"%>
<%@page import="java.util.Collection"%>
<%@page import="entity.Experiencialaboral"%>
<%@page import ="entity.Usuario"%>
<%@page import ="facade.UsuarioFacade"%>

<%
       Integer id;
       id = (Integer) request.getAttribute("idAlberto");
    
       String nombre;
       nombre = (String) request.getAttribute("nombre");
       
       String apellidos;
       apellidos = (String) request.getAttribute("apellidos");
                     
       java.util.Date fechanacimiento;
       fechanacimiento = (java.util.Date) request.getAttribute("fechanacimiento");
              
       String ciudad;
       ciudad = (String) request.getAttribute ("ciudad");
       
       String correo;
       correo = (String) request.getAttribute ("correo");
       
       String web;
       web = (String) request.getAttribute("web");
      
       String telefono;
       telefono = (String) request.getAttribute ("telefono");
       
       String instagram;
       instagram = (String) request.getAttribute ("instagram");
        
       String twitter;
       twitter = (String) request.getAttribute("twitter");
              
       String aficiones;
       aficiones = (String) request.getAttribute("aficiones");
        /*
        byte[] foto;
        //foto = (byte[]) request.getAttribute("foto");
        */
        List<Experiencialaboral> experiencia;
        experiencia = (List<Experiencialaboral>) session.getAttribute("experiencia");
        
        List<Estudios> estudios;
        estudios = (List<Estudios>)session.getAttribute ("estudios");
        
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
</head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>PERFIL DE USUARIO</title>
    </head>
    <body>
            <h2>Perfil de <%= nombre %></h2>
            
             <table>
                <th>Datos personales</th>
                <tr>
                <td><b>Nombre: </b></td><td><%= nombre %> <%= apellidos %><br/></td>
                </tr>
                <tr>
                <td><b>Fecha de nacimiento: </b> </td><td><%= fechanacimiento %><br/></td>
                </tr>
                <tr>
                <td><b>Ciudad de origen: </b></td><td> <%= ciudad %><br/></td>
                </tr>
                <tr>
                <td><b>Correo: </b></td><td><%= correo %><br/></td>
                </tr>
                <tr>
                <td><b>Página web: </b></td><td> <%= web %><br/></td>
                </tr>
                <tr>
                <td><b>Teléfono: </b></td><td><%= telefono %><br/></td>
                </tr>
                <tr>
                <td><b>Instagram: </b></td><td><%= instagram %><br/></td>
                </tr>
                <tr>
                <td><b>Twitter: </b></td><td><%= twitter %><br/></td>
                </tr>
                <tr>
                <td><b>Aficiones: </b></td><td><%= aficiones %><br/></td>
                </tr>
                <br/>
                <br/>
            </table>
            <input type="button" value="Modificar Perfil" onClick="location.href = 'modificarPerfil.jsp'" >
            <br/>
            <br/>
            
            
    
        <% if (estudios != null){ %>
                <h2>Estudios</h2>
                    <% for(Estudios est: estudios){ %>
                        <table>
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
                                <td><a href="BuscarELyEstudio?idBuscarEstudio=<%= est.getIdEstudios() %>">Editar Estudio</a></td>
                                <td><a href="BorrarELyEstudio?idEstudio=<%= est.getIdEstudios() %>">Borrar Estudio</a></td>
                            </tr>
                            <br/>
                        </table>
                            
                    <% } %>
                    
              <br/>
              <% } %>
              <input type="button" value="Añadir Estudios" onClick="location.href = 'anadirEstudios.jsp'">
              
               <% if (experiencia != null){ %>
              <% int count =0; %>
              
                <h2>Experiencia Laboral</h2>
                    <%for(Experiencialaboral exp: experiencia){ %>
                        <table>
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
                           <td><a href="BuscarELyEstudio?idBuscarLaboral=<%= exp.getIdExperienciaLaboral() %>">Editar Experiencia</a></td>
                           <td><a href="BorrarELyEstudio?idLaboral=<%= exp.getIdExperienciaLaboral() %>">Borrar Experiencia</a></td>
                        </tr>
                        <br/>
                        </table>
                    <%}%>
                    <br/>
            <% } %>
        <br/>
        <input type="button" value="Añadir Experiencia Laboral" onClick="location.href = 'anadirExperienciaLaboral.jsp'"><br/>
        <input type="button" value="Cerrar Sesión" onClick="location.href = 'CerrarSesion'"> 
    </body>
</html>
