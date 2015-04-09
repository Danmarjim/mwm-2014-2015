package evaluacion;

import java.sql.Connection;

import oracle.jdbc.pool.OracleDataSource;

public class conexionBD {

    public conexionBD() {
        super();
    }

    public static Connection creaConexion() throws Exception {
        Connection con = null;
        OracleDataSource fdo = new OracleDataSource();
        fdo.setDatabaseName("orc1");
        fdo.setDriverType("thin");
        fdo.setServerName("150.214.142.20");
        fdo.setPortNumber(1521);
        con = fdo.getConnection("scott", "kepa");

        return con;
    }
}