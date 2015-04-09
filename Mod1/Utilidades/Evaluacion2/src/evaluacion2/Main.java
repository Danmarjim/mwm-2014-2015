package evaluacion2;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
   
    public static void main(String[] args){
        
        Queue prueba = new Queue();

        //rellenarQueue(prueba);
        //removeElement(prueba);
        //getElement(prueba);
        
        QueueT<Integer> pruebaInt = new QueueT<Integer>();
        
        rellenarQueueT(pruebaInt);
        removeElementT(pruebaInt);
        getElementT(pruebaInt);
        
        
    }
    
    //Para el QUEUE normal
    public static void rellenarQueue(Queue q){
        
        Scanner tcld = new Scanner(System.in);
        System.out.println("Rellenar la cola Queue");
        String st = tcld.nextLine();
        while(!st.equals("")){
            q.addQueue(st);
            st = tcld.nextLine();
        }  
    }
    
    public static void removeElement(Queue q){
        
        Object o = q.removeQueue();
        System.out.println(o+ "\n"); 
        
        for(int i=0, n=q.size(); i!=n; i++){
            System.out.println(q.elementAt(i));
        }
    }
    
    public static void getElement(Queue q){
        Object o = q.getQueue();
        System.out.println(o);
        
        for(int i=0, n=q.size(); i!=n; i++){
            System.out.println(q.elementAt(i));
        }
    }
    
    //Para el QUEUE Generico
    public static void rellenarQueueT(QueueT q){
        
        Scanner tcld = new Scanner(System.in);
        System.out.println("Rellenar la cola Queue");
        /*String st = tcld.nextLine();
        while(!st.equals("")){
            q.addQueue(st);
            st = tcld.nextLine();
        }*/
        Integer in = tcld.nextInt();
        while(!in.equals("")){
            q.addQueue(in);
            in = tcld.nextInt();
        }

    }
    
    public static void removeElementT(QueueT q){
        
        Object o = q.removeQueue();
        System.out.println(o+ "\n"); 
        
        for(int i=0, n=q.size(); i!=n; i++){
            System.out.println(q.elementAt(i));
        }
    }
    
    public static void getElementT(QueueT q){
        Object o = q.getQueue();
        System.out.println(o);
        
        for(int i=0, n=q.size(); i!=n; i++){
            System.out.println(q.elementAt(i));
        }
    }
   
}
