package evaluacion2;

public class AlumnoNoTitulado extends Alumno {
    private Date fechaInicio;
    private int curso;

    public AlumnoNoTitulado(String nombre, int telefono, int DNI, String titulacion, Date fechaInicio, int curso) {
    }

    public AlumnoNoTitulado() {
    }

    public int getCurso() {
        return 0;
    }

    public void setCurso(int curso) {
    }

    public Date getFechaInicio() {
        return null;
    }

    public void setFechaInicio(Date fechaInicio) {
    }
}
