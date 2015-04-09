package servletencuesta;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "Servletencuesta", urlPatterns = { "/servletencuesta" })
public class ServletEncuesta extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";
    private int si, no, nsnc;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        si = 0;
        no = 0;
        nsnc = 0;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Resultados Encuesta con Servlet</title></head>");
        out.println("<body>");
        out.println("<h3>Los resultados hasta este momento son:</h3><br/>");
        out.println("<table border=\"2\">");
        out.println("<tr><td><b>Respuesta</b></td> <td><b>Numero de votos</b></td></tr>");
        out.println("<tr><td align=\"center\">SI </td> <td align=\"center\">" + si + "</td></tr>");
        out.println("<tr><td align=\"center\">NO </td> <td align=\"center\">" + no + "</td></tr>");
        out.println("<tr><td align=\"center\">NSNC </td> <td align=\"center\">" + nsnc + "</td></tr>");
        out.println("</table>");
        out.println("</body></html>");
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre, email, respuesta;
        try {
            response.setContentType(CONTENT_TYPE);
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head><title>Encuesta con Servlet</title></head>");
            out.println("<body>");
            nombre = request.getParameter("Nombre");
            email = request.getParameter("Email");
            respuesta = request.getParameter("Respuesta");

            if (respuesta == null) {
                out.println("<h2>Introduzca una respuesta, por favor</h2>");
            } else {
                if (respuesta.equals("SI"))
                    si++;
                else if (respuesta.equals("NO"))
                    no++;
                else
                    nsnc++;
                out.println("<h2>Gracias por participar en esta encuesta</h2>");
                out.println("<hr size=7><blockquote>");
                out.println("<b>Nombre:</b>" + nombre);
                out.println("<br><b>Email:</b>" + email);
                if (respuesta.equals("NSNC")) {
                    out.println("<br>Aun no sabe si va a utilizar Servlet");
                } else
                    out.println("<br><b>" + respuesta + "</b> piensa utilizar los servlet para sus proyectos");
                out.println("</blockquote><hr>");

                out.println("<h3>Los resultados hasta este momento son:</h3>");
                out.println("<table border=\"2\">");
                out.println("<tr><td><b>Respuesta</b></td> <td><b>Numero de votos</b></td></tr>");
                out.println("<tr><td align=\"center\">SI </td> <td align=\"center\">" + si + "</td></tr>");
                out.println("<tr><td align=\"center\">NO </td> <td align=\"center\">" + no + "</td></tr>");
                out.println("<tr><td align=\"center\">NSNC </td> <td align=\"center\">" + nsnc + "</td></tr>");
                out.println("</table>");
            }
            out.println("</body></html>");
            out.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
