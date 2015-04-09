package evaluacion;

public class votacionBean {
    
    private String coche;
    private int seat, opel, vol;
    
    public votacionBean() {
        super();
        
        seat = 0;
        opel = 0;
        vol = 0;
    }
    
    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getSeat() {
        return seat;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }

    public int getVol() {
        return vol;
    }

    public void setOpel(int opel) {
        this.opel = opel;
    }

    public int getOpel() {
        return opel;
    }
    
    public void setCoche(String coche) {
            this.coche = coche;
            try {
                int valor = Integer.parseInt(coche);
                if (valor == 1) {
                    this.setVol(this.getVol() + 1);
                } else if (valor == 2) {
                    this.setSeat(this.getSeat() + 1);
                } else if (valor == 3) {
                    this.setOpel(this.getOpel() + 1);
                }
            } catch (Exception e) {
                System.out.println("No se ha contabilizado el voto "+e);
            }
    }
    
    public String getCoche() {
        return coche;
    }
}
