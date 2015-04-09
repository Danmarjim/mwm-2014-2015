package es.us.master.beans;

import es.us.master.entities.UsuarioAMC;

import java.text.MessageFormat;

import java.util.Iterator;

import java.util.Locale;

import java.util.ResourceBundle;

import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class LoginBean {
    private FacesContext context;
    private static final String FICHERO_ERRORES = "i18n.errores";
    @EJB
    private UsuarioBeanLocal usuarioBean;
    private UsuarioAMC usuario;

    public LoginBean() {
        usuario = new UsuarioAMC();
        context = FacesContext.getCurrentInstance();
        Iterator<String> destroybeanIterator =
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().keySet().iterator();
        while (destroybeanIterator.hasNext()) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(destroybeanIterator.next());
        }
    }

    public UsuarioAMC getUsuario() {
        return usuario;
    }

    public String login() {
        String res = "OK";

        UsuarioAMC u = usuarioBean.getUsuarioUsernamePassword(usuario.getUsername(), usuario.getPassword());

        if (u == null) {


            ResourceBundle rb = ResourceBundle.getBundle(FICHERO_ERRORES);


            context.addMessage(null,
                               new FacesMessage(FacesMessage.SEVERITY_INFO, "Error",
                                                MessageFormat.format(rb.getString("error.autentificacion"), null)));

            res = "ERROR";
        } else {
            context.getExternalContext().getSessionMap().put("usuario", u);
        }

        return res;
    }
}
