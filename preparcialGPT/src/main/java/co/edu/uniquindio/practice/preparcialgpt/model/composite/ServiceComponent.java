package co.edu.uniquindio.practice.preparcialgpt.model.composite;

import java.util.List;

/**
 * Interfaz base para el patrón Composite de servicios
 */
public interface ServiceComponent {
    
    /**
     * Obtiene el nombre del servicio
     * @return Nombre del servicio
     */
    String getNombre();
    
    /**
     * Obtiene el precio base del servicio
     * @return Precio base
     */
    double getPrecioBase();
    
    /**
     * Calcula el precio final del servicio considerando descuentos o recargos
     * @return Precio final
     */
    double calcularPrecio();
    
    /**
     * Lista todos los servicios elementales (hojas) contenidas en este componente
     * @return Lista de servicios elementales
     */
    List<ServiceComponent> listarHojas();
    
    /**
     * Verifica si el componente contiene un servicio con el nombre dado
     * @param textoBusqueda Texto a buscar en el nombre del servicio
     * @return true si hay coincidencia, false en caso contrario
     */
    boolean contiene(String textoBusqueda);
    
    /**
     * Devuelve la descripción detallada del servicio
     * @return Descripción del servicio
     */
    String getDescripcion();
    
    /**
     * Obtiene las etiquetas asociadas al servicio para búsquedas
     * @return Lista de etiquetas
     */
    List<String> getEtiquetas();
}