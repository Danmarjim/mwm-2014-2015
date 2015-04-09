package ejercicio3;

public abstract class FactoriaDAO {
    public static final int ORACLE =1;
    public static final int ACCESS =2;
    public static final int POSTGRES =3;

    public abstract AgendaDAO getAgendaDAO();

    public FactoriaDAO getFactoriaDAO(int factoria) {
        return null;
    }
}
