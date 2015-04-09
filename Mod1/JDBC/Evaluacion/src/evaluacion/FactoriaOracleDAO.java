package evaluacion;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.pool.OracleDataSource;


public class FactoriaOracleDAO extends FactoriaDAO {
    
    private static Connection con = null;
    private static Statement consultaSQL = null;
    private static PreparedStatement insertaSQL = null;
    
    public static Connection creaConexion() throws Exception {
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
