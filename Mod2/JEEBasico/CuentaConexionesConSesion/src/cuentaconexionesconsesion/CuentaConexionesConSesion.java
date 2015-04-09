package cuentaconexionesconsesion;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "CuentaConexionesConSesion", urlPatterns = { "/cuentaconexionesconsesion" })
public class CuentaConexionesConSesion extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        sesion.invalidate();
        
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Cuenta Conexiones con sesion</title></head>");
        out.println("<body>");
        out.println("<h1>Sesion cerrada correctamente</h1>");
        out.println("<a href='Formulario.html'>Ir al formulario</a>");
        out.println("</body></html>");
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    
        PrintWriter out = response.getWriter();
        int conexiones;
        HttpSession sesion = request.getSession(true);
        if(sesion.isNew()){
            conexiones = 1;
        } else {
            conexiones = (Integer)sesion.getAttribute("conexiones");
            conexiones++;
        }
        sesion.setAttribute("conexiones", conexiones);
        
        String nombre=null;
        nombre=request.getParameter("NombreUsuario");
        response.setContentType(CONTENT_TYPE);
        out.println("<html>");
        out.println("<head><title>CuentaConexiones</title></head>");
        out.println("<body>");
        out.println("<p>Gracias por su visita, "+nombre+" eres el visitante numero</p>");
        out.println(Integer.toString(conexiones));
        out.println("</body></html>");
        out.close();
    }
}
