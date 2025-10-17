package co.edu.uniquindio;

public class MensajeFirmado extends MensajeDecorador {
    public MensajeFirmado(Mensaje mensaje) {
        super(mensaje);
    }

    @Override
    public void enviar(String texto) {
        System.out.println("Mensaje firmado digitalmente");
        super.enviar(texto);
    }
}
