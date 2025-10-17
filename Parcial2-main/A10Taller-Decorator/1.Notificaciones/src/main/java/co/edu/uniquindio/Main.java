package co.edu.uniquindio;

public class Main {
    public static void main(String[] args) {

        // Mensaje base
        Mensaje mensaje = new MensajeTexto();

        // Agregamos decoradores (pueden anidarse en cualquier orden)
        mensaje = new MensajeComprimido(new MensajeCifrado(new MensajeFirmado(mensaje)));

        // Enviamos mensaje
        mensaje.enviar("Hola a todos.");

    }
}