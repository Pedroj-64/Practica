package co.edu.uniquindio.bridge;

/**
 * Implementación concreta (ConcreteImplementor) para un televisor.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class Televisor implements DispositivoElectronico {
    
    private boolean encendido;
    private int volumen;
    private int canal;
    private String nombre;
    
    /**
     * Constructor para Televisor.
     * 
     * @param nombre El nombre o modelo del televisor
     */
    public Televisor(String nombre) {
        this.nombre = nombre;
        this.encendido = false;
        this.volumen = 30; // Volumen predeterminado
        this.canal = 1;    // Canal predeterminado
    }
    
    @Override
    public void encender() {
        if (!encendido) {
            encendido = true;
            System.out.println(nombre + ": Televisor encendido. Iniciando en canal " + canal + " con volumen " + volumen);
        } else {
            System.out.println(nombre + ": El televisor ya está encendido");
        }
    }
    
    @Override
    public void apagar() {
        if (encendido) {
            encendido = false;
            System.out.println(nombre + ": Televisor apagado");
        } else {
            System.out.println(nombre + ": El televisor ya está apagado");
        }
    }
    
    @Override
    public void setVolumen(int nivel) {
        if (!encendido) {
            System.out.println(nombre + ": No se puede ajustar el volumen. El televisor está apagado");
            return;
        }
        
        if (nivel < 0) {
            nivel = 0;
        } else if (nivel > 100) {
            nivel = 100;
        }
        
        this.volumen = nivel;
        System.out.println(nombre + ": Volumen del televisor ajustado a " + nivel);
    }
    
    @Override
    public void setCanal(int canal) {
        if (!encendido) {
            System.out.println(nombre + ": No se puede cambiar el canal. El televisor está apagado");
            return;
        }
        
        if (canal < 1) {
            canal = 1;
        }
        
        this.canal = canal;
        System.out.println(nombre + ": Canal del televisor cambiado a " + canal);
    }
    
    @Override
    public boolean estaEncendido() {
        return encendido;
    }
    
    @Override
    public int getVolumen() {
        return volumen;
    }
    
    @Override
    public int getCanal() {
        return canal;
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }
}