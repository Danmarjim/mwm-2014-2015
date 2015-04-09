package es.us.master.entities;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

/**
 * To create ID generator sequence "USUARIOAMC_ID_SEQ_GEN":
 * CREATE SEQUENCE "USUARIOAMC_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({
              @NamedQuery(name = "UsuarioAMC.findAll", query = "select o from UsuarioAMC o"),
              @NamedQuery(name = "UsuarioAMC.findByUsernamePassword",
                          query = "select o from UsuarioAMC o where o.username=:u and o.password=:p")
    })
@SequenceGenerator(name = "UsuarioAMC_Id_Seq_Gen", sequenceName = "USUARIOAMC_ID_SEQ_GEN", allocationSize = 50,
                   initialValue = 50)
public class UsuarioAMC implements Serializable {
    private static final long serialVersionUID = 3301094452324507533L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UsuarioAMC_Id_Seq_Gen")
    private Integer id;
    @Version
    private Integer version;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private int estado = 1;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String apellidos;
    @Column(nullable = false)
    private String password;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<TareaAMC> tareas;

    public UsuarioAMC() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setTareas(List<TareaAMC> tareas) {
        this.tareas = tareas;
    }

    public List<TareaAMC> getTareas() {
        return tareas;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof UsuarioAMC)) {
            return false;
        }
        final UsuarioAMC other = (UsuarioAMC) object;
        if (!(id == null ? other.id == null : id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 37;
        int result = 1;
        result = PRIME * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}
