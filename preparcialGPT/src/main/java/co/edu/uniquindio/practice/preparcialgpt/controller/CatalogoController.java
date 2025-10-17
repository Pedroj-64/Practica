package co.edu.uniquindio.practice.preparcialgpt.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeView;

import java.util.HashMap;
import java.util.Map;

/**
 * Controlador para la vista del Catálogo de Servicios
 */
public class CatalogoController {

    @FXML
    private TextField txtBuscar;
    
    @FXML
    private ComboBox<String> cbCategoria;
    
    @FXML
    private TreeView<String> treeServicios;
    
    @FXML
    private Label lblNombre;
    
    @FXML
    private Label lblTipo;
    
    @FXML
    private Label lblDescripcion;
    
    @FXML
    private Label lblPrecio;
    
    @FXML
    private Label lblCapacidad;
    
    @FXML
    private TableView<HorarioDisplay> tblHorarios;
    
    @FXML
    private TableColumn<HorarioDisplay, String> colDia;
    
    @FXML
    private TableColumn<HorarioDisplay, String> colHoraInicio;
    
    @FXML
    private TableColumn<HorarioDisplay, String> colHoraFin;
    
    @FXML
    private TableColumn<HorarioDisplay, Integer> colDisponibilidad;
    
    // El servicio controller se utilizará en futuras implementaciones
    
    @FXML
    public void initialize() {
        // Configuración de ComboBox para categoría
        ObservableList<String> categorias = FXCollections.observableArrayList(
                "Todos", "Clases Dirigidas", "Zonas", "Spa", "Paquetes");
        cbCategoria.setItems(categorias);
        cbCategoria.setValue("Todos");
        
        // Configuración de las columnas de la tabla de horarios
        colDia.setCellValueFactory(new PropertyValueFactory<>("dia"));
        colHoraInicio.setCellValueFactory(new PropertyValueFactory<>("horaInicio"));
        colHoraFin.setCellValueFactory(new PropertyValueFactory<>("horaFin"));
        colDisponibilidad.setCellValueFactory(new PropertyValueFactory<>("disponibilidad"));
        
        // Cargar datos iniciales
        cargarArbolServicios();
        configurarSeleccionServicio();
    }
    
    /**
     * Carga el árbol de servicios desde el controlador de servicios
     */
    private void cargarArbolServicios() {
        TreeItem<String> rootItem = new TreeItem<>("Servicios FitHub+");
        rootItem.setExpanded(true);
        
        // Crear categorías principales
        TreeItem<String> clasesItem = new TreeItem<>("Clases Dirigidas");
        TreeItem<String> zonasItem = new TreeItem<>("Zonas");
        TreeItem<String> spaItem = new TreeItem<>("Spa");
        TreeItem<String> paquetesItem = new TreeItem<>("Paquetes");
        
        // Agregar algunos servicios de ejemplo a cada categoría
        // En la implementación real, estos datos vendrían del modelo
        clasesItem.getChildren().addAll(
            new TreeItem<>("Yoga"),
            new TreeItem<>("Pilates"),
            new TreeItem<>("Spinning"),
            new TreeItem<>("Zumba")
        );
        
        zonasItem.getChildren().addAll(
            new TreeItem<>("Musculación"),
            new TreeItem<>("Cardio"),
            new TreeItem<>("Funcional")
        );
        
        spaItem.getChildren().addAll(
            new TreeItem<>("Masajes"),
            new TreeItem<>("Sauna"),
            new TreeItem<>("Jacuzzi")
        );
        
        paquetesItem.getChildren().addAll(
            new TreeItem<>("Pack Bienestar"),
            new TreeItem<>("Pack Deportivo")
        );
        
        // Agregar todas las categorías al nodo raíz
        rootItem.getChildren().addAll(clasesItem, zonasItem, spaItem, paquetesItem);
        
        // Asignar el árbol a la vista
        treeServicios.setRoot(rootItem);
    }
    
