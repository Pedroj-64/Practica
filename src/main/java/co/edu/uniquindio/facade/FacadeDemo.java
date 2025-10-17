package co.edu.uniquindio.facade;

/**
 * Clase de demostración para el patrón Facade.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class FacadeDemo {
    
    public static void main(String[] args) {
        System.out.println("===== DEMOSTRACIÓN DEL PATRÓN FACADE =====\n");
        
        // Crear la fachada
        ReservaVuelosFacade reservaFacade = new ReservaVuelosFacade();
        
        // Demostración 1: Reserva de vuelo de ida sencillo
        System.out.println("DEMOSTRACIÓN 1: RESERVA DE VUELO IDA SENCILLO");
        String codigoReserva1 = reservaFacade.reservarVueloIdaSencillo(
                "Juan Pérez",             // Nombre del pasajero
                "Bogotá",                 // Origen
                "Medellín",               // Destino
                "2025-11-15",             // Fecha de salida
                "1234567890123456",       // Número de tarjeta
                "JUAN PEREZ",             // Titular de tarjeta
                "12/27",                  // Fecha de expiración
                "123",                    // CVV
                "juan.perez@email.com",   // Correo de contacto
                "3101234567"              // Teléfono de contacto
        );
        
        // Demostración 2: Consulta del estado de la reserva
        if (codigoReserva1 != null) {
            System.out.println("\nDEMOSTRACIÓN 2: CONSULTA DE ESTADO DE RESERVA");
            reservaFacade.consultarEstadoReserva(codigoReserva1);
        }
        
        // Demostración 3: Reserva de vuelo de ida y vuelta
        System.out.println("\nDEMOSTRACIÓN 3: RESERVA DE VUELO IDA Y VUELTA");
        String codigoReserva2 = reservaFacade.reservarVueloIdaVuelta(
                "María Rodríguez",        // Nombre del pasajero
                "Cali",                   // Origen
                "Cartagena",              // Destino
                "2025-12-20",             // Fecha de salida
                "2025-12-27",             // Fecha de regreso
                "9876543210987654",       // Número de tarjeta
                "MARIA RODRIGUEZ",        // Titular de tarjeta
                "09/26",                  // Fecha de expiración
                "456",                    // CVV
                "maria.rodriguez@email.com", // Correo de contacto
                "3159876543"              // Teléfono de contacto
        );
        
        // Demostración 4: Cancelación de reserva
        if (codigoReserva2 != null) {
            System.out.println("\nDEMOSTRACIÓN 4: CANCELACIÓN DE RESERVA");
            reservaFacade.cancelarReserva(codigoReserva2.split("-")[0], "maria.rodriguez@email.com");
        }
        
        System.out.println("\n===== FIN DE LA DEMOSTRACIÓN =====");
        
        // Mostrar la complejidad que oculta la fachada
        System.out.println("\nNota: La fachada oculta la complejidad de interactuar con:");
        System.out.println("1. Sistema de verificación de vuelos");
        System.out.println("2. Sistema de reservas");
        System.out.println("3. Procesador de pagos");
        System.out.println("4. Sistema de notificaciones");
        System.out.println("\nSin la fachada, el cliente tendría que conocer y coordinar todas estas interacciones.");
    }
}