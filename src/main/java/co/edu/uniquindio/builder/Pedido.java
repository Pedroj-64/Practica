package co.edu.uniquindio.builder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase Pedido que representa un pedido de pizzas y otros productos.
 * Esta clase utiliza el patrón Builder para su construcción.
 * 
 * A diferencia de la clase Pizza, aquí implementamos el Builder como una clase separada
 * en lugar de una clase interna estática.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class Pedido {
    
    // Atributos del pedido
    private final String numeroPedido;
    private final String nombreCliente;
    private final String telefonoCliente;
    private final String direccionEntrega;
    private final List<Pizza> pizzas;
    private final List<String> bebidas;
    private final List<String> adicionales;
    private final String metodoPago;
    private final double totalPago;
    private final LocalDateTime fechaHora;
    private final boolean delivery;
    private final String notasAdicionales;
    
    /**
     * Constructor que recibe un Builder para construir el Pedido.
     * Package-private para que pueda ser accedido por el PedidoBuilder.
     * 
     * @param builder Builder que contiene los valores para todos los atributos
     */
    Pedido(PedidoBuilder builder) {
        this.numeroPedido = builder.numeroPedido;
        this.nombreCliente = builder.nombreCliente;
        this.telefonoCliente = builder.telefonoCliente;
        this.direccionEntrega = builder.direccionEntrega;
        this.pizzas = builder.pizzas;
        this.bebidas = builder.bebidas;
        this.adicionales = builder.adicionales;
        this.metodoPago = builder.metodoPago;
        this.totalPago = builder.calcularTotalPago();
        this.fechaHora = builder.fechaHora;
        this.delivery = builder.delivery;
        this.notasAdicionales = builder.notasAdicionales;
    }
    
    // Getters
    
    public String getNumeroPedido() {
        return numeroPedido;
    }
    
    public String getNombreCliente() {
        return nombreCliente;
    }
    
    public String getTelefonoCliente() {
        return telefonoCliente;
    }
    
    public String getDireccionEntrega() {
        return direccionEntrega;
    }
    
    public List<Pizza> getPizzas() {
        return new ArrayList<>(pizzas);
    }
    
    public List<String> getBebidas() {
        return new ArrayList<>(bebidas);
    }
    
    public List<String> getAdicionales() {
        return new ArrayList<>(adicionales);
    }
    
    public String getMetodoPago() {
        return metodoPago;
    }
    
    public double getTotalPago() {
        return totalPago;
    }
    
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
    
    public boolean isDelivery() {
        return delivery;
    }
    
    public String getNotasAdicionales() {
        return notasAdicionales;
    }
    
    /**
     * Método que retorna una representación en String del Pedido.
     * 
     * @return Una descripción detallada del pedido
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        
        StringBuilder sb = new StringBuilder();
        sb.append("=== PEDIDO #").append(numeroPedido).append(" ===\n");
        sb.append("Fecha y hora: ").append(fechaHora.format(formatter)).append("\n");
        sb.append("Cliente: ").append(nombreCliente).append("\n");
        sb.append("Teléfono: ").append(telefonoCliente).append("\n");
        
        if (delivery) {
            sb.append("DELIVERY a: ").append(direccionEntrega).append("\n");
        } else {
            sb.append("PARA RECOGER EN TIENDA\n");
        }
        
        sb.append("\n=== PRODUCTOS ===\n");
        
        int numeroPizza = 1;
        for (Pizza pizza : pizzas) {
            sb.append("\nPIZZA #").append(numeroPizza++).append(":\n");
            sb.append(pizza.toString());
        }
        
        if (!bebidas.isEmpty()) {
            sb.append("\n=== BEBIDAS ===\n");
            for (String bebida : bebidas) {
                sb.append("- ").append(bebida).append("\n");
            }
        }
        
        if (!adicionales.isEmpty()) {
            sb.append("\n=== ADICIONALES ===\n");
            for (String adicional : adicionales) {
                sb.append("- ").append(adicional).append("\n");
            }
        }
        
        sb.append("\nMétodo de pago: ").append(metodoPago).append("\n");
        sb.append("TOTAL A PAGAR: $").append(String.format("%.2f", totalPago)).append("\n");
        
        if (notasAdicionales != null && !notasAdicionales.isEmpty()) {
            sb.append("\nNotas adicionales: ").append(notasAdicionales).append("\n");
        }
        
        return sb.toString();
    }
}

/**
 * Builder para la clase Pedido.
 * En este caso, implementamos el Builder como una clase separada
 * en lugar de una clase interna estática.
 */
class PedidoBuilder {
    
    // Generador de número de pedido
    private static int contadorPedidos = 1000;
    
    // Atributos obligatorios
    String numeroPedido;
    String nombreCliente;
    String telefonoCliente;
    
    // Atributos opcionales con valores predeterminados
    String direccionEntrega = "";
    List<Pizza> pizzas = new ArrayList<>();
    List<String> bebidas = new ArrayList<>();
    List<String> adicionales = new ArrayList<>();
    String metodoPago = "Efectivo";
    LocalDateTime fechaHora = LocalDateTime.now();
    boolean delivery = false;
    String notasAdicionales = "";
    
    /**
     * Constructor del Builder que requiere los parámetros obligatorios.
     * 
     * @param nombreCliente Nombre del cliente
     * @param telefonoCliente Teléfono del cliente
     */
    public PedidoBuilder(String nombreCliente, String telefonoCliente) {
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.numeroPedido = generarNumeroPedido();
    }
    
    /**
     * Método para generar un número de pedido único.
     * 
     * @return Un número de pedido
     */
    private String generarNumeroPedido() {
        return "P" + (++contadorPedidos);
    }
    
    /**
     * Método para establecer la dirección de entrega y activar el delivery.
     * 
     * @param direccionEntrega Dirección donde entregar el pedido
     * @return El builder para encadenar llamadas
     */
    public PedidoBuilder conDelivery(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
        this.delivery = true;
        return this;
    }
    
    /**
     * Método para agregar una pizza al pedido.
     * 
     * @param pizza La pizza a agregar
     * @return El builder para encadenar llamadas
     */
    public PedidoBuilder agregarPizza(Pizza pizza) {
        this.pizzas.add(pizza);
        return this;
    }
    
    /**
     * Método para agregar una bebida al pedido.
     * 
     * @param bebida La bebida a agregar
     * @return El builder para encadenar llamadas
     */
    public PedidoBuilder agregarBebida(String bebida) {
        this.bebidas.add(bebida);
        return this;
    }
    
    /**
     * Método para agregar un adicional al pedido.
     * 
     * @param adicional El adicional a agregar
     * @return El builder para encadenar llamadas
     */
    public PedidoBuilder agregarAdicional(String adicional) {
        this.adicionales.add(adicional);
        return this;
    }
    
    /**
     * Método para establecer el método de pago.
     * 
     * @param metodoPago El método de pago
     * @return El builder para encadenar llamadas
     */
    public PedidoBuilder conMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
        return this;
    }
    
    /**
     * Método para establecer la fecha y hora del pedido.
     * 
     * @param fechaHora La fecha y hora
     * @return El builder para encadenar llamadas
     */
    public PedidoBuilder conFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
        return this;
    }
    
    /**
     * Método para agregar notas adicionales al pedido.
     * 
     * @param notas Las notas adicionales
     * @return El builder para encadenar llamadas
     */
    public PedidoBuilder conNotas(String notas) {
        this.notasAdicionales = notas;
        return this;
    }
    
    /**
     * Método para calcular el total a pagar del pedido.
     * 
     * @return El total a pagar
     */
    double calcularTotalPago() {
        double total = 0;
        
        // Sumar el precio de las pizzas
        for (Pizza pizza : pizzas) {
            total += pizza.calcularPrecio();
        }
        
        // Sumar el precio de las bebidas (precio fijo por simplicidad)
        total += bebidas.size() * 5000;
        
        // Sumar el precio de los adicionales (precio fijo por simplicidad)
        total += adicionales.size() * 8000;
        
        // Cargo por delivery si aplica
        if (delivery) {
            total += 7000;
        }
        
        return total;
    }
    
    /**
     * Método que construye el pedido con los parámetros especificados.
     * 
     * @return Una nueva instancia de Pedido
     */
    public Pedido build() {
        // Validación: debe haber al menos una pizza en el pedido
        if (pizzas.isEmpty()) {
            throw new IllegalStateException("Un pedido debe contener al menos una pizza");
        }
        
        // Validación: si es delivery, debe haber una dirección
        if (delivery && (direccionEntrega == null || direccionEntrega.trim().isEmpty())) {
            throw new IllegalStateException("Si el pedido es para delivery, debe proporcionar una dirección de entrega");
        }
        
        return new Pedido(this);
    }
}