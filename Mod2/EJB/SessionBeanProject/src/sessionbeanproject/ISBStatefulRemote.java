package sessionbeanproject;

import javax.ejb.Remote;

@Remote
public interface ISBStatefulRemote {

    public void clearIt();

    public void calculate(String operation, Double number);

    public Double getValue();
}
