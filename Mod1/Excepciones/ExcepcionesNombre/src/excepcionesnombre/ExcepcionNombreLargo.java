package excepcionesnombre;

public class ExcepcionNombreLargo extends Exception{
    public ExcepcionNombreLargo() {
        super("Nombre demasiado largo");
    }
}
