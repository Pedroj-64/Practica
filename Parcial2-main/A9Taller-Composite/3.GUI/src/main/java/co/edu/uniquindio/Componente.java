package co.edu.uniquindio;

public class Componente implements IComponente {
    public String nombre;

    public Componente(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void mostrar(String identacion) {
        System.out.println(identacion + "- " + nombre);
    }
}
