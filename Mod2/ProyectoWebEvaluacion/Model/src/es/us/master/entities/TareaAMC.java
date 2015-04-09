package es.us.master.entities;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

/**
 * To create ID generator sequence "TAREAAMC_ID_SEQ_GEN":
 * CREATE SEQUENCE "TAREAAMC_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({
              @NamedQuery(name = "TareaAMC.findAll", query = "select o from TareaAMC o"),
              @NamedQuery(name = "TareaAMC.findOwn", query = "select o from TareaAMC o where o.usuario=:u")
    })
@SequenceGenerator(name = "TareaAMC_Id_Seq_Gen", sequenceName = "TAREAAMC_ID_SEQ_GEN", allocationSize = 50,
                   initialValue = 50)
public class TareaAMC implements Serializable {
    private static final long serialVersionUID = 5653062334105723614L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TareaAMC_Id_Seq_Gen")
    private Integer id;
    @Version
    private Integer version;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String estado = "activo";
    private String descripcion;
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaInicio;
    @ManyToOne
    private UsuarioAMC usuario;
    @Transient
    private boolean editable = false;

    public TareaAMC() {
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setUsuario(UsuarioAMC usuario) {
        this.usuario = usuario;
    }

    public UsuarioAMC getUsuario() {
        return usuario;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean isEditable() {
        return editable;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof TareaAMC)) {
            return false;
        }
        final TareaAMC other = (TareaAMC) object;
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
