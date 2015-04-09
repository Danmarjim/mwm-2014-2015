package vuelos;

public class MainVuelo {
    public static void main(String[] args){
        
        Aeropuerto aSevilla = new Aeropuerto("San Pablo", "Sevilla");
        Aeropuerto aMadrid = new Aeropuerto("Barajas", "Madrid");
        VueloPasajeros vp = new VueloPasajeros();
        VueloMercancias vm = new VueloMercancias(2, 5000, "Bagdad", 1000, 547, "Ayuda humanitaria", aSevilla, aMadrid);
        
        vp.setNumeroVuelo(1);
        vp.setAltitud(1000);
        vp.setDireccion("Sevilla");
        vp.setVelocidad(2500);
        vp.setPasajeros(342);
        imprime(vp);
        vp.numVuelos();
        imprime(vm);
        vm.numVuelos();
        Vuelos.numVuelos();
    }
    
        
    public static void imprime(Vuelos vuelos){
        System.out.println(vuelos);
     }      
    
}
