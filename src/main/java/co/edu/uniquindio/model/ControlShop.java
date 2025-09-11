package co.edu.uniquindio.model;

import java.util.ArrayList;
import java.util.List;

import co.edu.uniquindio.model.factory.VideoGamesFactory;

public class ControlShop implements IControlVideoGames {

    public List<VideoGame> listaForVocals(List<VideoGame> lista) {
        List<VideoGame> listInVocals = new ArrayList<>();

        for (VideoGame game : lista) {

            String name = game.getName();
            int countVocals = vocalsCount(name);

            if (countVocals >= 2) {
                listInVocals.add(game);
            }

        }

        return listInVocals;

    }

    public static int vocalsCount(String name) {
        int count = 0;
        char[] chars = name.toLowerCase().toCharArray();

        for (char charact : chars) {
            if ("aeiou".contains(String.valueOf(charact))) {
                count++;

            }
        }

        return count;
    }

    @Override
    public VideoGame createVideoGame(String type, String name, int gameplayDuration) {

        return VideoGamesFactory.videoGameFactory(type, name, gameplayDuration);

    }

    @Override
    public void deleteVideoGame(String name) {

    }

}
