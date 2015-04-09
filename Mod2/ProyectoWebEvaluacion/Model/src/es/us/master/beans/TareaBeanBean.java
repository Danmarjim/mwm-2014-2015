package es.us.master.beans;

import es.us.master.entities.TareaAMC;

import es.us.master.entities.UsuarioAMC;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "TareaBean", mappedName = "ProyectoWebEvaluacion-Model-TareaBean")
public class TareaBeanBean implements TareaBeanLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "ProyectoWebPersistencia")
    private EntityManager em;

    public TareaBeanBean() {
    }


    public TareaAMC persistTareaAMC(TareaAMC tareaAMC) {
        em.persist(tareaAMC);
        return tareaAMC;
    }

    public TareaAMC mergeTareaAMC(TareaAMC tareaAMC) {
        TareaAMC tarea = em.find(TareaAMC.class, tareaAMC.getId());
        if (tarea != null) {
            tareaAMC.setVersion(tarea.getVersion());
        }
        return em.merge(tareaAMC);

    }

    public void removeTareaAMC(TareaAMC tareaAMC) {
        tareaAMC = em.find(TareaAMC.class, tareaAMC.getId());
        em.remove(tareaAMC);
    }

    /** <code>select o from TareaAMC o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<TareaAMC> getTareaAMCFindAll() {
        return em.createNamedQuery("TareaAMC.findAll", TareaAMC.class).getResultList();
    }

    @Override
    public List<TareaAMC> getTareaFindOwn(UsuarioAMC usuario) {
        Query query = em.createNamedQuery("TareaAMC.findOwn", TareaAMC.class);
        query.setParameter("u", usuario);

        return query.getResultList();
    }


}
