package co.edu.uniquindio.practice.preparcial.model;

import co.edu.uniquindio.practice.preparcial.interfaces.Reserva;

public class ReservaConToalla extends ReservaDecorator{

    public ReservaConToalla(Reserva reserva) {
        super(reserva);
    }

    @Override
    public String getDescripcion() {
        return reserva.getDescripcion() + " + Toalla";
    }

    @Override
    public double getCosto() {
        return reserva.getCosto() + 5.0; // Costo adicional por la toalla
    }
}
