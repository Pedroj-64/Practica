package co.edu.uniquindio.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase compuesta (Composite) en el patrón Composite.
 * Representa un directorio que puede contener archivos y otros directorios.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class Directorio extends ComponenteArchivo {
    
    private List<ComponenteArchivo> hijos;
    
    /**
     * Constructor para Directorio.
     * 
     * @param nombre El nombre del directorio
     * @param ruta La ruta del directorio
     */
    public Directorio(String nombre, String ruta) {
        super(nombre, "", ruta); // Un directorio no tiene extensión
        this.hijos = new ArrayList<>();
    }
    
    @Override
    public void mostrar(int indentacion) {
        String indent = getIndentacion(indentacion);
        System.out.println(indent + "📁 " + nombre + " (" + calcularTamanio() + " total)");
        
        // Mostrar todos los componentes hijos con un nivel más de indentación
        for (ComponenteArchivo componente : hijos) {
            componente.mostrar(indentacion + 1);
        }
    }
    
    @Override
    public long calcularTamanio() {
        long tamanioTotal = 0;
        
        // Sumar el tamaño de todos los hijos
        for (ComponenteArchivo componente : hijos) {
            tamanioTotal += componente.calcularTamanio();
        }
        
        return tamanioTotal;
    }
    
    @Override
    public void agregar(ComponenteArchivo componente) {
        hijos.add(componente);
    }
    
    @Override
    public void eliminar(ComponenteArchivo componente) {
        hijos.remove(componente);
    }
    
    @Override
    public ComponenteArchivo obtenerHijo(int indice) {
        if (indice >= 0 && indice < hijos.size()) {
            return hijos.get(indice);
        } else {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
    }
    
    /**
     * Obtiene la lista de todos los componentes hijos.
     * 
     * @return Lista de componentes hijos
     */
    public List<ComponenteArchivo> getHijos() {
        return new ArrayList<>(hijos); // Devuelve una copia para evitar modificaciones directas
    }
    
    /**
     * Cuenta el número de componentes hijos directos.
     * 
     * @return Número de componentes hijos
     */
    public int contarHijos() {
        return hijos.size();
    }
    
    /**
     * Busca un componente por nombre en este directorio (no recursivo).
     * 
     * @param nombreBuscado El nombre a buscar
     * @return El componente encontrado o null si no existe
     */
    public ComponenteArchivo buscarPorNombre(String nombreBuscado) {
        for (ComponenteArchivo componente : hijos) {
            if (componente.getNombreCompleto().equals(nombreBuscado)) {
                return componente;
            }
        }
        return null;
    }
}