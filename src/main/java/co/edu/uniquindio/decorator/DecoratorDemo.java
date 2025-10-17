package co.edu.uniquindio.decorator;

/**
 * Clase de demostración para el patrón Decorator.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class DecoratorDemo {
    
    public static void main(String[] args) {
        System.out.println("===== DEMOSTRACIÓN DEL PATRÓN DECORATOR =====\n");
        
        // Crear cafés base (componentes concretos)
        System.out.println("CAFÉS BÁSICOS:");
        
        Cafe espresso = new EspressoCafe();
        mostrarCafe(espresso);
        
        Cafe americano = new AmericanoCafe();
        mostrarCafe(americano);
        
        Cafe descafeinado = new DescafeinadoCafe();
        mostrarCafe(descafeinado);
        
        System.out.println("\nCAFÉS CON UN SOLO INGREDIENTE ADICIONAL:");
        
        // Decorar con un solo ingrediente
        Cafe espressoConLeche = new LecheDecorator(new EspressoCafe());
        mostrarCafe(espressoConLeche);
        
        Cafe americanoConChocolate = new ChocolateDecorator(new AmericanoCafe());
        mostrarCafe(americanoConChocolate);
        
        Cafe descafeinadoConCanela = new CanelaDecorator(new DescafeinadoCafe());
        mostrarCafe(descafeinadoConCanela);
        
        System.out.println("\nCAFÉS CON MÚLTIPLES INGREDIENTES ADICIONALES:");
        
        // Decorar con múltiples ingredientes (decoradores anidados)
        Cafe cafeEspecial1 = new CremaBatidaDecorator(
                                new ChocolateDecorator(
                                    new LecheDecorator(
                                        new EspressoCafe())));
        mostrarCafe(cafeEspecial1);
        
        Cafe cafeEspecial2 = new ChocolateDecorator(
                                new CanelaDecorator(
                                    new AmericanoCafe()));
        mostrarCafe(cafeEspecial2);
        
        System.out.println("\nUTILIZANDO MÉTODOS ESPECÍFICOS DE LOS DECORADORES:");
        
        // Acceder a métodos específicos de los decoradores
        LecheDecorator lecheDecorator = new LecheDecorator(new AmericanoCafe());
        System.out.println("Tipo de leche: " + lecheDecorator.getTipoLeche());
        
        ChocolateDecorator chocolateDecorator = new ChocolateDecorator(new EspressoCafe());
        System.out.println(chocolateDecorator.anadirExtraChocolate());
        
        CanelaDecorator canelaDecorator = new CanelaDecorator(new DescafeinadoCafe());
        System.out.println("La canela es orgánica: " + (canelaDecorator.esOrganica() ? "Sí" : "No"));
        
        CremaBatidaDecorator cremaDecorator = new CremaBatidaDecorator(new EspressoCafe());
        System.out.println("Cantidad de crema: " + cremaDecorator.getCantidadCrema() + " gramos");
        
        System.out.println("\nEJEMPLO DE CREACIÓN DINÁMICA DE CAFÉ PERSONALIZADO:");
        
        // Ejemplo de creación dinámica basada en preferencias del usuario
        Cafe cafeDinamico = crearCafePersonalizado(new EspressoCafe(), true, true, false, true);
        mostrarCafe(cafeDinamico);
        
        System.out.println("\n===== FIN DE LA DEMOSTRACIÓN =====");
    }
    
    /**
     * Muestra la información de un café.
     * 
     * @param cafe El café a mostrar
     */
    private static void mostrarCafe(Cafe cafe) {
        System.out.println("- " + cafe.getDescripcion() + ": $" + String.format("%.2f", cafe.costo()));
    }
    
    /**
     * Crea un café personalizado según las preferencias del usuario.
     * 
     * @param cafeBase El café base
     * @param conLeche Si se debe añadir leche
     * @param conChocolate Si se debe añadir chocolate
     * @param conCanela Si se debe añadir canela
     * @param conCremaBatida Si se debe añadir crema batida
     * @return El café personalizado con los ingredientes seleccionados
     */
    private static Cafe crearCafePersonalizado(Cafe cafeBase, boolean conLeche, boolean conChocolate, 
                                             boolean conCanela, boolean conCremaBatida) {
        Cafe cafeFinal = cafeBase;
        
        if (conLeche) {
            cafeFinal = new LecheDecorator(cafeFinal);
        }
        
        if (conChocolate) {
            cafeFinal = new ChocolateDecorator(cafeFinal);
        }
        
        if (conCanela) {
            cafeFinal = new CanelaDecorator(cafeFinal);
        }
        
        if (conCremaBatida) {
            cafeFinal = new CremaBatidaDecorator(cafeFinal);
        }
        
        return cafeFinal;
    }
}