package evaluacion;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface AgendaDAO {

    public void insertar(Registro registro, ResultSet res) throws SQLException;
    public ResultSet consultar(Registro registro) throws SQLException;
    
}
