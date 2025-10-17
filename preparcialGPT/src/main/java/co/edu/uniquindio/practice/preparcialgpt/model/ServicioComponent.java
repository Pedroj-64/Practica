package co.edu.uniquindio.practice.preparcialgpt.model;

import java.util.List;

/**
 * Interfaz componente para el patrón Composite de servicios
 */
public interface ServicioComponent {
    String getNombre();
    String getDescripcion();
    double getPrecio();
    int getCapacidad();
    List<String> getHorarios();
    void agregarHorario(String horario);
    void eliminarHorario(String horario);
}