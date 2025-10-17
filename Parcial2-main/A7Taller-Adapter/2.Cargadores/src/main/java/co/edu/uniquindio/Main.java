package co.edu.uniquindio;

public class Main {
    public static void main(String[] args) {

        //Dispositivo Viejo
        DispositivoViejo alcatel = new DispositivoViejo();

        //Adaptador
        DispositivoNuevo cargadornuevo = new AdaptadorDispositivo(alcatel);

        //Usarlo como si fuera nuevo

        cargadornuevo.cargarUSB("Alcatel");

    }
}