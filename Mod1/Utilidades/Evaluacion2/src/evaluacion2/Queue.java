package evaluacion2;

import java.util.Vector;

public class Queue {
    
    private Vector vector;
    
    public Queue(){
        vector = new Vector();
    }
    
    public void addQueue(Object o){
        vector.add(o);
    }
    
    public Object removeQueue(){
        Object resultado = vector.elementAt(0);
        vector.removeElementAt(0);
        
        return resultado;
    }
    
    public Object getQueue(){
        Object resultado = vector.elementAt(0);
        return resultado;
    }
    
    public int size(){
        return vector.size();        
    }
    
    public Object elementAt(int i){
        return vector.elementAt(i);
    }

}