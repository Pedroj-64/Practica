package co.edu.uniquindio.practice.preparcialgpt.model.composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Clase abstracta para los servicios elementales (hojas) del patrón Composite
 */
public abstract class ServicioBase implements ServiceComponent {
    
    protected String nombre;
    protected String descripcion;
    protected double precioBase;
    protected List<String> etiquetas;
    
    public ServicioBase(String nombre, String descripcion, double precioBase) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.etiquetas = new ArrayList<>();
    }
    
    public ServicioBase(String nombre, String descripcion, double precioBase, String... etiquetas) {
        this(nombre, descripcion, precioBase);
        this.etiquetas.addAll(Arrays.asList(etiquetas));
    }

    @Override
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public double getPrecioBase() {
        return precioBase;
    }
    
    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    @Override
    public double calcularPrecio() {
        // Por defecto, devuelve el precio base sin modificaciones
        return precioBase;
    }

    @Override
    public List<ServiceComponent> listarHojas() {
        // Una hoja simplemente se devuelve a sí misma
        return Collections.singletonList(this);
    }

    @Override
    public boolean contiene(String textoBusqueda) {
        if (textoBusqueda == null || textoBusqueda.trim().isEmpty()) {
            return false;
        }
        
        String textoLower = textoBusqueda.toLowerCase();
        
        // Busca en nombre, descripción y etiquetas
        if (nombre.toLowerCase().contains(textoLower)) {
            return true;
        }
        
        if (descripcion.toLowerCase().contains(textoLower)) {
            return true;
        }
        
        // Busca en etiquetas
        for (String etiqueta : etiquetas) {
            if (etiqueta.toLowerCase().contains(textoLower)) {
                return true;
            }
        }
        
        return false;
    }

    @Override
    public List<String> getEtiquetas() {
        return new ArrayList<>(etiquetas);
    }
    
    public void agregarEtiqueta(String etiqueta) {
        if (etiqueta != null && !etiqueta.trim().isEmpty()) {
            etiquetas.add(etiqueta);
        }
    }
    
    public void eliminarEtiqueta(String etiqueta) {
        etiquetas.remove(etiqueta);
    }
    
    @Override
    public String toString() {
        return nombre + " - $" + precioBase;
    }
}