package co.edu.uniquindio.practice.preparcial.model;

import co.edu.uniquindio.practice.preparcial.interfaces.Reserva;

public class ReservaConLockerPremium extends ReservaDecorator {

    public ReservaConLockerPremium(Reserva reserva) {
        super(reserva);
    }

    @Override
    public String getDescripcion() {
        return reserva.getDescripcion() + " + Locker Premium";
    }

    @Override
    public double getCosto() {
        return reserva.getCosto() + 20.0; // Costo adicional por el locker premium
    }
}
