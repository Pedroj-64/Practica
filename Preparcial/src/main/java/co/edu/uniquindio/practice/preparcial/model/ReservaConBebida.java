package co.edu.uniquindio.practice.preparcial.model;

import co.edu.uniquindio.practice.preparcial.interfaces.Reserva;

public class ReservaConBebida extends ReservaDecorator{

    public ReservaConBebida(Reserva reserva) {
        super(reserva);
    }

    @Override
    public String getDescripcion() {
        return reserva.getDescripcion() + " + Bebida";
    }

    @Override
    public double getCosto() {
        return reserva.getCosto() + 3.0; // Costo adicional por la bebida
    }
}
