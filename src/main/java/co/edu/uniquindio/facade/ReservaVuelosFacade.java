package co.edu.uniquindio.facade;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Fachada (Facade) que proporciona una interfaz simplificada para reservar vuelos.
 * Esta clase oculta la complejidad de las interacciones con múltiples subsistemas.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class ReservaVuelosFacade {
    
    // Referencias a los subsistemas
    private VerificadorVuelos verificadorVuelos;
    private SistemaReservas sistemaReservas;
    private ProcesadorPagos procesadorPagos;
    private SistemaNotificaciones sistemaNotificaciones;
    
    /**
     * Constructor para ReservaVuelosFacade.
     * Inicializa todos los subsistemas necesarios.
     */
    public ReservaVuelosFacade() {
        this.verificadorVuelos = new VerificadorVuelos();
        this.sistemaReservas = new SistemaReservas();
        this.procesadorPagos = new ProcesadorPagos();
        this.sistemaNotificaciones = new SistemaNotificaciones();
    }
    
    /**
     * Proceso simplificado para reservar un vuelo de ida.
     * Este método coordina todos los pasos necesarios con los diferentes subsistemas.
     * 
     * @param nombrePasajero Nombre del pasajero
     * @param origen Ciudad de origen
     * @param destino Ciudad de destino
     * @param fechaSalida Fecha de salida
     * @param numeroTarjeta Número de tarjeta de crédito para el pago
     * @param nombreTitular Nombre del titular de la tarjeta
     * @param fechaExpiracion Fecha de expiración de la tarjeta
     * @param cvv Código de seguridad CVV
     * @param correoContacto Correo electrónico de contacto
     * @param telefonoContacto Teléfono de contacto
     * @return Código de reserva si fue exitoso, null en caso contrario
     */
    public String reservarVueloIdaSencillo(String nombrePasajero, String origen, String destino,
                                      String fechaSalida, String numeroTarjeta, String nombreTitular,
                                      String fechaExpiracion, String cvv, String correoContacto,
                                      String telefonoContacto) {
        
        System.out.println("\n=== INICIANDO PROCESO DE RESERVA DE VUELO IDA SENCILLO ===\n");
        
        // Paso 1: Verificar disponibilidad de vuelos
        boolean hayVuelosDisponibles = verificadorVuelos.verificarDisponibilidadVuelos(
                origen, destino, fechaSalida, null);
        
        if (!hayVuelosDisponibles) {
            System.out.println("\nNo hay vuelos disponibles para las fechas especificadas.");
            return null;
        }
        
        // Paso 2: Obtener información del vuelo (en un sistema real se seleccionaría uno)
        String codigoVuelo = "FL" + (1000 + (int)(Math.random() * 9000)); // Simulación
        String detallesVuelo = verificadorVuelos.obtenerDetallesVuelo(codigoVuelo);
        System.out.println("\nDetalles del vuelo seleccionado: " + detallesVuelo);
        
        // Paso 3: Asignar asiento (en un sistema real se seleccionaría uno)
        String asiento = "A" + (1 + (int)(Math.random() * 30)); // Simulación
        
        // Paso 4: Calcular costo (en un sistema real dependería del vuelo)
        double costoBoleto = 250.0 + (Math.random() * 300); // Entre $250 y $550
        System.out.println("\nCosto del boleto: $" + String.format("%.2f", costoBoleto));
        
        // Paso 5: Procesar pago
        boolean pagoExitoso = procesadorPagos.procesarPagoTarjeta(
                numeroTarjeta, nombreTitular, fechaExpiracion, cvv, costoBoleto);
        
        if (!pagoExitoso) {
            System.out.println("\nNo se pudo procesar el pago. Reserva cancelada.");
            return null;
        }
        
        String idTransaccion = "TX" + System.currentTimeMillis();
        
        // Paso 6: Crear reserva
        String codigoReserva = sistemaReservas.reservarVuelo(nombrePasajero, codigoVuelo, asiento);
        
        // Paso 7: Generar recibo
        String fechaActual = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String recibo = procesadorPagos.generarRecibo(idTransaccion, costoBoleto, fechaActual);
        System.out.println("\n" + recibo);
        
        // Paso 8: Enviar notificaciones
        String mensajeCorreo = "Estimado/a " + nombrePasajero + ",\n\n" +
                              "Su reserva ha sido confirmada. Código de reserva: " + codigoReserva + "\n" +
                              "Detalles del vuelo: " + detallesVuelo + "\n" +
                              "Asiento asignado: " + asiento + "\n\n" +
                              "Gracias por su preferencia.";
        
        sistemaNotificaciones.enviarCorreoElectronico(
                correoContacto, "Confirmación de Reserva: " + codigoReserva, mensajeCorreo);
        
        String mensajeSMS = "Su vuelo " + codigoVuelo + " ha sido reservado. Código: " + codigoReserva;
        if (telefonoContacto != null && !telefonoContacto.isEmpty()) {
            sistemaNotificaciones.enviarSMS(telefonoContacto, mensajeSMS);
        }
        
        System.out.println("\n=== PROCESO DE RESERVA COMPLETADO EXITOSAMENTE ===");
        return codigoReserva;
    }
    
    /**
     * Proceso simplificado para reservar un vuelo de ida y vuelta.
     * 
     * @param nombrePasajero Nombre del pasajero
     * @param origen Ciudad de origen
     * @param destino Ciudad de destino
     * @param fechaSalida Fecha de salida
     * @param fechaRegreso Fecha de regreso
     * @param numeroTarjeta Número de tarjeta de crédito para el pago
     * @param nombreTitular Nombre del titular de la tarjeta
     * @param fechaExpiracion Fecha de expiración de la tarjeta
     * @param cvv Código de seguridad CVV
     * @param correoContacto Correo electrónico de contacto
     * @param telefonoContacto Teléfono de contacto
     * @return Código de reserva si fue exitoso, null en caso contrario
     */
    public String reservarVueloIdaVuelta(String nombrePasajero, String origen, String destino,
                                    String fechaSalida, String fechaRegreso, String numeroTarjeta, 
                                    String nombreTitular, String fechaExpiracion, String cvv, 
                                    String correoContacto, String telefonoContacto) {
        
        System.out.println("\n=== INICIANDO PROCESO DE RESERVA DE VUELO IDA Y VUELTA ===\n");
        
        // Paso 1: Verificar disponibilidad de vuelos
        boolean hayVuelosDisponibles = verificadorVuelos.verificarDisponibilidadVuelos(
                origen, destino, fechaSalida, fechaRegreso);
        
        if (!hayVuelosDisponibles) {
            System.out.println("\nNo hay vuelos disponibles para las fechas especificadas.");
            return null;
        }
        
        // Paso 2: Obtener información de los vuelos
        String codigoVueloIda = "FL" + (1000 + (int)(Math.random() * 9000));
        String detallesVueloIda = verificadorVuelos.obtenerDetallesVuelo(codigoVueloIda);
        System.out.println("\nDetalles del vuelo de ida: " + detallesVueloIda);
        
        String codigoVueloRegreso = "FL" + (1000 + (int)(Math.random() * 9000));
        String detallesVueloRegreso = verificadorVuelos.obtenerDetallesVuelo(codigoVueloRegreso);
        System.out.println("\nDetalles del vuelo de regreso: " + detallesVueloRegreso);
        
        // Paso 3: Asignar asientos
        String asientoIda = "B" + (1 + (int)(Math.random() * 30));
        String asientoRegreso = "C" + (1 + (int)(Math.random() * 30));
        
        // Paso 4: Calcular costo
        double costoBoletosTotal = 450.0 + (Math.random() * 300); // Entre $450 y $750
        System.out.println("\nCosto total de los boletos: $" + String.format("%.2f", costoBoletosTotal));
        
        // Paso 5: Procesar pago
        boolean pagoExitoso = procesadorPagos.procesarPagoTarjeta(
                numeroTarjeta, nombreTitular, fechaExpiracion, cvv, costoBoletosTotal);
        
        if (!pagoExitoso) {
            System.out.println("\nNo se pudo procesar el pago. Reserva cancelada.");
            return null;
        }
        
        String idTransaccion = "TX" + System.currentTimeMillis();
        
        // Paso 6: Crear reservas
        String codigoReservaIda = sistemaReservas.reservarVuelo(nombrePasajero, codigoVueloIda, asientoIda);
        String codigoReservaRegreso = sistemaReservas.reservarVuelo(nombrePasajero, codigoVueloRegreso, asientoRegreso);
        
        String codigoReservaCompleto = codigoReservaIda + "-" + codigoReservaRegreso;
        
        // Paso 7: Generar recibo
        String fechaActual = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String recibo = procesadorPagos.generarRecibo(idTransaccion, costoBoletosTotal, fechaActual);
        System.out.println("\n" + recibo);
        
        // Paso 8: Enviar notificaciones
        String mensajeCorreo = "Estimado/a " + nombrePasajero + ",\n\n" +
                              "Sus reservas han sido confirmadas.\n" +
                              "Código de reserva ida: " + codigoReservaIda + "\n" +
                              "Detalles del vuelo de ida: " + detallesVueloIda + "\n" +
                              "Asiento asignado: " + asientoIda + "\n\n" +
                              "Código de reserva regreso: " + codigoReservaRegreso + "\n" +
                              "Detalles del vuelo de regreso: " + detallesVueloRegreso + "\n" +
                              "Asiento asignado: " + asientoRegreso + "\n\n" +
                              "Gracias por su preferencia.";
        
        sistemaNotificaciones.enviarCorreoElectronico(
                correoContacto, "Confirmación de Reservas: " + codigoReservaCompleto, mensajeCorreo);
        
        String mensajeSMS = "Sus vuelos han sido reservados. Códigos: " + codigoReservaIda + " y " + codigoReservaRegreso;
        if (telefonoContacto != null && !telefonoContacto.isEmpty()) {
            sistemaNotificaciones.enviarSMS(telefonoContacto, mensajeSMS);
        }
        
        System.out.println("\n=== PROCESO DE RESERVA COMPLETADO EXITOSAMENTE ===");
        return codigoReservaCompleto;
    }
    
    /**
     * Proceso simplificado para cancelar una reserva.
     * 
     * @param codigoReserva Código de la reserva a cancelar
     * @param correoContacto Correo electrónico de contacto
     * @return true si la cancelación fue exitosa, false en caso contrario
     */
    public boolean cancelarReserva(String codigoReserva, String correoContacto) {
        System.out.println("\n=== INICIANDO PROCESO DE CANCELACIÓN DE RESERVA ===\n");
        
        // Verificar el estado actual de la reserva
        String estadoReserva = sistemaReservas.verificarEstadoReserva(codigoReserva);
        System.out.println("\nEstado actual de la reserva: " + estadoReserva);
        
        // Cancelar la reserva
        boolean cancelacionExitosa = sistemaReservas.cancelarReserva(codigoReserva);
        
        if (cancelacionExitosa) {
            // Enviar notificación de cancelación
            String mensajeCorreo = "Estimado/a cliente,\n\n" +
                                  "Su reserva con código " + codigoReserva + " ha sido cancelada exitosamente.\n\n" +
                                  "Si usted no solicitó esta cancelación, por favor contáctenos inmediatamente.\n\n" +
                                  "Gracias por su preferencia.";
            
            sistemaNotificaciones.enviarCorreoElectronico(
                    correoContacto, "Confirmación de Cancelación: " + codigoReserva, mensajeCorreo);
            
            System.out.println("\n=== PROCESO DE CANCELACIÓN COMPLETADO EXITOSAMENTE ===");
        } else {
            System.out.println("\n=== ERROR EN EL PROCESO DE CANCELACIÓN ===");
        }
        
        return cancelacionExitosa;
    }
    
    /**
     * Proceso simplificado para verificar el estado de una reserva.
     * 
     * @param codigoReserva Código de la reserva
     * @return Estado de la reserva
     */
    public String consultarEstadoReserva(String codigoReserva) {
        System.out.println("\n=== CONSULTANDO ESTADO DE RESERVA ===\n");
        
        String estado = sistemaReservas.verificarEstadoReserva(codigoReserva);
        
        System.out.println("Estado de la reserva " + codigoReserva + ": " + estado);
        
        return estado;
    }
}