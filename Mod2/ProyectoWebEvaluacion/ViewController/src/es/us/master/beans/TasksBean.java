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
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class TasksBean {
    private FacesContext context;
    private String titulo;
    private String descripcion;
    private String estado;
    private Date fechaInicio;
    private Date fechaFin;

    @EJB
    private TareaBeanLocal tareaBean;
    private UsuarioAMC usuario;
    private List<TareaAMC> tareas;
    private static final String FICHERO_ERRORES = "i18n.errores";
    private static final String FICHERO_MENSAJES = "i18n.mensajes";

    public TasksBean() {
        context = FacesContext.getCurrentInstance();
        usuario = (UsuarioAMC) context.getExternalContext().getSessionMap().get("usuario");


    }

    @PostConstruct
    public void initIt() {
        if (usuario != null) {
            setTareas(tareaBean.getTareaFindOwn(usuario));
        } else {
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            try {
                context.redirect(context.getRequestContextPath() + "/faces/index.jsf");
            } catch (IOException e) {
                return ;
            }
        }


    }


    public void setTareas(List<TareaAMC> tareas) {
        this.tareas = tareas;
    }

    public List<TareaAMC> getTareas() {
        return tareas;
    }

    public String logout() {
        context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();
        ResourceBundle rb = ResourceBundle.getBundle(FICHERO_MENSAJES);
        context.addMessage(null,
                           new FacesMessage(FacesMessage.SEVERITY_INFO,
                                            MessageFormat.format(rb.getString("desconectado"), null), ""));


        return "EXIT";
    }


    public void nuevaTarea() {
        TareaAMC tarea = new TareaAMC();
        tarea.setDescripcion(descripcion);
        tarea.setEstado(estado);
        tarea.setFechaInicio(fechaInicio);
        tarea.setFechaFin(fechaFin);
        tarea.setTitulo(titulo);
        tarea.setUsuario(usuario);
        tareaBean.persistTareaAMC(tarea);
        setDescripcion("");
        setTitulo("");
        setEstado("");
        setFechaFin(null);
        setFechaInicio(null);
        setTareas(tareaBean.getTareaFindOwn(usuario));
        this.initIt();
        context = FacesContext.getCurrentInstance();
        ResourceBundle rb = ResourceBundle.getBundle(FICHERO_MENSAJES);
        context.addMessage(null,
                           new FacesMessage(FacesMessage.SEVERITY_INFO,
                                            MessageFormat.format(rb.getString("tarea.anadida.correctamente"), null),
                                            ""));


    }

    public void editAction(TareaAMC tarea) {
        tareas.get(tareas.indexOf(tarea)).setEditable(true);
    }

    public void save(TareaAMC tarea) {
        tareas.get(tareas.indexOf(tarea)).setEditable(false);
        tareaBean.mergeTareaAMC(tarea);
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }
}
