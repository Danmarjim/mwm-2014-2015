package evaluacion;

public abstract class FactoriaDAO {
    public static final int ORACLE = 1;
    public static final int MYSQL = 2;
    public static final int ACCESS = 3;

    public abstract AgendaDAO getAgendaDAO() throws Exception;

    public static FactoriaDAO getFactoriaDAO(int factoria) {
        switch(factoria) {
        case ORACLE:
                return new FactoriaOracleDAO();
        case MYSQL:
                return new FactoriaMySQLDAO();
        case ACCESS:
                return new FactoriaAccessDAO();
        default:
            return null;
        }
    }
}
