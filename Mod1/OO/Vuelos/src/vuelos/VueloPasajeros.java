package vuelos;

public class VueloPasajeros extends Vuelos {
    private static int numVuelos = 0;
    private int pasajeros;

    public VueloPasajeros() {
        numVuelos++;
    }

    public VueloPasajeros(int numeroVuelo, int altitud, String direccion, int velocidad, int pasajeros, Aeropuerto origen, Aeropuerto destino) {               
        super(numeroVuelo, altitud, direccion, velocidad, origen, destino);
        this.pasajeros = pasajeros;
        numVuelos++;
    }

    public static void numVuelos() {
        System.out.println("Se han creado " + numVuelos + " vuelos de pasajeros");
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    public String toString() {
        String vuelo = "***************************";
        vuelo += "\nVuelo de pasajeros \n";
        vuelo += super.toString();
        vuelo += "\nNumero de pasajeros: " +pasajeros;
        vuelo += "\n*****************************";
        
        return vuelo;
    }
}
