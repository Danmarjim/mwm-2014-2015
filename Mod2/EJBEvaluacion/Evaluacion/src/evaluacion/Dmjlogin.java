package evaluacion;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
              @NamedQuery(name = "Dmjlogin.findAll", query = "select o from Dmjlogin o"),
              @NamedQuery(name = "Dmjlogin.findByName", query = "select o from Dmjlogin o where o.usuario LIKE :name ")
    })
public class Dmjlogin implements Serializable {
    private static final long serialVersionUID = -7599437117076683704L;
    @Column(nullable = false, length = 20)
    private String contraseña;
    @Id
    @Column(nullable = false, length = 20)
    private String usuario;

    public Dmjlogin() {
    }

    public Dmjlogin(String contraseña, String usuario) {
        this.contraseña = contraseña;
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
