package co.edu.uniquindio.practice.preparcial.interfaces;

import co.edu.uniquindio.practice.preparcial.model.HorarioDTO;
import java.util.List;

/**
 * Interfaz objetivo (Target) en el patrón Adapter
 * Define el contrato que el sistema espera para obtener horarios
 */
public interface ProveedorHorarioPort {
    /**
     * Método para cargar horarios desde cualquier fuente de datos
     * @return Lista de horarios
     */
    List<HorarioDTO> cargarHorarios();
}