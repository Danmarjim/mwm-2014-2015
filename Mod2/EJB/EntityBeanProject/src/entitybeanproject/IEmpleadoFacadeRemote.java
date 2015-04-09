package entitybeanproject;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface IEmpleadoFacadeRemote {
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    <T> T persistEntity(T entity);

    <T> T mergeEntity(T entity);

    Dcmempleado persistDcmempleado(Dcmempleado dcmempleado);

    Dcmempleado mergeDcmempleado(Dcmempleado dcmempleado);

    void removeDcmempleado(Dcmempleado dcmempleado);

    List<Dcmempleado> getDcmempleadoFindAll();

    List<Dcmempleado> getDcempleadoFindByName(String name);
}
