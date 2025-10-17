package co.edu.uniquindio.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que representa una persona y extiende de Prototype para implementar
 * el patrón de diseño Prototype.
 * 
 * Esta clase demuestra cómo manejar referencias a objetos complejos durante
 * el proceso de clonación.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class Persona extends Prototype {
    
    private String nombre;
    private int edad;
    private String direccion;
    private Map<String, String> atributos;
    private Vehiculo vehiculoPrincipal;
    
    /**
     * Constructor por defecto.
     */
    public Persona() {
        this.atributos = new HashMap<>();
    }
    
    /**
     * Constructor con parámetros.
     * 
     * @param nombre El nombre de la persona
     * @param edad La edad de la persona
     * @param direccion La dirección de la persona
     */
    public Persona(String nombre, int edad, String direccion) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.atributos = new HashMap<>();
    }
    
    /**
     * Sobreescribe el método clone para realizar una clonación profunda (deep copy)
     * del objeto Persona, incluyendo el mapa de atributos y el vehículo.
     * 
     * @return Un clon de la persona actual
     */
    @Override
    public Object clone() {
        // Primero obtenemos un clon utilizando el método de la clase padre (copia superficial)
        Persona persona = (Persona) super.clone();
        
        // Realizamos una copia profunda del mapa de atributos
        Map<String, String> atributosClonados = new HashMap<>(this.atributos);
        persona.setAtributos(atributosClonados);
        
        // Realizamos una copia profunda del vehículo si existe
        if (this.vehiculoPrincipal != null) {
            persona.setVehiculoPrincipal((Vehiculo) this.vehiculoPrincipal.clone());
        }
        
        return persona;
    }
    
    /**
     * Método para agregar un atributo a la persona.
     * 
     * @param clave La clave del atributo
     * @param valor El valor del atributo
     */
    public void agregarAtributo(String clave, String valor) {
        this.atributos.put(clave, valor);
    }
    
    /**
     * Método para mostrar los detalles de la persona.
     * 
     * @return Una cadena con los detalles de la persona
     */
    public String mostrarDetalles() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona: ").append(nombre).append("\n");
        sb.append("Edad: ").append(edad).append("\n");
        sb.append("Dirección: ").append(direccion).append("\n");
        
        sb.append("Atributos:\n");
        for (Map.Entry<String, String> entrada : atributos.entrySet()) {
            sb.append("- ").append(entrada.getKey()).append(": ").append(entrada.getValue()).append("\n");
        }
        
        if (vehiculoPrincipal != null) {
            sb.append("\nVehículo Principal:\n");
            sb.append(vehiculoPrincipal.mostrarDetalles());
        }
        
        return sb.toString();
    }
    
    // Getters y setters
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public Map<String, String> getAtributos() {
        return atributos;
    }
    
    public void setAtributos(Map<String, String> atributos) {
        this.atributos = atributos;
    }
    
    public Vehiculo getVehiculoPrincipal() {
        return vehiculoPrincipal;
    }
    
    public void setVehiculoPrincipal(Vehiculo vehiculoPrincipal) {
        this.vehiculoPrincipal = vehiculoPrincipal;
    }
}