    /**
     * Configura el evento de selección en el TreeView
     */
    private void configurarSeleccionServicio() {
        treeServicios.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                if (newValue != null && newValue.isLeaf() && newValue.getParent() != treeServicios.getRoot()) {
                    mostrarDetalleServicio(newValue.getValue());
                } else {
                    limpiarDetalleServicio();
                }
            }
        );
    }
    
    /**
     * Muestra los detalles del servicio seleccionado
     * @param nombreServicio El nombre del servicio seleccionado
     */
    private void mostrarDetalleServicio(String nombreServicio) {
        // En una implementación real, estos datos vendrían del modelo
        // a través del controlador de servicios
        
        // Ejemplo de datos de muestra
        lblNombre.setText(nombreServicio);
        
        // Determinar el tipo según la categoría padre
        TreeItem<String> selectedItem = treeServicios.getSelectionModel().getSelectedItem();
        TreeItem<String> parent = selectedItem.getParent();
        lblTipo.setText(parent.getValue());
        
        // Datos de ejemplo para los demás campos
        Map<String, String> descripciones = new HashMap<>();
        descripciones.put("Yoga", "Clase de yoga para todos los niveles que combina posturas, respiración y meditación.");
        descripciones.put("Pilates", "Método de ejercicio y movimiento físico diseñado para estirar, fortalecer y equilibrar el cuerpo.");
        descripciones.put("Spinning", "Clase de ciclismo indoor de alta intensidad con música motivadora.");
        descripciones.put("Zumba", "Entrenamiento de baile de fitness con música latina.");
        
        lblDescripcion.setText(descripciones.getOrDefault(nombreServicio, 
                               "Servicio de alta calidad para mejorar tu condición física y bienestar."));
        
        // Precio y capacidad de ejemplo
        Map<String, Double> precios = new HashMap<>();
        precios.put("Yoga", 25.0);
        precios.put("Pilates", 30.0);
        precios.put("Spinning", 20.0);
        precios.put("Zumba", 15.0);
        precios.put("Musculación", 35.0);
        precios.put("Cardio", 25.0);
        precios.put("Funcional", 30.0);
        precios.put("Masajes", 50.0);
        precios.put("Sauna", 20.0);
        precios.put("Jacuzzi", 25.0);
        precios.put("Pack Bienestar", 80.0);
        precios.put("Pack Deportivo", 100.0);
        
        lblPrecio.setText(String.format("$%.2f", precios.getOrDefault(nombreServicio, 30.0)));
        
        // Capacidad según el tipo
        if (parent.getValue().equals("Clases Dirigidas")) {
            lblCapacidad.setText("20 personas");
        } else if (parent.getValue().equals("Zonas")) {
            lblCapacidad.setText("40 personas");
        } else if (parent.getValue().equals("Spa")) {
            lblCapacidad.setText("10 personas");
        } else {
            lblCapacidad.setText("Variable según servicios");
        }
        
        // Cargar horarios de ejemplo
        cargarHorariosEjemplo();
    }
    
    /**
     * Carga horarios de ejemplo para el servicio seleccionado
     */
    private void cargarHorariosEjemplo() {
        ObservableList<HorarioDisplay> horarios = FXCollections.observableArrayList(
            new HorarioDisplay("Lunes", "09:00", "10:00", 15),
            new HorarioDisplay("Lunes", "17:00", "18:00", 8),
            new HorarioDisplay("Martes", "11:00", "12:00", 12),
            new HorarioDisplay("Miércoles", "09:00", "10:00", 10),
            new HorarioDisplay("Jueves", "19:00", "20:00", 5),
            new HorarioDisplay("Viernes", "16:00", "17:00", 20)
        );
        
        tblHorarios.setItems(horarios);
    }
    
    /**
     * Limpia la vista de detalles del servicio
     */
    private void limpiarDetalleServicio() {
        lblNombre.setText("");
        lblTipo.setText("");
        lblDescripcion.setText("");
        lblPrecio.setText("");
        lblCapacidad.setText("");
        tblHorarios.getItems().clear();
    }
    
    /**
     * Busca servicios según el criterio ingresado
     * @param event El evento de acción
     */
    @FXML
    private void buscarServicios(ActionEvent event) {
        String criterio = txtBuscar.getText().toLowerCase().trim();
        String categoria = cbCategoria.getValue();
        
        // Búsqueda simulada - En una implementación real, estos datos vendrían del modelo
        // Expandir todo el árbol para la búsqueda
        expandAllNodes(treeServicios.getRoot());
        
        // Si no hay criterio de búsqueda, mostrar todo
        if (criterio.isEmpty() && "Todos".equals(categoria)) {
            return;
        }
        
        // Filtrar por categoría
        if (!"Todos".equals(categoria)) {
            for (TreeItem<String> item : treeServicios.getRoot().getChildren()) {
                if (!item.getValue().equals(categoria)) {
                    item.setExpanded(false);
                }
            }
        }
        
        // Si hay texto de búsqueda, buscar en los nodos hoja
        if (!criterio.isEmpty()) {
            buscarEnNodos(treeServicios.getRoot(), criterio);
        }
    }
    
    /**
     * Expande todos los nodos del árbol
     * @param item El nodo a expandir
     */
    private void expandAllNodes(TreeItem<String> item) {
        if (item != null && !item.isLeaf()) {
            item.setExpanded(true);
            for (TreeItem<String> child : item.getChildren()) {
                expandAllNodes(child);
            }
        }
    }
    
    /**
     * Busca recursivamente en los nodos del árbol
     * @param item El nodo actual
     * @param criterio El criterio de búsqueda
     * @return true si se encontró una coincidencia en este nodo o sus hijos
     */
    private boolean buscarEnNodos(TreeItem<String> item, String criterio) {
        boolean encontrado = false;
        
        if (item.isLeaf()) {
            // Si es una hoja, verificar si coincide con el criterio
            if (item.getValue().toLowerCase().contains(criterio)) {
                encontrado = true;
            }
        } else {
            // Si no es una hoja, buscar en sus hijos
            for (TreeItem<String> child : item.getChildren()) {
                encontrado |= buscarEnNodos(child, criterio);
            }
            
            // Expandir solo si hay coincidencias en los hijos
            item.setExpanded(encontrado);
        }
        
        return encontrado;
    }
    
    /**
     * Muestra el diálogo para agregar un nuevo servicio
     * @param event El evento de acción
     */
    @FXML
    private void mostrarDialogoAgregarServicio(ActionEvent event) {
        // Implementación para mostrar un diálogo de agregar servicio
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Agregar Servicio");
        alert.setHeaderText("Agregar Nuevo Servicio");
        alert.setContentText("Esta funcionalidad está en desarrollo.");
        alert.showAndWait();
    }
    
    /**
     * Edita el servicio seleccionado actualmente
     * @param event El evento de acción
     */
    @FXML
    private void editarServicioSeleccionado(ActionEvent event) {
        TreeItem<String> selectedItem = treeServicios.getSelectionModel().getSelectedItem();
        if (selectedItem != null && selectedItem.isLeaf() && selectedItem.getParent() != treeServicios.getRoot()) {
            // Implementación para editar el servicio seleccionado
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Editar Servicio");
            alert.setHeaderText("Editar Servicio");
            alert.setContentText("Editando servicio: " + selectedItem.getValue());
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Selección Inválida");
            alert.setHeaderText("No hay servicio seleccionado");
            alert.setContentText("Por favor, seleccione un servicio para editar.");
            alert.showAndWait();
        }
    }
    
    /**
     * Elimina el servicio seleccionado actualmente
     * @param event El evento de acción
     */
    @FXML
    private void eliminarServicioSeleccionado(ActionEvent event) {
        TreeItem<String> selectedItem = treeServicios.getSelectionModel().getSelectedItem();
        if (selectedItem != null && selectedItem.isLeaf() && selectedItem.getParent() != treeServicios.getRoot()) {
            // Confirmar eliminación
            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
            confirmation.setTitle("Confirmar Eliminación");
            confirmation.setHeaderText("Eliminar Servicio");
            confirmation.setContentText("¿Está seguro de que desea eliminar el servicio: " + selectedItem.getValue() + "?");
            
            confirmation.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    // Eliminar el servicio del árbol
                    selectedItem.getParent().getChildren().remove(selectedItem);
                    limpiarDetalleServicio();
                }
            });
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Selección Inválida");
            alert.setHeaderText("No hay servicio seleccionado");
            alert.setContentText("Por favor, seleccione un servicio para eliminar.");
            alert.showAndWait();
        }
    }
    
    /**
     * Inicia el proceso de reserva para el servicio seleccionado
     * @param event El evento de acción
     */
    @FXML
    private void reservarServicio(ActionEvent event) {
        TreeItem<String> selectedItem = treeServicios.getSelectionModel().getSelectedItem();
        if (selectedItem != null && selectedItem.isLeaf() && selectedItem.getParent() != treeServicios.getRoot()) {
            // Implementación para iniciar el proceso de reserva
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Reservar Servicio");
            alert.setHeaderText("Reservar Servicio");
            alert.setContentText("Iniciando reserva para: " + selectedItem.getValue());
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Selección Inválida");
            alert.setHeaderText("No hay servicio seleccionado");
            alert.setContentText("Por favor, seleccione un servicio para reservar.");
            alert.showAndWait();
        }
    }
    
    /**
     * Clase para mostrar horarios en la tabla
     */
    public static class HorarioDisplay {
        private String dia;
        private String horaInicio;
        private String horaFin;
        private int disponibilidad;
        
        public HorarioDisplay(String dia, String horaInicio, String horaFin, int disponibilidad) {
            this.dia = dia;
            this.horaInicio = horaInicio;
            this.horaFin = horaFin;
            this.disponibilidad = disponibilidad;
        }
        
        public String getDia() {
            return dia;
        }
        
        public String getHoraInicio() {
            return horaInicio;
        }
        
        public String getHoraFin() {
            return horaFin;
        }
        
        public int getDisponibilidad() {
            return disponibilidad;
        }
    }
}