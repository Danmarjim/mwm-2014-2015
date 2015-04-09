package vuelos;

public class VueloMercancias extends Vuelos {
    private static int numVuelos = 0;
    String tipoCarga;
    private int carga;

    public VueloMercancias() {
        numVuelos++;
    }

    public VueloMercancias(int numeroVuelo, int altitud, String direccion, int velocidad, int carga, String tipoCarga, Aeropuerto origen, Aeropuerto destino) {
        super(numeroVuelo, altitud, direccion, velocidad, origen, destino);
        this.carga = carga;
        this.tipoCarga = tipoCarga;
        numVuelos++;
    }

    public static void numVuelos() {
        System.out.println("Se han creado " + numVuelos + " vuelos de mercancias");
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public String getTipoCarga() {
        return tipoCarga;
    }

    public void setTipoCarga(String tipoCarga) {
        this.tipoCarga = tipoCarga;
    }

    public String toString() {
        String vuelo = "***************************";
        vuelo += "\nVuelo de mercancias \n";
        vuelo += super.toString();
        vuelo += "\nTipo de carga: " +tipoCarga;
        vuelo += "\nPeso de la carga: " +carga+ " toneladas";
        vuelo += "\n*****************************";
        
        return vuelo;
    }
}
