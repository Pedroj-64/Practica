package co.edu.uniquindio.adapter;

/**
 * Clase legada (Adaptee) con una interfaz incompatible.
 * Esta clase representa un sistema antiguo que tiene métodos con nombres y
 * comportamientos diferentes a los que espera el cliente.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class SistemaAudioLegado {
    
    private boolean encendido;
    private int nivelSonido;
    private String cancionActual;
    private boolean enPausa;
    
    /**
     * Constructor del SistemaAudioLegado.
     */
    public SistemaAudioLegado() {
        this.encendido = false;
        this.nivelSonido = 5;  // Escala de 0 a 10
        this.cancionActual = null;
        this.enPausa = false;
    }
    
    /**
     * Enciende el sistema de audio.
     */
    public void encender() {
        if (!encendido) {
            System.out.println("Sistema de Audio Legado: Encendiendo...");
            this.encendido = true;
        } else {
            System.out.println("Sistema de Audio Legado: El sistema ya está encendido.");
        }
    }
    
    /**
     * Apaga el sistema de audio.
     */
    public void apagar() {
        if (encendido) {
            System.out.println("Sistema de Audio Legado: Apagando...");
            this.encendido = false;
            this.cancionActual = null;
            this.enPausa = false;
        } else {
            System.out.println("Sistema de Audio Legado: El sistema ya está apagado.");
        }
    }
    
    /**
     * Inicia la reproducción de una canción.
     * 
     * @param cancion El nombre de la canción a reproducir
     */
    public void iniciarReproduccion(String cancion) {
        if (!encendido) {
            System.out.println("Sistema de Audio Legado: El sistema está apagado. Enciéndalo primero.");
            return;
        }
        
        if (!cancion.toLowerCase().endsWith(".mp3")) {
            System.out.println("Sistema de Audio Legado: Solo se admiten archivos MP3.");
            return;
        }
        
        this.cancionActual = cancion;
        this.enPausa = false;
        System.out.println("Sistema de Audio Legado: Iniciando reproducción de '" + cancion + "'.");
        System.out.println("Sistema de Audio Legado: Nivel de sonido: " + nivelSonido + "/10");
    }
    
    /**
     * Detiene la reproducción actual.
     */
    public void detenerReproduccion() {
        if (!encendido) {
            System.out.println("Sistema de Audio Legado: El sistema está apagado.");
            return;
        }
        
        if (cancionActual != null) {
            System.out.println("Sistema de Audio Legado: Deteniendo reproducción de '" + cancionActual + "'.");
            this.cancionActual = null;
            this.enPausa = false;
        } else {
            System.out.println("Sistema de Audio Legado: No hay ninguna canción en reproducción.");
        }
    }
    
    /**
     * Pone en pausa o reanuda la reproducción.
     * 
     * @return true si la reproducción quedó en pausa, false si se reanudó
     */
    public boolean alternarPausa() {
        if (!encendido) {
            System.out.println("Sistema de Audio Legado: El sistema está apagado.");
            return false;
        }
        
        if (cancionActual == null) {
            System.out.println("Sistema de Audio Legado: No hay ninguna canción en reproducción.");
            return false;
        }
        
        this.enPausa = !this.enPausa;
        
        if (enPausa) {
            System.out.println("Sistema de Audio Legado: Reproducción en pausa.");
        } else {
            System.out.println("Sistema de Audio Legado: Reanudando reproducción.");
        }
        
        return enPausa;
    }
    
    /**
     * Ajusta el nivel de sonido.
     * 
     * @param nivel Nivel de sonido (0-10)
     */
    public void ajustarSonido(int nivel) {
        if (!encendido) {
            System.out.println("Sistema de Audio Legado: El sistema está apagado.");
            return;
        }
        
        if (nivel < 0 || nivel > 10) {
            System.out.println("Sistema de Audio Legado: El nivel de sonido debe estar entre 0 y 10.");
            return;
        }
        
        this.nivelSonido = nivel;
        System.out.println("Sistema de Audio Legado: Nivel de sonido ajustado a " + nivel + "/10");
    }
    
    /**
     * Verifica si el sistema está encendido.
     * 
     * @return true si está encendido, false en caso contrario
     */
    public boolean estaEncendido() {
        return encendido;
    }
    
    /**
     * Obtiene el nivel actual de sonido.
     * 
     * @return El nivel de sonido (0-10)
     */
    public int obtenerNivelSonido() {
        return nivelSonido;
    }
    
    /**
     * Verifica si hay una canción en reproducción.
     * 
     * @return true si hay una canción en reproducción, false en caso contrario
     */
    public boolean enReproduccion() {
        return encendido && cancionActual != null && !enPausa;
    }
    
    /**
     * Verifica si la reproducción está en pausa.
     * 
     * @return true si está en pausa, false en caso contrario
     */
    public boolean estaEnPausa() {
        return encendido && cancionActual != null && enPausa;
    }
    
    /**
     * Obtiene el nombre de la canción actual.
     * 
     * @return El nombre de la canción actual o null si no hay ninguna
     */
    public String obtenerCancionActual() {
        return cancionActual;
    }
}