package co.edu.uniquindio.model;

public class RPG extends VideoGame {

    private String lore;

    private RPG(Builder builder) {
        super(builder.name, builder.gameplayDuration);
        this.lore = builder.lore;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }

    public String getLore() {
        return lore;
    }

    public static class Builder {
        private String name, lore;
        private int gameplayDuration;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder lore(String lore) {
            this.lore = lore;
            return this;
        }

        public Builder gameplayDuration(int duration) {
            this.gameplayDuration = duration;
            return this;
        }

        public RPG build() {
            return new RPG(this);
        }
    }

}
