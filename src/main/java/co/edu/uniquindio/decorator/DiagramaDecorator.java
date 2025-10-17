package co.edu.uniquindio.decorator;

/**
 * Diagrama UML del patrón Decorator
 * 
 * +---------------+
 * |     Cafe      |
 * |  (Component)  |
 * +---------------+
 * | +getDescripcion() |
 * | +costo()     |
 * +---------------+
 *       ^   ^
 *       |   |
 *       |   |
 * +-----+   +---------------+
 * |                         |
 * |                         |
 * v                         v
 * +---------------+   +---------------+
 * |  Café Concreto |   | CafeDecorator |
 * |(EspressoCafe,  |   |  (Decorator)  |
 * |AmericanoCafe,  |   +---------------+
 * |DescafeinadoCafe)|   | -cafeDecorado|
 * +---------------+   | +getDescripcion() |
 *                      | +costo()     |
 *                      +---------------+
 *                             ^
 *                             |
 *            +----------------+----------------+
 *            |                |                |
 *            v                v                v
 * +------------------+  +------------------+  +------------------+
 * | LecheDecorator   |  | ChocolateDecorator|  | CanelaDecorator  |
 * |(ConcreteDecorator)|  |(ConcreteDecorator)|  |(ConcreteDecorator)|
 * +------------------+  +------------------+  +------------------+
 * | +getDescripcion()|  | +getDescripcion()|  | +getDescripcion()|
 * | +costo()        |  | +costo()        |  | +costo()        |
 * | +getTipoLeche() |  | +anadirExtra... |  | +esOrganica()   |
 * +------------------+  +------------------+  +------------------+
 *                                                     |
 *                                                     |
 *                                                     v
 *                                         +------------------+
 *                                         |CremaBatidaDecorator|
 *                                         |(ConcreteDecorator)|
 *                                         +------------------+
 *                                         | +getDescripcion()|
 *                                         | +costo()        |
 *                                         | +getCantidadCrema() |
 *                                         +------------------+
 * 
 * Estructura del Patrón Decorator:
 * 
 * 1. Component (Cafe):
 *    - Define la interfaz para los objetos que pueden ser decorados
 *    - Declara operaciones comunes tanto para objetos simples como decorados
 * 
 * 2. ConcreteComponent (EspressoCafe, AmericanoCafe, DescafeinadoCafe):
 *    - Implementan la interfaz Component
 *    - Definen objetos a los que se les puede agregar responsabilidades
 * 
 * 3. Decorator (CafeDecorator):
 *    - Mantiene una referencia al objeto Component
 *    - Implementa la interfaz Component delegando al objeto contenido
 *    - Define una interfaz que conforma a la interfaz Component
 * 
 * 4. ConcreteDecorator (LecheDecorator, ChocolateDecorator, etc.):
 *    - Agregan responsabilidades al componente
 *    - Heredan del Decorator
 *    - Pueden añadir estado o comportamiento adicional
 * 
 * Relaciones:
 * - Los ConcreteComponent implementan la interfaz Component
 * - El Decorator implementa Component y contiene una referencia a Component
 * - Los ConcreteDecorator heredan de Decorator
 * 
 * Flujo de ejecución:
 * 1. El cliente crea un objeto ConcreteComponent
 * 2. El cliente puede envolver el componente con uno o más ConcreteDecorator
 * 3. El cliente llama a los métodos del componente
 * 4. Cada decorador puede procesar la llamada y/o delegarla al siguiente objeto
 * 
 * Ventajas:
 * - Más flexible que la herencia estática
 * - Permite añadir o quitar responsabilidades en tiempo de ejecución
 * - Permite combinar múltiples comportamientos
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class DiagramaDecorator {
    // Esta clase solo contiene documentación
}