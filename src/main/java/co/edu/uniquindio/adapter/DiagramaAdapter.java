package co.edu.uniquindio.adapter;

/**
 * Diagrama UML del patrón Adapter
 * 
 * +----------------------+       +------------------------+
 * |ReproductorMultimedia |<|---- |  ReproductorModerno   |
 * | (Target Interface)   |       | (ConcreteImplementation)|
 * +----------------------+       +------------------------+
 *           ^
 *           |
 *           |                    +------------------------+
 *           |                    |  SistemaAudioLegado   |
 *           |                    |      (Adaptee)        |
 *           |                    +------------------------+
 *           |                             ^
 *           |                             | Has-a
 *           |                    +------------------------+
 *           |------------------<>|  SistemaAudioAdapter   |
 *           |                    | (Object Adapter)      |
 *           |                    +------------------------+
 *           |
 *           |                    +------------------------+
 *           |                    |ReproductorVideoAntiguo|
 *           |                    |      (Adaptee)        |
 *           |                    +------------------------+
 *           |                             ^
 *           |                             | Is-a (extends)
 *           |                    +------------------------+
 *           |------------------<>|ReproductorVideoAdapter|
 *                                | (Class Adapter)       |
 *                                +------------------------+
 *           ^
 *           | Uses
 *           |
 * +----------------------+
 * |  ClienteMultimedia   |
 * | (Client)             |
 * +----------------------+
 * 
 * El patrón Adapter implementado:
 * 
 * 1. ReproductorMultimedia (Target):
 *    - Define la interfaz que espera el cliente.
 *    - Declara métodos como reproducir(), detener(), pausar(), etc.
 * 
 * 2. ReproductorModerno (ConcreteImplementation):
 *    - Implementa directamente la interfaz ReproductorMultimedia.
 *    - No requiere adaptación.
 * 
 * 3. SistemaAudioLegado (Adaptee):
 *    - Clase existente con interfaz incompatible.
 *    - Utiliza métodos como iniciarReproduccion(), detenerReproduccion(), etc.
 * 
 * 4. SistemaAudioAdapter (Object Adapter):
 *    - Implementa ReproductorMultimedia
 *    - Contiene una instancia de SistemaAudioLegado (composición)
 *    - Traduce llamadas de la interfaz target a la interfaz del adaptee
 * 
 * 5. ReproductorVideoAntiguo (Adaptee):
 *    - Otra clase existente con interfaz incompatible
 *    - Utiliza métodos como cargarVideo(), iniciarVideo(), etc.
 * 
 * 6. ReproductorVideoAdapter (Class Adapter):
 *    - Extiende ReproductorVideoAntiguo (herencia)
 *    - Implementa ReproductorMultimedia
 *    - Implementa los métodos de la interfaz target utilizando
 *      funcionalidad heredada del adaptee
 * 
 * 7. ClienteMultimedia (Client):
 *    - Utiliza la interfaz ReproductorMultimedia
 *    - Puede trabajar con cualquier implementación concreta o adaptador
 *      que implemente esta interfaz
 *    - No conoce los detalles de las clases concretas o adaptadas
 * 
 * 8. AdapterDemo:
 *    - Demuestra el uso del patrón Adapter
 *    - Muestra cómo las interfaces incompatibles pueden trabajar juntas
 *    - Ilustra los dos tipos de adaptadores: de clase y de objeto
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class DiagramaAdapter {
    // Esta clase solo contiene documentación
}