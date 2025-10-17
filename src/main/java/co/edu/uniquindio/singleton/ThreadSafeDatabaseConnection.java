package co.edu.uniquindio.singleton;

/**
 * Implementación avanzada del patrón Singleton que es segura para entornos multihilo.
 * 
 * Esta clase demuestra un Singleton thread-safe utilizando el enfoque de "Double-Checked Locking"
 * y la palabra clave "volatile" para garantizar la visibilidad correcta entre hilos.
 * 
 * @author Pedro Jose 
 * @version 1.0
 */
public final class ThreadSafeDatabaseConnection {
    
    // La palabra clave volatile garantiza que los cambios a la instancia son visibles para todos los hilos
    private static volatile ThreadSafeDatabaseConnection instance;
    
    // Variables para la conexión
    private String connectionId;
    private boolean connected;
    
    /**
     * Constructor privado
     */
    private ThreadSafeDatabaseConnection() {
        this.connectionId = "conn-" + System.currentTimeMillis();
        this.connected = false;
        
        // Simular inicialización costosa
        try {
            Thread.sleep(1000);
            System.out.println("Inicializando conexión a base de datos con ID: " + connectionId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Método para obtener la instancia del Singleton con implementación thread-safe.
     * Utiliza "Double-Checked Locking" para minimizar la sobrecarga de sincronización.
     * 
     * @return La única instancia de ThreadSafeDatabaseConnection
     */
    public static ThreadSafeDatabaseConnection getInstance() {
        // Primera verificación (sin sincronización)
        if (instance == null) {
            // Sincronización en la clase
            synchronized (ThreadSafeDatabaseConnection.class) {
                // Segunda verificación (con sincronización)
                if (instance == null) {
                    instance = new ThreadSafeDatabaseConnection();
                }
            }
        }
        return instance;
    }
    
    /**
     * Método que simula la conexión a la base de datos.
     */
    public void connect() {
        if (!connected) {
            System.out.println("Conectando con ID: " + connectionId);
            connected = true;
        } else {
            System.out.println("Ya conectado con ID: " + connectionId);
        }
    }
    
    /**
     * Método que retorna el ID único de la conexión.
     * Este ID nos ayuda a verificar que siempre es la misma instancia.
     * 
     * @return El ID único de la conexión
     */
    public String getConnectionId() {
        return connectionId;
    }
    
    /**
     * Método para demostrar el Singleton thread-safe con múltiples hilos.
     */
    public static void testWithMultipleThreads() {
        System.out.println("=== PRUEBA DE SINGLETON THREAD-SAFE CON MÚLTIPLES HILOS ===");
        
        // Creamos varios hilos que intentarán obtener la instancia del Singleton
        Runnable task = () -> {
            ThreadSafeDatabaseConnection connection = ThreadSafeDatabaseConnection.getInstance();
            connection.connect();
            System.out.println(Thread.currentThread().getName() + " - ID de conexión: " + connection.getConnectionId());
        };
        
        // Creamos y arrancamos 5 hilos
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(task, "Hilo-" + i);
            thread.start();
        }
    }
}