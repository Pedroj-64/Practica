package co.edu.uniquindio.decorator;

/**
 * Decorador concreto (ConcreteDecorator) en el patrón Decorator.
 * Añade funcionalidad para agregar crema batida al café.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class CremaBatidaDecorator extends CafeDecorator {
    
    /**
     * Constructor para CremaBatidaDecorator.
     * 
     * @param cafeDecorado El café que va a ser decorado con crema batida
     */
    public CremaBatidaDecorator(Cafe cafeDecorado) {
        super(cafeDecorado);
    }
    
    @Override
    public String getDescripcion() {
        return cafeDecorado.getDescripcion() + " con Crema Batida";
    }
    
    @Override
    public double costo() {
        return cafeDecorado.costo() + 1.00;
    }
    
    /**
     * Método específico del decorador CremaBatidaDecorator.
     * Indica la cantidad de crema batida añadida.
     * 
     * @return Cantidad de crema batida en gramos
     */
    public int getCantidadCrema() {
        return 30; // gramos
    }
}