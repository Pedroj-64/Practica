package co.edu.uniquindio.practice.preparcialgpt.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del patrón Facade para simplificar las operaciones de reserva
 */
public class ReservaFacade {
    
    /**
     * Crea una nueva reserva rápida
     * @param clienteId ID del cliente
     * @param servicioId ID del servicio
     * @param fecha Fecha de la reserva
     * @param hora Hora de la reserva
     * @param extras Lista de extras para la reserva
     * @param metodoPago Método de pago
     * @return DTO con el resultado de la operación
     */
    public ResultadoOperacionDTO crearReservaRapida(String clienteId, String servicioId, 
                                                 LocalDate fecha, String hora, 
                                                 List<String> extras, String metodoPago) {
        // En una implementación real, aquí se realizaría la creación de la reserva
        // interactuando con las diferentes clases del modelo
        
        return new ResultadoOperacionDTO(true, "Reserva creada con éxito", "RES-" + Math.round(Math.random() * 10000));
    }
    
    /**
     * Cancela una reserva existente
     * @param reservaId ID de la reserva a cancelar
     * @return DTO con el resultado de la operación
     */
    public ResultadoOperacionDTO cancelarReserva(String reservaId) {
        // En una implementación real, aquí se realizaría la cancelación de la reserva
        
        return new ResultadoOperacionDTO(true, "Reserva cancelada con éxito", reservaId);
    }
    
    /**
     * Obtiene una lista de próximas reservas
     * @return Lista de DTOs con la información de reservas
     */
    public List<ReservaDTO> obtenerProximasReservas() {
        // En una implementación real, estos datos vendrían de una base de datos
        List<ReservaDTO> reservas = new ArrayList<>();
        
        // Datos simulados para mostrar en la UI
        reservas.add(new ReservaDTO(LocalDate.now().plusDays(1), "10:00", "Yoga", "Ana García", "Confirmada"));
        reservas.add(new ReservaDTO(LocalDate.now().plusDays(1), "16:30", "Spinning", "Carlos López", "Pendiente"));
        reservas.add(new ReservaDTO(LocalDate.now().plusDays(2), "09:15", "Pilates", "María Rodríguez", "Confirmada"));
        reservas.add(new ReservaDTO(LocalDate.now().plusDays(3), "18:00", "Musculación", "Juan Pérez", "Confirmada"));
        reservas.add(new ReservaDTO(LocalDate.now().plusDays(4), "11:30", "Masajes", "Laura Martín", "Pendiente"));
        
        return reservas;
    }
}