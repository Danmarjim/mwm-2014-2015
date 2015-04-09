package ejercicio4;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class Main {
   
    public static void main(String[] args){
        
        //mostrarFechaCumple();
        //operacionesPila();
        recorrerVector();
    }
    
    public static void mostrarFechaCumple(){
        
        String dias[] = {" ", "Sabado", "Domingo", "Lunes", "Martes",  "Miercoles", "Jueves", "Viernes"};
        int dia=4;
        int mes=Calendar.OCTOBER;
        int añoactual;
        Calendar c1 = GregorianCalendar.getInstance();
        
        Date hoy = new Date();
        GregorianCalendar cal = new GregorianCalendar();
        
        cal.setTime(hoy);
        añoactual = cal.get(Calendar.YEAR);
        System.out.println("Cumpleaños los años siguientes");
        
        for(int i=añoactual, n=i+11; i!=n; i++){
            c1.set(dia, mes, i);
            System.out.println("Año: " +i+ " Dia: " +dias[c1.get(Calendar.DAY_OF_WEEK)]);
        }
    }
    
    public static void operacionesPila(){
        Stack st = new Stack();
        st.push(new Integer(1));
        st.push(new Integer(2));
        st.push(new Integer(3));
        st.push(new Integer(4));
        
        System.out.println("elemento extraido " +st.pop().toString());
        System.out.println("elemento extraido " +st.pop().toString());
        
        st.push(new Integer(5));
        st.push(new Integer(6));
        st.push(new Integer(7));
        
        Object o;
        LinkedList ll = new LinkedList();
        Iterator it = st.iterator();
        while(it.hasNext()){
            o = it.next();
            ll.add(o);
            System.out.println("elemento extraido " +o.toString());
        }
    }
    
    public static void recorrerVector(){
        
        Vector<String> vector = new Vector<String>();
        Scanner tcld = new Scanner(System.in);
        
        System.out.println("Introduce por teclado cadenas de caracteres");
        String st = tcld.nextLine();
        while(!st.equals("")){
            vector.add(st);
            st = tcld.nextLine();
        }
        
        System.out.println("Todas las cadenas ha leidos son: ");
        Iterator<String> it = vector.iterator();
        while(it.hasNext()){
            st = it.next();
            System.out.println(st);
        }
        
    }
}
