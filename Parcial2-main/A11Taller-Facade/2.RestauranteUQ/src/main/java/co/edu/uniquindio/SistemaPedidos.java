package co.edu.uniquindio;

import java.util.List;

/**
 * Subsistema 3: Pedidos
 * Calcula el total de la compra y aplica impuestos.
 */
class SistemaPedidos {

    public double calcularTotal(List<Plato> platos) {
        double subtotal = platos.stream().mapToDouble(Plato::getPrecio).sum();
        double impuesto = subtotal * 0.19; // IVA 19%
        return subtotal + impuesto;
    }

    public void registrarPedido(Cliente cliente, List<Plato> platos) {
        System.out.println("\nPedido registrado para " + cliente.getNombre());
        platos.forEach(p -> System.out.println(" - " + p));
        System.out.println("Total con impuestos: $" + calcularTotal(platos));
    }
}
