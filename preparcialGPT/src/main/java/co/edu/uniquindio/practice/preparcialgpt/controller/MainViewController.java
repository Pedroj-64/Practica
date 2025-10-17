package co.edu.uniquindio.practice.preparcialgpt.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.io.IOException;

/**
 * Controlador principal que maneja la navegación entre las diferentes vistas de la aplicación FitHub+
 */
public class MainViewController {

    @FXML
    private Button btnDashboard;
    
    @FXML
    private Button btnCatalogo;
    
    @FXML
    private Button btnNuevaReserva;
    
    @FXML
    private Button btnImportacion;
    
    @FXML
    private Button btnReportes;
    
    @FXML
    private StackPane contentArea;
    
    @FXML
    public void initialize() {
        try {
            // Carga la vista de dashboard por defecto al iniciar la aplicación
            navigateToDashboard(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Navega a la vista del dashboard
     * @param event El evento de acción
     */
    @FXML
    private void navigateToDashboard(ActionEvent event) {
        loadView("view/dashboard-view.fxml");
    }
    
    /**
     * Navega a la vista del catálogo de servicios
     * @param event El evento de acción
     */
    @FXML
    private void navigateToCatalogo(ActionEvent event) {
        loadView("view/catalogo-view.fxml");
    }
    
    /**
     * Navega a la vista de creación de reservas
     * @param event El evento de acción
     */
    @FXML
    private void navigateToNuevaReserva(ActionEvent event) {
        loadView("view/reserva-view.fxml");
    }
    
    /**
     * Navega a la vista de importación de datos
     * @param event El evento de acción
     */
    @FXML
    private void navigateToImportacion(ActionEvent event) {
        loadView("view/importacion-view.fxml");
    }
    
    /**
     * Navega a la vista de reportes
     * @param event El evento de acción
     */
    @FXML
    private void navigateToReportes(ActionEvent event) {
        loadView("view/reportes-view.fxml");
    }
    
    /**
     * Carga una vista en el área de contenido
     * @param fxmlPath La ruta del archivo FXML a cargar
     */
    private void loadView(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/practice/preparcialgpt/" + fxmlPath));
            Parent view = loader.load();
            contentArea.getChildren().clear();
            contentArea.getChildren().add(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}