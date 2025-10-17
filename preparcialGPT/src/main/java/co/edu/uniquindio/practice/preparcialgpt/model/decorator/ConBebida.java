package co.edu.uniquindio.practice.preparcialgpt.model.decorator;

import co.edu.uniquindio.practice.preparcialgpt.model.Reserva;

/**
 * Decorador para agregar bebida isotónica a la reserva
 */
public class ConBebida extends ReservaDecorator {
    
    private static final double COSTO_BEBIDA = 8000;
    private int cantidad;
    private String tipoBebida;
    
    public ConBebida(Reserva reservaDecorada) {
        this(reservaDecorada, 1, "Isotónica");
    }
    
    public ConBebida(Reserva reservaDecorada, int cantidad, String tipoBebida) {
        super(reservaDecorada);
        this.cantidad = Math.max(1, cantidad);
        this.tipoBebida = tipoBebida != null && !tipoBebida.isEmpty() ? tipoBebida : "Isotónica";
    }

    @Override
    public String getDescripcion() {
        return reservaDecorada.getDescripcion() + 
               "\n+ " + cantidad + " bebida" + (cantidad > 1 ? "s" : "") + " " + tipoBebida;
    }

    @Override
    public double getCosto() {
        return reservaDecorada.getCosto() + (COSTO_BEBIDA * cantidad);
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public String getTipoBebida() {
        return tipoBebida;
    }
}