# Patrón Adapter

## Descripción
El patrón Adapter es un patrón estructural que permite que interfaces incompatibles trabajen juntas. Actúa como un puente entre dos interfaces incompatibles, convirtiendo la interfaz de una clase en otra interfaz que un cliente espera.

## Propósito
- Permitir que objetos con interfaces incompatibles colaboren entre sí.
- Convertir la interfaz de una clase en otra interfaz que el cliente espera.
- Hacer que clases con interfaces incompatibles trabajen juntas.
- Integrar sistemas legacy o de terceros con nuestro código moderno.

## Componentes clave
1. **Target (Objetivo)**: Define la interfaz específica del dominio que el cliente utiliza.
2. **Adaptee (Adaptado)**: Define una interfaz existente que necesita ser adaptada.
3. **Adapter (Adaptador)**: Adapta la interfaz del Adaptee a la interfaz del Target.
4. **Client (Cliente)**: Colabora con objetos que cumplen con la interfaz Target.

## Tipos de Adaptadores
### Adaptador de Clase
- Utiliza herencia: el adaptador hereda tanto de la interfaz objetivo como de la clase adaptada.
- Solo puede adaptar una clase específica y no sus subclases.
- Es un adaptador más estático.

### Adaptador de Objeto
- Utiliza composición: el adaptador contiene una instancia del objeto adaptado.
- Puede adaptar la clase adaptada y cualquiera de sus subclases.
- Más flexible y preferible en la mayoría de los casos.

## Implementación
En este ejemplo se han implementado ambos tipos de adaptadores:

### ReproductorMultimedia (Target)
Interfaz que define los métodos que el cliente espera utilizar.

### ReproductorModerno (Implementación directa del Target)
Una implementación moderna que cumple directamente con la interfaz objetivo.

### SistemaAudioLegado (Adaptee)
Un sistema de audio legado con una interfaz incompatible con ReproductorMultimedia.

### SistemaAudioAdapter (Adapter de Objeto)
Adapta SistemaAudioLegado para que implemente la interfaz ReproductorMultimedia usando composición.

### ReproductorVideoAntiguo (Adaptee)
Un sistema de video antiguo con una interfaz incompatible.

### ReproductorVideoAdapter (Adapter de Clase)
Adapta ReproductorVideoAntiguo para que implemente la interfaz ReproductorMultimedia usando herencia.

### ClienteMultimedia (Client)
Un cliente que trabaja con la interfaz ReproductorMultimedia sin conocer los detalles de implementación.

## Ventajas
1. **Desacoplamiento**: El cliente está desacoplado de las clases adaptadas.
2. **Reutilización**: Permite reutilizar clases existentes sin modificarlas.
3. **Flexibilidad**: Permite que sistemas incompatibles trabajen juntos.
4. **Mantenibilidad**: Facilita la actualización de componentes sin afectar a los clientes.

## Consideraciones
1. Aumenta la complejidad al introducir nuevas clases intermedias.
2. A veces, reescribir una clase puede ser más eficiente que adaptarla.
3. Puede requerir adaptación de múltiples métodos lo que podría volverse tedioso.

## Cuándo usar el patrón Adapter
- Cuando se necesita usar una clase existente pero su interfaz no es compatible.
- Para reutilizar código legacy sin modificarlo.
- Para hacer que bibliotecas o frameworks de terceros funcionen con tu aplicación.
- Al refactorizar sistemas donde no se puede cambiar la interfaz existente.