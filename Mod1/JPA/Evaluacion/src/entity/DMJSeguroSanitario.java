package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
@NamedQueries({ @NamedQuery(name = "DMJSeguroSanitario.findAll", query = "select o from DMJSeguroSanitario o") })
public class DMJSeguroSanitario implements Serializable {
    private static final long serialVersionUID = -6985502318053231573L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Version
    private Integer version;
    @Column(name="nombre", length = 150)
    private String nombre;
    @OneToOne(fetch=FetchType.LAZY, mappedBy="seguroSanitario")
    private DMJEmpleado empleado;

    public void setEmpleado(DMJEmpleado empleado) {
        this.empleado = empleado;
    }

    public DMJEmpleado getEmpleado() {
        return empleado;
    }

    public void setAseguradora(String aseguradora) {
        this.nombre = aseguradora;
    }

    public String getAseguradora() {
        return nombre;
    }

    public DMJSeguroSanitario() {
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
