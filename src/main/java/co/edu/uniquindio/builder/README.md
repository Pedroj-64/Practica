# Patrón de Diseño Builder

## Descripción
El patrón Builder es un patrón de diseño creacional que permite construir objetos complejos paso a paso. A diferencia de otros patrones creacionales que construyen productos en un solo paso, el patrón Builder construye el producto final en varios pasos, permitiendo diferentes tipos de representaciones para un mismo proceso de construcción.

## Propósito
- Separar la construcción de un objeto complejo de su representación
- Permitir diferentes representaciones para un mismo objeto
- Encapsular el código de construcción y representación
- Proporcionar mayor control sobre el proceso de construcción

## Estructura del Patrón Builder

### Componentes Principales:
1. **Product** (producto): La clase compleja que se está construyendo
   - En nuestro ejemplo: Las clases `Pizza` y `Pedido`

2. **Builder** (constructor): Una interfaz o clase abstracta que define los pasos para construir el producto
   - En nuestro ejemplo: La clase interna `Pizza.Builder` y la clase `PedidoBuilder`

3. **ConcreteBuilder** (constructor concreto): Implementa la interfaz Builder y proporciona una representación específica
   - En nuestro ejemplo: Ambas implementaciones de Builder son concretas

4. **Director** (director, opcional): Encapsula la lógica para construir un producto usando un Builder
   - En nuestro ejemplo: La clase `PizzaDirector`

## Implementación del Patrón Builder

### 1. Builder como clase interna estática
Esta es la forma más común de implementar el patrón Builder en Java moderno. 
La clase Builder se implementa como una clase interna estática de la clase Product.

```java
public class Pizza {
    // Atributos
    private final String tamaño;
    private final String tipoMasa;
    // ...
    
    // Constructor privado
    private Pizza(Builder builder) {
        // Inicialización de atributos
    }
    
    // Clase Builder interna estática
    public static class Builder {
        // Atributos obligatorios
        private final String tamaño;
        private final String tipoMasa;
        
        // Atributos opcionales con valores predeterminados
        private String salsa = "Tomate";
        // ...
        
        // Constructor que inicializa atributos obligatorios
        public Builder(String tamaño, String tipoMasa) {
            this.tamaño = tamaño;
            this.tipoMasa = tipoMasa;
        }
        
        // Métodos para configurar atributos opcionales
        public Builder salsa(String salsa) {
            this.salsa = salsa;
            return this;
        }
        // ...
        
        // Método build que crea el producto
        public Pizza build() {
            return new Pizza(this);
        }
    }
}
```

### 2. Builder como clase separada
El Builder también puede implementarse como una clase separada, especialmente cuando el Builder es más complejo.

```java
public class Pedido {
    // Atributos
    private final String numeroPedido;
    // ...
    
    // Constructor package-private
    Pedido(PedidoBuilder builder) {
        // Inicialización de atributos
    }
}

class PedidoBuilder {
    // Atributos
    String numeroPedido;
    // ...
    
    // Métodos para configurar atributos
    public PedidoBuilder agregarPizza(Pizza pizza) {
        this.pizzas.add(pizza);
        return this;
    }
    // ...
    
    // Método build que crea el producto
    public Pedido build() {
        return new Pedido(this);
    }
}
```

### 3. Builder con Director
El Director es opcional pero útil para encapsular diferentes formas de construir un objeto usando el mismo Builder.

```java
public class PizzaDirector {
    public Pizza construirPizzaHawaiana(String tamaño) {
        return new Pizza.Builder(tamaño, "Tradicional")
                .salsa("Tomate")
                .queso("Mozzarella")
                .agregarIngrediente("Jamón")
                .agregarIngrediente("Piña")
                .build();
    }
    // ...
}
```

## Ventajas del Patrón Builder
1. **Construcción paso a paso**: Permite construir objetos complejos de manera incremental
2. **Variaciones del mismo objeto**: Facilita la creación de diferentes representaciones del mismo objeto
3. **Encapsulación**: Oculta los detalles de la construcción y la representación interna
4. **Código más limpio**: Evita constructores con muchos parámetros (constructor telescópico)
5. **Inmutabilidad**: Facilita la creación de objetos inmutables
6. **Parámetros opcionales**: Maneja parámetros opcionales de forma elegante

## Desventajas del Patrón Builder
1. **Código adicional**: Requiere crear clases adicionales, lo que aumenta la complejidad
2. **Duplicación de código**: Puede haber duplicación entre la clase producto y el builder
3. **Acoplamiento**: El producto y el builder están estrechamente acoplados

## Casos de Uso Comunes
1. **Objetos con muchos parámetros**: Cuando un objeto tiene muchos parámetros, especialmente opcionales
2. **Construcción en etapas**: Cuando la construcción de un objeto requiere varios pasos
3. **Variantes del mismo objeto**: Cuando se necesitan diferentes representaciones del mismo objeto
4. **Inmutabilidad**: Cuando se quiere crear objetos inmutables con muchos parámetros
5. **Validaciones complejas**: Cuando la validación de los parámetros es compleja o dependiente del contexto

## Patrones Relacionados
- **Abstract Factory**: Crea familias de objetos sin especificar sus clases concretas
- **Factory Method**: Define una interfaz para crear objetos, pero deja que las subclases decidan qué clase instanciar
- **Prototype**: Crea nuevos objetos clonando un prototipo existente
- **Composite**: El Builder puede utilizarse para construir estructuras jerárquicas complejas

## Ejemplo Práctico
En este proyecto se incluye un ejemplo práctico del patrón Builder aplicado a un sistema de pizzería:

- `Pizza.java`: Implementa el patrón Builder como clase interna estática
- `PizzaDirector.java`: Implementa un Director para crear diferentes tipos de pizzas
- `Pedido.java` y `PedidoBuilder.java`: Implementan el patrón Builder como clase separada
- `BuilderDemo.java`: Demostración del patrón Builder en acción

## Conclusión
El patrón Builder es una excelente solución para construir objetos complejos de manera limpia y mantenible. Evita la proliferación de constructores con muchos parámetros, proporciona un control fino sobre el proceso de construcción y permite crear diferentes representaciones del mismo objeto utilizando el mismo código de construcción.