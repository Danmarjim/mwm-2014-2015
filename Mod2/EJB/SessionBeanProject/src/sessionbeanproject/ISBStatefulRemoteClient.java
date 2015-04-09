package sessionbeanproject;

import java.util.Hashtable;

import javax.naming.CommunicationException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ISBStatefulRemoteClient {
    public static void main(String[] args) {
        try {
            final Context context = getInitialContext();
            ISBStatefulRemote iSBStatefulRemote =
                (ISBStatefulRemote) context.lookup("EJB-SessionBeanProject-SBStateful#sessionbeanproject.ISBStatefulRemote");
            iSBStatefulRemote.clearIt();
            iSBStatefulRemote.calculate("+", 2.0);
            System.out.println("Resultado: " + iSBStatefulRemote.getValue());
            iSBStatefulRemote.calculate("-", 5.0);
            System.out.println("Resultado: " + iSBStatefulRemote.getValue());
        } catch (CommunicationException ex) {
            System.out.println(ex.getClass().getName());
            System.out.println(ex.getRootCause().getLocalizedMessage());
            System.out.println("\n*** A CommunicationException was raised.  This typically\n*** occurs when the target WebLogic server is not running.\n");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        // WebLogic Server 10.x/12.x connection details
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.PROVIDER_URL, "t3://127.0.0.1:7101");
        return new InitialContext(env);
    }
}
