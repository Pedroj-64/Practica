package co.edu.uniquindio.model;

import java.util.ArrayList;
import java.util.List;

public class Fifas extends VideoGame {

    private List<String> teams;

    private Fifas(Builder builder) {
        super(builder.name, builder.gameplayDuration);
        teams = new ArrayList<>();
    }

    public void addTeam(String team) {
        teams.add(team);
    }

    public void deleteTeam(String team) {
        teams.remove(team);
    }

    public List<String> getTeams() {
        return new ArrayList<>(teams);
    }

    public static class Builder {
        private String name;
        private int gameplayDuration;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder gameplayDuration(int duration) {
            this.gameplayDuration = duration;
            return this;
        }

        public Fifas build() {
            return new Fifas(this);
        }
    }
}
