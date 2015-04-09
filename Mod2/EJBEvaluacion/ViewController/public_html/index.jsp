<!DOCTYPE html>
<%@ page contentType="text/html;charset=windows-1252"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    </head>
    <body>
        <h1>Formulario de Login</h1>
         
        <form id="formulario" action="consulta" method="POST">
            Usuario:
            <input type="text" name="user"/>
            <br/>
            <br/>
            Password:
            <input type="password" name="pass"/>
            <br/>
            <br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>