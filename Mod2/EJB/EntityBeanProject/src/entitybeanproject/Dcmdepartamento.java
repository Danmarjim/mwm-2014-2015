package entitybeanproject;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ @NamedQuery(name = "Dcmdepartamento.findAll", query = "select o from Dcmdepartamento o") })
public class Dcmdepartamento implements Serializable {
    private static final long serialVersionUID = 2536872968482842272L;
    @Id
    @Column(name = "DEP_ID", nullable = false)
    private Long depId;
    @Column(nullable = false)
    private String nombredep;
    @OneToMany(mappedBy = "dcmdepartamento", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Dcmempleado> dcmempleadoList;

    public Dcmdepartamento() {
    }

    public Dcmdepartamento(Long depId, String nombredep) {
        this.depId = depId;
        this.nombredep = nombredep;
    }

    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }

    public String getNombredep() {
        return nombredep;
    }

    public void setNombredep(String nombredep) {
        this.nombredep = nombredep;
    }

    public List<Dcmempleado> getDcmempleadoList() {
        return dcmempleadoList;
    }

    public void setDcmempleadoList(List<Dcmempleado> dcmempleadoList) {
        this.dcmempleadoList = dcmempleadoList;
    }

    public Dcmempleado addDcmempleado(Dcmempleado dcmempleado) {
        getDcmempleadoList().add(dcmempleado);
        dcmempleado.setDcmdepartamento(this);
        return dcmempleado;
    }

    public Dcmempleado removeDcmempleado(Dcmempleado dcmempleado) {
        getDcmempleadoList().remove(dcmempleado);
        dcmempleado.setDcmdepartamento(null);
        return dcmempleado;
    }
}
