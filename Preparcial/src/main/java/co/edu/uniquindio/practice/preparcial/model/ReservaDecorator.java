package co.edu.uniquindio.practice.preparcial.model;

import co.edu.uniquindio.practice.preparcial.interfaces.Reserva;
import co.edu.uniquindio.practice.preparcial.interfaces.ServiceComponent;

public class ReservaDecorator implements Reserva {
    protected Reserva reserva;

    public ReservaDecorator(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public String getDescripcion() {
        return reserva.getDescripcion();
    }

    @Override
    public double getCosto() {
        return reserva.getCosto();
    }

    @Override
    public ServiceComponent getServices() {
        return reserva.getServices();
    }
}
