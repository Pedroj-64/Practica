package co.edu.uniquindio.practice.preparcialgpt.model.decorator;

import co.edu.uniquindio.practice.preparcialgpt.model.Reserva;

/**
 * Decorador para agregar un locker premium a la reserva
 */
public class ConLockerPremium extends ReservaDecorator {
    
    private static final double COSTO_LOCKER_PREMIUM = 15000;
    
    public ConLockerPremium(Reserva reservaDecorada) {
        super(reservaDecorada);
    }

    @Override
    public String getDescripcion() {
        return reservaDecorada.getDescripcion() + "\n+ Locker Premium";
    }

    @Override
    public double getCosto() {
        return reservaDecorada.getCosto() + COSTO_LOCKER_PREMIUM;
    }
}