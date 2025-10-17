package co.edu.uniquindio;

public abstract class MensajeDecorador implements Mensaje {
    protected Mensaje mensaje;

    public MensajeDecorador(Mensaje mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public void enviar(String texto) {
        mensaje.enviar(texto);
    }
}
