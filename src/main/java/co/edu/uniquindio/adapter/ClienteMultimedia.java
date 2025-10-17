package co.edu.uniquindio.adapter;

/**
 * Clase Cliente que utiliza la interfaz ReproductorMultimedia.
 * Esta clase trabaja con cualquier objeto que implemente la interfaz ReproductorMultimedia,
 * sin importar si es una implementación directa o un adaptador.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class ClienteMultimedia {
    
    private ReproductorMultimedia reproductor;
    
    /**
     * Constructor del ClienteMultimedia.
     * 
     * @param reproductor El reproductor multimedia a utilizar
     */
    public ClienteMultimedia(ReproductorMultimedia reproductor) {
        this.reproductor = reproductor;
    }
    
    /**
     * Cambia el reproductor utilizado por el cliente.
     * 
     * @param reproductor El nuevo reproductor multimedia
     */
    public void cambiarReproductor(ReproductorMultimedia reproductor) {
        this.reproductor = reproductor;
    }
    
    /**
     * Reproduce un archivo multimedia.
     * 
     * @param nombreArchivo El nombre del archivo a reproducir
     */
    public void reproducirArchivo(String nombreArchivo) {
        System.out.println("\nClienteMultimedia: Intentando reproducir " + nombreArchivo);
        
        if (reproductor.esCompatible(nombreArchivo)) {
            reproductor.reproducir(nombreArchivo);
        } else {
            System.out.println("ClienteMultimedia: El archivo " + nombreArchivo + 
                               " no es compatible con el reproductor actual.");
        }
    }
    
    /**
     * Controla la reproducción (pausar, reanudar, detener).
     * 
     * @param accion La acción a realizar ("pausar", "reanudar", "detener")
     */
    public void controlarReproduccion(String accion) {
        System.out.println("\nClienteMultimedia: Ejecutando acción: " + accion);
        
        switch (accion.toLowerCase()) {
            case "pausar":
                reproductor.pausar();
                break;
            case "reanudar":
                reproductor.reanudar();
                break;
            case "detener":
                reproductor.detener();
                break;
            default:
                System.out.println("ClienteMultimedia: Acción no reconocida: " + accion);
        }
    }
    
    /**
     * Ajusta el volumen de la reproducción.
     * 
     * @param nivel Nivel de volumen (0-100)
     */
    public void ajustarVolumen(int nivel) {
        System.out.println("\nClienteMultimedia: Ajustando volumen a " + nivel + "%");
        reproductor.ajustarVolumen(nivel);
    }
    
    /**
     * Ejecuta una demostración con varios archivos y acciones.
     */
    public void ejecutarDemostracion() {
        System.out.println("\n=== DEMOSTRACIÓN DEL CLIENTE MULTIMEDIA ===");
        
        // Probar con diferentes tipos de archivos
        reproducirArchivo("cancion.mp3");
        reproducirArchivo("pelicula.mp4");
        reproducirArchivo("video.avi");
        
        // Probar controles de reproducción
        controlarReproduccion("pausar");
        controlarReproduccion("reanudar");
        
        // Ajustar volumen
        ajustarVolumen(75);
        
        // Detener reproducción
        controlarReproduccion("detener");
    }
}