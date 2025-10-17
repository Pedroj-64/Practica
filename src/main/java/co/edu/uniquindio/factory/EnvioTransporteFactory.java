package co.edu.uniquindio.factory;

/**
 * Fábrica abstracta que proporciona métodos para crear diferentes tipos de transportes
 * según los parámetros del envío.
 * 
 * Esta clase implementa el patrón Factory Method y añade lógica para seleccionar
 * el tipo de fábrica adecuado según los requisitos del envío.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public abstract class EnvioTransporteFactory {
    
    /**
     * Método estático que crea la fábrica adecuada según los requisitos del envío.
     * 
     * @param tipo Tipo de envío ("terrestre", "aereo", "maritimo")
     * @param distancia Distancia en kilómetros
     * @param esInternacional Si el envío es internacional
     * @param esPrioritario Si el envío es prioritario
     * @param pesoKg Peso del envío en kilogramos
     * @return Una fábrica de transporte adecuada para los requisitos
     */
    public static TransporteFactory crearFabricaTransporte(String tipo, double distancia, 
                                                          boolean esInternacional, boolean esPrioritario, double pesoKg) {
        
        // Lógica para seleccionar el tipo de fábrica según los requisitos
        switch (tipo.toLowerCase()) {
            case "terrestre":
                if (esPrioritario) {
                    // Para envíos prioritarios usamos vehículos más rápidos
                    return new TransporteTerrestreFactory("Furgoneta rápida", 90.0, 1500.0);
                } else if (pesoKg > 1000) {
                    // Para envíos pesados usamos camiones grandes
                    return new TransporteTerrestreFactory("Camión grande", 50.0, 800.0);
                } else {
                    // Para envíos normales usamos camiones estándar
                    return new TransporteTerrestreFactory();
                }
                
            case "aereo":
                if (distancia > 5000) {
                    // Para largas distancias usamos aviones de carga grandes
                    return new TransporteAereoFactory("Boeing 747 Cargo", 850.0, 5500.0, esInternacional);
                } else if (esPrioritario) {
                    // Para envíos prioritarios usamos aviones más rápidos
                    return new TransporteAereoFactory("Jet de carga", 950.0, 7000.0, esInternacional);
                } else {
                    // Para envíos normales usamos aviones estándar
                    return new TransporteAereoFactory(esInternacional);
                }
                
            case "maritimo":
                if (pesoKg > 10000) {
                    // Para envíos muy grandes usamos barcos con mucha capacidad
                    return new TransporteMaritimoFactory("Super carguero", 30.0, 500.0, 1000);
                } else if (esPrioritario) {
                    // Para envíos prioritarios usamos barcos más rápidos
                    return new TransporteMaritimoFactory("Carguero rápido", 60.0, 1200.0, 300);
                } else {
                    // Para envíos normales usamos barcos estándar
                    return new TransporteMaritimoFactory(500);
                }
                
            default:
                throw new IllegalArgumentException("Tipo de transporte no soportado: " + tipo);
        }
    }
    
    /**
     * Método estático que simplifica la creación del transporte adecuado directamente.
     * 
     * @param tipo Tipo de envío ("terrestre", "aereo", "maritimo")
     * @param distancia Distancia en kilómetros
     * @param esInternacional Si el envío es internacional
     * @param esPrioritario Si el envío es prioritario
     * @param pesoKg Peso del envío en kilogramos
     * @return Un transporte adecuado para los requisitos
     */
    public static Transporte crearTransporte(String tipo, double distancia, 
                                           boolean esInternacional, boolean esPrioritario, double pesoKg) {
        TransporteFactory factory = crearFabricaTransporte(tipo, distancia, esInternacional, esPrioritario, pesoKg);
        return factory.crearTransporte();
    }
}