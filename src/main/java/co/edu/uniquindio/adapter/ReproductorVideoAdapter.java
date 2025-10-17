package co.edu.uniquindio.adapter;

/**
 * Adapter por herencia que adapta ReproductorVideoAntiguo a la interfaz ReproductorMultimedia.
 * Esta implementación utiliza herencia en lugar de composición.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class ReproductorVideoAdapter extends ReproductorVideoAntiguo implements ReproductorMultimedia {
    
    private boolean pausado;
    
    /**
     * Constructor del ReproductorVideoAdapter.
     */
    public ReproductorVideoAdapter() {
        super();
        this.pausado = false;
    }
    
    @Override
    public void reproducir(String nombreArchivo) {
        // Activamos el reproductor si no está activo
        if (!estaActivo()) {
            activar();
        }
        
        // Intentamos cargar y reproducir el video
        if (cargarVideo(nombreArchivo)) {
            iniciarVideo();
            this.pausado = false;
        }
    }
    
    @Override
    public void detener() {
        if (estaActivo() && estaReproduciendo()) {
            finalizarVideo();
        }
        this.pausado = false;
    }
    
    @Override
    public void pausar() {
        // El reproductor antiguo no tiene función de pausa,
        // así que simulamos deteniendo la reproducción y guardando el estado
        if (estaActivo() && estaReproduciendo() && !pausado) {
            System.out.println("ReproductorVideoAdapter: Pausando video (simulado)");
            finalizarVideo();
            this.pausado = true;
        }
    }
    
    @Override
    public void reanudar() {
        // Si estaba pausado, reiniciamos la reproducción
        if (estaActivo() && !estaReproduciendo() && pausado) {
            System.out.println("ReproductorVideoAdapter: Reanudando video");
            iniciarVideo();
            this.pausado = false;
        }
    }
    
    @Override
    public void ajustarVolumen(int nivel) {
        // Llamamos directamente al método heredado
        establecerVolumen(nivel);
    }
    
    @Override
    public boolean esCompatible(String nombreArchivo) {
        // Utilizamos el método heredado
        return verificarFormatoVideo(nombreArchivo);
    }
    
    /**
     * Método adicional para ajustar el brillo del video.
     * Este método es específico de este adaptador y no forma parte de la interfaz.
     * 
     * @param nivel Nivel de brillo (0-100)
     */
    public void ajustarBrillo(int nivel) {
        establecerBrillo(nivel);
    }
    
    /**
     * Verifica si el video está pausado.
     * 
     * @return true si está pausado, false en caso contrario
     */
    public boolean estaPausado() {
        return pausado;
    }
}