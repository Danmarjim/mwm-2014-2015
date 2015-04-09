package evaluacion;

public class ExcepcionEdadIlegal extends Exception{
    public ExcepcionEdadIlegal() {
        super("Formato de edad incorrecto");
    }
}
