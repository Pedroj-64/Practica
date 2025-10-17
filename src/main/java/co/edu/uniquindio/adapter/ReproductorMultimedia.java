package co.edu.uniquindio.adapter;

/**
 * Interfaz objetivo (Target) que define las operaciones que el cliente utiliza.
 * Esta interfaz representa el comportamiento que el cliente espera.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public interface ReproductorMultimedia {
    
    /**
     * Reproduce un archivo multimedia.
     * 
     * @param nombreArchivo El nombre del archivo a reproducir
     */
    void reproducir(String nombreArchivo);
    
    /**
     * Detiene la reproducción actual.
     */
    void detener();
    
    /**
     * Pausa la reproducción actual.
     */
    void pausar();
    
    /**
     * Continúa la reproducción desde donde se pausó.
     */
    void reanudar();
    
    /**
     * Ajusta el volumen de reproducción.
     * 
     * @param nivel Nivel de volumen entre 0 y 100
     */
    void ajustarVolumen(int nivel);
    
    /**
     * Verifica si el archivo es compatible con el reproductor.
     * 
     * @param nombreArchivo El nombre del archivo a verificar
     * @return true si es compatible, false en caso contrario
     */
    boolean esCompatible(String nombreArchivo);
}