package evaluacion2;

public class PruebaAgenda {
   
    public static void main(String[] args){
        
        Contacto contacto = new Contacto();
        Contacto contacto2 = new Contacto();
        
        contacto.setNombre("asd");
        contacto.setTelefono("asd");
        contacto.setEmail("asd");
        contacto.setDireccion("asd");
        contacto.setProvincia("asd");
        contacto2.setNombre("qwe");
        contacto2.setTelefono("qwe");
        contacto2.setEmail("qwe");
        contacto2.setDireccion("qwe");
        contacto2.setProvincia("qwe");
        
        Agenda agenda = new Agenda();
        
        agenda.insertar(contacto);
        agenda.insertar(contacto2);
        System.out.println(contacto.getNombre()+" " +contacto.getTelefono()+" " +contacto.getEmail()+" " +contacto.getDireccion()+" " +contacto.getProvincia());
        
        //contacto2 = agenda.consultarDatosContacto("qwe");

    }
   
}
