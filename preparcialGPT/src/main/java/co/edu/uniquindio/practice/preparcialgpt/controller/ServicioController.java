package co.edu.uniquindio.practice.preparcialgpt.controller;

import co.edu.uniquindio.practice.preparcialgpt.model.composite.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Controlador para la gestión de servicios
 */
public class ServicioController {
    
    private final Map<String, ServiceComponent> servicios;
    private final PaqueteServicio catalogoRaiz;
    
    public ServicioController() {
        servicios = new HashMap<>();
        catalogoRaiz = new PaqueteServicio("Catálogo FitHub+", "Catálogo completo de servicios", 0);
        
        // Cargar servicios de ejemplo
        cargarServiciosEjemplo();
    }
    
    /**
     * Carga servicios de ejemplo para demostración
     */
    private void cargarServiciosEjemplo() {
        // Clases dirigidas
        ClaseDirigida yoga = new ClaseDirigida("Yoga", "Clase de yoga para todos los niveles", 25000,
                "Ana Martínez", 60, 15, "bienestar", "flexibilidad", "relajación");
        
        ClaseDirigida spinning = new ClaseDirigida("Spinning", "Clase de spinning de alta intensidad", 30000,
                "Carlos López", 45, 20, "cardio", "resistencia", "intensidad");
        
        ClaseDirigida zumba = new ClaseDirigida("Zumba", "Baile y ejercicio al ritmo de la música", 28000,
                "María García", 50, 25, "baile", "cardio", "diversión");
        
        // Zonas
        Zona musculacion = new Zona("Sala de Musculación", "Zona con máquinas y pesas", 35000,
                "Piso 2", 50, true, "fuerza", "hipertrofia");
        
        Zona funcional = new Zona("Entrenamiento Funcional", "Área para entrenamiento funcional", 32000,
                "Piso 1", 30, false, "flexibilidad", "fuerza", "coordinación");
        
        // Spa
        Spa masaje = new Spa("Masaje Relajante", "Masaje para reducir el estrés y la tensión muscular", 50000,
                "Relajante", 60, true, "relajación", "bienestar");
        
        Spa sauna = new Spa("Sauna Finlandesa", "Sauna tradicional con calor seco", 35000,
                "Calor seco", 30, false, "desintoxicación", "relajación");
        
        // Paquetes
        PaqueteServicio paqueteBienestar = new PaqueteServicio("Combo Bienestar", 
                "Paquete completo para el bienestar físico y mental", 0.15, "bienestar", "completo");
        paqueteBienestar.agregarServicio(yoga);
        paqueteBienestar.agregarServicio(masaje);
        
        PaqueteServicio paqueteDeportista = new PaqueteServicio("Combo Deportista", 
                "Paquete ideal para deportistas", 0.10, "deporte", "rendimiento");
        paqueteDeportista.agregarServicio(spinning);
        paqueteDeportista.agregarServicio(musculacion);
        
        // Agregar servicios y paquetes al mapa y al catálogo raíz
        agregarServicioAlMapa(yoga);
        agregarServicioAlMapa(spinning);
        agregarServicioAlMapa(zumba);
        agregarServicioAlMapa(musculacion);
        agregarServicioAlMapa(funcional);
        agregarServicioAlMapa(masaje);
        agregarServicioAlMapa(sauna);
        agregarServicioAlMapa(paqueteBienestar);
        agregarServicioAlMapa(paqueteDeportista);
        
        // Agregar todos al catálogo raíz
        catalogoRaiz.agregarServicio(yoga);
        catalogoRaiz.agregarServicio(spinning);
        catalogoRaiz.agregarServicio(zumba);
        catalogoRaiz.agregarServicio(musculacion);
        catalogoRaiz.agregarServicio(funcional);
        catalogoRaiz.agregarServicio(masaje);
        catalogoRaiz.agregarServicio(sauna);
        catalogoRaiz.agregarServicio(paqueteBienestar);
        catalogoRaiz.agregarServicio(paqueteDeportista);
    }
    
    private void agregarServicioAlMapa(ServiceComponent servicio) {
        servicios.put(servicio.getNombre(), servicio);
    }
    
