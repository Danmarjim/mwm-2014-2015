package entity;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
@NamedQueries({ @NamedQuery(name = "DMJDepartamento.findAll", query = "select o from DMJDepartamento o") })
public class DMJDepartamento implements Serializable {
    private static final long serialVersionUID = 2704728180813347236L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="DEP_ID")
    private Integer id;
    @Version
    private Integer version;
    @Column(name="nombre",length = 50)
    private String nombre;
    @OneToMany(mappedBy = "departamento", cascade=CascadeType.ALL)
    private Set<DMJEmpleado> setEmpleados;
    @JoinTable(
    name="DMJDEP_PROY",
        joinColumns={
            @JoinColumn(name="DEP_ID", referencedColumnName="DEP_ID")},
            inverseJoinColumns={
                @JoinColumn(name="PROY_ID", referencedColumnName="PROY_ID")})
    private Set<DMJProyecto> setProyectos;

    public void addProyecto(DMJProyecto proy) {
        this.setProyectos.add(proy);
        if (!proy.getSetDepartamentos().contains(this)) {
            proy.getSetDepartamentos().add(this);
        }
    }

    public void setSetProyectos(Set<DMJProyecto> setProyectos) {
        this.setProyectos = setProyectos;
    }

    public Set<DMJProyecto> getSetProyectos() {
        return setProyectos;
    }

    public DMJDepartamento() {
        setEmpleados = new HashSet();
        setProyectos= new HashSet();
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setSetEmpleados(Set<DMJEmpleado> setEmpleados) {
        this.setEmpleados = setEmpleados;
    }

    public Set<DMJEmpleado> getSetEmpleados() {
        return setEmpleados;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
        
    public void addEmpleado(DMJEmpleado empleado) {
        this.setEmpleados.add(empleado);
        if (empleado.getDepartamento() != this) {
            empleado.setDepartamento(this);
        }
    }
}
