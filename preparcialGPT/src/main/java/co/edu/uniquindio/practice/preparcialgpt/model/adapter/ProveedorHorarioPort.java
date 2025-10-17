package co.edu.uniquindio.practice.preparcialgpt.model.adapter;

import co.edu.uniquindio.practice.preparcialgpt.model.dto.HorarioDTO;

import java.util.List;

/**
 * Interfaz (puerto) que define el comportamiento esperado para obtener horarios
 * Target en el patrón Adapter
 */
public interface ProveedorHorarioPort {
    
    /**
     * Carga los horarios desde la fuente de datos
     * @return Lista de horarios disponibles
     */
    List<HorarioDTO> cargarHorarios();
    
    /**
     * Verifica si un horario está disponible
     * @param idServicio ID del servicio
     * @param fechaStr Fecha y hora en formato de texto
     * @return true si está disponible, false en caso contrario
     */
    boolean verificarDisponibilidad(String idServicio, String fechaStr);
    
    /**
     * Obtiene los errores encontrados durante la carga de datos
     * @return Lista de mensajes de error
     */
    List<String> getErrores();
    
    /**
     * Obtiene un resumen de la información cargada
     * @return String con el resumen
     */
    String getResumenCarga();
}