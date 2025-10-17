package co.edu.uniquindio;

public class Main {
    public static void main(String[] args) {

        // Dispositivo viejo
        LamparaTradicional lamparaVieja = new LamparaTradicional();

        // Adaptar
        IDomotica adaptador = new AdapterLampara(lamparaVieja);

        // Usar como si fuera nuevo melo
        adaptador.encenderDispositivo("Lamparita");
    }
}