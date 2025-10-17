package co.edu.uniquindio.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Pizza que representa el producto complejo que se construirá.
 * Esta clase tiene muchos parámetros opcionales y obligatorios,
 * lo que la hace ideal para aplicar el patrón Builder.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class Pizza {
    
    // Atributos obligatorios
    private final String tamaño;
    private final String tipoMasa;
    
    // Atributos opcionales
    private final String salsa;
    private final String queso;
    private final List<String> ingredientes;
    private final List<String> toppings;
    private final boolean bordeCon;
    private final String tipoBorde;
    private final boolean dobleQueso;
    private final String instruccionesEspeciales;
    
    /**
     * Constructor privado que recibe un Builder para construir la Pizza.
     * Este constructor es privado para forzar el uso del Builder.
     * 
     * @param builder Builder que contiene los valores para todos los atributos
     */
    private Pizza(Builder builder) {
        this.tamaño = builder.tamaño;
        this.tipoMasa = builder.tipoMasa;
        this.salsa = builder.salsa;
        this.queso = builder.queso;
        this.ingredientes = builder.ingredientes;
        this.toppings = builder.toppings;
        this.bordeCon = builder.bordeCon;
        this.tipoBorde = builder.tipoBorde;
        this.dobleQueso = builder.dobleQueso;
        this.instruccionesEspeciales = builder.instruccionesEspeciales;
    }
    
    // Getters para todos los atributos
    
    public String getTamaño() {
        return tamaño;
    }
    
    public String getTipoMasa() {
        return tipoMasa;
    }
    
    public String getSalsa() {
        return salsa;
    }
    
    public String getQueso() {
        return queso;
    }
    
    public List<String> getIngredientes() {
        return new ArrayList<>(ingredientes);  // Devolvemos una copia para mantener la inmutabilidad
    }
    
    public List<String> getToppings() {
        return new ArrayList<>(toppings);  // Devolvemos una copia para mantener la inmutabilidad
    }
    
    public boolean isBordeCon() {
        return bordeCon;
    }
    
    public String getTipoBorde() {
        return tipoBorde;
    }
    
    public boolean isDobleQueso() {
        return dobleQueso;
    }
    
    public String getInstruccionesEspeciales() {
        return instruccionesEspeciales;
    }
    
    /**
     * Método que retorna una representación en String de la Pizza.
     * 
     * @return Una descripción detallada de la pizza
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== PIZZA ===\n");
        sb.append("Tamaño: ").append(tamaño).append("\n");
        sb.append("Tipo de masa: ").append(tipoMasa).append("\n");
        
        if (salsa != null) {
            sb.append("Salsa: ").append(salsa).append("\n");
        }
        
        if (queso != null) {
            sb.append("Queso: ").append(queso);
            if (dobleQueso) {
                sb.append(" (doble)");
            }
            sb.append("\n");
        }
        
        if (!ingredientes.isEmpty()) {
            sb.append("Ingredientes:\n");
            for (String ingrediente : ingredientes) {
                sb.append("  - ").append(ingrediente).append("\n");
            }
        }
        
        if (!toppings.isEmpty()) {
            sb.append("Toppings:\n");
            for (String topping : toppings) {
                sb.append("  - ").append(topping).append("\n");
            }
        }
        
        if (bordeCon) {
            sb.append("Borde con: ").append(tipoBorde).append("\n");
        }
        
        if (instruccionesEspeciales != null) {
            sb.append("Instrucciones especiales: ").append(instruccionesEspeciales).append("\n");
        }
        
        return sb.toString();
    }
    
    /**
     * Calcular el precio total de la pizza basado en sus características.
     * 
     * @return El precio calculado
     */
    public double calcularPrecio() {
        double precio = 0;
        
        // Precio base según tamaño
        switch (tamaño) {
            case "Personal":
                precio += 12000;
                break;
            case "Mediana":
                precio += 24000;
                break;
            case "Grande":
                precio += 36000;
                break;
            case "Familiar":
                precio += 45000;
                break;
        }
        
        // Precio adicional por tipo de masa
        if ("Integral".equals(tipoMasa) || "Sin Gluten".equals(tipoMasa)) {
            precio += 3000;
        }
        
        // Precio adicional por ingredientes y toppings
        precio += ingredientes.size() * 2000;
        precio += toppings.size() * 3000;
        
        // Precio adicional por borde
        if (bordeCon) {
            precio += 5000;
        }
        
        // Precio adicional por doble queso
        if (dobleQueso) {
            precio += 4000;
        }
        
        return precio;
    }
    
    /**
     * Clase Builder estática para construir objetos Pizza.
     */
    public static class Builder {
        // Parámetros obligatorios
        private final String tamaño;
        private final String tipoMasa;
        
        // Parámetros opcionales con valores predeterminados
        private String salsa = "Tomate";
        private String queso = "Mozzarella";
        private List<String> ingredientes = new ArrayList<>();
        private List<String> toppings = new ArrayList<>();
        private boolean bordeCon = false;
        private String tipoBorde = "Queso";
        private boolean dobleQueso = false;
        private String instruccionesEspeciales = null;
        
        /**
         * Constructor del Builder que requiere los parámetros obligatorios.
         * 
         * @param tamaño Tamaño de la pizza (Personal, Mediana, Grande, Familiar)
         * @param tipoMasa Tipo de masa (Tradicional, Delgada, Integral, Sin Gluten)
         */
        public Builder(String tamaño, String tipoMasa) {
            this.tamaño = tamaño;
            this.tipoMasa = tipoMasa;
        }
        
        /**
         * Método para establecer el tipo de salsa.
         * 
         * @param salsa Tipo de salsa
         * @return El builder para encadenar llamadas
         */
        public Builder salsa(String salsa) {
            this.salsa = salsa;
            return this;
        }
        
        /**
         * Método para establecer el tipo de queso.
         * 
         * @param queso Tipo de queso
         * @return El builder para encadenar llamadas
         */
        public Builder queso(String queso) {
            this.queso = queso;
            return this;
        }
        
        /**
         * Método para añadir un ingrediente.
         * 
         * @param ingrediente Ingrediente a añadir
         * @return El builder para encadenar llamadas
         */
        public Builder agregarIngrediente(String ingrediente) {
            this.ingredientes.add(ingrediente);
            return this;
        }
        
        /**
         * Método para establecer todos los ingredientes de una vez.
         * 
         * @param ingredientes Lista de ingredientes
         * @return El builder para encadenar llamadas
         */
        public Builder ingredientes(List<String> ingredientes) {
            this.ingredientes = new ArrayList<>(ingredientes);
            return this;
        }
        
        /**
         * Método para añadir un topping.
         * 
         * @param topping Topping a añadir
         * @return El builder para encadenar llamadas
         */
        public Builder agregarTopping(String topping) {
            this.toppings.add(topping);
            return this;
        }
        
        /**
         * Método para establecer todos los toppings de una vez.
         * 
         * @param toppings Lista de toppings
         * @return El builder para encadenar llamadas
         */
        public Builder toppings(List<String> toppings) {
            this.toppings = new ArrayList<>(toppings);
            return this;
        }
        
        /**
         * Método para establecer el borde con queso u otro ingrediente.
         * 
         * @param bordeCon Si tiene borde relleno
         * @param tipoBorde Tipo de relleno del borde
         * @return El builder para encadenar llamadas
         */
        public Builder borde(boolean bordeCon, String tipoBorde) {
            this.bordeCon = bordeCon;
            if (bordeCon) {
                this.tipoBorde = tipoBorde;
            }
            return this;
        }
        
        /**
         * Método para establecer si lleva doble queso.
         * 
         * @param dobleQueso Si lleva doble queso
         * @return El builder para encadenar llamadas
         */
        public Builder dobleQueso(boolean dobleQueso) {
            this.dobleQueso = dobleQueso;
            return this;
        }
        
        /**
         * Método para establecer instrucciones especiales.
         * 
         * @param instruccionesEspeciales Instrucciones especiales para la preparación
         * @return El builder para encadenar llamadas
         */
        public Builder instruccionesEspeciales(String instruccionesEspeciales) {
            this.instruccionesEspeciales = instruccionesEspeciales;
            return this;
        }
        
        /**
         * Método que construye la pizza con los parámetros especificados.
         * 
         * @return Una nueva instancia de Pizza
         */
        public Pizza build() {
            return new Pizza(this);
        }
    }
}