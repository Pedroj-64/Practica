package co.edu.uniquindio.decorator;

/**
 * Componente concreto (ConcreteComponent) en el patrón Decorator.
 * Implementa la interfaz Cafe para un tipo de café específico: Descafeinado.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class DescafeinadoCafe implements Cafe {
    
    @Override
    public String getDescripcion() {
        return "Café Descafeinado";
    }
    
    @Override
    public double costo() {
        return 3.00;
    }
}