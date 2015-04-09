<!DOCTYPE html>
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ page errorPage="error.jsp"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
        <title>Ejercicio 2</title>
    </head>
    <body>
    <h1>
    Segun su solicitud la pagina generada ha sido:
    </h1><br>
    <% 
    String nombre = request.getParameter("nombre");
    String nveces = request.getParameter("n");
    int n = Integer.parseInt(nveces);
    for(int i=0;i<n;i++){ %>
        <h2>
        <%=nombre%> se imprime <%=n%> veces
        </h2>
    
    <%}%>
    </body>
</html>