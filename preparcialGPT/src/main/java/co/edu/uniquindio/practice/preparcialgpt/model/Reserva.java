package co.edu.uniquindio.practice.preparcialgpt.model;

import co.edu.uniquindio.practice.preparcialgpt.model.bridge.Pago;
import co.edu.uniquindio.practice.preparcialgpt.model.composite.ServiceComponent;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Clase abstracta que representa una reserva en el sistema
 */
public abstract class Reserva {
    
    private final String id;
    private final Cliente cliente;
    private LocalDateTime fechaHora;
    private Pago pago;
    private boolean pagado;
    
    public Reserva(Cliente cliente, LocalDateTime fechaHora) {
        this.id = UUID.randomUUID().toString();
        this.cliente = cliente;
        this.fechaHora = fechaHora;
        this.pagado = false;
    }
    
    public String getId() {
        return id;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
    
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
    
    public Pago getPago() {
        return pago;
    }
    
    public void setPago(Pago pago) {
        this.pago = pago;
    }
    
    public boolean isPagado() {
        return pagado;
    }
    
    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }
    
    /**
     * Obtiene la descripción detallada de la reserva
     * @return Cadena con la descripción de la reserva
     */
    public abstract String getDescripcion();
    
    /**
     * Calcula el costo total de la reserva
     * @return El valor monetario de la reserva
     */
    public abstract double getCosto();
    
    /**
     * Obtiene el servicio base de esta reserva
     * @return El componente de servicio reservado
     */
    public abstract ServiceComponent getServicioBase();
}