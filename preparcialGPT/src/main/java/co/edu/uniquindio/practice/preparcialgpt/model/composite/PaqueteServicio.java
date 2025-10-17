package co.edu.uniquindio.practice.preparcialgpt.model.composite;

import java.util.*;

/**
 * Implementación del componente compuesto del patrón Composite para los servicios
 * Permite agrupar servicios en paquetes
 */
public class PaqueteServicio implements ServiceComponent {
    
    private String nombre;
    private String descripcion;
    private List<ServiceComponent> servicios;
    private double factorDescuento;
    private List<String> etiquetas;
    
    public PaqueteServicio(String nombre, String descripcion, double factorDescuento) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.servicios = new ArrayList<>();
        this.factorDescuento = factorDescuento;
        this.etiquetas = new ArrayList<>();
    }
    
    public PaqueteServicio(String nombre, String descripcion, double factorDescuento, String... etiquetas) {
        this(nombre, descripcion, factorDescuento);
        this.etiquetas.addAll(Arrays.asList(etiquetas));
    }
    
    /**
     * Agrega un servicio al paquete
     * @param servicio Servicio a agregar
     */
    public void agregarServicio(ServiceComponent servicio) {
        if (servicio != null) {
            servicios.add(servicio);
        }
    }
    
    /**
     * Elimina un servicio del paquete
     * @param servicio Servicio a eliminar
     * @return true si se eliminó correctamente, false en caso contrario
     */
    public boolean eliminarServicio(ServiceComponent servicio) {
        return servicios.remove(servicio);
    }
    
    /**
     * Ordena los servicios del paquete por nombre de forma ascendente
     */
    public void ordenarPorNombreAsc() {
        servicios.sort(Comparator.comparing(ServiceComponent::getNombre));
    }
    
    /**
     * Ordena los servicios del paquete por precio de forma ascendente
     */
    public void ordenarPorPrecioAsc() {
        servicios.sort(Comparator.comparingDouble(ServiceComponent::getPrecioBase));
    }
    
    /**
     * Ordena los servicios del paquete por precio de forma descendente
     */
    public void ordenarPorPrecioDesc() {
        servicios.sort(Comparator.comparingDouble(ServiceComponent::getPrecioBase).reversed());
    }
    
    /**
     * Filtra los servicios del paquete que estén por debajo de un precio máximo
     * @param precioMaximo El precio máximo para filtrar
     * @return Lista de servicios que cumplen el criterio
     */
    public List<ServiceComponent> filtrarPorPrecioMaximo(double precioMaximo) {
        List<ServiceComponent> resultado = new ArrayList<>();
        for (ServiceComponent servicio : servicios) {
            if (servicio.getPrecioBase() <= precioMaximo) {
                resultado.add(servicio);
            }
        }
        return resultado;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public double getPrecioBase() {
        // El precio base es la suma de los precios base de todos los servicios
        return servicios.stream()
                .mapToDouble(ServiceComponent::getPrecioBase)
                .sum();
    }

    @Override
    public double calcularPrecio() {
        // El precio final incluye el descuento del paquete
        double precioTotal = servicios.stream()
                .mapToDouble(ServiceComponent::calcularPrecio)
                .sum();
        
        return precioTotal * (1 - factorDescuento);
    }

    @Override
    public List<ServiceComponent> listarHojas() {
        List<ServiceComponent> hojas = new ArrayList<>();
        for (ServiceComponent servicio : servicios) {
            hojas.addAll(servicio.listarHojas());
        }
        return hojas;
    }

    @Override
    public boolean contiene(String textoBusqueda) {
        if (textoBusqueda == null || textoBusqueda.trim().isEmpty()) {
            return false;
        }
        
        String textoLower = textoBusqueda.toLowerCase();
        
        // Busca en nombre y descripción del paquete
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
        
        // Busca en los servicios contenidos
        for (ServiceComponent servicio : servicios) {
            if (servicio.contiene(textoLower)) {
                return true;
            }
        }
        
        return false;
    }

    @Override
    public String getDescripcion() {
        StringBuilder sb = new StringBuilder();
        sb.append(descripcion).append("\n\nIncluye los siguientes servicios:\n");
        
        for (ServiceComponent servicio : servicios) {
            sb.append("- ").append(servicio.getNombre()).append("\n");
        }
        
        sb.append("\nDescuento aplicado: ").append(factorDescuento * 100).append("%");
        
        return sb.toString();
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
    
    public double getFactorDescuento() {
        return factorDescuento;
    }

    public void setFactorDescuento(double factorDescuento) {
        this.factorDescuento = factorDescuento;
    }
    
    public List<ServiceComponent> getServicios() {
        return Collections.unmodifiableList(servicios);
    }
    
    @Override
    public String toString() {
        return nombre + " - Paquete con " + servicios.size() + " servicios";
    }
}