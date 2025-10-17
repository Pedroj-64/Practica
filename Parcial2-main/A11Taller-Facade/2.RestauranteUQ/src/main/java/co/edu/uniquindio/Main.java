package co.edu.uniquindio;

import java.util.List;

/**
 * Clase Main.
 * Demuestra cómo el usuario interactúa solo con la fachada sin conocer los subsistemas.
 */
public class Main {
    public static void main(String[] args) {

        // Crear fachada
        RestauranteFacade restaurante = new RestauranteFacade();

        // Registrar datos iniciales
        restaurante.agregarPlatoAlMenu(new Plato("Bandeja Paisa", "Principal", 25000));
        restaurante.agregarPlatoAlMenu(new Plato("Ajiaco", "Principal", 18000));
        restaurante.agregarPlatoAlMenu(new Plato("Postre de Tres Leches", "Postre", 9000));

        restaurante.registrarCliente(new Cliente("Santiago"));

        // Consultar menú ordenado por precio
        restaurante.consultarMenuOrdenadoPorPrecio();

        // Buscar cliente existente
        restaurante.buscarCliente("Santiago");

        // Realizar pedido
        List<String> pedido = List.of("Bandeja Paisa", "Postre de Tres Leches");
        restaurante.realizarPedido("Santiago", pedido);
    }
}