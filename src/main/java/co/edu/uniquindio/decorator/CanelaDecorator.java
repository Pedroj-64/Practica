package co.edu.uniquindio.decorator;

/**
 * Decorador concreto (ConcreteDecorator) en el patrón Decorator.
 * Añade funcionalidad para agregar canela al café.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class CanelaDecorator extends CafeDecorator {
    
    /**
     * Constructor para CanelaDecorator.
     * 
     * @param cafeDecorado El café que va a ser decorado con canela
     */
    public CanelaDecorator(Cafe cafeDecorado) {
        super(cafeDecorado);
    }
    
    @Override
    public String getDescripcion() {
        return cafeDecorado.getDescripcion() + " con Canela";
    }
    
    @Override
    public double costo() {
        return cafeDecorado.costo() + 0.50;
    }
    
    /**
     * Método específico del decorador CanelaDecorator.
     * Indica si la canela es orgánica.
     * 
     * @return true si la canela es orgánica, false en caso contrario
     */
    public boolean esOrganica() {
        return true;
    }
}