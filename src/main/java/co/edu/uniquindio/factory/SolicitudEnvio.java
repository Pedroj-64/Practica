package co.edu.uniquindio.factory;

/**
 * Clase que representa una solicitud de envío y utiliza las fábricas para crear
 * transportes adecuados.
 * 
 * Esta clase es un ejemplo de cliente que utiliza el patrón Factory Method.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class SolicitudEnvio {
    
    private String identificador;
    private String origen;
    private String destino;
    private double distanciaKm;
    private boolean esInternacional;
    private boolean esPrioritario;
    private double pesoKg;
    private String descripcionPaquete;
    private Transporte transporteAsignado;
    
    /**
     * Constructor para SolicitudEnvio.
     * 
     * @param identificador Identificador único del envío
     * @param origen Lugar de origen
     * @param destino Lugar de destino
     * @param distanciaKm Distancia en kilómetros
     * @param esInternacional Si el envío es internacional
     * @param esPrioritario Si el envío es prioritario
     * @param pesoKg Peso del envío en kilogramos
     * @param descripcionPaquete Descripción del paquete a enviar
     */
    public SolicitudEnvio(String identificador, String origen, String destino, 
                          double distanciaKm, boolean esInternacional, 
                          boolean esPrioritario, double pesoKg, String descripcionPaquete) {
        this.identificador = identificador;
        this.origen = origen;
        this.destino = destino;
        this.distanciaKm = distanciaKm;
        this.esInternacional = esInternacional;
        this.esPrioritario = esPrioritario;
        this.pesoKg = pesoKg;
        this.descripcionPaquete = descripcionPaquete;
    }
    
    /**
     * Método para asignar un transporte adecuado según los requisitos del envío.
     * 
     * @param tipoTransporte Tipo de transporte deseado ("terrestre", "aereo", "maritimo")
     * @return true si se asignó correctamente, false en caso contrario
     */
    public boolean asignarTransporte(String tipoTransporte) {
        try {
            // Utilizamos la fábrica abstracta para crear el transporte adecuado
            transporteAsignado = EnvioTransporteFactory.crearTransporte(
                tipoTransporte, distanciaKm, esInternacional, esPrioritario, pesoKg);
            return true;
        } catch (IllegalArgumentException e) {
            System.err.println("Error al asignar transporte: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Método para procesar el envío.
     * 
     * @return Un resumen del proceso de envío
     */
    public String procesarEnvio() {
        if (transporteAsignado == null) {
            return "Error: No se ha asignado un transporte para el envío " + identificador;
        }
        
        StringBuilder resultado = new StringBuilder();
        resultado.append("=== Procesando Envío ").append(identificador).append(" ===\n");
        resultado.append("Desde: ").append(origen).append("\n");
        resultado.append("Hasta: ").append(destino).append("\n");
        resultado.append("Distancia: ").append(distanciaKm).append(" km\n");
        resultado.append("Tipo de transporte: ").append(transporteAsignado.getTipo()).append("\n");
        resultado.append("Mensaje de entrega: ").append(transporteAsignado.entregar(descripcionPaquete)).append("\n");
        resultado.append("Costo: $").append(String.format("%.2f", transporteAsignado.calcularCosto(distanciaKm))).append("\n");
        resultado.append("Tiempo estimado: ").append(String.format("%.1f", transporteAsignado.tiempoEstimado(distanciaKm))).append(" horas\n");
        
        return resultado.toString();
    }
    
    /**
     * Método para obtener una cotización del envío sin procesarlo.
     * 
     * @param tipoTransporte Tipo de transporte a cotizar
     * @return Una cotización del envío
     */
    public String obtenerCotizacion(String tipoTransporte) {
        // Creamos temporalmente un transporte para la cotización
        Transporte transporte = EnvioTransporteFactory.crearTransporte(
            tipoTransporte, distanciaKm, esInternacional, esPrioritario, pesoKg);
        
        StringBuilder cotizacion = new StringBuilder();
        cotizacion.append("=== Cotización de Envío ===\n");
        cotizacion.append("Tipo de transporte: ").append(transporte.getTipo()).append("\n");
        cotizacion.append("Distancia: ").append(distanciaKm).append(" km\n");
        cotizacion.append("Costo estimado: $").append(String.format("%.2f", transporte.calcularCosto(distanciaKm))).append("\n");
        cotizacion.append("Tiempo estimado: ").append(String.format("%.1f", transporte.tiempoEstimado(distanciaKm))).append(" horas\n");
        
        return cotizacion.toString();
    }
    
    // Getters y setters

    public String getIdentificador() {
        return identificador;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public boolean isEsInternacional() {
        return esInternacional;
    }

    public boolean isEsPrioritario() {
        return esPrioritario;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public String getDescripcionPaquete() {
        return descripcionPaquete;
    }

    public Transporte getTransporteAsignado() {
        return transporteAsignado;
    }
}