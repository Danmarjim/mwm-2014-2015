<!DOCTYPE html>
<%@ page contentType="text/html;charset=windows-1252"%>
<html>
   <head>
       <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
   </head>
   <body>
   <h1>Bienvenido a nuestro portal</h1>
   <%
           String nombre=null;
           HttpSession sesion = request.getSession(true);
           nombre = (String)sesion.getAttribute("nombre");
   %>
   
   <p><%=nombre%> le agradecemos su confianza en nuestros servicios.</p>
   
   </body>
</html>