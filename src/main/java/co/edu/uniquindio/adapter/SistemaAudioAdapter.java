package co.edu.uniquindio.adapter;

/**
 * Adapter que adapta la interfaz de SistemaAudioLegado a la interfaz ReproductorMultimedia.
 * Esta clase implementa la interfaz objetivo y contiene una referencia al objeto adaptado.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class SistemaAudioAdapter implements ReproductorMultimedia {
    
    private SistemaAudioLegado sistemaAudio;
    
    /**
     * Constructor del SistemaAudioAdapter.
     * 
     * @param sistemaAudio El sistema de audio legado que se adaptará
     */
    public SistemaAudioAdapter(SistemaAudioLegado sistemaAudio) {
        this.sistemaAudio = sistemaAudio;
    }
    
    @Override
    public void reproducir(String nombreArchivo) {
        // Asegurarse de que el sistema esté encendido
        if (!sistemaAudio.estaEncendido()) {
            sistemaAudio.encender();
        }
        
        // El sistema legado solo soporta MP3, pero intentaremos reproducir el archivo
        sistemaAudio.iniciarReproduccion(nombreArchivo);
    }
    
    @Override
    public void detener() {
        // Verificar si el sistema está encendido antes de intentar detener
        if (sistemaAudio.estaEncendido()) {
            sistemaAudio.detenerReproduccion();
        }
    }
    
    @Override
    public void pausar() {
        // El sistema legado alterna entre pausa y reproducción, pero nosotros queremos
        // específicamente pausar, así que verificamos el estado actual
        if (sistemaAudio.estaEncendido() && sistemaAudio.obtenerCancionActual() != null && !sistemaAudio.estaEnPausa()) {
            sistemaAudio.alternarPausa();
        }
    }
    
    @Override
    public void reanudar() {
        // De manera similar, solo reanudamos si está en pausa
        if (sistemaAudio.estaEncendido() && sistemaAudio.obtenerCancionActual() != null && sistemaAudio.estaEnPausa()) {
            sistemaAudio.alternarPausa();
        }
    }
    
    @Override
    public void ajustarVolumen(int nivel) {
        // Adaptar la escala de volumen: de 0-100 a 0-10
        int nivelAdaptado = nivel / 10;
        sistemaAudio.ajustarSonido(nivelAdaptado);
    }
    
    @Override
    public boolean esCompatible(String nombreArchivo) {
        // El sistema legado solo soporta archivos MP3
        return nombreArchivo != null && nombreArchivo.toLowerCase().endsWith(".mp3");
    }
    
    /**
     * Método para obtener información sobre el sistema adaptado.
     * 
     * @return Información sobre el sistema de audio adaptado
     */
    public String obtenerInformacion() {
        StringBuilder info = new StringBuilder();
        info.append("Adaptador de Sistema de Audio Legado\n");
        info.append("Estado: ").append(sistemaAudio.estaEncendido() ? "Encendido" : "Apagado").append("\n");
        
        if (sistemaAudio.obtenerCancionActual() != null) {
            info.append("Archivo en reproducción: ").append(sistemaAudio.obtenerCancionActual()).append("\n");
            info.append("Estado: ").append(sistemaAudio.estaEnPausa() ? "En pausa" : "Reproduciendo").append("\n");
        }
        
        info.append("Volumen: ").append(sistemaAudio.obtenerNivelSonido() * 10).append("%");
        
        return info.toString();
    }
}