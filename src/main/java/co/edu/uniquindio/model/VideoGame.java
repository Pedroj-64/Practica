package co.edu.uniquindio.model;

public abstract class VideoGame {

    private String name;
    private int gameplayDuration;

    public VideoGame(String name, int gameplayDuration) {
        this.name = name;
        this.gameplayDuration = gameplayDuration;
    }

    public String getName() {
        return name;
    }

    public int getGameplayDuration() {
        return gameplayDuration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGamplayDuration(int duration) {
        this.gameplayDuration = duration;
    }

}
