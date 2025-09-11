package co.edu.uniquindio.model.factory;

import co.edu.uniquindio.model.CallOfAss;
import co.edu.uniquindio.model.Fifas;
import co.edu.uniquindio.model.RPG;
import co.edu.uniquindio.model.VideoGame;

public class VideoGamesFactory {

    public static VideoGame videoGameFactory(String type,String name,int gameplayDuration){

        VideoGame game= switch(type.toLowerCase()){
            case "rpg" -> new RPG.Builder().name(name).gameplayDuration(gameplayDuration).build();
            case "callofass" -> new CallOfAss.Builder().name(name).gameplayDuration(gameplayDuration).build();
            case "fifa" -> new Fifas.Builder().name(name).gameplayDuration(gameplayDuration).build();
            default -> throw new IllegalArgumentException("Dato no aceptado" + type);
        };

        return game;

    
    }

}
