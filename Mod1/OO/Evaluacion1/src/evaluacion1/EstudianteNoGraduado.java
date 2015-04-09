package evaluacion1;

public class EstudianteNoGraduado extends Estudiante {

    public EstudianteNoGraduado(String nombre) {
        super(nombre);
    }

    public EstudianteNoGraduado(String nombre, int examen1, int examen2) {
        super(nombre, examen1, examen2);
    }

    public String calcularNotaCurso() {
        String notaCurso = "";
        
        double notaMedia = getNotaMedio();
        if(notaMedia >= 70){
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
