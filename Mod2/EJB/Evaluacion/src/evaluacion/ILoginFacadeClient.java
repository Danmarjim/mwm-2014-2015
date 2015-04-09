package evaluacion;

import java.util.Hashtable;
import java.util.List;

import javax.naming.CommunicationException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ILoginFacadeClient {
    public static void main(String[] args) {
        try {
            final Context context = getInitialContext();
            ILoginFacade iLoginFacade =
                (ILoginFacade) context.lookup("EJB-Evaluacion-SessionEJB#evaluacion.ILoginFacade");
            /*for (Dmjlogin dmjlogin : (List<Dmjlogin>) iLoginFacade.getDmjloginFindAll()) {
                printDmjlogin(dmjlogin);
            }*/
            for (Dmjlogin dmjloginUser : (List<Dmjlogin>) iLoginFacade.getDmjloginFindByName("dmartin")) {
                //printDmjlogin(dmjlogin);
                for (Dmjlogin dmjloginPass : (List<Dmjlogin>) iLoginFacade.getDmjloginFindByNameAndPass("dmartin")){
                    if(dmjloginUser.getUsuario().equals(dmjloginPass.getUsuario())){
                        printDmjlogin(dmjloginUser);
                    } else {
                        System.out.println("NO hay usuario con dichas credenciales");
                    }
                }
            }

        } catch (CommunicationException ex) {
            System.out.println(ex.getClass().getName());
            System.out.println(ex.getRootCause().getLocalizedMessage());
            System.out.println("\n*** A CommunicationException was raised.  This typically\n*** occurs when the target WebLogic server is not running.\n");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void printDmjlogin(Dmjlogin dmjlogin) {
        System.out.println("usuario = " + dmjlogin.getUsuario());
        System.out.println("contraseña = " + dmjlogin.getContraseña());
    }

    private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        // WebLogic Server 10.x/12.x connection details
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.PROVIDER_URL, "t3://127.0.0.1:7101");
        return new InitialContext(env);
    }
}
