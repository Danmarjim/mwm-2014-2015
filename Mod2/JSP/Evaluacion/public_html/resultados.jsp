<%@ page import="evaluacion.usuarioBean"%>
<%@ page import="evaluacion.votacionBean"%>
<%@ page errorPage="error.jsp"%>
<jsp:useBean id="usuario" scope="page" class="evaluacion.usuarioBean"/>
<jsp:useBean id="votacion" scope="application" class="evaluacion.votacionBean"/>
<jsp:setProperty name="usuario" property="*"/>
<jsp:setProperty name="votacion" property="*"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    </head>
    <body>
        <h1>Obtenido con getParameter</h1>
         
        <%
    String usuarioNombre=request.getParameter("nombre");
    String usuarioEdad=request.getParameter("edad");
    
    Cookie votado=new Cookie("votado","si");
             votado.setMaxAge(60);
             response.addCookie(votado);
    %>
        <p>
            Hola 
            <%=usuarioNombre%>
             de 
            <%=usuarioEdad%>
             a&ntilde;os.
        </p>
        <h1>Obtenido con getParameter</h1>
         
        <%
        String name = usuario.getNombre();
        int age = usuario.getEdad(); 
        %>
        <p>
            Hola 
            <%=name%>
             de 
            <%=age%>
             a&ntilde;os.
        </p>
         <h1>Los votos obtenidos son :</h1>
         
        <%= votacion.getVol() %>
         votos Volkswagen, 
        <%= votacion.getSeat() %>
         votos Seat, 
        <%= votacion.getOpel() %>
         votos Opel 
        <br/>
         &iquest;Desea 
        <a href="index.jsp">votar otra vez</a>?
    </body>
</html>