package entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.Version;

@Entity
@NamedQueries({ @NamedQuery(name = "DMJEmpleado.findAll", query = "select o from DMJEmpleado o") })
public class DMJEmpleado implements Serializable {
    private static final long serialVersionUID = 4232710516368655922L;
    @Id
    private Integer id;
    @Version
    private Integer version;
    @Column(name="apellido", nullable = false, length = 50)
    private String apellidos;
    @Column(name="nombre", nullable = false, length = 50)
    private String nombre;
    //@Transient
    @Column(name="fechaalta", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaAlta;
    @Column(name="salario", nullable = true)
    private Long salario;

    public DMJEmpleado() {
    }
    
    public String getApellidos(){
        return apellidos;
    }
    
    public void setApellidos(String apellidos){
        this.apellidos=apellidos;
    }
    
    public String nombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public Date getFechaAlta(){
        return fechaAlta;
    }
    
    public void setFechaAlta(Date fechaAlta){
        this.fechaAlta=fechaAlta;
    }
    
    public Long getSalario(){
        return salario;
    }
    
    public void setSalario(Long salario){
        this.salario=salario;
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
