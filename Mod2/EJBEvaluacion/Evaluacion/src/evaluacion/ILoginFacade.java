package evaluacion;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface ILoginFacade {
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    <T> T persistEntity(T entity);

    <T> T mergeEntity(T entity);

    Dmjlogin persistDmjlogin(Dmjlogin dmjlogin);

    Dmjlogin mergeDmjlogin(Dmjlogin dmjlogin);

    void removeDmjlogin(Dmjlogin dmjlogin);

    List<Dmjlogin> getDmjloginFindAll();
    
    Dmjlogin getDmjloginfindByName(String name);
}
