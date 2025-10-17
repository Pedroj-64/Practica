# Patrón Composite

## Descripción
El patrón Composite es un patrón de diseño estructural que permite componer objetos en estructuras de árbol para representar jerarquías parte-todo. Este patrón permite que los clientes traten de manera uniforme tanto a los objetos individuales como a los grupos de objetos.

## Propósito
- Representar jerarquías parte-todo de objetos.
- Permitir a los clientes ignorar las diferencias entre composiciones de objetos y objetos individuales.
- Tratar todos los objetos de la composición de manera uniforme.
- Crear estructuras de árbol recursivas donde los elementos hoja y los elementos contenedores se tratan de forma similar.

## Componentes clave

### 1. Componente (Component)
- Define la interfaz para todos los objetos en la composición (hojas y compuestos).
- Implementa comportamiento predeterminado común para todas las clases.
- Declara una interfaz para acceder y gestionar componentes hijos.

### 2. Hoja (Leaf)
- Representa los objetos hoja en la composición, que no tienen hijos.
- Define el comportamiento para objetos primitivos en la composición.
- Implementa todas las operaciones de Component; las operaciones relacionadas con hijos generalmente lanzan excepciones.

### 3. Compuesto (Composite)
- Define el comportamiento para componentes que tienen hijos.
- Almacena componentes hijo.
- Implementa operaciones relacionadas con hijos en la interfaz de Component.

### 4. Cliente (Client)
- Manipula los objetos de la composición a través de la interfaz de Component.
- Trata tanto a los objetos Leaf como a los Composite de manera uniforme.

## Implementación en este ejemplo

### Componente (Component)
`ComponenteArchivo`: Clase abstracta que define la interfaz común para archivos y directorios.

### Hoja (Leaf)
`Archivo`: Clase que representa un archivo individual (objeto hoja).

### Compuesto (Composite)
`Directorio`: Clase que representa un directorio que puede contener otros archivos y directorios.

### Cliente (Client)
`CompositeDemo`: Clase que utiliza la jerarquía de archivos y directorios.

## Diagrama UML

```
     ComponenteArchivo
           /     \
          /       \
     Archivo    Directorio
                   |
                   | contiene
                   V
           ComponenteArchivo
```

## Ventajas
1. **Uniformidad**: Define jerarquías de clase que contienen objetos primitivos y objetos compuestos.
2. **Simplicidad para el cliente**: Los clientes tratan todos los objetos de la estructura de manera uniforme.
3. **Facilidad de extensión**: Se pueden añadir nuevos tipos de componentes sin alterar el código existente.
4. **Diseño recursivo**: Naturalmente recursivo, ideal para estructuras jerárquicas.

## Consideraciones
1. Puede dificultar el restringir el tipo de componentes de un composite.
2. Puede llevar a diseños demasiado generales cuando no todos los métodos tienen sentido para cada componente.

## Cuándo usar el patrón Composite
- Para representar jerarquías parte-todo de objetos.
- Para permitir a los clientes ignorar la diferencia entre objetos individuales y composiciones.
- Cuando la estructura puede tener cualquier nivel de complejidad y anidamiento.
- Sistemas de archivos, interfaces gráficas, estructuras organizativas, etc.