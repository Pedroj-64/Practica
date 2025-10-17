package co.edu.uniquindio.factory;

/**
 * Interfaz para la fábrica de transportes que define el método de fábrica.
 * 
 * Esta interfaz define el contrato para las fábricas concretas que crearán
 * diferentes tipos de transportes.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public interface TransporteFactory {
    
    /**
     * Método de fábrica para crear un nuevo transporte.
     * 
     * @return Un objeto de tipo Transporte
     */
    Transporte crearTransporte();
    
    /**
     * Método para obtener una descripción del tipo de fábrica.
     * 
     * @return Una descripción de la fábrica
     */
    String getDescripcion();
}