package co.edu.uniquindio.model;

public class CallOfAss extends VideoGame {

    private String gun;

    private CallOfAss(Builder builder) {
        super(builder.name, builder.gameplayDuration);
        this.gun = builder.gun;
    }

    public String getGun() {
        return gun;
    }

    public void setGun(String gun) {
        this.gun = gun;
    }

    

    public static class Builder {
        private String name, gun;
        private int gameplayDuration;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder gameplayDuration(int duration) {
            this.gameplayDuration = duration;
            return this;
        }

        public Builder gun(String gun) {
            this.gun = gun;
            return this;
        }

        public CallOfAss build() {
            return new CallOfAss(this);
        }

    }

}
