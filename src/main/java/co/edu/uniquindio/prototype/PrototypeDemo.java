package co.edu.uniquindio.prototype;

/**
 * Clase que demuestra el uso del patrón de diseño Prototype.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class PrototypeDemo {
    
    public static void main(String[] args) {
        System.out.println("===== DEMOSTRACIÓN DEL PATRÓN PROTOTYPE =====\n");
        
        // Demostración de clonación de vehículos
        demoVehiculos();
        
        // Demostración de clonación de personas con relaciones complejas
        demoPersonas();
        
        // Demostración del uso del registro de prototipos
        demoRegistroPrototipos();
        
        System.out.println("\n===== FIN DE LA DEMOSTRACIÓN =====");
    }
    
    /**
     * Demostración de clonación de vehículos.
     */
    private static void demoVehiculos() {
        System.out.println("----- CLONACIÓN DE VEHÍCULOS -----\n");
        
        // Creamos un vehículo prototipo
        Vehiculo prototipoSedan = new Vehiculo("Toyota", "Corolla", 2023, "Plateado");
        prototipoSedan.agregarCaracteristica("Motor 2.0L");
        prototipoSedan.agregarCaracteristica("Transmisión automática");
        prototipoSedan.agregarCaracteristica("4 puertas");
        
        System.out.println("Vehículo Original (Prototipo):");
        System.out.println(prototipoSedan.mostrarDetalles());
        
        // Clonamos el vehículo y modificamos algunas propiedades
        Vehiculo vehiculoClonado = (Vehiculo) prototipoSedan.clone();
        vehiculoClonado.setColor("Azul");
        vehiculoClonado.agregarCaracteristica("Techo solar");
        
        System.out.println("Vehículo Clonado (con modificaciones):");
        System.out.println(vehiculoClonado.mostrarDetalles());
        
        // Verificamos que el original no ha sido modificado
        System.out.println("Vehículo Original (después de la modificación del clon):");
        System.out.println(prototipoSedan.mostrarDetalles());
        
        // Demostramos que la clonación fue profunda verificando que las listas son diferentes
        System.out.println("¿Las listas de características son el mismo objeto? " + 
                          (prototipoSedan.getCaracteristicas() == vehiculoClonado.getCaracteristicas()));
    }
    
    /**
     * Demostración de clonación de personas con relaciones complejas.
     */
    private static void demoPersonas() {
        System.out.println("\n----- CLONACIÓN DE PERSONAS CON RELACIONES COMPLEJAS -----\n");
        
        // Creamos un vehículo
        Vehiculo auto = new Vehiculo("Honda", "Civic", 2022, "Rojo");
        auto.agregarCaracteristica("Motor 1.8L");
        auto.agregarCaracteristica("Transmisión manual");
        
        // Creamos una persona con un vehículo
        Persona juan = new Persona("Juan Pérez", 35, "Calle Principal 123");
        juan.agregarAtributo("Profesión", "Ingeniero");
        juan.agregarAtributo("Email", "juan@ejemplo.com");
        juan.setVehiculoPrincipal(auto);
        
        System.out.println("Persona Original:");
        System.out.println(juan.mostrarDetalles());
        
        // Clonamos la persona
        Persona juanClonado = (Persona) juan.clone();
        juanClonado.setNombre("Juan Pérez (Clon)");
        juanClonado.setDireccion("Avenida Secundaria 456");
        juanClonado.agregarAtributo("Nota", "Esta es una persona clonada");
        juanClonado.getVehiculoPrincipal().setColor("Negro");
        
        System.out.println("Persona Clonada (con modificaciones):");
        System.out.println(juanClonado.mostrarDetalles());
        
        // Verificamos que el original no ha sido modificado
        System.out.println("Persona Original (después de la modificación del clon):");
        System.out.println(juan.mostrarDetalles());
        
        // Demostramos que la clonación fue profunda
        System.out.println("¿Los vehículos son el mismo objeto? " + 
                          (juan.getVehiculoPrincipal() == juanClonado.getVehiculoPrincipal()));
    }
    
    /**
     * Demostración del uso del registro de prototipos.
     */
    private static void demoRegistroPrototipos() {
        System.out.println("\n----- USO DEL REGISTRO DE PROTOTIPOS -----\n");
        
        // Creamos el registro de prototipos
        PrototypeRegistry registro = new PrototypeRegistry();
        
        // Registramos algunos prototipos de vehículos
        Vehiculo sedanBasico = new Vehiculo("Genérico", "Sedan", 2023, "Blanco");
        sedanBasico.agregarCaracteristica("4 puertas");
        registro.registrarPrototipo("sedan-basico", sedanBasico);
        
        Vehiculo suvLujo = new Vehiculo("Genérico", "SUV", 2023, "Negro");
        suvLujo.agregarCaracteristica("5 puertas");
        suvLujo.agregarCaracteristica("Tracción 4x4");
        suvLujo.agregarCaracteristica("Asientos de cuero");
        registro.registrarPrototipo("suv-lujo", suvLujo);
        
        // Registramos un prototipo de persona
        Persona clienteBase = new Persona("Cliente", 30, "Sin dirección");
        clienteBase.agregarAtributo("Tipo", "Cliente regular");
        registro.registrarPrototipo("cliente-base", clienteBase);
        
        // Clonamos y personalizamos a partir de los prototipos
        System.out.println("Creando instancias a partir de prototipos registrados:");
        
        // Clonamos un sedan básico y lo personalizamos
        Vehiculo miSedan = (Vehiculo) registro.obtenerClon("sedan-basico");
        miSedan.setMarca("Toyota");
        miSedan.setModelo("Corolla");
        miSedan.setColor("Azul");
        System.out.println("Sedan personalizado:");
        System.out.println(miSedan.mostrarDetalles());
        
        // Clonamos un SUV de lujo y lo personalizamos
        Vehiculo miSuv = (Vehiculo) registro.obtenerClon("suv-lujo");
        miSuv.setMarca("BMW");
        miSuv.setModelo("X5");
        System.out.println("SUV personalizado:");
        System.out.println(miSuv.mostrarDetalles());
        
        // Clonamos un cliente base y lo personalizamos
        Persona cliente = (Persona) registro.obtenerClon("cliente-base");
        cliente.setNombre("Ana García");
        cliente.setDireccion("Calle Roble 789");
        cliente.setEdad(28);
        cliente.agregarAtributo("Preferencia", "Entrega rápida");
        System.out.println("Cliente personalizado:");
        System.out.println(cliente.mostrarDetalles());
        
        // Mostramos información sobre el registro
        System.out.println("\nInformación del registro:");
        System.out.println("Cantidad de prototipos: " + registro.cantidadPrototipos());
        System.out.print("Prototipos disponibles: ");
        for (String nombre : registro.obtenerNombresPrototipos()) {
            System.out.print(nombre + " ");
        }
        System.out.println();
    }
}