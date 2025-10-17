package co.edu.uniquindio;

public class MensajeCifrado extends MensajeDecorador {
    public MensajeCifrado(Mensaje mensaje) {
        super(mensaje);
    }

    @Override
    public void enviar(String texto) {
        System.out.println("Mensaje cifrado");
        super.enviar(texto);
    }
}
