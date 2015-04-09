package evaluacion;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "Registrousuario", urlPatterns = { "/registro" })
public class RegistroUsuario extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        sesion.invalidate();

        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Registro</title></head>");
        out.println("<body>");
        String nombre = request.getParameter("NombreUsuario");
        String pass = request.getParameter("Email");
        Cookie miCookie = new Cookie("nombre", request.getParameter("NombreUsuario"));
        response.addCookie(miCookie);
        if (nombre.equals("")) {
            out.println("<h2>Usuario no registrado</h2>");
            out.println("<br/>");
            out.println("<a href='registro.html'>Registrarse</a>");
        } else {
            String destination = "/consulta.html";
            RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
            rd.forward(request, response);
        }
        out.println("</body></html>");
        out.close();
    }
}
