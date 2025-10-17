package co.edu.uniquindio.composite;

/**
 * Diagrama UML del patrón Composite
 * 
 * +--------------------+
 * | ComponenteArchivo  |
 * | (Component)        |
 * +--------------------+
 * | - nombre: String   |
 * | - extension: String|
 * | - ruta: String     |
 * +--------------------+
 * | + mostrar()        |
 * | + calcularTamanio()|
 * | + agregar()        |
 * | + eliminar()       |
 * | + obtenerHijo()    |
 * +--------------------+
 *           ^
 *           |
 *          / \
 *         /   \
 *        /     \
 * +-------------+    +-----------------+
 * |  Archivo    |    |   Directorio    |
 * |  (Leaf)     |    |   (Composite)   |
 * +-------------+    +-----------------+
 * | - tamanio   |    | - hijos: List   |
 * | - tipo      |    +-----------------+
 * +-------------+    | + mostrar()     |
 * | + mostrar() |    | + calcularTam.. |
 * | + calcular..|    | + agregar()     |
 * +-------------+    | + eliminar()    |
 *                    | + obtenerHijo() |
 *                    +-----------------+
 *                            |
 *                            | 0..*
 *                            V
 *                    +-----------------+
 *                    | ComponenteArchivo|
 *                    +-----------------+
 * 
 * Estructura del Patrón Composite:
 * 
 * 1. Component (ComponenteArchivo):
 *    - Define la interfaz común para todos los componentes
 *    - Declara operaciones para manipular componentes hijos
 *    - Proporciona implementaciones predeterminadas para estas operaciones
 * 
 * 2. Leaf (Archivo):
 *    - Representa los objetos hoja sin hijos
 *    - Implementa operaciones definidas en Component
 *    - Las operaciones para manipular hijos lanzan excepciones
 * 
 * 3. Composite (Directorio):
 *    - Representa componentes con hijos
 *    - Implementa operaciones para manipular hijos
 *    - Delega operaciones a sus componentes hijos
 * 
 * Relaciones:
 * - Archivo y Directorio heredan de ComponenteArchivo
 * - Directorio contiene una lista de objetos ComponenteArchivo
 * - Un Directorio puede contener Archivos y otros Directorios
 * 
 * Flujo de ejecución:
 * 1. El cliente crea un objeto Composite (Directorio) como raíz
 * 2. Añade Leafs (Archivos) y otros Composites (Directorios) a la raíz
 * 3. El cliente puede tratar todos los elementos de manera uniforme
 * 4. Al llamar a operaciones como calcularTamanio(), los compuestos
 *    delegan la operación a sus hijos recursivamente
 * 
 * Ventajas:
 * - Define jerarquías de clases con componentes simples y complejos
 * - Simplifica el código cliente
 * - Facilita la adición de nuevos tipos de componentes
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class DiagramaComposite {
    // Esta clase solo contiene documentación
}