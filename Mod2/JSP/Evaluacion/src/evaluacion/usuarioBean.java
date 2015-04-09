package evaluacion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.TimeZone;

public class usuarioBean {
    
    private String nombre;
    private int edad;
    String nombreUsuario;
    String pass;
    
    public usuarioBean() {
        super();
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }
}
