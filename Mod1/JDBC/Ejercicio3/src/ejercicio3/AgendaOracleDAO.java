package ejercicio3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AgendaOracleDAO implements AgendaDAO {
    private Statement sen;
    private Connection con;
    private ResultSet res;
    
    public AgendaOracleDAO(){
        
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
