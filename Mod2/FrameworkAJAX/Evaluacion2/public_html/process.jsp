<%
       String name= request.getParameter("name");
       String mail= request.getParameter("mail");
       String tel= request.getParameter("phone");
       boolean var=false;
   %>
<%
       if (name.equals("")){
           var=false;
       }else if (mail.equals("")){
           var=false;
       }else if (tel.equals("")){
           var=false;
       }
       else {
           var=true;
           HttpSession sesion = request.getSession(true);
           sesion.setAttribute("nombre", name);
       }
   String respuesta = "{ \"respuesta\" : \""+var+"\"}"; 
   out.print((String)respuesta);
   %>