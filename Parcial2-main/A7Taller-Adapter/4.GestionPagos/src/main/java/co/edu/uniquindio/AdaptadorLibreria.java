package co.edu.uniquindio;

public class AdaptadorLibreria implements  LibreriaModerna {
    private LibreriaAntigua libreriaAntigua;

    public AdaptadorLibreria(LibreriaAntigua libreria) {
        this.libreriaAntigua = libreria;
    }

    @Override
    public void mostrarImagen(String ruta) {
        libreriaAntigua.renderizar("Usando adaptador en: " +ruta);
    }
}
