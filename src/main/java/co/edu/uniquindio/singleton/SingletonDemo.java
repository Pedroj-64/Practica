package co.edu.uniquindio.singleton;

/**
 * Clase de demostración que muestra el uso del patrón Singleton.
 * Esta clase contiene un método main para probar la clase DatabaseConnection
 * y verificar que siempre se obtiene la misma instancia.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class SingletonDemo {
    
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN DEL PATRÓN SINGLETON ===");
        
        // Obtenemos la primera instancia de DatabaseConnection
        System.out.println("\n1. Obteniendo primera instancia del Singleton");
        DatabaseConnection connection1 = DatabaseConnection.getInstance();
        
        // Conectamos a la base de datos con la primera instancia
        System.out.println("\n2. Conectando a la base de datos con la primera instancia");
        connection1.connect();
        
        // Ejecutamos una consulta
        System.out.println("\n3. Ejecutando consulta con la primera instancia");
        System.out.println("   Resultado: " + connection1.executeQuery("SELECT * FROM usuarios"));
        
        // Obtenemos una segunda instancia de DatabaseConnection
        System.out.println("\n4. Obteniendo segunda instancia del Singleton");
        DatabaseConnection connection2 = DatabaseConnection.getInstance();
        
        // Comprobamos si ambas instancias son la misma (comparación de referencias)
        System.out.println("\n5. Verificando si ambas instancias son la misma");
        System.out.println("   ¿Son la misma instancia? " + (connection1 == connection2));
        
        // Intentamos conectar con la segunda instancia (que en realidad es la misma)
        System.out.println("\n6. Intentando conectar con la segunda instancia");
        connection2.connect();
        
        // Intentamos cambiar los parámetros de conexión (no debería funcionar si está conectado)
        System.out.println("\n7. Intentando cambiar parámetros de conexión");
        connection2.setConnectionParams("nuevo-host:5432", "admin", "secreto");
        
        // Desconectamos usando la segunda instancia
        System.out.println("\n8. Desconectando usando la segunda instancia");
        connection2.disconnect();
        
        // Ahora sí podemos cambiar los parámetros
        System.out.println("\n9. Cambiando parámetros después de desconectar");
        connection1.setConnectionParams("nuevo-host:5432", "admin", "secreto");
        
        // Conectamos de nuevo
        System.out.println("\n10. Conectando de nuevo con los nuevos parámetros");
        connection1.connect();
        
        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
        
        // Explicación final
        System.out.println("\nEXPLICACIÓN:");
        System.out.println("- El patrón Singleton garantiza que solo exista una instancia de DatabaseConnection");
        System.out.println("- Aunque llamamos a getInstance() dos veces, obtenemos la misma instancia");
        System.out.println("- Esto se demuestra cuando connection1 == connection2 devuelve true");
        System.out.println("- Los cambios realizados a través de connection2 afectan a connection1 porque son la misma instancia");
    }
}