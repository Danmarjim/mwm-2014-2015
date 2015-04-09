package entity;

import java.io.Serializable;

import java.util.Date;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@NamedQueries({
    @NamedQuery(name="DMJEmpleado.findAll",
                query="SELECT o FROM DMJEmpleado o"),
    @NamedQuery(name="DMJEmpleado.findAllOrderBySalary",
                query="SELECT o FROM DMJEmpleado o ORDER BY o.salario"),
    @NamedQuery(name="DMJEmpleado.findEmplByName",
                query="SELECT o FROM DMJEmpleado o WHERE o.nombre LIKE :nombre")
})
public class DMJEmpleado implements Serializable {
    private static final long serialVersionUID = 4232710516368655922L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="EMP_ID")
    private Integer id;
    @Version
    private Integer version;
    @Column(name="apellido", nullable = false, length = 50)
    private String apellido;
    @Column(name="nombre", nullable = false, length = 50)
    private String nombre;
    @Column(name="fechaalta", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaalta;
    @Column(name="salario", nullable = true)
    private Long salario;
    @OneToMany(mappedBy = "empleado", cascade=CascadeType.ALL)
    private Set<DMJNumeroTelefono> setTelefonos;
    @Transient
    private String sexo;
    @OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="id_seguro")
    private DMJSeguroSanitario seguroSanitario;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
    name="DMJEMP_PROY",
        joinColumns={
            @JoinColumn(name="EMP_ID", referencedColumnName="EMP_ID")},
            inverseJoinColumns={
                @JoinColumn(name="PROY_ID", referencedColumnName="PROY_ID")})
    private Set<DMJProyecto> setProyectos;
    @ManyToOne (fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name="departamento_id")
    private DMJDepartamento departamento;

    public void setDepartamento(DMJDepartamento departamento) {
        this.departamento = departamento;
    }

    public DMJDepartamento getDepartamento() {
        return departamento;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSeguroSanitario(DMJSeguroSanitario seguroSanitario) {
        this.seguroSanitario = seguroSanitario;
    }

    public DMJSeguroSanitario getSeguroSanitario() {
        return seguroSanitario;
    }

    public void setSetProyectos(Set<DMJProyecto> setProyectos) {
        this.setProyectos = setProyectos;
    }

    public Set<DMJProyecto> getSetProyectos() {
        return setProyectos;
    }
        
    public void addTelef(DMJNumeroTelefono telef) {
        this.setTelefonos.add(telef);
        if (telef.getEmpleado() != this) {
            telef.setEmpleado(this);
        }
    }
        
    public void addProyecto(DMJProyecto proy) {
        this.getSetProyectos().add(proy);
        if (!proy.getSetEmpleados().contains(this)) {
            proy.getSetEmpleados().add(this);
        }
    }

    public void setSetTelefonos(Set<DMJNumeroTelefono> setTelefono) {
        this.setTelefonos = setTelefono;
    }

    public Set<DMJNumeroTelefono> getSetTelefonos() {
        return setTelefonos;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setFechaalta(Date fechaalta) {
        this.fechaalta = fechaalta;
    }

    public Date getFechaalta() {
        return fechaalta;
    }

    public void setSalario(Long salario) {
        this.salario = salario;
    }

    public Long getSalario() {
        return salario;
    }
       
    public DMJEmpleado() {
        this.setTelefonos = new HashSet();
        this.setProyectos = new HashSet(); 
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
}
