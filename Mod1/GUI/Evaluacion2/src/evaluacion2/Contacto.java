package evaluacion2;

public class Contacto {
    private String direccion;
    private String nombre;
    private String telefono;
    private String email;
    private String provincia;
    private String tipoContacto;
    
    public Contacto() {
        
    }
    
    public Contacto(String nombre, String telefono, String email, String direccion, String provincia, String tipoContacto){
        this.nombre=nombre;
        this.telefono=telefono;
        this.email=email;
        this.direccion=direccion;
        this.provincia=provincia;
        this.tipoContacto = tipoContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getTipoContacto() {
        return tipoContacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion=direccion;
    }

    public void setEmail(String email) {
        this.email=email;
    }

    public void setNombre(String nombre) {
        this.nombre=nombre;
    }

    public void setProvincia(String provincia) {
        this.provincia=provincia;
    }

    public void setTelefono(String telefono) {
        this.telefono=telefono;
    }

    public void setTipoContacto(String tipoContacto) {
        this.tipoContacto=tipoContacto;
    }

    public boolean equals(Object o) {
        boolean resultado = false;       
        if(o instanceof String){
            String nombre = (String) o;
            String nombreContacto = getNombre();
            if(nombreContacto.contains(nombre)){
                resultado = true;
            }
        }
        return resultado;
    }
}
