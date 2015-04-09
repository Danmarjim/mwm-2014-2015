package entitybeanproject;

import java.util.List;

import javax.naming.CommunicationException;
import javax.naming.Context;
import javax.naming.InitialContext;

public class IEmpleadoFacadeRemoteClient {
    public static void main(String[] args) {
        try {
            final Context context = getInitialContext();
            IEmpleadoFacadeRemote iEmpleadoFacadeRemote =
                (IEmpleadoFacadeRemote) context.lookup("EJB-EntityBeanProject-SessionEJB#entitybeanproject.IEmpleadoFacadeRemote");
            for (Dcmempleado dcmempleado : (List<Dcmempleado>) iEmpleadoFacadeRemote.getDcmempleadoFindAll()) {
                printDcmempleado(dcmempleado);
            }
            for (Dcmempleado dcmempleado :
                 (List<Dcmempleado>) iEmpleadoFacadeRemote.getDcempleadoFindByName("") /* FIXME: Pass parameters here */) {
                printDcmempleado(dcmempleado);
            }
        } catch (CommunicationException ex) {
            System.out.println(ex.getClass().getName());
            System.out.println(ex.getRootCause().getLocalizedMessage());
            System.out.println("\n*** A CommunicationException was raised.  This typically\n*** occurs when the target WebLogic server is not running.\n");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void printDcmempleado(Dcmempleado dcmempleado) {
        System.out.println("apellido = " + dcmempleado.getApellido());
        System.out.println("empId = " + dcmempleado.getEmpId());
        System.out.println("fechaalta = " + dcmempleado.getFechaalta());
        System.out.println("nombre = " + dcmempleado.getNombre());
        System.out.println("salario = " + dcmempleado.getSalario());
        System.out.println("seguroId = " + dcmempleado.getSeguroId());
        System.out.println("version = " + dcmempleado.getVersion());
        System.out.println("dcmdepartamento = " + dcmempleado.getDcmdepartamento());
    }

    private static Context getInitialContext() {
        return null;
    }
}
