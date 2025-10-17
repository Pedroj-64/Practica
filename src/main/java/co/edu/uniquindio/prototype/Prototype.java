package co.edu.uniquindio.prototype;

/**
 * Clase abstracta que implementa la interfaz Cloneable para servir como base
 * para todos los objetos que utilizarán el patrón Prototype.
 * 
 * La interfaz Cloneable de Java es una interfaz de marcado que indica que un objeto
 * permite ser clonado utilizando el método clone() heredado de la clase Object.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public abstract class Prototype implements Cloneable {
    
    /**
     * Sobreescribe el método clone() de la clase Object para hacer público el método
     * y para manejar la excepción CloneNotSupportedException.
     * 
     * @return Un clon del objeto actual
     */
    @Override
    public Object clone() {
        Object clone = null;
        
        try {
            // Llamamos al método clone() de la clase Object que realiza una copia superficial
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            // Esta excepción no debería ocurrir ya que implementamos Cloneable
            e.printStackTrace();
        }
        
        return clone;
    }
}