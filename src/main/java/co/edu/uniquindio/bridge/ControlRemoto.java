package co.edu.uniquindio.bridge;

/**
 * Abstracción en el patrón Bridge.
 * Define la interfaz de alto nivel y mantiene una referencia a la implementación.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public abstract class ControlRemoto {
    
    // Referencia a la implementación (el puente)
    protected DispositivoElectronico dispositivo;
    
    /**
     * Constructor para ControlRemoto.
     * 
     * @param dispositivo El dispositivo electrónico a controlar
     */
    public ControlRemoto(DispositivoElectronico dispositivo) {
        this.dispositivo = dispositivo;
    }
    
    /**
     * Enciende el dispositivo.
     */
    public void encender() {
        dispositivo.encender();
    }
    
    /**
     * Apaga el dispositivo.
     */
    public void apagar() {
        dispositivo.apagar();
    }
    
    /**
     * Aumenta el volumen del dispositivo.
     */
    public void subirVolumen() {
        if (dispositivo.estaEncendido()) {
            dispositivo.setVolumen(dispositivo.getVolumen() + 10);
        } else {
            System.out.println("No se puede subir el volumen: el dispositivo está apagado");
        }
    }
    
    /**
     * Disminuye el volumen del dispositivo.
     */
    public void bajarVolumen() {
        if (dispositivo.estaEncendido()) {
            dispositivo.setVolumen(dispositivo.getVolumen() - 10);
        } else {
            System.out.println("No se puede bajar el volumen: el dispositivo está apagado");
        }
    }
    
    /**
     * Cambia al canal/pista siguiente.
     */
    public void canalSiguiente() {
        if (dispositivo.estaEncendido()) {
            dispositivo.setCanal(dispositivo.getCanal() + 1);
        } else {
            System.out.println("No se puede cambiar de canal: el dispositivo está apagado");
        }
    }
    
    /**
     * Cambia al canal/pista anterior.
     */
    public void canalAnterior() {
        if (dispositivo.estaEncendido()) {
            int canalActual = dispositivo.getCanal();
            if (canalActual > 1) {
                dispositivo.setCanal(canalActual - 1);
            } else {
                System.out.println("Ya estás en el primer canal/pista");
            }
        } else {
            System.out.println("No se puede cambiar de canal: el dispositivo está apagado");
        }
    }
    
    /**
     * Silencia el dispositivo.
     */
    public void silenciar() {
        if (dispositivo.estaEncendido()) {
            System.out.println("Silenciando " + dispositivo.getNombre());
            dispositivo.setVolumen(0);
        } else {
            System.out.println("No se puede silenciar: el dispositivo está apagado");
        }
    }
}