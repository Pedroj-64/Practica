package co.edu.uniquindio;

public class Main {
    public static void main(String[] args) {

        //Objeto del sistema antiguo
        ReproductorViejo reproductorMp3 = new ReproductorViejo();

        //Adaptador para que funcione en el nuevo sistema
        ReproductorNuevo iPhone = new ReproductorAdaptador(reproductorMp3);

        //Usarlo como si fuera nuevo
        iPhone.reproducir("Sublime Mujer - Vicente Fernandez");
    }
}