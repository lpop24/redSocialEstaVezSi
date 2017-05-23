<%-- 
    Document   : crearUsuario
    Created on : 21-may-2017, 16:41:23
    Author     : Loubna Channouf Cherradi
--%>

<%@page import="entity.Login" %>
<%
    Login login = new Login();
%>

<%@page import="entity.Usuario" %>
<%
    Usuario usuario = new Usuario();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Usuario</title>
    </head>
    <body>
        <h1>Crear Perfil</h1>
        <form method="post" action="CrearUsuarioServlet">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Nombre de Usuario </td>
                        <td><input type="text" name="usuarioLogin" /></td>
                    </tr>
                    <tr>
                        <td>Contraseña</td>
                        <td><input type="password" name="contrasena" /></td>
                    </tr>
                    <tr>
                        <td>Nombre:</td>
                        <td><input type="text" name="nombre" ></td>
                    </tr>
                    <tr>
                        <td>Apellidos:</td>
                        <td><input type="text" name="apellidos" ></td>
                    </tr>
                    <tr>
                        <td>Instagram:</td>
                        <td><input type="text" name="instagram" ></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input type="text" name="correoElectronico" ></td>
                    </tr>
                    <tr>
                        <td>Twitter:</td>
                        <td><input type="text" name="twitter" ></td>
                    </tr>
                    <tr>
                        <td>Telefono:</td>
                        <td><input type="text" name="telefono" ></td>
                    </tr>
                    <tr>
                        <td>Fecha de nacimiento:</td>
                        <td><input type="date" name="fechaNacimiento"  ></td>
                    </tr>
                    <tr>
                        <td>Pagina web:</td>
                        <td><input type="text" name="paginaWebUsuario" ></td>
                    </tr>
                    <tr>
                        <td>Aficiones:</td>
                        <td><input type="text" name="aficiones" ></td>
                    </tr>
                    <tr>
                        <td>Ciudad:</td>
                        <td><input type="text" name="ciudad" ></td>
                    </tr>
                    
                </tbody>
            </table>
                    
            <button>Guardar</button>
        </form>
        <input type="button" value="Cancelar" onClick="location.href = 'login.jsp'">
    </body>
</html>
