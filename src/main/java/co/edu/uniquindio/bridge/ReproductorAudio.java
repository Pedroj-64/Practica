package co.edu.uniquindio.bridge;

/**
 * Implementación concreta (ConcreteImplementor) para un reproductor de audio.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class ReproductorAudio implements DispositivoElectronico {
    
    private boolean encendido;
    private int volumen;
    private int pista;  // En lugar de canal, usamos pista
    private String nombre;
    
    /**
     * Constructor para ReproductorAudio.
     * 
     * @param nombre El nombre o modelo del reproductor de audio
     */
    public ReproductorAudio(String nombre) {
        this.nombre = nombre;
        this.encendido = false;
        this.volumen = 20; // Volumen predeterminado
        this.pista = 1;    // Pista predeterminada
    }
    
    @Override
    public void encender() {
        if (!encendido) {
            encendido = true;
            System.out.println(nombre + ": Reproductor de audio encendido. Reproduciendo pista " + pista + " con volumen " + volumen);
        } else {
            System.out.println(nombre + ": El reproductor de audio ya está encendido");
        }
    }
    
    @Override
    public void apagar() {
        if (encendido) {
            encendido = false;
            System.out.println(nombre + ": Reproductor de audio apagado");
        } else {
            System.out.println(nombre + ": El reproductor de audio ya está apagado");
        }
    }
    
    @Override
    public void setVolumen(int nivel) {
        if (!encendido) {
            System.out.println(nombre + ": No se puede ajustar el volumen. El reproductor de audio está apagado");
            return;
        }
        
        if (nivel < 0) {
            nivel = 0;
        } else if (nivel > 100) {
            nivel = 100;
        }
        
        this.volumen = nivel;
        System.out.println(nombre + ": Volumen del reproductor de audio ajustado a " + nivel);
    }
    
    @Override
    public void setCanal(int pista) {
        if (!encendido) {
            System.out.println(nombre + ": No se puede cambiar la pista. El reproductor de audio está apagado");
            return;
        }
        
        if (pista < 1) {
            pista = 1;
        }
        
        this.pista = pista;
        System.out.println(nombre + ": Pista del reproductor de audio cambiada a " + pista);
    }
    
    @Override
    public boolean estaEncendido() {
        return encendido;
    }
    
    @Override
    public int getVolumen() {
        return volumen;
    }
    
    @Override
    public int getCanal() {
        return pista; // Retornamos la pista como canal
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Método específico del ReproductorAudio.
     * Muestra información sobre el modo de ecualización.
     */
    public void mostrarEcualizacion() {
        if (encendido) {
            System.out.println(nombre + ": Mostrando configuración de ecualización");
            System.out.println("  - Bajos: +3dB");
            System.out.println("  - Medios: 0dB");
            System.out.println("  - Agudos: +2dB");
        } else {
            System.out.println(nombre + ": No se puede mostrar la ecualización. El reproductor está apagado");
        }
    }
}