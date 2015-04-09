package view;

import evaluacion.Dmjlogin;
import evaluacion.LoginFacade;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "Consulta", urlPatterns = { "/consulta" })
public class Consulta extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    private LoginFacade myBean;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario, contraseña;

        usuario = request.getParameter("user");
        contraseña = request.getParameter("pass");

        Dmjlogin dmjlogin = myBean.getDmjloginfindByName(usuario);
        if (dmjlogin.getContraseña().equals(contraseña)) {
            response.sendRedirect("welcome.jsp");
        } else {
            response.sendRedirect("exit.jsp");
        }

    }
}