    /**
     * Obtiene la ocupación por servicio
     * @return Mapa con nombre de servicio como clave y cantidad de reservas como valor
     */
    public Map<String, Integer> obtenerOcupacionPorServicio() {
        // Simulamos obtener datos desde la base de datos o servicio
        Map<String, Integer> ocupacion = new HashMap<>();
        
        // Datos de demostración
        ocupacion.put("Yoga", 30);
        ocupacion.put("Pilates", 15);
        ocupacion.put("Spinning", 25);
        ocupacion.put("Musculación", 20);
        ocupacion.put("Spa", 10);
        
        return ocupacion;
    }

    /**
     * Obtiene los ingresos por servicio
     * @return Mapa con nombre de servicio como clave y total de ingresos como valor
     */
    public Map<String, Double> obtenerIngresosPorServicio() {
        // Simulamos obtener datos desde la base de datos o servicio
        Map<String, Double> ingresos = new HashMap<>();
        
        // Datos de demostración
        ingresos.put("Yoga", 850000.0);
        ingresos.put("Pilates", 650000.0);
        ingresos.put("Spinning", 780000.0);
        ingresos.put("Musculación", 920000.0);
        ingresos.put("Spa", 1250000.0);
        
        return ingresos;
    }
    
    /**
     * Agrega una nueva clase dirigida
     * @param nombre Nombre de la clase
     * @param descripcion Descripción detallada
     * @param precioBase Precio base
     * @param instructor Nombre del instructor
     * @param duracionMinutos Duración en minutos
     * @param capacidadMaxima Capacidad máxima de participantes
     * @param etiquetas Etiquetas para búsqueda
     * @return Servicio creado
     */
    public ServiceComponent agregarClaseDirigida(String nombre, String descripcion, double precioBase,
                                              String instructor, int duracionMinutos, int capacidadMaxima,
                                              String... etiquetas) {
        ClaseDirigida clase = new ClaseDirigida(nombre, descripcion, precioBase,
                instructor, duracionMinutos, capacidadMaxima, etiquetas);
        
        agregarServicioAlMapa(clase);
        catalogoRaiz.agregarServicio(clase);
        
        return clase;
    }
    
    /**
     * Agrega una nueva zona
     * @param nombre Nombre de la zona
     * @param descripcion Descripción detallada
     * @param precioBase Precio base
     * @param ubicacion Ubicación dentro del centro
     * @param aforoMaximo Capacidad máxima
     * @param requiereInduccion Si requiere inducción previa
     * @param etiquetas Etiquetas para búsqueda
     * @return Servicio creado
     */
    public ServiceComponent agregarZona(String nombre, String descripcion, double precioBase,
                                     String ubicacion, int aforoMaximo, boolean requiereInduccion,
                                     String... etiquetas) {
        Zona zona = new Zona(nombre, descripcion, precioBase, ubicacion, aforoMaximo, requiereInduccion, etiquetas);
        
        agregarServicioAlMapa(zona);
        catalogoRaiz.agregarServicio(zona);
        
        return zona;
    }
    
    /**
     * Agrega un nuevo servicio de spa
     * @param nombre Nombre del servicio
     * @param descripcion Descripción detallada
     * @param precioBase Precio base
     * @param tipo Tipo de servicio de spa
     * @param duracionMinutos Duración en minutos
     * @param incluyeProductos Si incluye productos
     * @param etiquetas Etiquetas para búsqueda
     * @return Servicio creado
     */
    public ServiceComponent agregarSpa(String nombre, String descripcion, double precioBase,
                                    String tipo, int duracionMinutos, boolean incluyeProductos,
                                    String... etiquetas) {
        Spa spa = new Spa(nombre, descripcion, precioBase, tipo, duracionMinutos, incluyeProductos, etiquetas);
        
        agregarServicioAlMapa(spa);
        catalogoRaiz.agregarServicio(spa);
        
        return spa;
    }
    
    /**
     * Crea un nuevo paquete de servicios
     * @param nombre Nombre del paquete
     * @param descripcion Descripción detallada
     * @param factorDescuento Factor de descuento (0 a 1)
     * @param etiquetas Etiquetas para búsqueda
     * @return Paquete creado
     */
    public PaqueteServicio crearPaquete(String nombre, String descripcion, double factorDescuento,
                                       String... etiquetas) {
        PaqueteServicio paquete = new PaqueteServicio(nombre, descripcion, factorDescuento, etiquetas);
        
        agregarServicioAlMapa(paquete);
        catalogoRaiz.agregarServicio(paquete);
        
        return paquete;
    }
    
