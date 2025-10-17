package co.edu.uniquindio.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un vehículo y extiende de Prototype para implementar
 * el patrón de diseño Prototype.
 * 
 * Esta clase muestra tanto la clonación superficial (shallow copy) como
 * la clonación profunda (deep copy) de objetos.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class Vehiculo extends Prototype {
    
    private String marca;
    private String modelo;
    private int año;
    private String color;
    private List<String> caracteristicas;
    
    /**
     * Constructor por defecto.
     */
    public Vehiculo() {
        this.caracteristicas = new ArrayList<>();
    }
    
    /**
     * Constructor con parámetros.
     * 
     * @param marca La marca del vehículo
     * @param modelo El modelo del vehículo
     * @param año El año del vehículo
     * @param color El color del vehículo
     */
    public Vehiculo(String marca, String modelo, int año, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.color = color;
        this.caracteristicas = new ArrayList<>();
    }
    
    /**
     * Sobreescribe el método clone para realizar una clonación profunda (deep copy)
     * del objeto Vehiculo, incluyendo la lista de características.
     * 
     * @return Un clon del vehículo actual
     */
    @Override
    public Object clone() {
        // Primero obtenemos un clon utilizando el método de la clase padre (copia superficial)
        Vehiculo vehiculo = (Vehiculo) super.clone();
        
        // Realizamos una copia profunda de la lista de características
        List<String> caracteristicasClonadas = new ArrayList<>(this.caracteristicas);
        vehiculo.setCaracteristicas(caracteristicasClonadas);
        
        return vehiculo;
    }
    
    /**
     * Método para agregar una característica al vehículo.
     * 
     * @param caracteristica La característica a agregar
     */
    public void agregarCaracteristica(String caracteristica) {
        this.caracteristicas.add(caracteristica);
    }
    
    /**
     * Método para mostrar los detalles del vehículo.
     * 
     * @return Una cadena con los detalles del vehículo
     */
    public String mostrarDetalles() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehículo: ").append(marca).append(" ").append(modelo).append("\n");
        sb.append("Año: ").append(año).append("\n");
        sb.append("Color: ").append(color).append("\n");
        sb.append("Características:\n");
        
        for (String caracteristica : caracteristicas) {
            sb.append("- ").append(caracteristica).append("\n");
        }
        
        return sb.toString();
    }
    
    // Getters y setters
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public int getAño() {
        return año;
    }
    
    public void setAño(int año) {
        this.año = año;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public List<String> getCaracteristicas() {
        return caracteristicas;
    }
    
    public void setCaracteristicas(List<String> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}