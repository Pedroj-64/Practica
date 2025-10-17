package co.edu.uniquindio;

public class Plato implements MostrarMenu {
    public String nombre;

    public Plato(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void mostrar() {
        System.out.println("    "+ nombre);
    }
}
