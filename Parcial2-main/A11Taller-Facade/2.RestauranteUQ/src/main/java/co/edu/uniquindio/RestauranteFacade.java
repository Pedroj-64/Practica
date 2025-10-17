package co.edu.uniquindio;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Facade.
 * Unifica los tres subsistemas (menú, clientes y pedidos) en una interfaz simple.
 * El usuario solo usa esta clase sin conocer los detalles internos.
 */
class RestauranteFacade {

    private Menu menu;
    private SistemaClientes sistemaClientes;
    private SistemaPedidos sistemaPedidos;

    public RestauranteFacade() {
        this.menu = new Menu();
        this.sistemaClientes = new SistemaClientes();
        this.sistemaPedidos = new SistemaPedidos();
    }

    // Métodos de alto nivel

    /** Busca un cliente por nombre sin acceder directamente al subsistema. */
    public void buscarCliente(String nombre) {
        Cliente cliente = sistemaClientes.buscarCliente(nombre);
        if (cliente != null)
            System.out.println("Cliente encontrado: " + cliente);
        else
            System.out.println("Cliente no registrado: " + nombre);
    }

    /** Muestra el menú ordenado por precio. */
    public void consultarMenuOrdenadoPorPrecio() {
        System.out.println("\nMenú ordenado por precio:");
        for (Plato p : menu.obtenerMenuOrdenadoPorPrecio()) {
            System.out.println(" - " + p);
        }
    }

    /** Realiza un pedido completo, coordinando los subsistemas. */
    public void realizarPedido(String nombreCliente, List<String> nombresPlatos) {
        Cliente cliente = sistemaClientes.buscarCliente(nombreCliente);
        if (cliente == null) {
            System.out.println("El cliente no existe. Registrando nuevo...");
            cliente = new Cliente(nombreCliente);
            sistemaClientes.registrarCliente(cliente);
        }

        List<Plato> platosSeleccionados = new ArrayList<>();
        for (String nombre : nombresPlatos) {
            Plato plato = menu.buscarPlato(nombre);
            if (plato != null)
                platosSeleccionados.add(plato);
            else
                System.out.println("Plato no encontrado: " + nombre);
        }

        if (!platosSeleccionados.isEmpty())
            sistemaPedidos.registrarPedido(cliente, platosSeleccionados);
        else
            System.out.println("No se pudo realizar el pedido. Ningún plato válido seleccionado.");
    }

    /** Permite agregar platos al menú desde fuera de la fachada (uso opcional). */
    public void agregarPlatoAlMenu(Plato plato) {
        menu.agregarPlato(plato);
    }

    /** Permite registrar un cliente directamente. */
    public void registrarCliente(Cliente cliente) {
        sistemaClientes.registrarCliente(cliente);
    }
}
