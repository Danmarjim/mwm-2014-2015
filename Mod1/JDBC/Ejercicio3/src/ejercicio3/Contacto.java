package ejercicio3;

public class Contacto {
    private int codPostal;
    private String nombre;
    private String telefono;
    private String direccion;
    private String provincia;

    public Contacto() {
    }

    public Contacto(String nombre, String telefono, String direccion, int codPostal, String provincia) {
        this.nombre=nombre;
        this.telefono=telefono;
        this.direccion=direccion;
        this.codPostal=codPostal;
        this.provincia=provincia;
    }

    public int getCodPostal() {
        return codPostal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setNombre(String nombre) {
        this.nombre=nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono=telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion=direccion;
    }

    public void setProvincia(String provincia) {
        this.provincia=provincia;
    }

    public void setCodPostal(int codPostal) {
        this.codPostal=codPostal;
    }
}
