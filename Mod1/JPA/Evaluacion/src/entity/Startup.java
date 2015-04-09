package entity;

import java.text.ParseException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

public class Startup {
    
    @PersistenceUnit
    EntityManagerFactory emf;
    EntityManager em;
    
    public static void main(String[] args) throws ParseException{
        List<DMJEmpleado> query1, query2;
        List<DMJDepartamento> query4;
        Startup startup = new Startup();
                
        System.out.println("Creando Tablas y Cargado Datos...");
        startup.createData();
        System.out.println(">> Query 1: findAllOrderBySalary \n \n");
        query1 = startup.findAllOrderBySalary();
        startup.printEmpleados(query1);
        System.out.println(">> Query 2:findEmplByName: Daniel \n \n");
        query2 = startup.findEmplByName("Daniel") ;
        startup.printEmpleados(query2);
        System.out.println(">> Query 3: Native Query \n \n");
        query4 = startup.nativeQuery();
        startup.printDepartamentos(query4);
                
        startup.cerrarConexiones();
    }
    
    public Startup() {
            super();
            emf = Persistence.createEntityManagerFactory("Empleado");
            em = emf.createEntityManager();
        }

        private void createData() throws ParseException {
            DMJEmpleado e1, e2, e3;
            DMJNumeroTelefono n1a, n1b, n2;
            DMJSeguroSanitario s1, s2;
            DMJProyecto p1, p2, p3;
            DMJDepartamento d1, d2;
            Date date1, date2, date3;
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            em.getTransaction().begin();
            
            /***********************DEPARTAMENTOS*************************/
            d1 = new DMJDepartamento();
            d1.setNombre("Matematicas");
            d2 = new DMJDepartamento();
            d2.setNombre("Literatura");
            /***********************PROYECTOS*****************************/
            p1 = new DMJProyecto();
            p1.setNombre("Portal Web Junta de Andalucia");
            p2 = new DMJProyecto();
            p2.setNombre("SCADA - Cuenca Guadalquivir");
            p3 = new DMJProyecto();
            p3.setNombre("Sistemas Planta Solucar");
            /***********************SEGUROS*****************************/
            s1 =  new DMJSeguroSanitario();
            s1.setAseguradora("CatalanaOccidente");
            s2 =  new DMJSeguroSanitario();
            s2.setAseguradora("Mapfre");
            /***********************TELEFONOS*****************************/
            n1a = new DMJNumeroTelefono();
            n1a.setPrefijoInternacional("+34");
            n1a.setNumeroLocal("636899504");
            n1b = new DMJNumeroTelefono();
            n1b.setPrefijoInternacional("+35");
            n1b.setNumeroLocal("6360000000");
            n2 = new DMJNumeroTelefono();
            n2.setPrefijoInternacional("+38");
            n2.setNumeroLocal("636884554");
            /***********************EMPLEADO *****************************/
            /**Datos Empleados 1**/
            e1 = new DMJEmpleado();
            e1.setApellido("Rodriguez");
            e1.setNombre("Carlos");
            date1 = formatter.parse("2014-10-05");
            e1.setFechaalta(date1);
            e1.setSalario((long)15000);
            /**Relaciones Empleados 1**/
            e1.setSeguroSanitario(s1);
            e1.addTelef(n1a);
            e1.addTelef(n1b);
            e1.addProyecto(p2);
            /**Datos Empleados 2**/
            e2 = new DMJEmpleado();
            e2.setApellido("Ureña");
            e2.setNombre("Macarena");
            date2 = formatter.parse("2014-11-05");
            e2.setFechaalta(date2);
            e2.setSalario((long)25000000);
            /**Relaciones Empleados 2**/
            e2.setSeguroSanitario(s2);
            e2.addTelef(n2);
            e2.addProyecto(p1);
            e2.addProyecto(p2);
            e2.addProyecto(p3);
            /**Datos Empleados 3**/
            e3 = new DMJEmpleado();
            e3.setApellido("Gutierrez");
            e3.setNombre("Paco");
            date3 = formatter.parse("2010-09-05");
            e3.setFechaalta(date3);
            e3.setSalario((long)25000);
            e3.setSeguroSanitario(s1);
            /***********************Relac. DEPARTAMENTOS*************************/
            
            
            p1.addDepartamento(d1);
            p2.addDepartamento(d1);
            p3.addDepartamento(d2);
            d1.addEmpleado(e1);
            d1.addEmpleado(e3);
            d2.addEmpleado(e2);
            d1.addProyecto(p1);
            d1.addProyecto(p2);
            d2.addProyecto(p1);
            d2.addProyecto(p2);
            d2.addProyecto(p3);      
            
  
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);
            em.persist(s1);
            em.persist(s2);
            em.persist(n1a);
            em.persist(n1b);
            em.persist(n2);
            em.persist(e1);
            em.persist(e2);
            em.persist(e3);
            em.persist(d1);
            em.persist(d2);
            em.getTransaction().commit();

        }

        private List<DMJEmpleado> findAll() {
            Query q = em.createNamedQuery("DMJEmpleado.findAll");
            return q.getResultList();
        }
        
        private List<DMJEmpleado> findAllOrderBySalary() {
            Query q = em.createNamedQuery("DMJEmpleado.findAllOrderBySalary");
            return q.getResultList();
        }
        
        private List<DMJEmpleado> findEmplByName(String name) {
            Query q = em.createNamedQuery("DMJEmpleado.findEmplByName");
            q.setParameter("nombre", name);
            return q.getResultList();
        }
        
        private List<DMJDepartamento> nativeQuery() {
            List<DMJDepartamento> result;
            result = (List<DMJDepartamento>)em.createNativeQuery("SELECT * FROM DMJDepartamento ORDER BY DEP_ID ASC", entity.DMJDepartamento.class).getResultList();
            return result;
        }
        
        private void printEmpleados(List<DMJEmpleado> empleados) {
            for (DMJEmpleado e : empleados) {
                System.out.println("EMPLEADO*********************************************************************************");
                System.out.println("Id: " + e.getId() + " \n-- Nombre: " + e.getNombre() + "\n-- Apellido: " + e.getApellido() +
                                   "\n-- Fecha Alta: " + e.getFechaalta() + "\n-- Salario: " + e.getSalario() +
                                   "\n-- Seguro: " + e.getSeguroSanitario().getAseguradora()+ "\n-- Departamento: "+e.getDepartamento().getNombre());
                System.out.println("******************************************************************************************");
                HashSet<DMJNumeroTelefono> telfSet = (HashSet<DMJNumeroTelefono>) e.getSetTelefonos();
                HashSet<DMJProyecto> proySet = (HashSet<DMJProyecto>) e.getSetProyectos();
                if (!telfSet.isEmpty()) {
                    Iterator iterator = telfSet.iterator();
                    while (iterator.hasNext()) {
                        DMJNumeroTelefono telf = (DMJNumeroTelefono) iterator.next();
                        System.out.println("Id Emp: " + telf.getEmpleado().getId() + "-- Pref: " +
                                           telf.getPrefijoInternacional() + "-- Telf: " + telf.getNumeroLocal());
                    }
                }
                if (!proySet.isEmpty()) {
                    Iterator iterator = proySet.iterator();
                    while (iterator.hasNext()) {
                        DMJProyecto proy = (DMJProyecto) iterator.next();
                        System.out.println("Id proy: " + proy.getId() + "-- Nombre Proy: " + proy.getNombre());
                    }
                }
            }
        }
        
        private void printDepartamentos(List<DMJDepartamento> departamentos) {
            for (DMJDepartamento d : departamentos) {
                System.out.println("DEPARTAMENTO******************************************************************************");
                System.out.println("Id: " + d.getId() + "\n -- Nombre: " + d.getNombre());
                System.out.println("******************************************************************************************");
                HashSet<DMJEmpleado> empSet = (HashSet<DMJEmpleado>) d.getSetEmpleados();
                HashSet<DMJProyecto> proySet = (HashSet<DMJProyecto>) d.getSetProyectos();
                if (!empSet.isEmpty()) {
                    Iterator iterator = empSet.iterator();
                    while (iterator.hasNext()) {
                        DMJEmpleado emp = (DMJEmpleado) iterator.next();
                        System.out.println("Id Emp: " + emp.getId() + "-- Nombre: " + emp.getNombre() + "-- Apellido: " + emp.getApellido());
                    }
                }
                if (!proySet.isEmpty()) {
                    Iterator iterator = proySet.iterator();
                    while (iterator.hasNext()) {
                        DMJProyecto proy = (DMJProyecto) iterator.next();
                        System.out.println("Id proy: " + proy.getId() + "-- Nombre Proy: " + proy.getNombre());
                    }
                }
                
            }
        }
        
        private void cerrarConexiones() {
            em.close();
            emf.close();
        }
    
}
