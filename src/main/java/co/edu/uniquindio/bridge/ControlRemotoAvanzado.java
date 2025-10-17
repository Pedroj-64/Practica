package co.edu.uniquindio.bridge;

/**
 * Abstracción refinada (Refined Abstraction) en el patrón Bridge.
 * Extiende la interfaz definida por ControlRemoto con funcionalidades avanzadas.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class ControlRemotoAvanzado extends ControlRemoto {
    
    /**
     * Constructor para ControlRemotoAvanzado.
     * 
     * @param dispositivo El dispositivo electrónico a controlar
     */
    public ControlRemotoAvanzado(DispositivoElectronico dispositivo) {
        super(dispositivo);
    }
    
    /**
     * Establece un volumen específico en el dispositivo.
     * 
     * @param nivel El nivel de volumen a establecer
     */
    public void establecerVolumen(int nivel) {
        if (dispositivo.estaEncendido()) {
            System.out.println("Estableciendo volumen a " + nivel);
            dispositivo.setVolumen(nivel);
        } else {
            System.out.println("No se puede establecer el volumen: el dispositivo está apagado");
        }
    }
    
    /**
     * Cambia a un canal/pista específico.
     * 
     * @param canal El canal/pista al que cambiar
     */
    public void irACanal(int canal) {
        if (dispositivo.estaEncendido()) {
            System.out.println("Cambiando al canal/pista " + canal);
            dispositivo.setCanal(canal);
        } else {
            System.out.println("No se puede cambiar de canal: el dispositivo está apagado");
        }
    }
    
    /**
     * Muestra el estado actual del dispositivo.
     */
    public void mostrarEstado() {
        System.out.println("\n=== Estado del dispositivo: " + dispositivo.getNombre() + " ===");
        System.out.println("Estado: " + (dispositivo.estaEncendido() ? "Encendido" : "Apagado"));
        
        if (dispositivo.estaEncendido()) {
            System.out.println("Volumen actual: " + dispositivo.getVolumen());
            System.out.println("Canal/Pista actual: " + dispositivo.getCanal());
        }
        System.out.println("=====================================\n");
    }
}