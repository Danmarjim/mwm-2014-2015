package evaluacion2;

import java.util.Collection;
import java.util.List;

public class Departamento {

    /**
     * @associates <{evaluacion2.Alumno}>
     */
    private List<Alumno> listaAlumnos;

    /**
     * @associates <{evaluacion2.Profesor}>
     */
    private List<Profesor> listaProfesores;
    private Profesor director;
    private Profesor secretario;
    private String nombre;

    public Departamento() {
    }

    public Departamento(String nombre, Profesor director, Profesor secretario, List<Alumno> listaAlumnos,
                        List<Profesor> listaProfesores) {
    }

    public String getNombre() {
        return "";
    }

    public void setNombre() {
    }

    public void añadirAlumno(Alumno alumno) {
    }

    public void eliminarAlumno(Alumno alumno) {
    }

    public void añadirProfesor(Profesor profesor) {
    }

    public void eliminarProfesor(Profesor profesor) {
    }

    public void mostrarAlumno(List<Alumno> listaAlumnos) {
        return null;
    }

    public void mostrarProfesor(List<Profesor> listaProfesores) {
        return null;
    }

    public Profesor getDirector() {
        return null;
    }

    public void setDirector(Profesor director) {
    }

    public Profesor getSecretario() {
        return null;
    }

    public void setSecretario(Profesor secretario) {
    }
}
