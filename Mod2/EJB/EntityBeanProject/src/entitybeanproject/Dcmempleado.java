package entitybeanproject;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
              @NamedQuery(name = "Dcmempleado.findAll", query = "select o from Dcmempleado o"),
              @NamedQuery(name = "Dcempleado.findByName", query = "select o from Dcmempleado o where o.name like :name")
    })
public class Dcmempleado implements Serializable {
    private static final long serialVersionUID = 4036663890719244828L;
    @Column(nullable = false)
    private String apellido;
    @Id
    @Column(name = "EMP_ID", nullable = false)
    private Long empId;
    @Temporal(TemporalType.DATE)
    private Date fechaalta;
    @Column(nullable = false)
    private String nombre;
    private BigDecimal salario;
    @Column(name = "SEGURO_ID")
    private Long seguroId;
    private Long version;
    @ManyToOne
    @JoinColumn(name = "TRABAJADOR_DEP_ID")
    private Dcmdepartamento dcmdepartamento;

    public Dcmempleado() {
    }

    public Dcmempleado(String apellido, Long empId, Date fechaalta, String nombre, BigDecimal salario, Long seguroId,
                       Dcmdepartamento dcmdepartamento, Long version) {
        this.apellido = apellido;
        this.empId = empId;
        this.fechaalta = fechaalta;
        this.nombre = nombre;
        this.salario = salario;
        this.seguroId = seguroId;
        this.dcmdepartamento = dcmdepartamento;
        this.version = version;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public Date getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(Date fechaalta) {
        this.fechaalta = fechaalta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Long getSeguroId() {
        return seguroId;
    }

    public void setSeguroId(Long seguroId) {
        this.seguroId = seguroId;
    }


    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Dcmdepartamento getDcmdepartamento() {
        return dcmdepartamento;
    }

    public void setDcmdepartamento(Dcmdepartamento dcmdepartamento) {
        this.dcmdepartamento = dcmdepartamento;
    }
}
