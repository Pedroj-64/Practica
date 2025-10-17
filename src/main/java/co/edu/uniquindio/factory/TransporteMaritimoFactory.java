package co.edu.uniquindio.factory;

/**
 * Fábrica concreta que crea transportes marítimos.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class TransporteMaritimoFactory implements TransporteFactory {
    
    private final String tipo;
    private final double velocidadPromedio;
    private final double costoPorKm;
    private final int capacidadContenedores;
    
    /**
     * Constructor para TransporteMaritimoFactory.
     * 
     * @param tipo El tipo específico de transporte marítimo (ej: barco de contenedores, ferry)
     * @param velocidadPromedio La velocidad promedio en km/h
     * @param costoPorKm El costo por kilómetro
     * @param capacidadContenedores La capacidad de contenedores del barco
     */
    public TransporteMaritimoFactory(String tipo, double velocidadPromedio, double costoPorKm, int capacidadContenedores) {
        this.tipo = tipo;
        this.velocidadPromedio = velocidadPromedio;
        this.costoPorKm = costoPorKm;
        this.capacidadContenedores = capacidadContenedores;
    }
    
    /**
     * Constructor simple que usa valores predeterminados para barco de contenedores.
     * 
     * @param capacidadContenedores La capacidad de contenedores del barco
     */
    public TransporteMaritimoFactory(int capacidadContenedores) {
        this("Barco de contenedores", 40.0, 800.0, capacidadContenedores);
    }
    
    @Override
    public Transporte crearTransporte() {
        return new TransporteMaritimo(tipo, velocidadPromedio, costoPorKm, capacidadContenedores);
    }
    
    @Override
    public String getDescripcion() {
        return "Fábrica de transporte marítimo - Tipo: " + tipo + 
               " (Capacidad: " + capacidadContenedores + " contenedores)";
    }
}