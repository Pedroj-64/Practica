package co.edu.uniquindio.bridge;

/**
 * Clase de demostración para el patrón Bridge.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class BridgeDemo {
    
    public static void main(String[] args) {
        System.out.println("===== DEMOSTRACIÓN DEL PATRÓN BRIDGE =====\n");
        
        // Crear objetos de implementación
        DispositivoElectronico televisorSala = new Televisor("TV Samsung 4K");
        DispositivoElectronico reproductorAudio = new ReproductorAudio("Bose SoundSystem");
        
        // Demostración con ControlRemotoAvanzado
        System.out.println("----- DEMOSTRACIÓN CON CONTROL REMOTO AVANZADO -----\n");
        demoControlRemotoAvanzado(televisorSala);
        
        System.out.println("\n----- DEMOSTRACIÓN CON CONTROL REMOTO MULTIMEDIA -----\n");
        demoControlRemotoMultimedia(reproductorAudio);
        
        // Demostración de la flexibilidad del patrón Bridge
        System.out.println("\n----- DEMOSTRACIÓN DE LA FLEXIBILIDAD DEL PATRÓN BRIDGE -----\n");
        System.out.println("Intercambiando las implementaciones entre abstracciones:");
        
        // Usar un control remoto avanzado con un reproductor de audio
        ControlRemotoAvanzado controlAvanzadoAudio = new ControlRemotoAvanzado(reproductorAudio);
        System.out.println("\nControl Avanzado con Reproductor de Audio:");
        controlAvanzadoAudio.encender();
        controlAvanzadoAudio.establecerVolumen(45);
        controlAvanzadoAudio.irACanal(5);
        controlAvanzadoAudio.mostrarEstado();
        controlAvanzadoAudio.apagar();
        
        // Usar un control remoto multimedia con un televisor
        ControlRemotoMultimedia controlMultimediaTv = new ControlRemotoMultimedia(televisorSala);
        System.out.println("\nControl Multimedia con Televisor:");
        controlMultimediaTv.encender();
        controlMultimediaTv.reproducir();
        controlMultimediaTv.pausar();
        controlMultimediaTv.canalSiguiente();
        controlMultimediaTv.subirVolumen();
        controlMultimediaTv.detener();
        controlMultimediaTv.apagar();
        
        System.out.println("\n===== FIN DE LA DEMOSTRACIÓN =====");
    }
    
    /**
     * Demostración del uso de un ControlRemotoAvanzado.
     * 
     * @param dispositivo El dispositivo a controlar
     */
    private static void demoControlRemotoAvanzado(DispositivoElectronico dispositivo) {
        ControlRemotoAvanzado controlAvanzado = new ControlRemotoAvanzado(dispositivo);
        
        // Mostrar estado inicial
        controlAvanzado.mostrarEstado();
        
        // Encender el dispositivo y realizar operaciones
        controlAvanzado.encender();
        controlAvanzado.mostrarEstado();
        
        // Operaciones con volumen
        System.out.println("Probando control de volumen:");
        controlAvanzado.subirVolumen();  // +10
        controlAvanzado.subirVolumen();  // +10
        controlAvanzado.bajarVolumen();  // -10
        
        // Establecer volumen específico
        controlAvanzado.establecerVolumen(75);
        
        // Operaciones con canales
        System.out.println("\nProbando control de canales:");
        controlAvanzado.canalSiguiente();
        controlAvanzado.canalSiguiente();
        controlAvanzado.canalAnterior();
        
        // Ir a un canal específico
        controlAvanzado.irACanal(15);
        
        // Silenciar y mostrar estado
        System.out.println("\nProbando silenciado:");
        controlAvanzado.silenciar();
        
        // Mostrar estado final
        controlAvanzado.mostrarEstado();
        
        // Apagar el dispositivo
        controlAvanzado.apagar();
    }
    
    /**
     * Demostración del uso de un ControlRemotoMultimedia.
     * 
     * @param dispositivo El dispositivo a controlar
     */
    private static void demoControlRemotoMultimedia(DispositivoElectronico dispositivo) {
        ControlRemotoMultimedia controlMultimedia = new ControlRemotoMultimedia(dispositivo);
        
        // Intentar operaciones con dispositivo apagado
        controlMultimedia.reproducir();
        
        // Encender el dispositivo
        controlMultimedia.encender();
        
        // Cambiar canal/pista
        System.out.println("\nNavegando entre pistas:");
        controlMultimedia.canalSiguiente();  // Pista 2
        controlMultimedia.canalSiguiente();  // Pista 3
        
        // Ajustar volumen
        System.out.println("\nAjustando volumen:");
        controlMultimedia.subirVolumen();  // +10
        controlMultimedia.subirVolumen();  // +10
        
        // Probar funciones multimedia
        System.out.println("\nProbando funciones multimedia:");
        controlMultimedia.reproducir();
        controlMultimedia.pausar();
        controlMultimedia.reproducir();
        controlMultimedia.ajustarEcualizador(2);  // Modo Rock
        controlMultimedia.activarRepeticion();
        controlMultimedia.detener();
        
        // Apagar el dispositivo
        controlMultimedia.apagar();
    }
}