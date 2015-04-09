package sessionbeanproject;

import javax.annotation.Resource;

import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless(name = "SBStateful", mappedName = "EJB-SessionBeanProject-SBStateful")
@Local
public class SBStatefulBean implements ISBStatefulRemote {

    private Double value;

    @Resource
    SessionContext sessionContext;

    public SBStatefulBean() {
        this.value = 0.0;
    }

    @Override
    public void clearIt() {
        this.value = 0.0;
    }

    @Override
    public void calculate(String operation, Double number) {
        switch (operation) {
        case "+":
            this.value += number;
            break;
        case "-":
            this.value -= number;
            break;
        default:
            this.value = Double.NaN;
        }
    }

    @Override
    public Double getValue() {
        return this.value;
    }
}
