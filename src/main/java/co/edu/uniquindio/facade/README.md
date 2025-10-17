# Patrón de Diseño Facade (Fachada)

## Descripción
El patrón Facade proporciona una interfaz simplificada para un conjunto de interfaces en un subsistema. Define una interfaz de nivel superior que hace que el subsistema sea más fácil de usar al ocultar su complejidad.

## Propósito
Simplificar el acceso a un conjunto de interfaces de un subsistema, proporcionando una interfaz única y simplificada de alto nivel.

## Estructura
- **Facade (Fachada)**: Conoce qué clases del subsistema son responsables de una petición y delega las solicitudes de los clientes a los objetos del subsistema apropiados.
- **Subsistemas**: Implementan la funcionalidad del subsistema, manejan el trabajo asignado por el objeto Facade y no tienen conocimiento de la existencia de la fachada.
- **Cliente**: Se comunica con el sistema a través de la fachada.

## Implementación en este Proyecto

### Fachada
- `ReservaVuelosFacade`: Proporciona métodos simplificados para reservar vuelos, consultar estados y cancelar reservas.

### Subsistemas
- `VerificadorVuelos`: Gestiona la búsqueda y verificación de disponibilidad de vuelos.
- `SistemaReservas`: Maneja la creación, cancelación y consulta de reservas.
- `ProcesadorPagos`: Se encarga del procesamiento y validación de pagos.
- `SistemaNotificaciones`: Envía notificaciones y confirmaciones a los usuarios.

### Cliente
- `FacadeDemo`: Muestra cómo utilizar la fachada para interactuar con los subsistemas complejos de manera simplificada.

## Ventajas
1. **Simplifica la interfaz**: Reduce la complejidad al proporcionar una interfaz única y simplificada.
2. **Desacopla el cliente de los subsistemas**: El cliente no necesita conocer los detalles de implementación de los subsistemas.
3. **Promueve el bajo acoplamiento**: Minimiza las dependencias entre los clientes y los subsistemas.
4. **Facilita la migración de sistemas**: Permite cambiar los subsistemas sin afectar a los clientes.

## Desventajas
1. **Puede convertirse en una "clase Dios"**: Si no se diseña adecuadamente, puede acumular demasiada responsabilidad.
2. **Puede introducir una capa adicional**: Añade un nivel de indirección que puede afectar el rendimiento.
3. **Puede ocultar funcionalidades útiles**: Al simplificar, algunas funcionalidades específicas de los subsistemas pueden quedar inaccesibles.

## Cuándo Usar
- Cuando se necesita proporcionar una interfaz simple para un subsistema complejo.
- Cuando hay muchas dependencias entre clientes y las clases de implementación.
- Cuando se desea estructurar un subsistema en capas, utilizando la fachada como punto de entrada.
- Cuando se necesita desacoplar los subsistemas de los clientes y otros subsistemas.

## Ejemplo de Uso
```java
// Crear la fachada
ReservaVuelosFacade reservaFacade = new ReservaVuelosFacade();

// Reservar un vuelo de ida sencillo
String codigoReserva = reservaFacade.reservarVueloIdaSencillo(
    "Juan Pérez",             // Nombre del pasajero
    "Bogotá",                 // Origen
    "Medellín",               // Destino
    "2025-11-15",             // Fecha de salida
    "1234567890123456",       // Número de tarjeta
    "JUAN PEREZ",             // Titular de tarjeta
    "12/27",                  // Fecha de expiración
    "123",                    // CVV
    "juan.perez@email.com",   // Correo de contacto
    "3101234567"              // Teléfono de contacto
);

// Consultar estado de la reserva
reservaFacade.consultarEstadoReserva(codigoReserva);
```

## Diagramas UML
El diagrama UML de esta implementación se encuentra en la clase `DiagramaFacade.java`.

## Referencias
- "Design Patterns: Elements of Reusable Object-Oriented Software" (Gamma, Helm, Johnson, Vlissides)
- "Head First Design Patterns" (Freeman, Robson, Bates, Sierra)