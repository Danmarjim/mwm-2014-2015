package entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

public class Startup {
    public static void main(String[] args){
        Startup startup = new Startup();
        startup.createData();
        List<DMJEmpleado> empleados = startup.findAll();
        for(DMJEmpleado e:empleados){
            System.out.println(e);
        }
        startup.cerrarConexiones();
    }
    
    @PersistenceUnit
    EntityManagerFactory emf;
    EntityManager em;
    
    public Startup(){
        super();
        emf = Persistence.createEntityManagerFactory("Empleado");
        em = emf.createEntityManager();
    }
    
    private List<DMJEmpleado> findAll(){
        Query q = em.createNamedQuery("DMJEmpleado.findAll");
        return q.getResultList();
    }
    
    private void createData(){
        em.getTransaction().begin();
        DMJEmpleado e = new DMJEmpleado();
        e.setId(1);
        em.persist(e);
        em.getTransaction().commit();
    }
    
    private void cerrarConexiones(){
        em.close();
        emf.close();
    }
}
