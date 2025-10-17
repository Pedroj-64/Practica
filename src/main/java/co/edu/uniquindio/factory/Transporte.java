package co.edu.uniquindio.factory;

/**
 * Interfaz de Producto que define el comportamiento común para todos los productos
 * creados por las fábricas concretas.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public interface Transporte {
    
    /**
     * Método que define la operación para entregar un paquete.
     * 
     * @param paquete El paquete a entregar
     * @return Un mensaje describiendo cómo se entregó el paquete
     */
    String entregar(String paquete);
    
    /**
     * Método que calcula el costo de envío basado en la distancia.
     * 
     * @param distanciaKm La distancia en kilómetros
     * @return El costo del envío
     */
    double calcularCosto(double distanciaKm);
    
    /**
     * Método que retorna el tiempo estimado de entrega basado en la distancia.
     * 
     * @param distanciaKm La distancia en kilómetros
     * @return El tiempo estimado en horas
     */
    double tiempoEstimado(double distanciaKm);
    
    /**
     * Método que retorna el tipo de transporte.
     * 
     * @return El tipo de transporte
     */
    String getTipo();
}