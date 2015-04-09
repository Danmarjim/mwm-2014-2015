package es.us.master.beans;

import es.us.master.entities.TareaAMC;
import es.us.master.entities.UsuarioAMC;

import java.io.IOException;

import java.text.MessageFormat;

import java.util.Date;
import java.util.List;

import java.util.ResourceBundle;

import javax.annotation.PostConstruct;

import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class EditBean {

    private FacesContext context;
    private String nombre;
    private String apellidos;
    private String username;
    private String estado;
    private String email;
    private String password;
    private String repassword;
    private static final String FICHERO_ERRORES = "i18n.errores";

    @EJB
    private UsuarioBeanLocal usuarioBean;
    private UsuarioAMC usuario;


    public EditBean() {
        context = FacesContext.getCurrentInstance();
        usuario = (UsuarioAMC) context.getExternalContext().getSessionMap().get("usuario");

    }

    @PostConstruct
    public void initIt() {
        if (usuario == null) {


            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            try {
                context.redirect(context.getRequestContextPath() + "/faces/index.jsf");
            } catch (IOException e) {
            }
        } else {
            nombre = usuario.getNombre();
            apellidos = usuario.getApellidos();
            estado = String.valueOf(usuario.getEstado());
            email = usuario.getEmail();
            username = usuario.getUsername();

        }

    }

    public String edit() {
        if (!password.isEmpty() || !repassword.isEmpty()) {
            if (!password.equals(repassword)) {


                ResourceBundle rb = ResourceBundle.getBundle(FICHERO_ERRORES);


                context.addMessage(null,
                                   new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                    MessageFormat.format(rb.getString("error.contrasenas.no.coinciden"),
                                                                         null), ""));

            } else {
                usuario.setNombre(nombre);
                usuario.setApellidos(apellidos);
                usuario.setEmail(email);
                usuario.setPassword(password);
                if (Integer.valueOf(estado).equals(1)) {
                    usuario.setEstado(1);
                } else if (Integer.valueOf(estado).equals(0)) {
                    usuario.setEstado(0);
                }
                usuarioBean.mergeUsuarioAMC(usuario);
            }
        } else {
            usuario.setNombre(nombre);
            usuario.setApellidos(apellidos);
            usuario.setEmail(email);
            if (Integer.valueOf(estado).equals(1)) {
                usuario.setEstado(1);
            } else if (Integer.valueOf(estado).equals(0)) {
                usuario.setEstado(0);
            }
            usuarioBean.mergeUsuarioAMC(usuario);
        }
        return "";

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getApellidos() {
        return apellidos;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getRepassword() {
        return repassword;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }


}
