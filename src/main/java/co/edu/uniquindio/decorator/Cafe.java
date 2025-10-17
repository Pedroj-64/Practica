package co.edu.uniquindio.decorator;

/**
 * Interfaz Componente (Component) en el patrón Decorator.
 * Define la interfaz para los objetos a los que se les puede añadir responsabilidades.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public interface Cafe {
    
    /**
     * Obtiene la descripción del café.
     * 
     * @return Descripción del café
     */
    String getDescripcion();
    
    /**
     * Calcula el costo del café.
     * 
     * @return Costo del café
     */
    double costo();
}