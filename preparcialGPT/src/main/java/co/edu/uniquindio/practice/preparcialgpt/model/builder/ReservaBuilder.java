package co.edu.uniquindio.practice.preparcialgpt.model.builder;

import co.edu.uniquindio.practice.preparcialgpt.model.Cliente;
import co.edu.uniquindio.practice.preparcialgpt.model.Reserva;
import co.edu.uniquindio.practice.preparcialgpt.model.bridge.Pago;
import co.edu.uniquindio.practice.preparcialgpt.model.composite.ServiceComponent;
import co.edu.uniquindio.practice.preparcialgpt.model.decorator.ConBebida;
import co.edu.uniquindio.practice.preparcialgpt.model.decorator.ConEntrenadorPersonal;
import co.edu.uniquindio.practice.preparcialgpt.model.decorator.ConLockerPremium;
import co.edu.uniquindio.practice.preparcialgpt.model.decorator.ConToalla;
import co.edu.uniquindio.practice.preparcialgpt.model.decorator.ReservaBase;

import java.time.LocalDateTime;

/**
 * Builder para construir objetos Reserva de manera incremental
 * Implementa el patrón Builder
 */
public class ReservaBuilder {
    
    private Cliente cliente;
    private ServiceComponent servicio;
    private LocalDateTime fechaHora;
    private Pago pago;
    private boolean conLockerPremium;
    private int cantidadToallas;
    private int cantidadBebidas;
    private String tipoBebida;
    private boolean conEntrenador;
    private int duracionEntrenador;
    private String nombreEntrenador;
    
    public ReservaBuilder() {
        // Valores por defecto
        this.conLockerPremium = false;
        this.cantidadToallas = 0;
        this.cantidadBebidas = 0;
        this.tipoBebida = "Isotónica";
        this.conEntrenador = false;
        this.duracionEntrenador = 60;
        this.nombreEntrenador = "Entrenador asignado";
    }
    
    /**
     * Establece el cliente para la reserva
     * @param cliente Cliente que realiza la reserva
     * @return El builder para encadenamiento
     */
    public ReservaBuilder conCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }
    
    /**
     * Establece el servicio para la reserva
     * @param servicio Servicio a reservar
     * @return El builder para encadenamiento
     */
    public ReservaBuilder conServicio(ServiceComponent servicio) {
        this.servicio = servicio;
        return this;
    }
    
    /**
     * Establece la fecha y hora de la reserva
     * @param fechaHora Fecha y hora
     * @return El builder para encadenamiento
     */
    public ReservaBuilder conFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
        return this;
    }
    
    /**
     * Establece el medio de pago para la reserva
     * @param pago Medio de pago
     * @return El builder para encadenamiento
     */
    public ReservaBuilder conPago(Pago pago) {
        this.pago = pago;
        return this;
    }
    
    /**
     * Agrega un locker premium a la reserva
     * @return El builder para encadenamiento
     */
    public ReservaBuilder conLockerPremium() {
        this.conLockerPremium = true;
        return this;
    }
    
    /**
     * Agrega servicio de toallas a la reserva
     * @param cantidad Cantidad de toallas
     * @return El builder para encadenamiento
     */
    public ReservaBuilder conToalla(int cantidad) {
        this.cantidadToallas = cantidad;
        return this;
    }
    
    /**
     * Agrega bebidas a la reserva
     * @param cantidad Cantidad de bebidas
     * @param tipo Tipo de bebida
     * @return El builder para encadenamiento
     */
    public ReservaBuilder conBebida(int cantidad, String tipo) {
        this.cantidadBebidas = cantidad;
        this.tipoBebida = tipo;
        return this;
    }
    
    /**
     * Agrega un entrenador personal a la reserva
     * @param duracionMinutos Duración en minutos
     * @param nombreEntrenador Nombre del entrenador
     * @return El builder para encadenamiento
     */
    public ReservaBuilder conEntrenadorPersonal(int duracionMinutos, String nombreEntrenador) {
        this.conEntrenador = true;
        this.duracionEntrenador = duracionMinutos;
        this.nombreEntrenador = nombreEntrenador;
        return this;
    }
    
    /**
     * Construye el objeto Reserva con todas las configuraciones establecidas
     * @return Reserva completa
     * @throws IllegalStateException si faltan datos obligatorios
     */
    public Reserva construir() {
        // Validar datos obligatorios
        if (cliente == null) {
            throw new IllegalStateException("No se ha especificado el cliente para la reserva");
        }
        
        if (servicio == null) {
            throw new IllegalStateException("No se ha especificado el servicio para la reserva");
        }
        
        if (fechaHora == null) {
            throw new IllegalStateException("No se ha especificado la fecha y hora para la reserva");
        }
        
        // Crear reserva base
        Reserva reserva = new ReservaBase(cliente, servicio, fechaHora);
        
        // Aplicar decoradores según configuración
        if (conLockerPremium) {
            reserva = new ConLockerPremium(reserva);
        }
        
        if (cantidadToallas > 0) {
            reserva = new ConToalla(reserva, cantidadToallas);
        }
        
        if (cantidadBebidas > 0) {
            reserva = new ConBebida(reserva, cantidadBebidas, tipoBebida);
        }
        
        if (conEntrenador) {
            reserva = new ConEntrenadorPersonal(reserva, duracionEntrenador, nombreEntrenador);
        }
        
        // Establecer medio de pago si está disponible
        if (pago != null) {
            reserva.setPago(pago);
        }
        
        return reserva;
    }
}