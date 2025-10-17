# Patrón Bridge

## Descripción
El patrón Bridge es un patrón estructural que separa la abstracción de su implementación para que ambas puedan variar independientemente. Este patrón implica una interfaz que actúa como un puente que hace que la funcionalidad de las clases concretas sea independiente de las clases de implementación. Ambas pueden ser alteradas estructuralmente sin afectarse entre sí.

## Propósito
- Desacoplar una abstracción de su implementación para que ambas puedan variar independientemente.
- Evitar un vínculo permanente entre una abstracción y su implementación.
- Permitir que tanto la abstracción como la implementación sean extensibles mediante subclases.
- Ocultar los detalles de implementación a los clientes.

## Componentes clave

### 1. Abstracción (Abstraction)
- Define la interfaz de alto nivel para la parte de "control".
- Mantiene una referencia a un objeto de tipo Implementor.

### 2. Abstracción Refinada (Refined Abstraction)
- Extiende la interfaz definida por la Abstracción.
- Puede añadir funcionalidades adicionales.

### 3. Implementador (Implementor)
- Define la interfaz para las clases de implementación.
- Esta interfaz no tiene que corresponder exactamente a la interfaz de la abstracción.

### 4. Implementación Concreta (Concrete Implementor)
- Implementa la interfaz Implementor.
- Proporciona la implementación concreta.

## Implementación en este ejemplo

### Implementador (Implementor)
`DispositivoElectronico`: Interfaz que define las operaciones primitivas que deben implementar los dispositivos electrónicos.

### Implementaciones Concretas (Concrete Implementors)
1. `Televisor`: Implementa DispositivoElectronico para un televisor.
2. `ReproductorAudio`: Implementa DispositivoElectronico para un reproductor de audio.

### Abstracción (Abstraction)
`ControlRemoto`: Clase abstracta que define la interfaz de alto nivel y mantiene una referencia a un DispositivoElectronico.

### Abstracciones Refinadas (Refined Abstractions)
1. `ControlRemotoAvanzado`: Extiende ControlRemoto con funcionalidades avanzadas.
2. `ControlRemotoMultimedia`: Extiende ControlRemoto con funcionalidades multimedia.

## Diagrama UML

```
          ControlRemoto
         /           \
        /             \
ControlRemotoAvanzado  ControlRemotoMultimedia
        |               |
        |               |
        v               v
   DispositivoElectronico
        /           \
       /             \
  Televisor    ReproductorAudio
```

## Ventajas
1. **Desacoplamiento**: Separa la interfaz de usuario (abstracción) de la implementación subyacente.
2. **Extensibilidad**: Permite extender tanto la abstracción como la implementación independientemente.
3. **Ocultamiento de la implementación**: Los clientes solo interactúan con la abstracción.
4. **Flexibilidad**: Permite cambiar la implementación sin afectar el código cliente.

## Consideraciones
1. Aumenta la complejidad del código.
2. Es necesario diseñar cuidadosamente la jerarquía de clases.
3. Solo útil cuando se necesita esta separación de jerarquías.

## Cuándo usar el patrón Bridge
- Cuando se desea evitar un enlace permanente entre abstracción e implementación.
- Cuando tanto la abstracción como la implementación deben ser extensibles.
- Cuando los cambios en la implementación no deben impactar al cliente.
- Cuando se tienen múltiples variantes de implementación para una abstracción.