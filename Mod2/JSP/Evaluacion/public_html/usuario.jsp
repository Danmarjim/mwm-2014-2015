<%@ page import="evaluacion.comprobacionBean"%>
<%@ page errorPage="error.jsp"%>
<jsp:useBean id="usuarioBean" scope="page" class="evaluacion.comprobacionBean"/>
<jsp:setProperty name="usuarioBean" property="*"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    </head>
    <body>
        <h1>Consulte la contrase&ntilde;a de un usuario</h1>
         
        <form name="formularioUsuario" method="POST">
            <label>Usuario:</label>
            <input type="text" name="nombreUsuario" required="required"/>
            <br/>
            <input type="submit"/>
        </form>
        
        <% if(request.getMethod()=="POST"){ %>
         Contrase&ntilde;a de 
        <%= usuarioBean.getNombreUsuario() %>
         es: 
        <%= usuarioBean.getPass() %>
         
        <% }%>
    </body>
</html>