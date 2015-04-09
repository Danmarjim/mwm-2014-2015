package evaluacion2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Agenda {
    /**
     * @associates <{evaluacion2.Contacto}>
     */
    private LinkedList<Contacto> contactos;
    private Contacto contacto;

    public Agenda() {
        this.contactos = new LinkedList<Contacto>();
        this.contacto = new Contacto();
    }

    public String insertar(Contacto contacto) {
        String resultado = "";        
        contactos.add(contacto);
        resultado += "Contacto añadido correctamente";
        return resultado;
    }

    public LinkedList<Contacto> consultarDatosContacto(String nombre) {
        LinkedList<Contacto> listaResultados = new LinkedList<Contacto>();
        for(int i=0, n=contactos.size();i!=n;i++){
            Contacto c = contactos.get(i);
            if(c.equals(nombre)){
                listaResultados.add(c);
            }
        }
        return listaResultados;
    }
}
