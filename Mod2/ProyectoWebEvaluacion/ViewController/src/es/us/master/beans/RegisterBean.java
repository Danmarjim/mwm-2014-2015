package es.us.master.beans;

import es.us.master.entities.UsuarioAMC;

import java.text.MessageFormat;

import java.util.ResourceBundle;

import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class RegisterBean {
    private FacesContext context;

    @EJB
    private UsuarioBeanLocal usuarioBean;
    private UsuarioAMC usuario;
    private String repassword;
    private static final String FICHERO_ERRORES = "i18n.errores";

    public RegisterBean() {


        usuario = new UsuarioAMC();


        context = FacesContext.getCurrentInstance();
    }


    public UsuarioAMC getUsuario() {
        return usuario;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String register() {
        String res = validate();

        if (!res.equals("ERROR")) {
            UsuarioAMC u = usuarioBean.persistUsuarioAMC(usuario);
            ResourceBundle rb = ResourceBundle.getBundle(FICHERO_ERRORES);
            if (u == null) {


                context.addMessage(null,
                                   new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                    MessageFormat.format(rb.getString("error.no.usuario.creado"), null),
                                                    ""));


                res = "ERROR";
            } else {


                context.addMessage(null,
                                   new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                    MessageFormat.format(rb.getString("error.usuario.creado"), null),
                                                    ""));

            }
        }

        return res;
    }

    private String validate() {
        String res = "OK";

        if (!usuario.getPassword().equals(repassword)) {
            ResourceBundle rb = ResourceBundle.getBundle(FICHERO_ERRORES);
            context.addMessage(null,
                               new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                MessageFormat.format(rb.getString("error.contrasenas.no.coinciden"),
                                                                     null), ""));

            res = "ERROR";
        }

        return res;
    }


}
