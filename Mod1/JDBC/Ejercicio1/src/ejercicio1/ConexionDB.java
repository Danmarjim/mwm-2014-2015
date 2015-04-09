package ejercicio1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.pool.OracleDataSource;

public class ConexionDB {
    
    private Connection con = null;
    private Statement consultaSQL = null;
    private PreparedStatement insertaSQL = null;
    
    public ConexionDB() throws Exception {
        OracleDataSource fdo = new OracleDataSource();
        //Inicializar las propiedades de la fuente de datos
        fdo.setDatabaseName("orc1");
        fdo.setDriverType("thin");
        fdo.setServerName("150.214.142.20");
        fdo.setPortNumber(1521);
        con = fdo.getConnection("scott", "kepa");
        
        //Crea los objetos para enviar las sentencias sql
        consultaSQL = con.createStatement();
        //consultaSQL = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        insertaSQL = con.prepareStatement("INSERT INTO AGENDA VALUES (?,?,?,?,?)");
    }
    
    /*void insertar(Contacto agenda, ResultSet res) throws SQLException {
        if(res == null){
            res = consultaSQL.executeQuery("SELECT NOMBRE, TELEFONO, DIRECCION, CODPOSTAL, PROVINCIA FROM agenda");
        } else {
            res.moveToInsertRow();
            res.updateString(1, agenda.getNombre());
            res.updateString(2, agenda.getTelefono());
            res.updateString(3, agenda.getDireccion());
            res.updateInt(4, agenda.getCodPostal());
            res.updateString(5, agenda.getProvincia());
            res.insertRow();
        }
    }
    
    ResultSet consultar(Contacto agenda) throws SQLException {
        String query = "SELECT NOMBRE, TELEFONO, DIRECCION, CODPOSTAL, PROVINCIA FROM agenda WHERE 1=1";
        if(!agenda.getNombre().equals(""))
            query += " and nombre='" +agenda.getNombre() + "'";
        if(!agenda.getTelefono().equals(""))
            query += " and Telefono='" +agenda.getTelefono() + "'";
        if(!agenda.getDireccion().equals(""))
            query += " and Direccion='" +agenda.getDireccion() + "'";
        if(agenda.getCodPostal() != -1)
            query += " and codPostal='" +agenda.getCodPostal() + "'";
        if(!agenda.getProvincia().equals(""))
            query += " and Provincia='" +agenda.getProvincia() + "'";
        return consultaSQL.executeQuery(query);
    }*/
    
    //Metodos pertenecientes a la primera parte del ejercicio JDBC
    void insertar(Contacto agenda) throws SQLException{
        insertaSQL.setString(1, agenda.getNombre());
        insertaSQL.setString(2, agenda.getTelefono());
        insertaSQL.setString(3, agenda.getDireccion());
        insertaSQL.setInt(4, agenda.getCodPostal());
        insertaSQL.setString(5, agenda.getProvincia());
    }
    
    ResultSet consultarPorNombre(String nombre) throws SQLException{
        String query = "SELECT * FROM agenda";
        if(!nombre.equals("")){
            query += " WHERE nombre LIKE '%" +nombre+ "%'";
        }
        return consultaSQL.executeQuery(query);
    }
}
