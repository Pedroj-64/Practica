package co.edu.uniquindio.decorator;

/**
 * Decorador abstracto (Decorator) en el patrón Decorator.
 * Implementa la interfaz Cafe y mantiene una referencia a un objeto Cafe.
 * Sirve como base para todos los decoradores concretos.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public abstract class CafeDecorator implements Cafe {
    
    // Componente que va a ser decorado
    protected Cafe cafeDecorado;
    
    /**
     * Constructor para CafeDecorator.
     * 
     * @param cafeDecorado El café que va a ser decorado
     */
    public CafeDecorator(Cafe cafeDecorado) {
        this.cafeDecorado = cafeDecorado;
    }
    
    @Override
    public String getDescripcion() {
        // Por defecto, delega al componente decorado
        return cafeDecorado.getDescripcion();
    }
    
    @Override
    public double costo() {
        // Por defecto, delega al componente decorado
        return cafeDecorado.costo();
    }
}