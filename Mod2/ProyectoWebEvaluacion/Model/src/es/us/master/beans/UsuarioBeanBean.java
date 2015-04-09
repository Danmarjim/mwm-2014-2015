package es.us.master.beans;

import es.us.master.entities.UsuarioAMC;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "UsuarioBean", mappedName = "ProyectoWebEvaluacion-Model-UsuarioBean")
public class UsuarioBeanBean implements UsuarioBeanLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "ProyectoWebPersistencia")
    private EntityManager em;

    public UsuarioBeanBean() {
    }

    public UsuarioAMC persistUsuarioAMC(UsuarioAMC usuarioAMC) {
        em.persist(usuarioAMC);
        return usuarioAMC;
    }

    public UsuarioAMC mergeUsuarioAMC(UsuarioAMC usuarioAMC) {
        return em.merge(usuarioAMC);
    }

    public void removeUsuarioAMC(UsuarioAMC usuarioAMC) {
        usuarioAMC = em.find(UsuarioAMC.class, usuarioAMC.getId());
        em.remove(usuarioAMC);
    }

    /** <code>select o from UsuarioAMC o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<UsuarioAMC> getUsuarioAMCFindAll() {
        return em.createNamedQuery("UsuarioAMC.findAll", UsuarioAMC.class).getResultList();
    }

    @Override
    public UsuarioAMC getUsuarioUsernamePassword(String username, String password) {
        UsuarioAMC res = null;
        try {

            Query query = em.createNamedQuery("UsuarioAMC.findByUsernamePassword", UsuarioAMC.class);
            query.setParameter("u", username);
            query.setParameter("p", password);

            res = (UsuarioAMC) query.getSingleResult();

            return res;
        } catch (NoResultException e) {
            return null;
        }

    }

}
