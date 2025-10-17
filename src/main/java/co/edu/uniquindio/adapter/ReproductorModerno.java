package co.edu.uniquindio.adapter;

import java.util.Arrays;
import java.util.List;

/**
 * Implementación concreta de la interfaz ReproductorMultimedia.
 * Este es un reproductor moderno que implementa directamente la interfaz objetivo.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class ReproductorModerno implements ReproductorMultimedia {
    
    private static final List<String> FORMATOS_SOPORTADOS = 
            Arrays.asList("mp3", "mp4", "wav", "mkv", "avi", "mov");
    
    private String archivoActual;
    private boolean reproduciendo;
    private boolean pausado;
    private int volumen;
    
    /**
     * Constructor del ReproductorModerno.
     */
    public ReproductorModerno() {
        this.reproduciendo = false;
        this.pausado = false;
        this.volumen = 50;  // Volumen predeterminado al 50%
    }
    
    @Override
    public void reproducir(String nombreArchivo) {
        if (!esCompatible(nombreArchivo)) {
            System.out.println("Error: El formato del archivo '" + nombreArchivo + "' no es compatible.");
            return;
        }
        
        this.archivoActual = nombreArchivo;
        this.reproduciendo = true;
        this.pausado = false;
        
        System.out.println("Reproductor Moderno: Reproduciendo '" + nombreArchivo + "' al " + volumen + "% de volumen.");
    }
    
    @Override
    public void detener() {
        if (reproduciendo) {
            System.out.println("Reproductor Moderno: Deteniendo la reproducción de '" + archivoActual + "'.");
            this.reproduciendo = false;
            this.pausado = false;
            this.archivoActual = null;
        } else {
            System.out.println("Reproductor Moderno: No hay ninguna reproducción activa que detener.");
        }
    }
    
    @Override
    public void pausar() {
        if (reproduciendo && !pausado) {
            System.out.println("Reproductor Moderno: Pausando la reproducción de '" + archivoActual + "'.");
            this.pausado = true;
        } else if (pausado) {
            System.out.println("Reproductor Moderno: La reproducción ya está pausada.");
        } else {
            System.out.println("Reproductor Moderno: No hay ninguna reproducción activa que pausar.");
        }
    }
    
    @Override
    public void reanudar() {
        if (reproduciendo && pausado) {
            System.out.println("Reproductor Moderno: Reanudando la reproducción de '" + archivoActual + "'.");
            this.pausado = false;
        } else if (reproduciendo) {
            System.out.println("Reproductor Moderno: La reproducción ya está en curso.");
        } else {
            System.out.println("Reproductor Moderno: No hay ninguna reproducción pausada que reanudar.");
        }
    }
    
    @Override
    public void ajustarVolumen(int nivel) {
        if (nivel < 0 || nivel > 100) {
            System.out.println("Reproductor Moderno: El nivel de volumen debe estar entre 0 y 100.");
            return;
        }
        
        this.volumen = nivel;
        System.out.println("Reproductor Moderno: Volumen ajustado al " + nivel + "%.");
    }
    
    @Override
    public boolean esCompatible(String nombreArchivo) {
        if (nombreArchivo == null || nombreArchivo.isEmpty()) {
            return false;
        }
        
        int indicePunto = nombreArchivo.lastIndexOf('.');
        if (indicePunto == -1 || indicePunto == nombreArchivo.length() - 1) {
            return false;
        }
        
        String extension = nombreArchivo.substring(indicePunto + 1).toLowerCase();
        return FORMATOS_SOPORTADOS.contains(extension);
    }
    
    /**
     * Método específico del ReproductorModerno para mostrar información técnica.
     * Este método no forma parte de la interfaz ReproductorMultimedia.
     * 
     * @return Información técnica sobre el reproductor
     */
    public String mostrarInfoTecnica() {
        StringBuilder info = new StringBuilder();
        info.append("Reproductor Multimedia Moderno v2.1\n");
        info.append("Formatos soportados: ").append(String.join(", ", FORMATOS_SOPORTADOS)).append("\n");
        info.append("Estado actual: ").append(reproduciendo ? (pausado ? "Pausado" : "Reproduciendo") : "Detenido").append("\n");
        if (archivoActual != null) {
            info.append("Archivo actual: ").append(archivoActual).append("\n");
        }
        info.append("Volumen: ").append(volumen).append("%");
        
        return info.toString();
    }
}