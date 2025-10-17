package co.edu.uniquindio.bridge;

/**
 * Otra abstracción refinada (Refined Abstraction) en el patrón Bridge.
 * Esta implementación proporciona funcionalidades específicas para dispositivos de entretenimiento.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class ControlRemotoMultimedia extends ControlRemoto {
    
    /**
     * Constructor para ControlRemotoMultimedia.
     * 
     * @param dispositivo El dispositivo electrónico a controlar
     */
    public ControlRemotoMultimedia(DispositivoElectronico dispositivo) {
        super(dispositivo);
    }
    
    /**
     * Simula la reproducción de un medio en el dispositivo.
     */
    public void reproducir() {
        if (dispositivo.estaEncendido()) {
            System.out.println("Reproduciendo en " + dispositivo.getNombre() + 
                              " - Canal/Pista " + dispositivo.getCanal());
        } else {
            System.out.println("No se puede reproducir: el dispositivo está apagado");
        }
    }
    
    /**
     * Simula la pausa en la reproducción.
     */
    public void pausar() {
        if (dispositivo.estaEncendido()) {
            System.out.println("Pausando reproducción en " + dispositivo.getNombre());
        } else {
            System.out.println("No se puede pausar: el dispositivo está apagado");
        }
    }
    
    /**
     * Simula la detención de la reproducción.
     */
    public void detener() {
        if (dispositivo.estaEncendido()) {
            System.out.println("Deteniendo reproducción en " + dispositivo.getNombre());
        } else {
            System.out.println("No se puede detener: el dispositivo está apagado");
        }
    }
    
    /**
     * Activa el modo de repetición.
     */
    public void activarRepeticion() {
        if (dispositivo.estaEncendido()) {
            System.out.println("Activando modo de repetición en " + dispositivo.getNombre());
        } else {
            System.out.println("No se puede activar la repetición: el dispositivo está apagado");
        }
    }
    
    /**
     * Simula un efecto de ecualizador.
     * 
     * @param modo El modo de ecualización (1-3)
     */
    public void ajustarEcualizador(int modo) {
        if (dispositivo.estaEncendido()) {
            String tipoEcualizacion;
            
            switch (modo) {
                case 1:
                    tipoEcualizacion = "Pop";
                    break;
                case 2:
                    tipoEcualizacion = "Rock";
                    break;
                case 3:
                    tipoEcualizacion = "Jazz";
                    break;
                default:
                    tipoEcualizacion = "Normal";
            }
            
            System.out.println("Ajustando ecualizador de " + dispositivo.getNombre() + 
                              " al modo: " + tipoEcualizacion);
            
            // Si es un ReproductorAudio, podemos usar su método específico
            if (dispositivo instanceof ReproductorAudio) {
                ((ReproductorAudio) dispositivo).mostrarEcualizacion();
            }
        } else {
            System.out.println("No se puede ajustar el ecualizador: el dispositivo está apagado");
        }
    }
}