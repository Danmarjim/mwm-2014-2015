package view;


import java.util.Locale;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "beanIdioma")
@SessionScoped
public class BeanIdioma {

    private Locale miLocale;

    public BeanIdioma() {
        this.miLocale = new Locale("es");
    }

    public Locale getLocale() {
        return miLocale;
    }

    public void cambiarLocale(ActionEvent e) {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String action = params.get("idioma");
        miLocale = new Locale(action);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(miLocale);

    }

    public void setLocale(Locale miLocale) {
        this.miLocale = miLocale;
    }
}
