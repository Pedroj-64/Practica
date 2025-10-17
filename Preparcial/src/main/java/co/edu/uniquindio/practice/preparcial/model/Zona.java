package co.edu.uniquindio.practice.preparcial.model;

import co.edu.uniquindio.practice.preparcial.interfaces.ServiceComponent;

import java.util.Collections;

public class Zona implements ServiceComponent {
    private String nombre;
    private int precioBase;

    public Zona(String nombre, int precioBase) {
        this.nombre = nombre;
        this.precioBase = precioBase;
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
        // Implementación del cálculo de precio específico para Zona
        System.out.println("Calculando precio para Zona: " + precioBase);
    }

    @Override
    public String listarHojas() {
        return null;
    }
}
