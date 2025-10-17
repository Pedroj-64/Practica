package co.edu.uniquindio.singleton;

/**
 * Ejemplo de implementación del patrón de diseño Singleton.
 * 
 * El patrón Singleton garantiza que una clase solo tenga una instancia y proporciona
 * un punto de acceso global a ella. Es útil cuando exactamente un objeto es necesario
 * para coordinar acciones en todo el sistema.
 * 
 * Casos de uso comunes:
 * - Conexiones a bases de datos
 * - Registros de log (loggers)
 * - Configuraciones de la aplicación
 * - Pools de conexiones o recursos
 * - Caché
 * 
 * @author Pedro Jose
 * @version 1.0
 */
public final class DatabaseConnection {
    
    // La instancia única se almacena en una variable estática privada
    private static DatabaseConnection instance;
    
    // Variables para la conexión (simuladas)
    private String host;
    private String username;
    private String password;
    private boolean connected;
    
    /**
     * El constructor es privado para evitar la instanciación directa desde fuera de la clase.
     * Esto asegura que la clase no pueda ser instanciada con el operador new.
     */
    private DatabaseConnection() {
        // Valores por defecto
        this.host = "localhost:3306";
        this.username = "root";
        this.password = "";
        this.connected = false;
        
        System.out.println("Inicializando conexión a la base de datos");
    }
    
    /**
     * Método estático que devuelve la única instancia de la clase.
     * Si la instancia no existe, la crea; de lo contrario, retorna la existente.
     * 
     * Este método implementa el "lazy initialization" (inicialización perezosa),
     * lo que significa que la instancia se crea solo cuando se necesita por primera vez.
     * 
     * @return La única instancia de DatabaseConnection
     */
    public static DatabaseConnection getInstance() {
        // Si la instancia no existe, la creamos
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        // Devolvemos la instancia (ya sea la recién creada o la existente)
        return instance;
    }
    
    /**
     * Método que simula la conexión a la base de datos.
     * 
     * @return true si la conexión fue exitosa, false en caso contrario
     */
    public boolean connect() {
        if (!connected) {
            System.out.println("Conectando a la base de datos en " + host + " con usuario " + username);
            // Simulamos la conexión
            connected = true;
            System.out.println("Conexión establecida exitosamente");
        } else {
            System.out.println("Ya existe una conexión activa");
        }
        return connected;
    }
    
    /**
     * Método que simula la desconexión de la base de datos.
     */
    public void disconnect() {
        if (connected) {
            System.out.println("Cerrando conexión a la base de datos");
            connected = false;
            System.out.println("Conexión cerrada exitosamente");
        } else {
            System.out.println("No hay conexión activa para cerrar");
        }
    }
    
    /**
     * Método para verificar si hay una conexión activa.
     * 
     * @return true si hay una conexión activa, false en caso contrario
     */
    public boolean isConnected() {
        return connected;
    }
    
    /**
     * Método para ejecutar una consulta en la base de datos (simulado).
     * 
     * @param query La consulta SQL a ejecutar
     * @return Un mensaje indicando el resultado de la operación
     */
    public String executeQuery(String query) {
        if (!connected) {
            return "Error: No hay conexión a la base de datos";
        }
        
        System.out.println("Ejecutando consulta: " + query);
        return "Consulta ejecutada exitosamente";
    }
    
    /**
     * Método para cambiar la configuración de la conexión.
     * 
     * @param host El nuevo host
     * @param username El nuevo nombre de usuario
     * @param password La nueva contraseña
     */
    public void setConnectionParams(String host, String username, String password) {
        // Solo permitimos cambiar los parámetros si no hay una conexión activa
        if (!connected) {
            this.host = host;
            this.username = username;
            this.password = password;
            System.out.println("Parámetros de conexión actualizados");
        } else {
            System.out.println("No se pueden cambiar los parámetros mientras hay una conexión activa");
        }
    }
}