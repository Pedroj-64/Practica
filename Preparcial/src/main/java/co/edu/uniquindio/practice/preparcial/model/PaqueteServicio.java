package co.edu.uniquindio.practice.preparcial.model;

import co.edu.uniquindio.practice.preparcial.interfaces.ServiceComponent;

import java.util.ArrayList;
import java.util.List;

public class PaqueteServicio implements ServiceComponent {
    private String nombre;
    private int precioBase;
    private List<ServiceComponent> services;

    public PaqueteServicio(String nombre,int precioBase) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.services = new ArrayList<>();

    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getPrecioBase() {
        return precioBase;
    }

    @Override
    public void calcularPrecio() {
        System.out.println("Calculando precio para Paquete de Servicios: ");
        calcularPrecioTotal();

    }

    private void calcularPrecioTotal() {
        int total = precioBase;
        for (ServiceComponent service : services) {
            total += service.getPrecioBase();
        }
        System.out.println("Precio total del paquete " + nombre + ": " + total);
    }

    @Override
    public String listarHojas() {
        return services.toString();
    }
}
