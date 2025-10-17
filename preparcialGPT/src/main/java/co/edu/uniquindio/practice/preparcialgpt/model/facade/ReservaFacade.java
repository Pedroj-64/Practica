package co.edu.uniquindio.practice.preparcialgpt.model.facade;

import co.edu.uniquindio.practice.preparcialgpt.model.Cliente;
import co.edu.uniquindio.practice.preparcialgpt.model.Reserva;
import co.edu.uniquindio.practice.preparcialgpt.model.adapter.ProveedorHorarioPort;
import co.edu.uniquindio.practice.preparcialgpt.model.bridge.Pago;
import co.edu.uniquindio.practice.preparcialgpt.model.builder.ReservaBuilder;
import co.edu.uniquindio.practice.preparcialgpt.model.composite.ServiceComponent;
import co.edu.uniquindio.practice.preparcialgpt.model.dto.ResultadoOperacionDTO;
import co.edu.uniquindio.practice.preparcialgpt.model.singleton.AppConfig;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Fachada para simplificar el proceso de reserva rápida
 * Implementa el patrón Facade
 */
public class ReservaFacade {
    
    private final ProveedorHorarioPort proveedorHorario;
    
    public ReservaFacade(ProveedorHorarioPort proveedorHorario) {
        this.proveedorHorario = proveedorHorario;
    }
    
    /**
     * Realiza una reserva rápida para un cliente
     * @param cliente Cliente que realiza la reserva
     * @param servicio Servicio a reservar
     * @param fechaHora Fecha y hora de la reserva
     * @param extras Lista de extras para agregar a la reserva
     * @param pago Medio de pago a utilizar
     * @return Resultado de la operación
     */
    public ResultadoOperacionDTO reservarRapido(Cliente cliente, ServiceComponent servicio, 
                                             LocalDateTime fechaHora, List<String> extras, Pago pago) {
        
        // Verificar disponibilidad del horario
        String fechaStr = fechaHora.format(DateTimeFormatter.ofPattern(AppConfig.getInstance().getFormatoFechaHora()));
        
        if (!proveedorHorario.verificarDisponibilidad(servicio.getNombre(), fechaStr)) {
            return ResultadoOperacionDTO.fallido("No hay disponibilidad para el servicio seleccionado en la fecha y hora indicada");
        }
        
        // Construir la reserva utilizando el Builder
        ReservaBuilder builder = new ReservaBuilder();
        builder.conCliente(cliente)
               .conServicio(servicio)
               .conFechaHora(fechaHora);
        
        // Agregar extras si corresponde
        if (extras != null) {
            for (String extra : extras) {
                switch (extra.toLowerCase()) {
                    case "locker":
                        builder.conLockerPremium();
                        break;
                    case "toalla":
                        builder.conToalla(1);
                        break;
                    case "bebida":
                        builder.conBebida(1, "Isotónica");
                        break;
                    case "entrenador":
                        builder.conEntrenadorPersonal(60, "Entrenador Disponible");
                        break;
                }
            }
        }
        
        // Establecer el medio de pago
        builder.conPago(pago);
        
        // Construir la reserva final
        Reserva reserva = builder.construir();
        
        // Calcular el costo total
        double total = reserva.getCosto();
        
        // Procesar el pago
        boolean pagoExitoso = pago.procesar(total);
        
        if (!pagoExitoso) {
            return ResultadoOperacionDTO.fallido("No se pudo procesar el pago");
        }
        
        // Marcar como pagado
        reserva.setPagado(true);
        
        // Agregar la reserva al historial del cliente
        cliente.agregarReserva(reserva);
        
        // Devolver resultado exitoso
        return ResultadoOperacionDTO.exitoso(
            "Reserva realizada con éxito para " + servicio.getNombre(), 
            total, 
            pago.getIdTransaccion()
        );
    }
}