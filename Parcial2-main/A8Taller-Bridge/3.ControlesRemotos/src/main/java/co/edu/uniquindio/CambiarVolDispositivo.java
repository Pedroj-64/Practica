package co.edu.uniquindio;

public class CambiarVolDispositivo implements Controlar {
    @Override
    public void controlarDispositivo(String dispositivo) {
        System.out.println("Cambiando volumen del Dispositivo " + dispositivo);
    }
}
