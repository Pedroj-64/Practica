package co.edu.uniquindio.builder;

/**
 * Director para el patrón Builder de Pizza.
 * 
 * El Director es opcional en el patrón Builder, pero es útil para encapsular
 * las diferentes formas de construir un objeto complejo usando el mismo Builder.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class PizzaDirector {
    
    /**
     * Construye una pizza hawaiana.
     * 
     * @param tamaño El tamaño de la pizza
     * @return Una pizza hawaiana con los ingredientes típicos
     */
    public Pizza construirPizzaHawaiana(String tamaño) {
        return new Pizza.Builder(tamaño, "Tradicional")
                .salsa("Tomate")
                .queso("Mozzarella")
                .agregarIngrediente("Jamón")
                .agregarIngrediente("Piña")
                .build();
    }
    
    /**
     * Construye una pizza vegetariana.
     * 
     * @param tamaño El tamaño de la pizza
     * @return Una pizza vegetariana con ingredientes vegetarianos
     */
    public Pizza construirPizzaVegetariana(String tamaño) {
        return new Pizza.Builder(tamaño, "Integral")
                .salsa("Tomate")
                .queso("Mozzarella Vegana")
                .agregarIngrediente("Pimiento")
                .agregarIngrediente("Cebolla")
                .agregarIngrediente("Champiñones")
                .agregarIngrediente("Aceitunas")
                .agregarTopping("Orégano")
                .build();
    }
    
    /**
     * Construye una pizza carnes.
     * 
     * @param tamaño El tamaño de la pizza
     * @param bordeCon Si tiene borde con queso
     * @return Una pizza de carnes con varios tipos de carne
     */
    public Pizza construirPizzaCarnes(String tamaño, boolean bordeCon) {
        Pizza.Builder builder = new Pizza.Builder(tamaño, "Tradicional")
                .salsa("BBQ")
                .queso("Mozzarella")
                .agregarIngrediente("Pepperoni")
                .agregarIngrediente("Jamón")
                .agregarIngrediente("Salchicha")
                .agregarIngrediente("Carne molida")
                .agregarTopping("Orégano")
                .dobleQueso(true);
        
        if (bordeCon) {
            builder.borde(true, "Queso Cheddar");
        }
        
        return builder.build();
    }
    
    /**
     * Construye una pizza personalizada de cuatro quesos.
     * 
     * @param tamaño El tamaño de la pizza
     * @param tipoMasa El tipo de masa de la pizza
     * @return Una pizza con cuatro tipos de queso
     */
    public Pizza construirPizzaCuatroQuesos(String tamaño, String tipoMasa) {
        return new Pizza.Builder(tamaño, tipoMasa)
                .salsa("Tomate")
                .queso("Mezcla Especial")
                .agregarIngrediente("Queso Mozzarella")
                .agregarIngrediente("Queso Gorgonzola")
                .agregarIngrediente("Queso Parmesano")
                .agregarIngrediente("Queso de Cabra")
                .agregarTopping("Orégano")
                .agregarTopping("Aceite de oliva")
                .instruccionesEspeciales("Hornear a temperatura alta para que los quesos se derritan bien")
                .build();
    }
    
    /**
     * Construye una pizza especial de la casa.
     * 
     * @param tamaño El tamaño de la pizza
     * @return Una pizza especial con muchos ingredientes y toppings
     */
    public Pizza construirPizzaEspecialDelChef(String tamaño) {
        return new Pizza.Builder(tamaño, "Artesanal")
                .salsa("Tomate y Albahaca")
                .queso("Mozzarella Fresca")
                .agregarIngrediente("Jamón Serrano")
                .agregarIngrediente("Rúcula")
                .agregarIngrediente("Tomate Cherry")
                .agregarIngrediente("Queso Parmesano")
                .agregarTopping("Aceite de oliva extra virgen")
                .agregarTopping("Reducción de Balsámico")
                .agregarTopping("Sal Marina")
                .borde(true, "Queso con Miel")
                .instruccionesEspeciales("Servir con una guarnición de rúcula fresca después de hornear")
                .build();
    }
}