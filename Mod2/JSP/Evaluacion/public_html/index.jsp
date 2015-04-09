 <!DOCTYPE html>
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ page errorPage="error.jsp"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
        <title>Votaci&oacute;n</title>
    </head>
    <body>
        <% 
        Boolean existe=false;
   Cookie[] cookies = null;
   cookies = request.getCookies();
   for (Cookie cookie : cookies) {
                if (cookie.getName().equals("votado")) {
                    existe=true;
                }
            }
    %>
         
        <h1>Votaci&oacute;n de coches</h1>
        <p>Ay&uacute;denos a encontrar el mejor coche. Por favor, rellene cuidadosamente el cuestionario.</p>
        <h1>Datos Personales</h1>
         
        <form name="formularioVoto" action="resultados.jsp" method="post">
            <label>Nombre:</label>
            <input type="text" name="nombre" required="required"/>
            <br/>
            <br/>
            <label>Edad:</label>
            <input type="number" name="edad" min="1" max="100" required="required"/>
            <br/>
            <br/>
            <label>Coche</label>
            <input type="radio" name="coche" value="1" required="required"/>
            Volkswagen
            <input type="radio" name="coche" value="2" required="required"/>
            Seat
            <input type="radio" name="coche" value="3" required="required"/>
            Opel
            <br/>
            <br/>
            <% if(!existe){
            %>
            <input type="submit" name="Enviar votación"/>
            <input type="reset" name="Borrar votación"/>
            <% }else{ 
            %>
            No puede votar hasta dentro de 60 segundos.
            <%  } %>
        </form>
    </body>
</html>