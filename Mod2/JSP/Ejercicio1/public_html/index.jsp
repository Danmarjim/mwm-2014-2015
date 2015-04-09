<!DOCTYPE html>
<%@ page contentType="text/html;charset=windows-1252"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
        <title>Muestra de la hora actual</title>
    </head>
    <body>
        Esta es mi primera pagina con JSP 
        <br/>
         
        <% java.util.Date dt = new java.util.Date(System.currentTimeMillis());%>
         
        <% int horas = dt.getHours(); %>
         
        <% int minutos = dt.getMinutes(); %>
         
        <h2>
            Ahora son las
            <%=horas%>
            horas y
            <%=minutos%>
            minutos
        </h2>
    </body>
</html>