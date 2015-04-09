package vuelos;

public class Aeropuerto {
    private String nombre;
    private String ciudad;

    public Aeropuerto(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String toString() {
        return ("\t Nombre: " +nombre+ "\n\t Ciudad: " +ciudad);
    }
}
