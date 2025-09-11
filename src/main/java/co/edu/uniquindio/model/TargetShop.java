package co.edu.uniquindio.model;

import java.util.LinkedList;
import java.util.List;

public class TargetShop {

    private String adress;
    private List<VideoGame> videoGames;
    private static TargetShop instance;

    private TargetShop(String adress) {
        this.adress = adress;
        videoGames = new LinkedList<>();
    }

    public static TargetShop getInstance(String adress) {
        if (instance == null) {
            instance = new TargetShop(adress);
        }
        return instance;

    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAdress() {
        return adress;
    }

    public void addListVideoGame(VideoGame videoGame) {
        videoGames.add(videoGame);
    }

    public void delateVideoGame(VideoGame videoGame) {
        videoGames.remove(videoGame);
    }

}
