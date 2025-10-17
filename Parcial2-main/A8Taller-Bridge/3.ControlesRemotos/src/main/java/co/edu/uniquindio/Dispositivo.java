package co.edu.uniquindio;

public abstract class Dispositivo {
    protected Controlar controlarDispositivo; // PUENTE

    public Dispositivo(Controlar controlarDispositivo) {
        this.controlarDispositivo = controlarDispositivo;
    }

    public abstract void controlador();
}
