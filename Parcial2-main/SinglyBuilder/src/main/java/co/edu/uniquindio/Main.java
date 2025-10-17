package co.edu.uniquindio;

/**
 * Clase principal para probar los patrones.
 */
public class Main {
    public static void main(String[] args) {

        // Singleton
        Configuracion c1 = Configuracion.getInstancia();
        Configuracion c2 = Configuracion.getInstancia();
        System.out.println("¿Misma instancia?: " + (c1 == c2));
        c1.mostrar();

        // Builder
        Usuario u1 = new Usuario.Builder()
                .setNombre("Santiago")
                .setRol("Admin")
                .build();

        Usuario u2 = new Usuario.Builder()
                .setNombre("Laura")
                .setRol("Cliente")
                .build();

        u1.mostrar();
        u2.mostrar();
    }
}