package co.edu.uniquindio;

public class Main {
    public static void main(String[] args) {

        ModuloSonido pioneer = new ModuloSonido();

        IMultimedia adaptadorBluetooh  = new AdapterModuloSonido(pioneer);

        adaptadorBluetooh.reproducirAudio("444 - Yan Block");

    }
}