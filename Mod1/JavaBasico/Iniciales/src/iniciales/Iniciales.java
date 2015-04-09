package iniciales;

public class Iniciales {
    public static void main(String[] args) {
        String nombre, apellido1, apellido2;
        nombre = "Daniel";
        apellido1 = "Martin";
        apellido2 = "Jimenez";
        String s = nombre.substring(0, 1);
        String s1 = apellido1.substring(0, 1);
        String s2 = apellido2.substring(0, 1);
        String temporal = nombre.concat(apellido1);
        String resultado = temporal.concat(apellido2);
        int longitud = resultado.length();
        System.out.println("Las iniciales son " + s + s1 + s2);
        System.out.println("Tiene una longitud de " + longitud);
    }
}
