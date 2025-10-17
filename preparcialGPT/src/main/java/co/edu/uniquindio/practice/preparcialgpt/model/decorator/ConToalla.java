package co.edu.uniquindio.practice.preparcialgpt.model.decorator;

import co.edu.uniquindio.practice.preparcialgpt.model.Reserva;

/**
 * Decorador para agregar servicio de toalla a la reserva
 */
public class ConToalla extends ReservaDecorator {
    
    private static final double COSTO_TOALLA = 5000;
    private int cantidadToallas;
    
    public ConToalla(Reserva reservaDecorada) {
        this(reservaDecorada, 1);
    }
    
    public ConToalla(Reserva reservaDecorada, int cantidadToallas) {
        super(reservaDecorada);
        this.cantidadToallas = Math.max(1, cantidadToallas);
    }

    @Override
    public String getDescripcion() {
        return reservaDecorada.getDescripcion() + 
               "\n+ " + cantidadToallas + " toalla" + (cantidadToallas > 1 ? "s" : "");
    }

    @Override
    public double getCosto() {
        return reservaDecorada.getCosto() + (COSTO_TOALLA * cantidadToallas);
    }
    
    public int getCantidadToallas() {
        return cantidadToallas;
    }
}