    /**
     * Agrega un servicio a un paquete existente
     * @param nombrePaquete Nombre del paquete
     * @param nombreServicio Nombre del servicio a agregar
     * @return true si se agregó correctamente, false en caso contrario
     */
    public boolean agregarServicioAPaquete(String nombrePaquete, String nombreServicio) {
        ServiceComponent paquete = servicios.get(nombrePaquete);
        ServiceComponent servicio = servicios.get(nombreServicio);
        
        if (paquete instanceof PaqueteServicio && servicio != null) {
            ((PaqueteServicio) paquete).agregarServicio(servicio);
            return true;
        }
        
        return false;
    }
    
    /**
     * Elimina un servicio del catálogo
     * @param nombreServicio Nombre del servicio a eliminar
     * @return true si se eliminó correctamente, false en caso contrario
     */
    public boolean eliminarServicio(String nombreServicio) {
        ServiceComponent servicio = servicios.get(nombreServicio);
        
        if (servicio != null) {
            servicios.remove(nombreServicio);
            
            // Quitar de los paquetes que lo contienen
            for (ServiceComponent comp : servicios.values()) {
                if (comp instanceof PaqueteServicio) {
                    ((PaqueteServicio) comp).eliminarServicio(servicio);
                }
            }
            
            return true;
        }
        
        return false;
    }
    
    /**
     * Busca un servicio por nombre
     * @param nombre Nombre del servicio
     * @return Servicio encontrado o null
     */
    public Optional<ServiceComponent> buscarPorNombre(String nombre) {
        return Optional.ofNullable(servicios.get(nombre));
    }
    
    /**
     * Busca servicios por texto en nombre, descripción o etiquetas
     * @param texto Texto a buscar
     * @return Lista de servicios que coinciden
     */
    public List<ServiceComponent> buscarPorTexto(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return Collections.emptyList();
        }
        
        return servicios.values().stream()
                .filter(s -> s.contiene(texto))
                .collect(Collectors.toList());
    }
    
    /**
     * Filtra servicios por precio máximo
     * @param precioMaximo Precio máximo
     * @return Lista de servicios filtrados
     */
    public List<ServiceComponent> filtrarPorPrecioMaximo(double precioMaximo) {
        return servicios.values().stream()
                .filter(s -> s.getPrecioBase() <= precioMaximo)
                .collect(Collectors.toList());
    }
    
    /**
     * Ordena servicios por nombre (ascendente)
     * @return Lista de servicios ordenados
     */
    public List<ServiceComponent> ordenarPorNombreAsc() {
        List<ServiceComponent> ordenados = new ArrayList<>(servicios.values());
        ordenados.sort(Comparator.comparing(ServiceComponent::getNombre));
        return ordenados;
    }
    
    /**
     * Ordena servicios por precio (ascendente)
     * @return Lista de servicios ordenados
     */
    public List<ServiceComponent> ordenarPorPrecioAsc() {
        List<ServiceComponent> ordenados = new ArrayList<>(servicios.values());
        ordenados.sort(Comparator.comparingDouble(ServiceComponent::getPrecioBase));
        return ordenados;
    }
    
    /**
     * Ordena servicios por precio (descendente)
     * @return Lista de servicios ordenados
     */
    public List<ServiceComponent> ordenarPorPrecioDesc() {
        List<ServiceComponent> ordenados = new ArrayList<>(servicios.values());
        ordenados.sort(Comparator.comparingDouble(ServiceComponent::getPrecioBase).reversed());
        return ordenados;
    }
    
    /**
     * Obtiene todos los servicios disponibles
     * @return Lista de todos los servicios
     */
    public List<ServiceComponent> listarServicios() {
        return new ArrayList<>(servicios.values());
    }
    
    /**
     * Obtiene el catálogo raíz (todos los servicios organizados jerárquicamente)
     * @return Catálogo raíz
     */
    public PaqueteServicio getCatalogoRaiz() {
        return catalogoRaiz;
    }
    
    /**
     * Obtiene servicios elementales (hojas) del catálogo
     * @return Lista de servicios elementales
     */
    public List<ServiceComponent> listarServiciosElementales() {
        return catalogoRaiz.listarHojas();
    }
}