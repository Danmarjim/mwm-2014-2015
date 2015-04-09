package evaluacion2;

import java.util.Vector;

public class QueueT<T> {
    
    private Vector<T> vector;
    
    public QueueT(){
        vector = new Vector<T>();
    }
    
    public void addQueue(T o){
        vector.add(o);
    }
    
    public T removeQueue(){
        T resultado = vector.elementAt(0);
        vector.removeElementAt(0);
        
        return resultado;
    }
    
    public T getQueue(){
        T resultado = vector.elementAt(0);
        return resultado;
    }
    
    public int size(){
        return vector.size();        
    }
    
    public Object elementAt(int i){
        return vector.elementAt(i);
    }
   
}
