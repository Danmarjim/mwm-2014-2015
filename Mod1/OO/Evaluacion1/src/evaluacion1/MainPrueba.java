package evaluacion1;

public class MainPrueba implements Prueba{
    public static void main(String[] args){  
        
        MainPrueba mainPrueba = new MainPrueba();
        
        //Prueba para alumno no Graduado
        Estudiante estudianteNoGraduado = new EstudianteNoGraduado("Daniel");
        mainPrueba.calcularNotaAlumno(estudianteNoGraduado, 60, 80);   
        
        //Prueba para alumno Graduado
        Estudiante estudianteGraduado = new EstudianteGraduado("Juan");
            mainPrueba.calcularNotaAlumno(estudianteGraduado, 100, 90);
    }
    
    @Override
    public void calcularNotaAlumno(Estudiante est, int nota1, int nota2) {
            est.setExamen1(nota1);
            est.setExamen2(nota2);
            //est.getNotaMedio();
            System.out.println(est);
    }
}
