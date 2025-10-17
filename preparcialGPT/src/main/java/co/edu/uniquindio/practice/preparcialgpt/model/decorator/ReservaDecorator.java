package co.edu.uniquindio.practice.preparcialgpt.model.decorator;

import co.edu.uniquindio.practice.preparcialgpt.model.Reserva;
import co.edu.uniquindio.practice.preparcialgpt.model.bridge.Pago;
import co.edu.uniquindio.practice.preparcialgpt.model.composite.ServiceComponent;

import java.time.LocalDateTime;

/**
 * Clase base abstracta para todos los decoradores de reserva
 */
public abstract class ReservaDecorator extends Reserva {
    
    protected Reserva reservaDecorada;
    
    public ReservaDecorator(Reserva reservaDecorada) {
        super(reservaDecorada.getCliente(), reservaDecorada.getFechaHora());
        this.reservaDecorada = reservaDecorada;
    }

    @Override
    public void setFechaHora(LocalDateTime fechaHora) {
        super.setFechaHora(fechaHora);
        reservaDecorada.setFechaHora(fechaHora);
    }

    @Override
    public void setPago(Pago pago) {
        super.setPago(pago);
        reservaDecorada.setPago(pago);
    }

    @Override
    public void setPagado(boolean pagado) {
        super.setPagado(pagado);
        reservaDecorada.setPagado(pagado);
    }

    @Override
    public ServiceComponent getServicioBase() {
        return reservaDecorada.getServicioBase();
    }
}