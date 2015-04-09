package evaluacion1;

public class EstudianteGraduado extends Estudiante {

    public EstudianteGraduado(String nombre) {
        super(nombre);
    }

    public EstudianteGraduado(String nombre, int examen1, int examen2) {
        super(nombre, examen1, examen2);
    }

    public String calcularNotaCurso() {
        String notaCurso = "";
        
        double notaMedia = getNotaMedio();
        if(notaMedia >= 80){
            notaCurso += "Alumno es Apto";
        } else {
            notaCurso += "Alumno no es Apto";
        }            
        
        return notaCurso;
    }
    
    public String toString(){
        String estudiante = "";
        
        estudiante += super.toString();
        estudiante += "\n\t" +calcularNotaCurso();
        
        return estudiante;
    }
}
