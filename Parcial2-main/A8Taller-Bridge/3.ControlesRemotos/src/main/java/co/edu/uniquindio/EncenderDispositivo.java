package co.edu.uniquindio;

public class EncenderDispositivo implements Controlar {
    @Override
    public void controlarDispositivo(String dispositivo) {
        System.out.println("Encendiendo Dispositivo " + dispositivo);
    }
}
