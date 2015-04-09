package evaluacion1;

public abstract class Estudiante {
    private String nombre;
    private int examen1;
    private int examen2;
    private String notaCurso;

    public Estudiante(String nombre) {
        this.nombre = nombre;
    }

    public Estudiante(String nombre, int examen1, int examen2) {
        this.nombre = nombre;
        this.examen1 = examen1;
        this.examen2 = examen2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getExamen1() {
        return examen1;
    }

    public void setExamen1(int examen1) {
        this.examen1 = examen1;
    }

    public int getExamen2() {
        return examen2;
    }

    public void setExamen2(int examen2) {
        this.examen2 = examen2;
    }

    public double getNotaMedio() {        
        int notaMedia;        
        notaMedia = (examen1 + examen2)/2;
        return notaMedia;
    }
    
    public String toString(){
        String estudiante = "";
        estudiante += nombre ;
        estudiante += " =>\tNota examen 1: " +examen1;
        estudiante += "\n\tNota examen 2: " +examen2;
        estudiante += "\n\tNota Media:    " +getNotaMedio();
        
        return estudiante;
    }
    
    public abstract String calcularNotaCurso();
}
