package evaluacion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.TimeZone;

public class comprobacionBean {
    
    String nombreUsuario;
    String pass;
    
    public comprobacionBean() {
        super();
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        Statement sen = null;
        Connection con = null;

        ResultSet result = null;
        try {
            TimeZone timezone = TimeZone.getTimeZone("GMT+1");
            TimeZone.setDefault(timezone);
            conexionBD conexionbd = new conexionBD();
            con = conexionbd.creaConexion();
        } catch (Exception e) {
            System.out.println("La conexión no se ha hecho "+e);
        }
        try {
            sen = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM usuarios_jmac j WHERE j.usuario LIKE '%" + nombreUsuario + "%' ";

            result = sen.executeQuery(query);
            if (result.next()) {
                setPass(result.getString("pass"));
            } else {
                setPass("no hay resultados");
            }

        } catch (SQLException e) {
            System.out.println("La conexión no se ha hecho "+e);
        }
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }
}
