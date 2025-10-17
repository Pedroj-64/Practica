# Patrón Decorator

## Descripción
El patrón Decorator es un patrón de diseño estructural que permite añadir funcionalidades a objetos dinámicamente sin modificar su estructura. Este patrón crea una clase decoradora que envuelve a la clase original, añadiendo nueva funcionalidad mientras mantiene la firma de sus métodos.

## Propósito
- Añadir responsabilidades adicionales a un objeto dinámicamente.
- Proporcionar una alternativa flexible a la herencia para extender funcionalidad.
- Permitir agregar o eliminar responsabilidades de objetos sin modificar su código.
- Combinar múltiples comportamientos utilizando múltiples decoradores.

## Componentes clave

### 1. Componente (Component)
- Define la interfaz para los objetos que pueden tener responsabilidades añadidas dinámicamente.
- Puede ser una interfaz o una clase abstracta.

### 2. Componente Concreto (ConcreteComponent)
- Define un objeto al cual se le pueden agregar responsabilidades adicionales.
- Implementa la interfaz Componente.

### 3. Decorador (Decorator)
- Mantiene una referencia al componente y define una interfaz conforme a la interfaz del Componente.
- Puede ser abstracto y delegar todas las operaciones al componente.

### 4. Decorador Concreto (ConcreteDecorator)
- Añade responsabilidades al componente.
- Puede sobrescribir métodos del Decorador y/o añadir nuevos métodos.

## Implementación en este ejemplo

### Componente (Component)
`Cafe`: Interfaz que define las operaciones básicas de un café.

### Componentes Concretos (ConcreteComponent)
- `EspressoCafe`: Implementa la interfaz Cafe para un café espresso.
- `AmericanoCafe`: Implementa la interfaz Cafe para un café americano.
- `DescafeinadoCafe`: Implementa la interfaz Cafe para un café descafeinado.

### Decorador (Decorator)
`CafeDecorator`: Clase abstracta que implementa la interfaz Cafe y mantiene una referencia a un objeto Cafe.

### Decoradores Concretos (ConcreteDecorator)
- `LecheDecorator`: Añade leche a un café.
- `ChocolateDecorator`: Añade chocolate a un café.
- `CanelaDecorator`: Añade canela a un café.
- `CremaBatidaDecorator`: Añade crema batida a un café.

## Diagrama UML

```
        +------------+
        |    Cafe    |
        | (Component)|
        +------------+
           /|\     /|\
            |       |
   +-----------------+    +------------------+
   |                 |    |  CafeDecorator   |
   | ConcreteComponent|    |    (Decorator)   |
   | (EspressoCafe,   |<---+                  |
   | AmericanoCafe,   |    +------------------+
   | DescafeinadoCafe)|         /|\
   +-----------------+          |
                                |
                 +---------------------------+
                 |              |            |
        +-----------------+     |     +-----------------+
        |LecheDecorator   |     |     |ChocolateDecorator|
        |(ConcreteDecorator)    |     |(ConcreteDecorator)|
        +-----------------+     |     +-----------------+
                                |
                     +------------------+  +------------------+
                     |CanelaDecorator   |  |CremaBatidaDecorator|
                     |(ConcreteDecorator)|  |(ConcreteDecorator)|
                     +------------------+  +------------------+
```

## Ventajas
1. **Flexibilidad**: Mayor flexibilidad que la herencia estática.
2. **Responsabilidad única**: Cada decorador tiene una funcionalidad específica.
3. **Combinaciones dinámicas**: Permite combinar comportamientos en tiempo de ejecución.
4. **Principio abierto/cerrado**: Las clases están abiertas para extensión pero cerradas para modificación.

## Consideraciones
1. Puede resultar en muchas clases pequeñas y similares, lo que dificulta la comprensión.
2. El código cliente puede volverse complejo al manejar múltiples decoradores.
3. Puede ser difícil eliminar un decorador específico de la cadena de decoradores.

## Cuándo usar el patrón Decorator
- Cuando se necesita añadir responsabilidades a objetos individuales dinámicamente.
- Cuando la herencia no es práctica o posible porque hay demasiadas clases concretas.
- Cuando se quiere evitar una jerarquía de clases sobrecargada.
- En sistemas donde la configuración de componentes puede cambiar en tiempo de ejecución.