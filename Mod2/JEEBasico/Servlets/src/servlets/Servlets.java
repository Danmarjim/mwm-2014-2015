package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "Servlets", urlPatterns = { "/servlets" })
public class Servlets extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    private int conexiones;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        conexiones = 0;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        String nombre=null;
        nombre=request.getParameter("NombreUsuario");
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>CuentaConexiones</title></head>");
        out.println("<body>");
        out.println("<p>Gracias por su visita, "+nombre+" eres el visitante numero</p>");
        conexiones++;
        out.println(Integer.toString(conexiones));
        out.println("</body></html>");
        out.close();
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
