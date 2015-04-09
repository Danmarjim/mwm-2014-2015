package evaluacion;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.sql.ResultSet;

import oracle.jdbc.pool.OracleDataSource;

public class FactoriaAccessDAO extends FactoriaDAO {
    private static java.sql.Connection con = null;
    private static java.sql.Statement consultaSQL = null;
    private static java.sql.PreparedStatement insertaSQL = null;
    
    public static java.sql.Connection creaConexion() throws Exception {
        OracleDataSource fdo = new OracleDataSource();

        fdo.setDatabaseName("orc1");
        fdo.setDriverType("thin");
        fdo.setServerName("150.214.142.20");
        fdo.setPortNumber(1521);
        con = fdo.getConnection("orc1", "150.214.142.20");
        
        consultaSQL = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        insertaSQL = con.prepareStatement("INSERT INTO AGENDA VALUES (?,?,?,?,?)");
        
        return con;
    }

    public AgendaDAO getAgendaDAO() throws Exception {
        return new AgendaOracleDAO();
    }
}
