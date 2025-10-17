package co.edu.uniquindio;

/**
 * Módulo que gestiona el cálculo de compras y descuentos.
 */
public class ModuloVentas {

    public double calcularTotal(Libro libro, int cantidad) {
        double total = libro.getPrecio() * cantidad;

        if (total > 100) {
            total *= 0.9; // Aplica descuento del 10%
            System.out.println("💸 Descuento aplicado (10%)");
        }

        return total;
    }
}

