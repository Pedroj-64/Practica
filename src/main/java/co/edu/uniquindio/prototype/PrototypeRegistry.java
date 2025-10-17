package co.edu.uniquindio.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que implementa un registro de prototipos.
 * 
 * Esta clase almacena prototipos (objetos que implementan Cloneable) por nombre
 * y permite recuperar clones de estos prototipos.
 * 
 * Es útil cuando tienes un conjunto de objetos preconfigurados que quieres usar
 * como base para crear nuevos objetos.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class PrototypeRegistry {
    
    private Map<String, Prototype> prototipos;
    
    /**
     * Constructor.
     */
    public PrototypeRegistry() {
        this.prototipos = new HashMap<>();
    }
    
    /**
     * Método para registrar un prototipo.
     * 
     * @param nombre El nombre con el que se registrará el prototipo
     * @param prototipo El objeto prototipo a registrar
     */
    public void registrarPrototipo(String nombre, Prototype prototipo) {
        prototipos.put(nombre, prototipo);
    }
    
    /**
     * Método para obtener un clon de un prototipo registrado.
     * 
     * @param nombre El nombre del prototipo a clonar
     * @return Un clon del prototipo solicitado o null si no existe
     */
    public Prototype obtenerClon(String nombre) {
        Prototype prototipo = prototipos.get(nombre);
        if (prototipo == null) {
            return null;
        }
        
        return (Prototype) prototipo.clone();
    }
    
    /**
     * Método para eliminar un prototipo registrado.
     * 
     * @param nombre El nombre del prototipo a eliminar
     */
    public void eliminarPrototipo(String nombre) {
        prototipos.remove(nombre);
    }
    
    /**
     * Método para obtener la cantidad de prototipos registrados.
     * 
     * @return El número de prototipos registrados
     */
    public int cantidadPrototipos() {
        return prototipos.size();
    }
    
    /**
     * Método para verificar si existe un prototipo con el nombre especificado.
     * 
     * @param nombre El nombre del prototipo a verificar
     * @return true si existe, false en caso contrario
     */
    public boolean existePrototipo(String nombre) {
        return prototipos.containsKey(nombre);
    }
    
    /**
     * Método para obtener los nombres de todos los prototipos registrados.
     * 
     * @return Un conjunto con los nombres de los prototipos
     */
    public Iterable<String> obtenerNombresPrototipos() {
        return prototipos.keySet();
    }
}