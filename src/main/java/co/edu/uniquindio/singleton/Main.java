package co.edu.uniquindio.singleton;

/**
 * Clase principal que demuestra diferentes implementaciones del patrón Singleton.
 * Esta clase contiene el método main para ejecutar los ejemplos.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("===== DEMOSTRACIÓN DEL PATRÓN SINGLETON =====");
        
        // Ejecutar la demostración básica del Singleton
        System.out.println("\n----- EJEMPLO BÁSICO DE SINGLETON -----");
        SingletonDemo.main(args);
        
        // Pausa para mejor visualización
        pausar(1000);
        
        // Ejecutar la demostración thread-safe del Singleton
        System.out.println("\n----- EJEMPLO THREAD-SAFE DE SINGLETON -----");
        ThreadSafeDatabaseConnection.testWithMultipleThreads();
        
        // Pausa para esperar a que terminen los hilos
        pausar(3000);
        
        System.out.println("\n===== RESUMEN DE IMPLEMENTACIONES DEL PATRÓN SINGLETON =====");
        System.out.println("1. Singleton básico (DatabaseConnection):");
        System.out.println("   - Implementación simple con inicialización perezosa");
        System.out.println("   - No es seguro para entornos multihilo");
        System.out.println("   - Adecuado para aplicaciones de un solo hilo");
        
        System.out.println("\n2. Singleton thread-safe (ThreadSafeDatabaseConnection):");
        System.out.println("   - Implementación avanzada con Double-Checked Locking");
        System.out.println("   - Seguro para entornos multihilo");
        System.out.println("   - Utiliza 'volatile' para garantizar visibilidad entre hilos");
        System.out.println("   - Minimiza la sobrecarga de sincronización");
        
        System.out.println("\n===== CONCLUSIONES =====");
        System.out.println("- El patrón Singleton es útil cuando se necesita una única instancia");
        System.out.println("- Existen diferentes implementaciones según las necesidades");
        System.out.println("- Es importante considerar la concurrencia en aplicaciones multihilo");
        System.out.println("- Debe usarse con precaución para evitar problemas de acoplamiento");
    }
    
    /**
     * Método auxiliar para hacer pausas en la ejecución.
     * 
     * @param milliseconds Tiempo en milisegundos para pausar la ejecución
     */
    private static void pausar(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}