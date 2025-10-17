package co.edu.uniquindio.bridge;

/**
 * Diagrama UML del patrón Bridge
 * 
 * +----------------+                  +------------------------+
 * | ControlRemoto  |<>--------------->| DispositivoElectronico |
 * |  (Abstraction) |                  |     (Implementor)      |
 * +----------------+                  +------------------------+
 *        ^                                       ^
 *        |                                       |
 *        |                                      / \
 *        |                                     /   \
 *        |                                    /     \
 *       / \                        +------------+  +-----------------+
 *      /   \                       |  Televisor |  | ReproductorAudio|
 *     /     \                      |(ConcreteIm |  | (ConcreteImpl)  |
 *    /       \                     | plementor) |  |                 |
 *   /         \                    +------------+  +-----------------+
 *  /           \
 * |             |
 * |             |
 * |             |
 * +----------------+  +---------------------------+
 * | ControlRemoto  |  |  ControlRemotoMultimedia  |
 * |   Avanzado     |  |  (RefinedAbstraction)     |
 * |(RefinedAbstrac |  |                           |
 * |     tion)      |  |                           |
 * +----------------+  +---------------------------+
 * 
 * Estructura del Patrón Bridge:
 * 
 * 1. Abstraction (ControlRemoto):
 *    - Define la interfaz de alto nivel
 *    - Mantiene una referencia al Implementor
 *    - Delega operaciones al objeto Implementor
 * 
 * 2. RefinedAbstraction (ControlRemotoAvanzado, ControlRemotoMultimedia):
 *    - Extienden la interfaz definida por Abstraction
 *    - Agregan funcionalidades más específicas
 * 
 * 3. Implementor (DispositivoElectronico):
 *    - Define la interfaz para las clases de implementación
 *    - La interfaz no tiene que corresponder a la de Abstraction
 * 
 * 4. ConcreteImplementor (Televisor, ReproductorAudio):
 *    - Implementan la interfaz del Implementor
 *    - Proporcionan implementaciones concretas
 * 
 * Relaciones:
 * - Abstraction tiene una relación de agregación (bridge) con Implementor
 * - RefinedAbstraction hereda de Abstraction
 * - ConcreteImplementor implementa Implementor
 * 
 * Flujo de ejecución:
 * 1. El cliente crea un objeto ConcreteImplementor
 * 2. El cliente crea un objeto Abstraction (o RefinedAbstraction) pasando el 
 *    objeto ConcreteImplementor
 * 3. El cliente llama a métodos de la Abstraction
 * 4. La Abstraction delega las operaciones al objeto Implementor
 * 
 * Ventajas:
 * - Desacopla la interfaz de su implementación
 * - Mejora la extensibilidad
 * - Oculta detalles de implementación a los clientes
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class DiagramaBridge {
    // Esta clase solo contiene documentación
}