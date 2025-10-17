package co.edu.uniquindio;

public class Main {
    public static void main(String[] args) {

        //Dispositivo Viejo
        RespaldoLocal unidadDisco = new RespaldoLocal();

        //Adaptador
        IRespaldo adaptador = new AdapterRespaldoLocal(unidadDisco);

        //Usar como nuevo
        adaptador.subirArchivo("Foticos azarosas");
    }
}