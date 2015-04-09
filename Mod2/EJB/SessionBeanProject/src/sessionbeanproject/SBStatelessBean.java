package sessionbeanproject;

import javax.annotation.Resource;

import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless(name = "SBStateless", mappedName = "EJB-SessionBeanProject-SBStateless")
@Local
public class SBStatelessBean implements ISBStatelessRemote {
    @Resource
    SessionContext sessionContext;

    public SBStatelessBean() {
    }
    
    public String sayHello(String s){
        return "Hello " + s + " from EJB";
    }
}
