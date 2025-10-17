package co.edu.uniquindio;

public class MensajeComprimido extends MensajeDecorador {
    public MensajeComprimido(Mensaje mensaje) {
        super(mensaje);
    }

    @Override
    public void enviar(String texto) {
        System.out.println("Mensaje comprimido");
        super.enviar(texto);
    }
}


