package co.edu.uniquindio.decorator;

/**
 * Decorador concreto (ConcreteDecorator) en el patrón Decorator.
 * Añade funcionalidad para agregar chocolate al café.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class ChocolateDecorator extends CafeDecorator {
    
    /**
     * Constructor para ChocolateDecorator.
     * 
     * @param cafeDecorado El café que va a ser decorado con chocolate
     */
    public ChocolateDecorator(Cafe cafeDecorado) {
        super(cafeDecorado);
    }
    
    @Override
    public String getDescripcion() {
        return cafeDecorado.getDescripcion() + " con Chocolate";
    }
    
    @Override
    public double costo() {
        return cafeDecorado.costo() + 1.20;
    }
    
    /**
     * Método específico del decorador ChocolateDecorator.
     * Añade extra de chocolate al café.
     * 
     * @return Mensaje indicando que se añadió chocolate extra
     */
    public String anadirExtraChocolate() {
        return "Añadiendo una cucharada extra de chocolate";
    }
}