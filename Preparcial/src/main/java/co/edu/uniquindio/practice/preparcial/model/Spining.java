package co.edu.uniquindio.practice.preparcial.model;
import co.edu.uniquindio.practice.preparcial.interfaces.ServiceComponent;

import java.util.Collections;
import java.util.List;

public class Spining implements ServiceComponent {
    private String nombre;
    private int precioBase;

    public Spining(String nombree, int precioBase) {
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
        // Implementación del cálculo de precio específico para Spining
        System.out.println("Calculando precio para Spining: " + precioBase);
    }

    @Override
    public String listarHojas() {
        return null;
    }
}
