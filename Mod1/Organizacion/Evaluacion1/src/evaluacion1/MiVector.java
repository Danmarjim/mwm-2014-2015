package evaluacion1;

import java.util.Enumeration;
import java.util.Random;
import java.util.Vector;

/**
 * Clase para definir el tipo MiVector
 */

public class MiVector {

    private Vector v;
    private int numeroVector;
    
    /**
     * Constructor vacio
     */
    
    public MiVector(){
        
        v = new Vector();
        Random r = new Random();
        Integer in;
        int n, i=0, base=900;        
        while(i!=10){
            n = base + r.nextInt(101);
            in = new Integer(n);
            v.addElement(in);
            i++;
        }
    }
    
    /**
     * Constructor con parametro para definir el numero de elementos
     * @param numeroVector para definir el numero de elementos del Vector
     */
    
    public MiVector(int numeroVector){
        this.numeroVector = numeroVector;
        v = new Vector();
        Random r = new Random();
        Integer in;
        int n, i=0, base=900;        
        while(i!=numeroVector){
            n = base + r.nextInt(101);
            in = new Integer(n);
            v.addElement(in);
            i++;
        }
    }
    
    /**
     * Metodo para obtener el valor mayor
     * @return devuelve el valor mayor de un Vector dado
     */
    
    public int valorMayor(){
        int mayor = (Integer) v.elementAt(0);
        for(int i = 0, n = v.size(); i != n; i++){
            int temporal = (Integer) v.elementAt(i);
            if(temporal>mayor){
                mayor = temporal;   
            }
        }
        
        return mayor;
    }
    
    /**
     * Metodo para obtener el valor menor
     * @return devuelve el valor menor de un Vector dado
     */
    
    public int valorMenor(){
        int menor = (Integer) v.elementAt(0);
        for(int i = 0, n = v.size(); i != n; i++){
            int temporal = (Integer) v.elementAt(i);
            if(temporal<menor){
                menor = temporal;   
            }
        }
        
        return menor;
    }
    
    /**
     * Metodo donde reordenamos el vector de menor a mayor y devolvemos el valor del objeto que se encuentra en la media
     * @return devuelve el valor que se encuentra en la media del Vector.
     */
    
    public int valorMediana(){
        int posicion = 0;
        for(int i = 0, n = v.size()-1; i!=n; i++){
            int resultado = (Integer) v.elementAt(i);
            if(i == v.size()/2){
                posicion = resultado;
            }
        }
        return posicion;
    }
    
    /**
     * Metodo que devuelve la posicion donde se encuentra el valor mayor de un Vector
     * @return devuelve la posicion 
     */
    
    public int posicionValorMayor(){
        int mayor = (Integer) v.elementAt(0);
        int posicion = 0;
        for(int i = 0, n = v.size(); i != n; i++){
            int temporal = (Integer) v.elementAt(i);
            if(temporal>mayor){
                mayor = temporal;  
                posicion = i;
            }            
        }
        
        return posicion;
    }
    
    /**
     * Metodo para calcular el valor medio del Vector
     * @return devuelve el valor medio 
     */
    
    public int valorMedia(){
        int media = 0;
        int sumaTotal = 0;
        for(int i = 0, n = v.size(); i != n; i++){
            sumaTotal += (Integer) v.elementAt(i);            
        }
        
        return media = sumaTotal / 10;
    } 
    
    /**
     * Metodo toString
     * @return devuelve el string
     */
    
    public String toString(){
        String res = "{";
        Enumeration e = v.elements();
        int i = 1;
        while(e.hasMoreElements()){
            if(i != v.size()){
                res += e.nextElement() + ", ";
                i++;
            } else {
                res += e.nextElement();
            }
        }        
        res += "}";
        return res;
    } 
    
    /**
     * Metodo equals
     * @param o se mete por parametros un Vector
     * @return devuelve un boolean indicando true o false si se cumple o no la condicion 
     */
    
    public boolean equals(Object o){
        boolean res = true;
        
        if(o instanceof MiVector){
            
            MiVector vector = (MiVector) o;
            int i = 0;
            int tamañoVector = v.size();   
                if(v.isEmpty()){
                    res = false;
                } else if (v.size() != (vector.getVector().size())){
                    res = false;
                }
                while (i!=tamañoVector && res == true){
                    int valorVector1 = (Integer) v.elementAt(i);
                    int valorVector2 = (Integer) vector.getVector().elementAt(i);
            
                    if(valorVector1 != valorVector2){
                        res = false;
                    }
                    i++;
                } 
        } else {
            res = false;
        }
            return res;
    } 
    
    /**
     * Metodo privado que devuelve un Vector
     * @return devuelve un Vector.
     */
    
    private Vector getVector(){
        return v;
    }
}   

