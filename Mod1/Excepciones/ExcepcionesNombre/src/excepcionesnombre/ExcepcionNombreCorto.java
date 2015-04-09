package excepcionesnombre;

public class ExcepcionNombreCorto extends Exception{
    public ExcepcionNombreCorto() {
        super("Nombre demasiado corto");
    }
}
