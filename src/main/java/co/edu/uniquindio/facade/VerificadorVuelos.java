package co.edu.uniquindio.facade;

/**
 * Clase del subsistema que verifica la disponibilidad de vuelos.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class VerificadorVuelos {
    
    /**
     * Verifica si hay vuelos disponibles para un destino en fechas específicas.
     * 
     * @param origen Ciudad de origen
     * @param destino Ciudad de destino
     * @param fechaSalida Fecha de salida
     * @param fechaRegreso Fecha de regreso (opcional, puede ser null)
     * @return true si hay vuelos disponibles, false en caso contrario
     */
    public boolean verificarDisponibilidadVuelos(String origen, String destino, 
                                              String fechaSalida, String fechaRegreso) {
        // En un sistema real, esta lógica consultaría una base de datos o un servicio
        System.out.println("Verificando vuelos disponibles de " + origen + " a " + destino);
        System.out.println("  Fecha de salida: " + fechaSalida);
        if (fechaRegreso != null) {
            System.out.println("  Fecha de regreso: " + fechaRegreso);
        }
        
        // Simulamos la disponibilidad
        boolean hayDisponibilidad = true;
        
        System.out.println("  Resultado: " + (hayDisponibilidad ? "Vuelos disponibles" : "No hay vuelos disponibles"));
        return hayDisponibilidad;
    }
    
    /**
     * Obtiene información detallada sobre un vuelo específico.
     * 
     * @param codigoVuelo Código del vuelo
     * @return Información del vuelo
     */
    public String obtenerDetallesVuelo(String codigoVuelo) {
        System.out.println("Obteniendo detalles del vuelo " + codigoVuelo);
        
        // Simulamos la obtención de detalles
        return "Vuelo " + codigoVuelo + " - Aerolínea UniAir - Duración: 2h 30m - Equipaje incluido: 1 maleta de mano";
    }
}