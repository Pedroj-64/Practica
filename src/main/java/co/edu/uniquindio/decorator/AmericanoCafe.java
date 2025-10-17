package co.edu.uniquindio.decorator;

/**
 * Componente concreto (ConcreteComponent) en el patrón Decorator.
 * Implementa la interfaz Cafe para un tipo de café específico: Americano.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class AmericanoCafe implements Cafe {
    
    @Override
    public String getDescripcion() {
        return "Café Americano";
    }
    
    @Override
    public double costo() {
        return 2.50;
    }
}