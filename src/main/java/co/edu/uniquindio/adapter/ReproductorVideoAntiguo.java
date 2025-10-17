package co.edu.uniquindio.adapter;

/**
 * Clase legada (Adaptee) para reproducción de video con interfaz incompatible.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class ReproductorVideoAntiguo {
    
    private boolean activo;
    private String archivoVideo;
    private boolean reproduciendo;
    private int brilloVideo;
    private int volumenAudio;
    
    /**
     * Constructor del ReproductorVideoAntiguo.
     */
    public ReproductorVideoAntiguo() {
        this.activo = false;
        this.archivoVideo = null;
        this.reproduciendo = false;
        this.brilloVideo = 50;  // Valor predeterminado
        this.volumenAudio = 50;  // Valor predeterminado
    }
    
    /**
     * Activa el reproductor de video.
     */
    public void activar() {
        if (!activo) {
            System.out.println("Reproductor de Video Antiguo: Activando...");
            activo = true;
        } else {
            System.out.println("Reproductor de Video Antiguo: Ya está activo.");
        }
    }
    
    /**
     * Desactiva el reproductor de video.
     */
    public void desactivar() {
        if (activo) {
            if (reproduciendo) {
                finalizarVideo();
            }
            System.out.println("Reproductor de Video Antiguo: Desactivando...");
            activo = false;
        } else {
            System.out.println("Reproductor de Video Antiguo: Ya está desactivado.");
        }
    }
    
    /**
     * Carga un archivo de video.
     * 
     * @param nombreArchivo El nombre del archivo de video
     * @return true si el archivo se cargó correctamente, false en caso contrario
     */
    public boolean cargarVideo(String nombreArchivo) {
        if (!activo) {
            System.out.println("Reproductor de Video Antiguo: No está activo.");
            return false;
        }
        
        if (!verificarFormatoVideo(nombreArchivo)) {
            System.out.println("Reproductor de Video Antiguo: Formato no soportado.");
            return false;
        }
        
        this.archivoVideo = nombreArchivo;
        System.out.println("Reproductor de Video Antiguo: Video cargado: " + nombreArchivo);
        return true;
    }
    
    /**
     * Inicia la reproducción del video cargado.
     * 
     * @return true si se inició la reproducción, false en caso contrario
     */
    public boolean iniciarVideo() {
        if (!activo) {
            System.out.println("Reproductor de Video Antiguo: No está activo.");
            return false;
        }
        
        if (archivoVideo == null) {
            System.out.println("Reproductor de Video Antiguo: No hay video cargado.");
            return false;
        }
        
        if (reproduciendo) {
            System.out.println("Reproductor de Video Antiguo: Ya está reproduciendo el video.");
            return true;
        }
        
        this.reproduciendo = true;
        System.out.println("Reproductor de Video Antiguo: Iniciando reproducción de " + archivoVideo);
        System.out.println("Reproductor de Video Antiguo: Brillo: " + brilloVideo + "%, Volumen: " + volumenAudio + "%");
        return true;
    }
    
    /**
     * Finaliza la reproducción del video.
     * 
     * @return true si se finalizó la reproducción, false en caso contrario
     */
    public boolean finalizarVideo() {
        if (!activo) {
            System.out.println("Reproductor de Video Antiguo: No está activo.");
            return false;
        }
        
        if (!reproduciendo) {
            System.out.println("Reproductor de Video Antiguo: No hay video en reproducción.");
            return false;
        }
        
        this.reproduciendo = false;
        System.out.println("Reproductor de Video Antiguo: Finalizando reproducción de " + archivoVideo);
        return true;
    }
    
    /**
     * Establece el brillo del video.
     * 
     * @param nivel Nivel de brillo (0-100)
     */
    public void establecerBrillo(int nivel) {
        if (nivel < 0 || nivel > 100) {
            System.out.println("Reproductor de Video Antiguo: Nivel de brillo debe estar entre 0 y 100.");
            return;
        }
        
        this.brilloVideo = nivel;
        System.out.println("Reproductor de Video Antiguo: Brillo ajustado a " + nivel + "%");
    }
    
    /**
     * Establece el volumen del audio.
     * 
     * @param nivel Nivel de volumen (0-100)
     */
    public void establecerVolumen(int nivel) {
        if (nivel < 0 || nivel > 100) {
            System.out.println("Reproductor de Video Antiguo: Nivel de volumen debe estar entre 0 y 100.");
            return;
        }
        
        this.volumenAudio = nivel;
        System.out.println("Reproductor de Video Antiguo: Volumen ajustado a " + nivel + "%");
    }
    
    /**
     * Verifica si el formato de video es compatible.
     * 
     * @param nombreArchivo El nombre del archivo a verificar
     * @return true si es compatible, false en caso contrario
     */
    public boolean verificarFormatoVideo(String nombreArchivo) {
        // El reproductor antiguo solo soporta formatos AVI y MPG
        return nombreArchivo != null && 
               (nombreArchivo.toLowerCase().endsWith(".avi") || 
                nombreArchivo.toLowerCase().endsWith(".mpg"));
    }
    
    /**
     * Obtiene el nombre del archivo de video actual.
     * 
     * @return El nombre del archivo de video actual o null si no hay ninguno
     */
    public String obtenerArchivoVideo() {
        return archivoVideo;
    }
    
    /**
     * Verifica si el reproductor está activo.
     * 
     * @return true si está activo, false en caso contrario
     */
    public boolean estaActivo() {
        return activo;
    }
    
    /**
     * Verifica si hay un video en reproducción.
     * 
     * @return true si hay un video en reproducción, false en caso contrario
     */
    public boolean estaReproduciendo() {
        return activo && reproduciendo;
    }
}