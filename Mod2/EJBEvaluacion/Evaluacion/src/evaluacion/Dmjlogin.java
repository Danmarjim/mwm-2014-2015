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
    private String contrase�a;
    @Id
    @Column(nullable = false, length = 20)
    private String usuario;

    public Dmjlogin() {
    }

    public Dmjlogin(String contrase�a, String usuario) {
        this.contrase�a = contrase�a;
        this.usuario = usuario;
    }

    public String getContrase�a() {
        return contrase�a;
    }

    public void setContrase�a(String contrase�a) {
        this.contrase�a = contrase�a;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
