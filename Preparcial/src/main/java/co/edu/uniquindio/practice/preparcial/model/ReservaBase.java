package co.edu.uniquindio.practice.preparcial.model;

import co.edu.uniquindio.practice.preparcial.interfaces.Reserva;
import co.edu.uniquindio.practice.preparcial.interfaces.ServiceComponent;

public class ReservaBase implements Reserva {
    private String descripcion;
    private double costo;
    private ServiceComponent services;



    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public double getCosto() {
        return costo;
    }

    @Override
    public ServiceComponent getServices() {
        return services;
    }
}
