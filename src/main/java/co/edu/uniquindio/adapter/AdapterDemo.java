package co.edu.uniquindio.adapter;

/**
 * Clase de demostración para el patrón Adapter.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class AdapterDemo {
    
    public static void main(String[] args) {
        System.out.println("===== DEMOSTRACIÓN DEL PATRÓN ADAPTER =====\n");
        
        // Demostración con el reproductor moderno (sin adapter)
        demoReproductorModerno();
        
        // Demostración con el sistema de audio legado adaptado (adapter por composición)
        demoSistemaAudioAdapter();
        
        // Demostración con el reproductor de video antiguo adaptado (adapter por herencia)
        demoReproductorVideoAdapter();
        
        // Demostración con el cliente que usa polimórficamente diferentes implementaciones
        demoClienteMultimedia();
        
        System.out.println("\n===== FIN DE LA DEMOSTRACIÓN =====");
    }
    
    /**
     * Demostración del ReproductorModerno (implementación directa de la interfaz objetivo).
     */
    private static void demoReproductorModerno() {
        System.out.println("----- DEMOSTRACIÓN DE REPRODUCTOR MODERNO -----\n");
        
        // Creamos un reproductor moderno que implementa directamente la interfaz
        ReproductorMultimedia reproductorModerno = new ReproductorModerno();
        
        // Probamos sus funcionalidades
        reproductorModerno.reproducir("cancion.mp3");
        reproductorModerno.pausar();
        reproductorModerno.reanudar();
        reproductorModerno.ajustarVolumen(80);
        reproductorModerno.detener();
        
        // Este método no está en la interfaz, necesitamos hacer un cast
        System.out.println("\nInformación técnica del reproductor moderno:");
        System.out.println(((ReproductorModerno) reproductorModerno).mostrarInfoTecnica());
    }
    
    /**
     * Demostración del SistemaAudioAdapter (adapter por composición).
     */
    private static void demoSistemaAudioAdapter() {
        System.out.println("\n----- DEMOSTRACIÓN DE SISTEMA AUDIO ADAPTADO -----\n");
        
        // Creamos el objeto adaptado (adaptee)
        SistemaAudioLegado sistemaLegado = new SistemaAudioLegado();
        
        // Creamos el adaptador que adapta el objeto legado a la interfaz objetivo
        ReproductorMultimedia adaptadorAudio = new SistemaAudioAdapter(sistemaLegado);
        
        // Utilizamos el adaptador como si fuera un ReproductorMultimedia
        adaptadorAudio.reproducir("cancion.mp3");
        adaptadorAudio.pausar();
        adaptadorAudio.reanudar();
        adaptadorAudio.ajustarVolumen(70);
        
        // Probamos con un formato no compatible
        System.out.println("\nProbando con un formato no compatible:");
        if (!adaptadorAudio.esCompatible("video.mp4")) {
            System.out.println("El formato mp4 no es compatible con el sistema de audio legado.");
        }
        
        adaptadorAudio.detener();
        
        // Información del adaptador
        System.out.println("\nInformación del adaptador de audio:");
        System.out.println(((SistemaAudioAdapter) adaptadorAudio).obtenerInformacion());
    }
    
    /**
     * Demostración del ReproductorVideoAdapter (adapter por herencia).
     */
    private static void demoReproductorVideoAdapter() {
        System.out.println("\n----- DEMOSTRACIÓN DE REPRODUCTOR VIDEO ADAPTADO -----\n");
        
        // Creamos el adaptador que hereda del objeto legado e implementa la interfaz objetivo
        ReproductorMultimedia adaptadorVideo = new ReproductorVideoAdapter();
        
        // Utilizamos el adaptador como un ReproductorMultimedia
        adaptadorVideo.reproducir("video.avi");
        adaptadorVideo.pausar();
        adaptadorVideo.reanudar();
        adaptadorVideo.ajustarVolumen(60);
        
        // Probamos un método específico del adaptador
        System.out.println("\nAjustando brillo (método específico del adaptador):");
        ((ReproductorVideoAdapter) adaptadorVideo).ajustarBrillo(75);
        
        adaptadorVideo.detener();
    }
    
    /**
     * Demostración del ClienteMultimedia con diferentes reproductores.
     */
    private static void demoClienteMultimedia() {
        System.out.println("\n----- DEMOSTRACIÓN DEL CLIENTE CON DIFERENTES REPRODUCTORES -----");
        
        // Creamos un cliente con un reproductor moderno
        ClienteMultimedia cliente = new ClienteMultimedia(new ReproductorModerno());
        
        System.out.println("\n1. Cliente utilizando Reproductor Moderno:");
        cliente.ejecutarDemostracion();
        
        // Cambiamos al adaptador de audio
        SistemaAudioLegado sistemaLegado = new SistemaAudioLegado();
        SistemaAudioAdapter adaptadorAudio = new SistemaAudioAdapter(sistemaLegado);
        cliente.cambiarReproductor(adaptadorAudio);
        
        System.out.println("\n2. Cliente utilizando Sistema de Audio Adaptado:");
        cliente.ejecutarDemostracion();
        
        // Cambiamos al adaptador de video
        cliente.cambiarReproductor(new ReproductorVideoAdapter());
        
        System.out.println("\n3. Cliente utilizando Reproductor de Video Adaptado:");
        cliente.ejecutarDemostracion();
    }
}