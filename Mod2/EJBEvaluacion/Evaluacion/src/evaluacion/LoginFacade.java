package evaluacion;

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

@Stateless(name = "SessionEJB", mappedName = "EJBEvaluacion-Evaluacion-SessionEJB")
@Local
public class LoginFacade implements ILoginFacade {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Evaluacion")
    private EntityManager em;

    public LoginFacade() {
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

    public Dmjlogin persistDmjlogin(Dmjlogin dmjlogin) {
        em.persist(dmjlogin);
        return dmjlogin;
    }

    public Dmjlogin mergeDmjlogin(Dmjlogin dmjlogin) {
        return em.merge(dmjlogin);
    }

    public void removeDmjlogin(Dmjlogin dmjlogin) {
        dmjlogin = em.find(Dmjlogin.class, dmjlogin.getUsuario());
        em.remove(dmjlogin);
    }

    /** <code>select o from Dmjlogin o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Dmjlogin> getDmjloginFindAll() {
        return em.createNamedQuery("Dmjlogin.findAll", Dmjlogin.class).getResultList();
    }

    @Override
    public Dmjlogin getDmjloginfindByName(String name) {
        Query query = em.createNamedQuery("Dmjlogin.findByName", Dmjlogin.class);
        query.setParameter("name", name);
        return (Dmjlogin) query.getSingleResult();
    }
}
