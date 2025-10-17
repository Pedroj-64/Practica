package co.edu.uniquindio.practice.preparcialgpt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase principal de la aplicación FitHub+
 */
public class HelloApplication extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 700);
        stage.setTitle("FitHub+ - Centro Deportivo y de Bienestar");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Método principal que inicia la aplicación
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        launch();
    }
}
