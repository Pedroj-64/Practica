package co.edu.uniquindio;

public class ApagarDispositivo implements Controlar {
    @Override
    public void controlarDispositivo(String dispositivo) {
        System.out.println("Apagando Dispositivo " + dispositivo);
    }
}
