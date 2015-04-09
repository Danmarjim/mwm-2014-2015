package entitybeanproject;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "SessionEJB", mappedName = "EJB-EntityBeanProject-SessionEJB")
@Local
public class EmpleadoFacade implements IEmpleadoFacadeRemote {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "EntityBeanProject")
    private EntityManager em;

    public EmpleadoFacade() {
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Object queryByRange(String jpqlStmt, int firstResult, int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }
        return query.getResultList();
    }

    public <T> T persistEntity(T entity) {
        em.persist(entity);
        return entity;
    }

    public <T> T mergeEntity(T entity) {
        return em.merge(entity);
    }

    public Dcmempleado persistDcmempleado(Dcmempleado dcmempleado) {
        em.persist(dcmempleado);
        return dcmempleado;
    }

    public Dcmempleado mergeDcmempleado(Dcmempleado dcmempleado) {
        return em.merge(dcmempleado);
    }

    public void removeDcmempleado(Dcmempleado dcmempleado) {
        dcmempleado = em.find(Dcmempleado.class, dcmempleado.getEmpId());
        em.remove(dcmempleado);
    }

    /** <code>select o from Dcmempleado o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Dcmempleado> getDcmempleadoFindAll() {
        return em.createNamedQuery("Dcmempleado.findAll", Dcmempleado.class).getResultList();
    }
    /** <code>select o from Dcmempleado o where o.name like :name</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Dcmempleado> getDcempleadoFindByName(String name) {
        Query query = em.createNamedQuery("Dcmepleado.findByName", Dcmempleado.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
}
