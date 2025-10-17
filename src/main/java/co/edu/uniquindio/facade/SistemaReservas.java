package co.edu.uniquindio.facade;

/**
 * Clase del subsistema que gestiona el sistema de reservas.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class SistemaReservas {
    
    /**
     * Reserva un vuelo para un pasajero.
     * 
     * @param nombrePasajero Nombre del pasajero
     * @param codigoVuelo Código del vuelo
     * @param asiento Número de asiento
     * @return Código de reserva
     */
    public String reservarVuelo(String nombrePasajero, String codigoVuelo, String asiento) {
        System.out.println("Reservando vuelo " + codigoVuelo + " para " + nombrePasajero);
        System.out.println("  Asiento asignado: " + asiento);
        
        // Generamos un código de reserva ficticio
        String codigoReserva = "RES" + System.currentTimeMillis() % 10000;
        
        System.out.println("  Reserva completada. Código: " + codigoReserva);
        return codigoReserva;
    }
    
    /**
     * Cancela una reserva existente.
     * 
     * @param codigoReserva Código de la reserva a cancelar
     * @return true si la cancelación fue exitosa, false en caso contrario
     */
    public boolean cancelarReserva(String codigoReserva) {
        System.out.println("Cancelando reserva con código " + codigoReserva);
        
        // Simulamos la cancelación
        boolean exitoso = true;
        
        if (exitoso) {
            System.out.println("  Reserva cancelada exitosamente");
        } else {
            System.out.println("  Error al cancelar la reserva");
        }
        
        return exitoso;
    }
    
    /**
     * Verifica el estado de una reserva.
     * 
     * @param codigoReserva Código de la reserva
     * @return Estado de la reserva
     */
    public String verificarEstadoReserva(String codigoReserva) {
        System.out.println("Verificando estado de reserva " + codigoReserva);
        
        // Simulamos la verificación del estado
        return "Confirmada";
    }
}