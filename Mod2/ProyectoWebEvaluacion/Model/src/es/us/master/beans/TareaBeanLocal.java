package es.us.master.beans;

import es.us.master.entities.TareaAMC;

import es.us.master.entities.UsuarioAMC;

import java.util.List;

import javax.ejb.Local;

@Local
public interface TareaBeanLocal {
    TareaAMC persistTareaAMC(TareaAMC tareaAMC);

    TareaAMC mergeTareaAMC(TareaAMC tareaAMC);

    void removeTareaAMC(TareaAMC tareaAMC);

    List<TareaAMC> getTareaAMCFindAll();

    List<TareaAMC> getTareaFindOwn(UsuarioAMC usuario);
}
