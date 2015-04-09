package evaluacion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.pool.OracleDataSource;

public class ConexionBD {
    private Connection con = null;
    private Statement consultaSQL = null;

    public ConexionBD() throws Exception {
        // crear una fuente de datos Oracle
        OracleDataSource fdo = new OracleDataSource();
        // inicializar las propiedades de la fuente de datos
        fdo.setDatabaseName("orc1");
        fdo.setDriverType("thin");
        fdo.setServerName("150.214.142.20");
        fdo.setPortNumber(1521);
        con = fdo.getConnection("scott", "kepa");
        // crea el objeto para enviar las sentencias SQL
        consultaSQL = con.createStatement();
    }

    ResultSet consultar(String tabla) throws SQLException {
        String query = "SELECT * FROM " + tabla;

        return consultaSQL.executeQuery(query);
    }

    ResultSet consultarSQL(String sql) throws SQLException {
        return consultaSQL.executeQuery(sql);
    }
}
