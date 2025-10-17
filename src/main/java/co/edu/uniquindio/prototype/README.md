# Patrón de Diseño Prototype

## Descripción
El patrón Prototype es un patrón de diseño creacional que permite crear nuevos objetos duplicando objetos existentes sin hacer que el código dependa de sus clases. Este patrón es especialmente útil cuando la creación de un objeto es costosa o compleja.

## Propósito
- Crear nuevos objetos copiando un objeto existente (el prototipo)
- Evitar la dependencia de las clases concretas del objeto
- Reducir el costo de creación de objetos complejos

## Implementación en Java con Cloneable
En Java, el patrón Prototype se puede implementar fácilmente usando la interfaz `Cloneable` y el método `clone()` heredado de la clase `Object`. Este enfoque tiene las siguientes ventajas:

1. Es simple de implementar
2. Se integra con las funcionalidades nativas de Java
3. No requiere crear interfaces o métodos adicionales

## Estructura del Patrón Prototype

### Componentes Principales:
1. **Prototype** (interfaz o clase abstracta): Define una interfaz para clonar objetos
   - En nuestro ejemplo: La clase abstracta `Prototype` que implementa `Cloneable`

2. **ConcretePrototype** (clase concreta): Implementa la operación de clonación
   - En nuestro ejemplo: Las clases `Vehiculo` y `Persona`

3. **Client** (cliente): Crea nuevos objetos pidiéndole al prototipo que se clone
   - En nuestro ejemplo: La clase `PrototypeDemo`

4. **PrototypeRegistry** (opcional): Mantiene un registro de prototipos disponibles
   - En nuestro ejemplo: La clase `PrototypeRegistry`

## Tipos de Clonación

### 1. Clonación Superficial (Shallow Copy)
- Solo copia los valores de los campos primitivos
- Los objetos referenciados seguirán apuntando al mismo objeto
- Es la implementación por defecto del método `clone()` de la clase `Object`

```java
@Override
public Object clone() {
    try {
        return super.clone();
    } catch (CloneNotSupportedException e) {
        return null;
    }
}
```

### 2. Clonación Profunda (Deep Copy)
- Copia tanto los valores primitivos como los objetos referenciados
- Requiere implementación adicional para cada objeto complejo
- Es necesaria cuando los objetos tienen referencias a otros objetos que también deben ser clonados

```java
@Override
public Object clone() {
    // Copia superficial primero
    Vehiculo clone = (Vehiculo) super.clone();
    
    // Copia profunda de colecciones y otros objetos
    clone.setCaracteristicas(new ArrayList<>(this.caracteristicas));
    
    return clone;
}
```

## Ventajas del Patrón Prototype
1. **Reduce la duplicación de código**: No es necesario repetir código de inicialización
2. **Oculta la complejidad de creación**: Los clientes no necesitan conocer las clases concretas
3. **Crea objetos dinámicamente**: Permite configurar el sistema con objetos en tiempo de ejecución
4. **Reduce el uso de subclases**: Proporciona una alternativa a la herencia para la reutilización
5. **Configuración flexible**: Permite agregar y eliminar productos en tiempo de ejecución

## Desventajas del Patrón Prototype
1. **Complejidad en objetos circulares**: La clonación de objetos con referencias circulares puede ser complicada
2. **Implementación de clonación profunda**: Puede ser complejo implementar la clonación profunda correctamente
3. **Limitaciones de la interfaz Cloneable**: La interfaz `Cloneable` de Java tiene algunas limitaciones y no ofrece soporte directo para clonación profunda

## Casos de Uso Comunes
1. **Objetos con muchas configuraciones posibles**: Cuando un objeto puede existir con muchas combinaciones de estado
2. **Objetos cuya creación es costosa**: Para evitar repetir operaciones costosas de inicialización
3. **Copias de objetos complejos**: Para crear variantes de un objeto complejo existente
4. **Escenarios de copia y pegado**: Para implementar funcionalidad de copiar y pegar
5. **Templates o plantillas**: Para crear objetos basados en plantillas preconfiguradas

## Patrones Relacionados
- **Factory Method**: Define una interfaz para crear objetos, pero deja que las subclases decidan qué clase instanciar
- **Abstract Factory**: Proporciona una interfaz para crear familias de objetos relacionados
- **Builder**: Separa la construcción de un objeto complejo de su representación
- **Composite**: El patrón Prototype a menudo se usa con Composite para implementar la clonación de estructuras jerárquicas
- **Memento**: Puede usar Prototype para implementar "checkpoints" en un sistema con estados

## Ejemplo Práctico
En este proyecto se incluye un ejemplo práctico del patrón Prototype aplicado a vehículos y personas:

- `Prototype.java`: Clase base abstracta que implementa la interfaz Cloneable
- `Vehiculo.java`: Clase concreta que implementa la clonación superficial y profunda
- `Persona.java`: Clase concreta que demuestra la clonación de objetos con relaciones complejas
- `PrototypeRegistry.java`: Implementación de un registro de prototipos
- `PrototypeDemo.java`: Demostración del uso del patrón Prototype

## Conclusión
El patrón Prototype es una forma elegante de crear nuevos objetos a partir de instancias existentes, evitando la duplicación de código de inicialización y reduciendo la dependencia de las clases concretas. En Java, la implementación se simplifica gracias a la interfaz `Cloneable` y el método `clone()`, aunque hay que tener cuidado al implementar la clonación profunda de objetos complejos.