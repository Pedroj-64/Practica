package co.edu.uniquindio;

public class Main {
    public static void main(String[] args) {

        Controlar apagar = new ApagarDispositivo();
        Controlar encender = new EncenderDispositivo();
        Controlar cambiarVol = new CambiarVolDispositivo();

        Dispositivo tv = new Televisor(apagar, "Sony");
        Dispositivo epson = new Proyector(encender, "Epson");
        Dispositivo radio = new Radio(cambiarVol, "JBL");

        tv.controlador();
        radio.controlador();
        epson.controlador();
    }
}