package entity;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Version;

@Entity
@NamedQueries({ @NamedQuery(name = "DMJProyecto.findAll", query = "select o from DMJProyecto o") })
public class DMJProyecto implements Serializable {
    private static final long serialVersionUID = -6285825838918558908L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="PROY_ID")
    private Integer id;
    @Version
    private Integer version;
    @Column(name="nombre", length = 150)
    private String nombre;
    @ManyToMany(mappedBy = "setProyectos")
    private Set<DMJEmpleado> setEmpleados;
    @ManyToMany(mappedBy = "setProyectos")
    private Set<DMJDepartamento> setDepartamentos;

    public void setSetDepartamentos(Set<DMJDepartamento> setDepartamentos) {
        this.setDepartamentos = setDepartamentos;
    }

    public Set<DMJDepartamento> getSetDepartamentos() {
        return setDepartamentos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSetEmpleados(Set<DMJEmpleado> setEmpleados) {
        this.setEmpleados = setEmpleados;
    }

    public Set<DMJEmpleado> getSetEmpleados() {
        return setEmpleados;
    }

    public String getNombre() {
        return nombre;
    }

    public DMJProyecto() {
        this.setEmpleados = new HashSet();
        this.setDepartamentos = new HashSet();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
    
    public void addEmpleado(DMJEmpleado emple) {
        this.getSetEmpleados().add(emple);
        if (!emple.getSetProyectos().contains(this)) {
                emple.getSetProyectos().add(this);
        }
    }
    
    public void addDepartamento(DMJDepartamento depart) {
        this.setDepartamentos.add(depart);
        if (!depart.getSetProyectos().contains(this)) {
            depart.getSetProyectos().add(this);
        }
    }
}
