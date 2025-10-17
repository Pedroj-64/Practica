# Patrón de Diseño Singleton

## Descripción
El patrón Singleton es un patrón de diseño creacional que garantiza que una clase tenga una única instancia y proporciona un punto de acceso global a ella. Este patrón es útil cuando exactamente un objeto es necesario para coordinar acciones en todo el sistema.

## Propósito
- Asegurar que una clase tenga una única instancia
- Proporcionar un punto de acceso global a dicha instancia
- Controlar el acceso concurrente a recursos compartidos

## Estructura del Patrón Singleton
La implementación básica del patrón Singleton incluye:

1. **Constructor privado**: Para evitar la instanciación directa desde fuera de la clase
2. **Variable estática privada**: Para almacenar la única instancia de la clase
3. **Método estático público**: Para obtener la instancia (creándola si no existe)

## Variantes de Implementación

### 1. Inicialización perezosa (Lazy Initialization)
La instancia se crea solo cuando se necesita por primera vez:

```java
public class Singleton {
    private static Singleton instance;
    
    private Singleton() {}
    
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

### 2. Inicialización temprana (Eager Initialization)
La instancia se crea al cargar la clase:

```java
public class Singleton {
    private static final Singleton instance = new Singleton();
    
    private Singleton() {}
    
    public static Singleton getInstance() {
        return instance;
    }
}
```

### 3. Thread-Safe Singleton
Para entornos multihilo:

```java
public class Singleton {
    private static volatile Singleton instance;
    
    private Singleton() {}
    
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

### 4. Inicialización con holder estático
Aprovecha la inicialización de clases por parte de la JVM:

```java
public class Singleton {
    private Singleton() {}
    
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
```

## Ventajas del Patrón Singleton
1. **Control de acceso**: Controla el acceso a la única instancia
2. **Espacio de nombres reducido**: Evita contaminar el espacio de nombres global
3. **Permite refinamiento**: La clase Singleton puede tener subclases
4. **Número variable de instancias**: Fácil de extender para permitir un número controlado de instancias
5. **Más flexible que métodos estáticos**: Permite polimorfismo

## Desventajas del Patrón Singleton
1. **Viola el principio de responsabilidad única**: La clase gestiona su propia instanciación
2. **Difícil de probar**: Crea dependencias ocultas y dificulta la prueba unitaria
3. **Acoplamiento alto**: Los componentes que usan un singleton están acoplados a él
4. **Problemas de concurrencia**: Requiere tratamiento especial en entornos multihilo
5. **Estado global**: Puede llevar a código difícil de mantener

## Casos de Uso Comunes
- **Conexiones a bases de datos**: Para compartir una conexión costosa
- **Registros de log (loggers)**: Para centralizar el registro de eventos
- **Configuraciones de la aplicación**: Para mantener configuraciones globales
- **Pools de recursos**: Para gestionar recursos compartidos
- **Cachés**: Para almacenar y compartir datos en caché
- **Diálogos de sistema**: Para controlar la visualización de cuadros de diálogo
- **Spoolers de impresión**: Para gestionar colas de impresión
- **Administradores de estado**: Para manejar el estado de la aplicación

## Consideraciones de Implementación
1. **Serialización**: Si la clase es serializable, se deben sobrescribir los métodos readObject/readResolve
2. **Reflexión**: El constructor privado puede ser accesible mediante reflexión
3. **Carga de clases**: Problemas si hay varios cargadores de clases
4. **Inicialización**: Considerar inicialización perezosa vs temprana según el caso

## Ejemplo Práctico
En este proyecto se incluye un ejemplo práctico del patrón Singleton aplicado a una conexión de base de datos:

- `DatabaseConnection.java`: Implementación del Singleton que simula una conexión a base de datos
- `SingletonDemo.java`: Clase que demuestra el uso del Singleton y verifica que siempre se obtiene la misma instancia

## Conclusión
El patrón Singleton es útil cuando se necesita controlar el acceso a un recurso compartido o cuando se requiere una única instancia de una clase en todo el sistema. Sin embargo, debe usarse con precaución considerando sus desventajas, especialmente en lo relacionado con el acoplamiento y las pruebas.