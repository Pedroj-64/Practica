package co.edu.uniquindio.facade;

/**
 * Clase que representa el diagrama UML del patrón Facade implementado.
 * 
 * Esta clase no contiene código ejecutable, sino una representación textual
 * del diagrama UML para el patrón Facade utilizado en este ejemplo.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class DiagramaFacade {
    
    /**
     * Diagrama UML del patrón Facade:
     * 
     * +------------------+       +--------------------+
     * |    Cliente       |------>| ReservaVuelosFacade|
     * +------------------+       +--------------------+
     *                            | + reservarVueloIdaSencillo()    |
     *                            | + reservarVueloIdaVuelta()      |
     *                            | + consultarEstadoReserva()      |
     *                            | + cancelarReserva()             |
     *                            +--------------------+
     *                                    |
     *                                    | usa
     *                                    v
     *     +---------------------------------------------------+
     *     |                                                   |
     *     |                                                   |
     *     v                                                   v
     * +--------------------+                        +--------------------+
     * | VerificadorVuelos  |                        | SistemaReservas    |
     * +--------------------+                        +--------------------+
     * | + verificarDisponibilidad() |                | + crearReserva()         |
     * | + buscarVuelos()     |                      | + cancelarReserva()      |
     * | + obtenerDetalles()  |                      | + consultarReserva()     |
     * +--------------------+                        +--------------------+
     *                                                          
     *     +---------------------------------------------------+
     *     |                                                   |
     *     |                                                   |
     *     v                                                   v
     * +--------------------+                        +--------------------+
     * | ProcesadorPagos    |                        | SistemaNotificaciones |
     * +--------------------+                        +--------------------+
     * | + procesarPago()    |                       | + enviarConfirmacion()  |
     * | + validarPago()     |                       | + enviarNotificacion()  |
     * | + reembolsarPago()  |                       | + enviarRecordatorio()  |
     * +--------------------+                        +--------------------+
     * 
     * 
     * Explicación:
     * 1. El cliente interactúa solamente con la fachada (ReservaVuelosFacade)
     * 2. La fachada conoce y coordina los subsistemas complejos
     * 3. Los subsistemas no conocen la fachada (desacoplamiento)
     * 4. Los subsistemas pueden ser usados independientemente si es necesario
     */
    
    // Esta clase solo contiene documentación del diagrama UML, no código ejecutable
}