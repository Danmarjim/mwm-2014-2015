package evaluacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AgendaMySQLDAO implements AgendaDAO {
    
    private Connection con = null;
    private Statement consultaSQL = null;
    private PreparedStatement insertaSQL = null;
    
    public AgendaMySQLDAO() throws Exception {
        /*OracleDataSource fdo = new OracleDataSource();

        fdo.setDatabaseName("orc1");
        fdo.setDriverType("thin");
        fdo.setServerName("150.214.142.20");
        fdo.setPortNumber(1521);
        con = fdo.getConnection("orc1", "150.214.142.20");
        
        consultaSQL = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        insertaSQL = con.prepareStatement("INSERT INTO AGENDA VALUES (?,?,?,?,?)");*/
        
        con = FactoriaOracleDAO.creaConexion();
        
    }

    public ResultSet consultar(Registro registro) throws SQLException {
        String query = "SELECT NOMBRE, TELEFONO, DIRECCION, CODPOSTAL, PROVINCIA FROM agenda WHERE 1=1";
        if(!registro.getNombre().equals(""))
            query += " and nombre='" +registro.getNombre() + "'";
        if(!registro.getTelefono().equals(""))
            query += " and Telefono='" +registro.getTelefono() + "'";
        if(!registro.getDireccion().equals(""))
            query += " and Direccion='" +registro.getDireccion() + "'";
        if(registro.getCodPostal() != -1)
            query += " and codPostal='" +registro.getCodPostal() + "'";
        if(!registro.getProvincia().equals(""))
            query += " and Provincia='" +registro.getProvincia() + "'";
        return consultaSQL.executeQuery(query);
    }

    @Override
    public void insertar(Registro registro, ResultSet res) throws SQLException {
        if(res == null){
            res = consultaSQL.executeQuery("SELECT NOMBRE, TELEFONO, DIRECCION, CODPOSTAL, PROVINCIA FROM agenda");
        } else {
            res.moveToInsertRow();
            res.updateString(1, registro.getNombre());
            res.updateString(2, registro.getTelefono());
            res.updateString(3, registro.getDireccion());
            res.updateInt(4, registro.getCodPostal());
            res.updateString(5, registro.getProvincia());
            res.insertRow();
        }
    }
}
