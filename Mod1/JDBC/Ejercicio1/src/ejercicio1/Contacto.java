package ejercicio1;

public class Contacto {
    
    private String nombre;
    private String telefono;
    private int codPostal;
    private String direccion;
    private String provincia;    
    
    public Contacto() {
    }
    
    public Contacto(String nombre, String telefono, String direccion, int codPostal,String provincia){
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.codPostal = codPostal;
        this.provincia = provincia;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getTelefono(){
        return telefono;
    }
    
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    
    public int getCodPostal(){
        return codPostal;
    }
    
    public void setCodPostal(int codPostal){
        this.codPostal = codPostal;
    }
    
    public String getProvincia(){
        return provincia;
    }
    
    public void setProvincia(String provincia){
        this.provincia = provincia;
    }
    
    public String getDireccion(){
        return direccion;
    }
    
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public String toString(){
        return "\tNombre: " +nombre+ "\n\tTelefono: " +telefono+ "\n\tDireccion: " +direccion+ "\n\tCodigo Postal: " +codPostal+ "\n\tProvincia: " +provincia;
    }
    
}
