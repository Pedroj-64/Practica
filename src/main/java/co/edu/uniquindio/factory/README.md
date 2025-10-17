# Patrón de Diseño Factory Method

## Descripción
El patrón Factory Method es un patrón de diseño creacional que define una interfaz para crear objetos en una superclase, pero permite que las subclases alteren el tipo de objetos que se crearán. Este patrón proporciona una forma de delegar la lógica de instanciación a las clases derivadas.

## Propósito
- Proporcionar una interfaz para crear objetos en una superclase
- Permitir que las subclases alteren el tipo de objetos que se crean
- Encapsular la creación de objetos
- Eliminar la necesidad de acoplar el código a clases específicas

## Estructura del Patrón Factory Method

### Componentes Principales:
1. **Product** (producto): Define la interfaz de los objetos que crea el método de fábrica
   - En nuestro ejemplo: La interfaz `Transporte`

2. **ConcreteProduct** (producto concreto): Implementa la interfaz del producto
   - En nuestro ejemplo: Las clases `TransporteTerrestre`, `TransporteAereo`, `TransporteMaritimo`

3. **Creator** (creador): Declara el método de fábrica que retorna un objeto de tipo producto
   - En nuestro ejemplo: La interfaz `TransporteFactory`

4. **ConcreteCreator** (creador concreto): Sobreescribe el método de fábrica para retornar una instancia del producto concreto
   - En nuestro ejemplo: Las clases `TransporteTerrestreFactory`, `TransporteAereoFactory`, `TransporteMaritimoFactory`

## Tipos de Implementaciones

### 1. Método de Fábrica Simple
- Una clase con un método que crea diferentes tipos de objetos basados en parámetros
- No utiliza herencia para especializar la lógica de creación
- En nuestro ejemplo: El método estático en `EnvioTransporteFactory`

### 2. Método de Fábrica Clásico
- Una jerarquía de clases donde cada subclase implementa el método de fábrica
- Cada subclase decide qué tipo de objeto crear
- En nuestro ejemplo: La implementación de `crearTransporte()` en cada fábrica concreta

### 3. Fábrica Abstracta Parameterizada
- Combina Factory Method con parámetros para crear diferentes tipos de productos
- En nuestro ejemplo: Los constructores paramétricos de nuestras fábricas

## Ventajas del Patrón Factory Method
1. **Evita el acoplamiento fuerte**: El código cliente no necesita conocer las clases concretas
2. **Principio de Responsabilidad Única**: Se mueve la lógica de creación a clases específicas
3. **Principio de Abierto/Cerrado**: Puedes introducir nuevos tipos de productos sin cambiar el código existente
4. **Flexibilidad**: Permite que las subclases elijan qué objetos crear
5. **Encapsulación**: Oculta los detalles de implementación de los productos

## Desventajas del Patrón Factory Method
1. **Complejidad**: Puede introducir muchas subclases nuevas solo para implementar el patrón
2. **Jerarquía más compleja**: El código se vuelve más complejo si hay muchas variantes de productos
3. **Sobrecarga potencial**: Para usar el patrón, el cliente debe crear una instancia de la fábrica

## Casos de Uso Comunes
1. **Frameworks y librerías**: Para permitir extensiones sin modificar el código base
2. **Sistemas con componentes configurables**: Donde los componentes varían según la configuración
3. **Sistemas de plugins**: Para crear diferentes implementaciones de plugins
4. **Aplicaciones multiplataforma**: Para crear componentes específicos de cada plataforma
5. **Sistemas de procesamiento**: Donde diferentes procesadores manejan diferentes tipos de datos

## Patrones Relacionados
- **Abstract Factory**: Proporciona una interfaz para crear familias de objetos relacionados
- **Builder**: Separa la construcción de un objeto complejo de su representación
- **Prototype**: Crea nuevos objetos copiando un objeto existente (prototipo)
- **Singleton**: Asegura que una clase tenga una única instancia
- **Template Method**: A menudo se usa con Factory Method, donde el método de fábrica es parte de un algoritmo mayor

## Ejemplo Práctico
En este proyecto se incluye un ejemplo práctico del patrón Factory Method aplicado a un sistema de transporte:

- `Transporte.java`: Interfaz de producto que define el comportamiento de los transportes
- `TransporteTerrestre.java`, `TransporteAereo.java`, `TransporteMaritimo.java`: Productos concretos
- `TransporteFactory.java`: Interfaz de creador que define el método de fábrica
- `TransporteTerrestreFactory.java`, `TransporteAereoFactory.java`, `TransporteMaritimoFactory.java`: Creadores concretos
- `EnvioTransporteFactory.java`: Implementación avanzada que combina diferentes enfoques
- `SolicitudEnvio.java`: Cliente que utiliza las fábricas para crear transportes según los requisitos
- `FactoryDemo.java`: Demostración del patrón Factory Method en acción

## Conclusión
El patrón Factory Method es una solución elegante para encapsular la lógica de creación de objetos y proporcionar flexibilidad en la selección de los tipos de objetos a crear. Es especialmente útil cuando se quiere desacoplar el código cliente de las clases concretas de los productos, permitiendo extensibilidad y manteniendo el principio de responsabilidad única.