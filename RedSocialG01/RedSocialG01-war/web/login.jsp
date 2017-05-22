<%-- 
    Document   : login
    Created on : 22-may-2017, 13:05:22
    Author     : DaniUni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="LoginServlet">
            <table>
            <tr>
                <td>Nombre de Usuario </td>
                <td><input type="text" name="nombreUsuario"/></td>
            </tr>
            <tr>
                <td>Contraseña</td>
                <td><input type="password" name="passUsuario"/></td>
            </tr>
            </table>
            <button>Entrar</button>
        </form>
        <br/>
        <input type="button" value="CrearCuenta" onClick="location.href = 'darDeAlta.jsp'">   
    </body>
</html>
