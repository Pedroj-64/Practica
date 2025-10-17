package co.edu.uniquindio;

public class Main {
    public static void main(String[] args) {

    //Libreria vieja
        LibreriaAntigua libreriaAntigua = new LibreriaAntigua();

    //Adaptador
        LibreriaModerna libreriaModerna  = new AdaptadorLibreria(libreriaAntigua);

    // Usar
        libreriaModerna.mostrarImagen("Disco C");
    }
}