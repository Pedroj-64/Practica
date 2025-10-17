package co.edu.uniquindio.builder;

import java.time.LocalDateTime;

/**
 * Clase de demostración para el patrón Builder.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class BuilderDemo {
    
    public static void main(String[] args) {
        System.out.println("===== DEMOSTRACIÓN DEL PATRÓN BUILDER =====\n");
        
        // Demostración del uso directo del Builder
        demoPizzaBuilder();
        
        // Demostración del uso del Director con el Builder
        demoPizzaDirector();
        
        // Demostración del Builder como clase separada
        demoPedidoBuilder();
        
        // Demostración de un pedido completo
        demoPedidoCompleto();
        
        System.out.println("\n===== FIN DE LA DEMOSTRACIÓN =====");
    }
    
    /**
     * Demostración del uso directo del Builder de Pizza.
     */
    private static void demoPizzaBuilder() {
        System.out.println("----- USO DIRECTO DEL BUILDER DE PIZZA -----\n");
        
        // Construcción paso a paso de una pizza usando el builder
        Pizza pizza = new Pizza.Builder("Grande", "Delgada")
                .salsa("Tomate")
                .queso("Mozzarella")
                .agregarIngrediente("Jamón")
                .agregarIngrediente("Champiñones")
                .agregarTopping("Orégano")
                .borde(true, "Queso")
                .dobleQueso(true)
                .build();
        
        System.out.println("Pizza creada directamente con el Builder:");
        System.out.println(pizza.toString());
        System.out.println("Precio: $" + pizza.calcularPrecio());
    }
    
    /**
     * Demostración del uso del Director con el Builder de Pizza.
     */
    private static void demoPizzaDirector() {
        System.out.println("\n----- USO DEL DIRECTOR CON EL BUILDER DE PIZZA -----\n");
        
        // Creamos un director
        PizzaDirector director = new PizzaDirector();
        
        // Usamos el director para construir diferentes tipos de pizzas
        Pizza hawaiana = director.construirPizzaHawaiana("Mediana");
        Pizza vegetariana = director.construirPizzaVegetariana("Grande");
        Pizza carnes = director.construirPizzaCarnes("Familiar", true);
        
        System.out.println("Pizza Hawaiana creada con el Director:");
        System.out.println(hawaiana.toString());
        System.out.println("Precio: $" + hawaiana.calcularPrecio());
        
        System.out.println("\nPizza Vegetariana creada con el Director:");
        System.out.println(vegetariana.toString());
        System.out.println("Precio: $" + vegetariana.calcularPrecio());
        
        System.out.println("\nPizza de Carnes creada con el Director:");
        System.out.println(carnes.toString());
        System.out.println("Precio: $" + carnes.calcularPrecio());
    }
    
    /**
     * Demostración del Builder como clase separada.
     */
    private static void demoPedidoBuilder() {
        System.out.println("\n----- USO DEL BUILDER COMO CLASE SEPARADA -----\n");
        
        // Creamos un pedido usando el builder
        Pizza pizza = new Pizza.Builder("Personal", "Tradicional")
                .salsa("Tomate")
                .queso("Mozzarella")
                .agregarIngrediente("Jamón")
                .agregarIngrediente("Champiñones")
                .build();
        
        Pedido pedido = new PedidoBuilder("Juan Pérez", "3101234567")
                .agregarPizza(pizza)
                .agregarBebida("Coca-Cola 350ml")
                .conMetodoPago("Tarjeta de Crédito")
                .build();
        
        System.out.println("Pedido creado con el Builder separado:");
        System.out.println(pedido.toString());
    }
    
    /**
     * Demostración de un pedido completo.
     */
    private static void demoPedidoCompleto() {
        System.out.println("\n----- DEMOSTRACIÓN DE UN PEDIDO COMPLETO -----\n");
        
        // Creamos un director de pizzas
        PizzaDirector director = new PizzaDirector();
        
        // Creamos varias pizzas usando el director
        Pizza pizza1 = director.construirPizzaCarnes("Grande", true);
        Pizza pizza2 = director.construirPizzaCuatroQuesos("Mediana", "Delgada");
        
        // Creamos un pedido completo
        Pedido pedidoCompleto = new PedidoBuilder("María Rodríguez", "3157654321")
                .conDelivery("Calle 123 #45-67, Apto 301")
                .agregarPizza(pizza1)
                .agregarPizza(pizza2)
                .agregarBebida("Sprite 1.5L")
                .agregarBebida("Agua con gas 500ml")
                .agregarAdicional("Palitos de ajo")
                .agregarAdicional("Alitas BBQ x6")
                .conMetodoPago("Efectivo")
                .conNotas("El timbre no funciona, por favor llamar al celular al llegar.")
                .conFechaHora(LocalDateTime.now().plusHours(1))
                .build();
        
        System.out.println("Pedido completo:");
        System.out.println(pedidoCompleto.toString());
    }
}