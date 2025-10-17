package co.edu.uniquindio.bridge;

/**
 * Interfaz Implementor en el patrón Bridge.
 * Define las operaciones primitivas que las implementaciones concretas deben proporcionar.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public interface DispositivoElectronico {
    
    /**
     * Enciende el dispositivo.
     */
    void encender();
    
    /**
     * Apaga el dispositivo.
     */
    void apagar();
    
    /**
     * Ajusta el volumen del dispositivo.
     * 
     * @param nivel El nivel de volumen (0-100)
     */
    void setVolumen(int nivel);
    
    /**
     * Ajusta el canal/entrada del dispositivo.
     * 
     * @param canal El canal o entrada a configurar
     */
    void setCanal(int canal);
    
    /**
     * Verifica si el dispositivo está encendido.
     * 
     * @return true si está encendido, false si está apagado
     */
    boolean estaEncendido();
    
    /**
     * Obtiene el volumen actual del dispositivo.
     * 
     * @return El nivel de volumen actual
     */
    int getVolumen();
    
    /**
     * Obtiene el canal/entrada actual del dispositivo.
     * 
     * @return El canal o entrada actual
     */
    int getCanal();
    
    /**
     * Obtiene el nombre del dispositivo.
     * 
     * @return El nombre del dispositivo
     */
    String getNombre();
}