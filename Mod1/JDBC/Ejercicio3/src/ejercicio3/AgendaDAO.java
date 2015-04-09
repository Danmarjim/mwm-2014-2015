package ejercicio3;

import java.sql.ResultSet;

public interface AgendaDAO {
    public void borrarContacto();

    public ResultSet consultar(Contacto contacto);

    public void insertar(Contacto contacto);

    public void modificar(Contacto contacto);
}
