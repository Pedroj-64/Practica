package co.edu.uniquindio.model;

public interface IControlVideoGames {

    VideoGame createVideoGame(String type,String name,int gameplayDuration);
    void deleteVideoGame(String name);

}
