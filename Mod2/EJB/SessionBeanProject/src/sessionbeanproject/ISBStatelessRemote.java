package sessionbeanproject;

import javax.ejb.Remote;

@Remote
public interface ISBStatelessRemote {

    public String sayHello(String s);

}
