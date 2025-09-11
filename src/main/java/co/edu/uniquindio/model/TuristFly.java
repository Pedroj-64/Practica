package co.edu.uniquindio.model;

import java.util.ArrayList;
import java.util.List;

public class TuristFly extends Fly implements Cloneable {


    private boolean wifi;
    private List<String> lunches;

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public List<String> getLunches() {
        return lunches;
    }

    public void setLunches(List<String> lunches) {
        this.lunches = lunches;
    }

    @Override
    public TuristFly clone(){
        return new TuristFly(this.getId(), this.getDestino(), this.numPassegers());

    }

    private TuristFly(Builder builder){
        super(builder.id,builder.destino,builder.numPassegers);
        lunches= new ArrayList<>();
        this.wifi=builder.wifi;
        this.lunches=builder.lunches;
    }

    public TuristFly(String id,String destino,int numPassegers){
        super(id,destino,numPassegers);


    }

    public static class Builder {
        private boolean wifi;
        private String id, destino;
        private int numPassegers;
        private List<String> lunches;

        public Builder Wifi(boolean wifi) {
            this.wifi = wifi;
            return this;
        }

        public Builder Id(String id) {
            this.id = id;
            return this;
        }

        public Builder Destino(String destino) {
            this.destino = destino;
            return this;
        }

        public Builder NumPassegers(int numPassegers) {
            this.numPassegers = numPassegers;
            return this;
        }

        public Builder Lunches(List<String> lunches) {
            this.lunches = lunches;
            return this;
        }

        public Builder wifi(boolean wifi) {
            this.wifi = wifi;
            return this;
        }

        public Builder lunches(List<String> lunches) {
            this.lunches = lunches;
            return this;
        }

        public TuristFly build() {
            return new TuristFly(this);
        }
    }

}
