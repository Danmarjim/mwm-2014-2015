package vuelos;

public class Vuelos {
    private Aeropuerto origen;
    private Aeropuerto destino;
    private int altitud;
    private int numeroVuelo;
    private int velocidad;
    private String direccion;
    private static int numVuelos=0;

    Vuelos() {
        numVuelos++;
    }

    public Vuelos(int numeroVuelo, int altitud, String direccion, int velocidad, Aeropuerto origen, Aeropuerto destino) {
        this.numeroVuelo = numeroVuelo;
        this.altitud = altitud;
        this.direccion = direccion;
        this.velocidad = velocidad;
        this.origen = origen;
        this.destino = destino;
        numVuelos++;
    }

    public int getAltitud() {
        return altitud;
    }

    public void setAltitud(int altitud) {
        this.altitud = altitud;
    }

    public int getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(int numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public Aeropuerto getOrigen() {
        return origen;
    }

    public void setOrigen(Aeropuerto origen) {
        this.origen = origen;
    }

    public static void numVuelos() {
        System.out.println("Se han creado " + numVuelos + " vuelos en total");
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String toString() {
        String vuelo = "Numero: " +numeroVuelo;
        vuelo += "\nAltitud: " +altitud+ " pies";
        vuelo += "\nDireccion: " +direccion;
        vuelo += "\nVelocidad: " +velocidad+ " nudos";
        vuelo += (origen != null) ? ("\nAeropuerto de origen: " +origen):"";
        vuelo += (destino != null) ? ("\nAeropuerto de destino: " +destino):"";
         
        return vuelo;
    }
}
