package co.edu.uniquindio.practice.preparcialgpt.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Controlador para la vista del Dashboard
 */
public class DashboardController {

    // Controladores para las operaciones de negocio
    private ReservaController reservaController;
    private ClienteController clienteController;
    private ServicioController servicioController;

    @FXML
    private Label lblReservasActivas;
    
    @FXML
    private Label lblIngresosMes;
    
    @FXML
    private Label lblClientesNuevos;
    
    @FXML
    private ComboBox<String> cbPeriodo;
    
    @FXML
    private PieChart chartOcupacion;
    
    @FXML
    private BarChart<String, Number> chartIngresos;
    
    @FXML
    private TableView<ReservaDisplay> tblProximasReservas;
    
    @FXML
    private TableColumn<ReservaDisplay, String> colFecha;
    
    @FXML
    private TableColumn<ReservaDisplay, String> colHora;
    
    @FXML
    private TableColumn<ReservaDisplay, String> colServicio;
    
    @FXML
    private TableColumn<ReservaDisplay, String> colCliente;
    
    @FXML
    private TableColumn<ReservaDisplay, String> colEstado;
    
    // Esta clase interna se usa para mostrar los datos en la tabla de reservas
    public static class ReservaDisplay {
        private String fecha;
        private String hora;
        private String servicio;
        private String cliente;
        private String estado;
        
        public ReservaDisplay(LocalDate fecha, String hora, String servicio, String cliente, String estado) {
            this.fecha = fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            this.hora = hora;
            this.servicio = servicio;
            this.cliente = cliente;
            this.estado = estado;
        }
        
        public String getFecha() {
            return fecha;
        }
        
        public String getHora() {
            return hora;
        }
        
        public String getServicio() {
            return servicio;
        }
        
        public String getCliente() {
            return cliente;
        }
        
        public String getEstado() {
            return estado;
        }
    }
    
    @FXML
    public void initialize() {
        // Inicializar controladores
        clienteController = new ClienteController();
        servicioController = new ServicioController();
        reservaController = new ReservaController(clienteController, servicioController);
        
        // Configuración de ComboBox para periodo
        ObservableList<String> periodos = FXCollections.observableArrayList(
                "Último día", "Última semana", "Último mes", "Último trimestre", "Último año");
        cbPeriodo.setItems(periodos);
        cbPeriodo.setValue("Última semana");
        
        // Configuración de las columnas de la tabla
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        colServicio.setCellValueFactory(new PropertyValueFactory<>("servicio"));
        colCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        
        // Cargar datos iniciales
        actualizarDashboard(null);
    }
    
    /**
     * Actualiza todos los datos del dashboard
     * @param event El evento de acción
     */
    @FXML
    private void actualizarDashboard(ActionEvent event) {
        actualizarIndicadores();
        actualizarGraficos();
        actualizarTablaReservas();
    }
    
    /**
     * Actualiza los indicadores principales del dashboard
     */
    private void actualizarIndicadores() {
        // Estas serían llamadas reales a los controladores para obtener datos
        int reservasActivas = reservaController.contarReservasActivas();
        double ingresosMes = reservaController.calcularIngresosMes();
        int clientesNuevos = clienteController.contarClientesNuevosEnMes();
        
        // Actualizar los labels con los datos obtenidos
        lblReservasActivas.setText(String.valueOf(reservasActivas));
        lblIngresosMes.setText(String.format("$%.2f", ingresosMes));
        lblClientesNuevos.setText(String.valueOf(clientesNuevos));
    }
    
    /**
     * Actualiza los gráficos del dashboard
     */
    private void actualizarGraficos() {
        actualizarGraficoOcupacion();
        actualizarGraficoIngresos();
    }
    
    /**
     * Actualiza el gráfico de ocupación de servicios
     */
    private void actualizarGraficoOcupacion() {
        // Obtener datos de ocupación por servicios
        Map<String, Integer> ocupacionPorServicio = servicioController.obtenerOcupacionPorServicio();
        
        // Crear datos para el gráfico de torta
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (Map.Entry<String, Integer> entry : ocupacionPorServicio.entrySet()) {
            pieChartData.add(new PieChart.Data(entry.getKey(), entry.getValue()));
        }
        
        // Actualizar el gráfico
        chartOcupacion.setData(pieChartData);
        chartOcupacion.setTitle("Ocupación por Servicios");
    }
    
    /**
     * Actualiza el gráfico de ingresos por servicio
     */
    private void actualizarGraficoIngresos() {
        // Obtener datos de ingresos por servicio
        Map<String, Double> ingresosPorServicio = servicioController.obtenerIngresosPorServicio();
        
        // Limpiar series anteriores
        chartIngresos.getData().clear();
        
        // Crear nueva serie de datos
        javafx.scene.chart.XYChart.Series<String, Number> series = new javafx.scene.chart.XYChart.Series<>();
        series.setName("Ingresos por Servicio");
        
        // Añadir datos a la serie
        for (Map.Entry<String, Double> entry : ingresosPorServicio.entrySet()) {
            series.getData().add(new javafx.scene.chart.XYChart.Data<>(entry.getKey(), entry.getValue()));
        }
        
        // Añadir serie al gráfico
        chartIngresos.getData().add(series);
        chartIngresos.setTitle("Ingresos por Servicio");
    }
    
    /**
     * Actualiza la tabla de próximas reservas
     */
    private void actualizarTablaReservas() {
        // En un entorno real, obtendríamos las reservas del controlador
        // reservaController.obtenerProximasReservas();
        
        // Por ahora usamos datos simulados directamente
        List<ReservaDisplay> reservasDisplay = new ArrayList<>();
        
        // Datos simulados para mostrar en la tabla
        reservasDisplay.add(new ReservaDisplay(LocalDate.now(), "10:00", "Yoga", "Ana García", "Confirmada"));
        reservasDisplay.add(new ReservaDisplay(LocalDate.now(), "16:30", "Spinning", "Carlos López", "Pendiente"));
        reservasDisplay.add(new ReservaDisplay(LocalDate.now().plusDays(1), "09:15", "Pilates", "María Rodríguez", "Confirmada"));
        reservasDisplay.add(new ReservaDisplay(LocalDate.now().plusDays(1), "18:00", "Musculación", "Juan Pérez", "Confirmada"));
        reservasDisplay.add(new ReservaDisplay(LocalDate.now().plusDays(2), "11:30", "Masajes", "Laura Martín", "Pendiente"));
        
        // Actualizar la tabla con las reservas convertidas
        tblProximasReservas.setItems(FXCollections.observableArrayList(reservasDisplay));
    }
}