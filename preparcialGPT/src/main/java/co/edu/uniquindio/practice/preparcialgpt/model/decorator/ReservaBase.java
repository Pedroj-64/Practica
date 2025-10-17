package co.edu.uniquindio.practice.preparcialgpt.model.decorator;

import co.edu.uniquindio.practice.preparcialgpt.model.Cliente;
import co.edu.uniquindio.practice.preparcialgpt.model.Reserva;
import co.edu.uniquindio.practice.preparcialgpt.model.composite.ServiceComponent;

import java.time.LocalDateTime;

/**
 * Clase base concreta para el patrón Decorator.
 * Esta es la implementación base de una reserva.
 */
public class ReservaBase extends Reserva {
    
    private final ServiceComponent servicio;
    
    public ReservaBase(Cliente cliente, ServiceComponent servicio, LocalDateTime fechaHora) {
        super(cliente, fechaHora);
        this.servicio = servicio;
    }

    @Override
    public String getDescripcion() {
        return "Reserva de " + servicio.getNombre() + 
               " para " + getCliente().getNombreCompleto() + 
               " el " + getFechaHora();
    }

    @Override
    public double getCosto() {
        return servicio.calcularPrecio();
    }

    @Override
    public ServiceComponent getServicioBase() {
        return servicio;
    }
}