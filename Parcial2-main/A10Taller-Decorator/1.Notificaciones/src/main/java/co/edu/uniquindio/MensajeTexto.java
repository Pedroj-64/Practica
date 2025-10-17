package co.edu.uniquindio;

public class MensajeTexto implements Mensaje {
    @Override
    public void enviar(String texto) {
        System.out.println("Enviando mensaje de texto: " + texto);
    }
}
