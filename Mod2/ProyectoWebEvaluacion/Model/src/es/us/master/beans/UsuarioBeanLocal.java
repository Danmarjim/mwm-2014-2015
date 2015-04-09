package es.us.master.beans;

import es.us.master.entities.UsuarioAMC;

import java.util.List;

import javax.ejb.Local;

@Local
public interface UsuarioBeanLocal {
    UsuarioAMC persistUsuarioAMC(UsuarioAMC usuarioAMC);

    UsuarioAMC mergeUsuarioAMC(UsuarioAMC usuarioAMC);

    void removeUsuarioAMC(UsuarioAMC usuarioAMC);

    List<UsuarioAMC> getUsuarioAMCFindAll();

    UsuarioAMC getUsuarioUsernamePassword(String username, String password);
}
