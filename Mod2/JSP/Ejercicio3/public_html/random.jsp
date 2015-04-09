<!DOCTYPE html>
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ page import="ejercicio3.BeanAcierto" %>

<jsp:useBean id="numacierto" class="ejercicio3.BeanAcierto" scope="request"/>
<jsp:setProperty name="numacierto" property="*"/>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
            <title>Acierte un n&uacute;mero</title>
        </head>
        <body>
            <% if(numacierto.getExito()){ %>
             &iexcl;FELICIDADES! Lo consiguio a los 
            <%=numacierto.getNumIntentos()%>
             intentos. 
            <% numacierto.inicia(); %>
             Desea 
            <a href="formulario.html">probar otra vez?</a>
             
            <% } else { %>
             No lo ha acertado. Intente 
            <b>
                <%=numacierto.getPista()%></b>
             Ha realizado 
            <%=numacierto.getNumIntentos()%>
             intentos. 
            <form action="random.jsp" method="POST">
                &iquest;Qu&eacute; n&uacute;mero he pensado?:
                <input type="text" name="numero"/>
                <input type="submit" value="Enviar"/>
            </form>
             
            <% } %>
        </body>
    </html>