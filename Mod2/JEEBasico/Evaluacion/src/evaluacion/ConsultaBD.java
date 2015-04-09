package evaluacion;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.util.TimeZone;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "ConsultaBD", urlPatterns = { "/consultabd" })
public class ConsultaBD extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";
    private ConexionBD conexion = null;
    private ResultSet rs = null;
    private int numColumnasAgenda = 5;
    private int numColumnasEmpleado = 13;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            TimeZone timezone = TimeZone.getTimeZone("GMT+1");
            TimeZone.setDefault(timezone);
            conexion = new ConexionBD();
        } catch (Exception e) {
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        sesion.invalidate();

        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Desconexion</title></head>");
        out.println("<body>");
        out.println("<h1>Usuario desconectado</h1>");
        out.println("<a href='registro.html'>Registrarse</a>");
        out.println("</body></html>");
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int conexiones;

        HttpSession sesion = request.getSession(true);
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();

        if (sesion.isNew()) {
            conexiones = 1;
        } else {
            conexiones = (Integer) sesion.getAttribute("conexiones");
            conexiones++;
        }
        sesion.setAttribute("conexiones", conexiones);
        String conection = Integer.toString(conexiones);

        out.println("<html>");
        out.println("<head><title>Consulta tabla</title></head>");
        out.println("<body>");
        String tabla = request.getParameter("NombreTabla");
        Cookie miCookie = new Cookie("tabla", request.getParameter("NombreTabla"));
        response.addCookie(miCookie);
        Cookie[] cookie = request.getCookies();

        //Solucion sabiendo las tablas que vamos a consultar

        /*if (tabla.equals("agenda")) {
            out.println("<div style='border:solid;border-color:black;text-align:center;color:white;background-color:red;'>");
            out.println("Resultados de la consulta realizada por " + cookie[0].getValue() + "<br/>");
            out.println("Tabla: " + tabla + "<br/>");
            out.println("Numero de accesos: " + conection + "<br/>");
            out.println("Fecha de ultimo acceso: " + "<script type=\"text/javascript\">\n" +
                        "                  var d = new Date();\n" + "var dia = new Array(7);\n" +
                        "var mes = new Array(11);\n" + "                  dia[0] = 'Dom';\n" +
                        "                  dia[1] = 'Lun';\n" + "                  dia[2] = 'Mar';\n" +
                        "                  dia[3] = 'Mie';\n" + "                  dia[4] = 'Jue';\n" +
                        "                  dia[5] = 'Vie';\n" + "                  dia[6] = 'Sab';\n " +
                        "                  mes[0] = 'Dic';\n" + "                  mes[1] = 'Ene';\n" +
                        "                  mes[2] = 'Feb';\n" + "                  mes[3] = 'Mar';\n" +
                        "                  mes[4] = 'Abr';\n" + "                  mes[5] = 'May';\n" +
                        "                  mes[6] = 'Jun';\n" + "                  mes[7] = 'Jul';\n" +
                        "                  mes[8] = 'Ago';\n" + "                  mes[9] = 'Sep';\n" +
                        "                  mes[10] = 'Oct';\n" + "                  mes[11] = 'Nov';\n" +
                        "                  document.write(dia[d.getDay()], ' ' +mes[d.getMonth()], ' ' +d.getHours(), ':' +d.getMinutes(), ':' +d.getSeconds(), ' GMT ' +d.getFullYear());\n" +
                        "                </script>" + "<br/>");
            if (sesion.isNew()) {
                out.println("Ultima tabla consultada: " + " " + "<br/>");
            } else {
                out.println("Ultima tabla consultada: " + cookie[1].getValue() + "<br/>");
            }
            out.println("</div>");
            out.println("<br/>");
            out.println("<a href='consulta.html'>Otra consulta</a>");
            out.println("<a href='registro.html'>Desconexion</a>");
            out.println("<br/>");
            out.println("<table border>");
            try {
                rs = conexion.consultar(tabla);

            } catch (SQLException e) {
            }
            try {
                while (rs.next()) {
                    out.println("<tr>");
                    for (int i = 1; i <= numColumnasAgenda; i++) {
                        out.println("<td>" + rs.getObject(i) + "</td>");
                    }
                    out.println("</tr>");
                }
            } catch (SQLException e) {
            }
            out.println("</table>");
        } else if (tabla.equals("empleados")) {
            out.println("<div style='border:solid;border-color:black;text-align:center;color:white;background-color:red;'>");
            out.println("Resultados de la consulta realizada por " + cookie[0].getValue() + "<br/>");
            out.println("Tabla: " + tabla + "<br/>");
            out.println("Numero de accesos: " + conection + "<br/>");
            out.println("Fecha de ultimo acceso: " + "<script type=\"text/javascript\">\n" +
                        "                  var d = new Date();\n" + "var dia = new Array(7);\n" +
                        "var mes = new Array(11);\n" + "                  dia[0] = 'Dom';\n" +
                        "                  dia[1] = 'Lun';\n" + "                  dia[2] = 'Mar';\n" +
                        "                  dia[3] = 'Mie';\n" + "                  dia[4] = 'Jue';\n" +
                        "                  dia[5] = 'Vie';\n" + "                  dia[6] = 'Sab';\n " +
                        "                  mes[0] = 'Dic';\n" + "                  mes[1] = 'Ene';\n" +
                        "                  mes[2] = 'Feb';\n" + "                  mes[3] = 'Mar';\n" +
                        "                  mes[4] = 'Abr';\n" + "                  mes[5] = 'May';\n" +
                        "                  mes[6] = 'Jun';\n" + "                  mes[7] = 'Jul';\n" +
                        "                  mes[8] = 'Ago';\n" + "                  mes[9] = 'Sep';\n" +
                        "                  mes[10] = 'Oct';\n" + "                  mes[11] = 'Nov';\n" +
                        "                  document.write(dia[d.getDay()], ' ' +mes[d.getMonth()], ' ' +d.getHours(), ':' +d.getMinutes(), ':' +d.getSeconds(), ' GMT ' +d.getFullYear());\n" +
                        "                </script>" + "<br/>");
            if (sesion.isNew()) {
                out.println("Ultima tabla consultada: " + " " + "<br/>");
            } else {
                out.println("Ultima tabla consultada: " + cookie[1].getValue() + "<br/>");
            }
            out.println("</div>");
            out.println("<br/>");
            out.println("<a href='consulta.html'>Otra consulta</a>");
            out.println("<a href='registro.html'>Desconexion</a>");
            out.println("<br/>");
            out.println("<table>");
            try {
                rs = conexion.consultar(tabla);
            } catch (SQLException e) {
            }
            try {
                while (rs.next()) {
                    out.println("<tr>");
                    for (int i = 1; i <= numColumnasEmpleado; i++) {
                        out.println("<td>" + rs.getObject(i) + "</td>");
                    }
                    out.println("</tr>");
                }
            } catch (SQLException e) {
            }
            out.println("</table>");
        } else {
            sesion.invalidate();
            out.println("<h2>Nombre de base de datos incorrecta</h2>");
            out.println("<a href='consulta.html'>Volver a consulta</a>");
        }*/

        //Solucion con el ResultSetMetaData, poder consultar cualquier tabla

        out.println("<div style='border:solid;border-color:black;text-align:center;color:white;background-color:red;'>");
        out.println("Resultados de la consulta realizada por " + cookie[0].getValue() + "<br/>");
        out.println("Tabla: " + tabla + "<br/>");
        out.println("Numero de accesos: " + conection + "<br/>");
        out.println("Fecha de ultimo acceso: " + "<script type=\"text/javascript\">\n" +
                    "                  var d = new Date();\n" + "var dia = new Array(7);\n" +
                    "var mes = new Array(11);\n" + "                  dia[0] = 'Dom';\n" +
                    "                  dia[1] = 'Lun';\n" + "                  dia[2] = 'Mar';\n" +
                    "                  dia[3] = 'Mie';\n" + "                  dia[4] = 'Jue';\n" +
                    "                  dia[5] = 'Vie';\n" + "                  dia[6] = 'Sab';\n " +
                    "                  mes[0] = 'Dic';\n" + "                  mes[1] = 'Ene';\n" +
                    "                  mes[2] = 'Feb';\n" + "                  mes[3] = 'Mar';\n" +
                    "                  mes[4] = 'Abr';\n" + "                  mes[5] = 'May';\n" +
                    "                  mes[6] = 'Jun';\n" + "                  mes[7] = 'Jul';\n" +
                    "                  mes[8] = 'Ago';\n" + "                  mes[9] = 'Sep';\n" +
                    "                  mes[10] = 'Oct';\n" + "                  mes[11] = 'Nov';\n" +
                    "                  document.write(dia[d.getDay()], ' ' +mes[d.getMonth()], ' ' +d.getHours(), ':' +d.getMinutes(), ':' +d.getSeconds(), ' GMT ' +d.getFullYear());\n" +
                    "                </script>" + "<br/>");
        if (sesion.isNew()) {
            out.println("Ultima tabla consultada: " + " " + "<br/>");
        } else {
            out.println("Ultima tabla consultada: " + cookie[1].getValue() + "<br/>");
        }
        out.println("</div>");
        out.println("<br/>");
        out.println("<a href='consulta.html'>Otra consulta</a>");
        out.println("<a href='registro.html'>Desconexion</a>");
        out.println("<br/>");
        out.println("<table border>");
        try {

            rs = conexion.consultar(tabla);
        } catch (SQLException e) {
        }
        try {
            ResultSetMetaData rsmt = rs.getMetaData();

            int cols = rsmt.getColumnCount();
            for (int i = 1; i < cols; i++) {
                out.println("<th>" + rsmt.getColumnName(i) + "</th>");
            }
            while (rs.next()) {
                out.println("<tr>");
                for (int i = 1; i < cols; i++) {
                    out.println("<td>" + rs.getObject(i) + "</td>");
                }
                out.println("</tr>");
            }
        } catch (SQLException e) {
        }

        out.println("</table>");

        out.println("</body></html>");
        out.close();
    }
}
