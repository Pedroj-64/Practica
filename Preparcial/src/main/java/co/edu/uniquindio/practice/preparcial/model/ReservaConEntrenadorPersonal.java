package co.edu.uniquindio.practice.preparcial.model;

import co.edu.uniquindio.practice.preparcial.interfaces.Reserva;

public class ReservaConEntrenadorPersonal extends ReservaDecorator{

    public ReservaConEntrenadorPersonal(Reserva reserva) {
        super(reserva);
    }

    @Override
    public String getDescripcion() {
        return reserva.getDescripcion() + " + Entrenador Personal";
    }

    @Override
    public double getCosto() {
        return reserva.getCosto() + 20.0; // Costo adicional por el entrenador personal
    }
}
