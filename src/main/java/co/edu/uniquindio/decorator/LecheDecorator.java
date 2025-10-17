package co.edu.uniquindio.decorator;

/**
 * Decorador concreto (ConcreteDecorator) en el patrón Decorator.
 * Añade funcionalidad para agregar leche al café.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class LecheDecorator extends CafeDecorator {
    
    /**
     * Constructor para LecheDecorator.
     * 
     * @param cafeDecorado El café que va a ser decorado con leche
     */
    public LecheDecorator(Cafe cafeDecorado) {
        super(cafeDecorado);
    }
    
    @Override
    public String getDescripcion() {
        return cafeDecorado.getDescripcion() + " con Leche";
    }
    
    @Override
    public double costo() {
        return cafeDecorado.costo() + 0.80;
    }
    
    /**
     * Método específico del decorador LecheDecorator.
     * Indica el tipo de leche utilizada.
     * 
     * @return El tipo de leche
     */
    public String getTipoLeche() {
        return "Leche entera";
    }
}