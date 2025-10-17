package co.edu.uniquindio.factory;

/**
 * Clase de demostración del patrón Factory Method.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class FactoryDemo {
    
    public static void main(String[] args) {
        System.out.println("===== DEMOSTRACIÓN DEL PATRÓN FACTORY METHOD =====\n");
        
        // Demostración simple del patrón Factory
        demoFactoryBasico();
        
        // Demostración avanzada con la fábrica abstracta
        demoFactoryAvanzado();
        
        // Demostración del sistema de solicitud de envío
        demoSolicitudEnvio();
        
        System.out.println("\n===== FIN DE LA DEMOSTRACIÓN =====");
    }
    
    /**
     * Demostración básica del patrón Factory.
     */
    private static void demoFactoryBasico() {
        System.out.println("----- DEMOSTRACIÓN BÁSICA DEL PATRÓN FACTORY -----\n");
        
        // Creamos diferentes fábricas
        TransporteFactory fabricaTerrestre = new TransporteTerrestreFactory("Camioneta", 70.0, 1200.0);
        TransporteFactory fabricaAereo = new TransporteAereoFactory("Avión de pasajeros", 900.0, 6000.0, true);
        TransporteFactory fabricaMaritimo = new TransporteMaritimoFactory(800);
        
        // Usamos las fábricas para crear transportes
        Transporte transporteTerrestre = fabricaTerrestre.crearTransporte();
        Transporte transporteAereo = fabricaAereo.crearTransporte();
        Transporte transporteMaritimo = fabricaMaritimo.crearTransporte();
        
        // Mostramos información sobre los transportes creados
        System.out.println("Transportes creados:");
        System.out.println("1. " + transporteTerrestre.getTipo());
        System.out.println("   - Costo para 100 km: $" + transporteTerrestre.calcularCosto(100));
        System.out.println("   - Tiempo para 100 km: " + transporteTerrestre.tiempoEstimado(100) + " horas");
        
        System.out.println("2. " + transporteAereo.getTipo());
        System.out.println("   - Costo para 1000 km: $" + transporteAereo.calcularCosto(1000));
        System.out.println("   - Tiempo para 1000 km: " + transporteAereo.tiempoEstimado(1000) + " horas");
        
        System.out.println("3. " + transporteMaritimo.getTipo());
        System.out.println("   - Costo para 5000 km: $" + transporteMaritimo.calcularCosto(5000));
        System.out.println("   - Tiempo para 5000 km: " + transporteMaritimo.tiempoEstimado(5000) + " horas");
    }
    
    /**
     * Demostración avanzada con la fábrica abstracta.
     */
    private static void demoFactoryAvanzado() {
        System.out.println("\n----- DEMOSTRACIÓN AVANZADA CON FÁBRICA ABSTRACTA -----\n");
        
        // Creamos transportes utilizando la fábrica abstracta
        System.out.println("Creando transportes con la fábrica abstracta:");
        
        Transporte t1 = EnvioTransporteFactory.crearTransporte("terrestre", 100, false, true, 500);
        System.out.println("1. Envío terrestre prioritario (500 kg, 100 km):");
        System.out.println("   - Tipo: " + t1.getTipo());
        System.out.println("   - Costo: $" + t1.calcularCosto(100));
        System.out.println("   - Tiempo: " + t1.tiempoEstimado(100) + " horas");
        
        Transporte t2 = EnvioTransporteFactory.crearTransporte("aereo", 6000, true, false, 300);
        System.out.println("\n2. Envío aéreo internacional (300 kg, 6000 km):");
        System.out.println("   - Tipo: " + t2.getTipo());
        System.out.println("   - Costo: $" + t2.calcularCosto(6000));
        System.out.println("   - Tiempo: " + t2.tiempoEstimado(6000) + " horas");
        
        Transporte t3 = EnvioTransporteFactory.crearTransporte("maritimo", 3000, true, false, 15000);
        System.out.println("\n3. Envío marítimo pesado (15000 kg, 3000 km):");
        System.out.println("   - Tipo: " + t3.getTipo());
        System.out.println("   - Costo: $" + t3.calcularCosto(3000));
        System.out.println("   - Tiempo: " + t3.tiempoEstimado(3000) + " horas");
    }
    
    /**
     * Demostración del sistema de solicitud de envío.
     */
    private static void demoSolicitudEnvio() {
        System.out.println("\n----- DEMOSTRACIÓN DEL SISTEMA DE SOLICITUD DE ENVÍO -----\n");
        
        // Creamos varias solicitudes de envío
        SolicitudEnvio solicitud1 = new SolicitudEnvio(
            "ENV-001", "Bogotá", "Medellín", 
            420, false, true, 200, "Equipos electrónicos"
        );
        
        SolicitudEnvio solicitud2 = new SolicitudEnvio(
            "ENV-002", "Bogotá", "Miami", 
            3500, true, false, 1500, "Maquinaria industrial"
        );
        
        SolicitudEnvio solicitud3 = new SolicitudEnvio(
            "ENV-003", "Cartagena", "Barcelona", 
            8500, true, false, 12000, "Contenedor de productos"
        );
        
        // Procesamos las solicitudes
        System.out.println("Procesando solicitudes de envío:");
        
        // Solicitud 1 - Terrestre prioritario
        solicitud1.asignarTransporte("terrestre");
        System.out.println(solicitud1.procesarEnvio());
        
        // Solicitud 2 - Aéreo internacional
        solicitud2.asignarTransporte("aereo");
        System.out.println(solicitud2.procesarEnvio());
        
        // Solicitud 3 - Marítimo internacional y pesado
        solicitud3.asignarTransporte("maritimo");
        System.out.println(solicitud3.procesarEnvio());
        
        // Ejemplo de cotización
        System.out.println("\nComparativa de cotizaciones para el envío ENV-003:");
        System.out.println(solicitud3.obtenerCotizacion("terrestre"));
        System.out.println(solicitud3.obtenerCotizacion("aereo"));
        System.out.println(solicitud3.obtenerCotizacion("maritimo"));
    }
}