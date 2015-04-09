package ejercicio3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AgendaAccessDAO implements AgendaDAO {
    private Connection con;
    private ResultSet res;
    private Statement sen;

    public AgendaAccessDAO() {
    }

    public void borrarContacto() {
    }

    public ResultSet consultar(Contacto contacto) {
        return null;
    }

    public void insertar(Contacto contacto) {
    }

    public void modificar(Contacto contacto) {
    }
}
