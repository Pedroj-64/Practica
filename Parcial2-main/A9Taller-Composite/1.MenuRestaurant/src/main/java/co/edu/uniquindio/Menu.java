package co.edu.uniquindio;

import java.util.ArrayList;
import java.util.List;

public class Menu implements MostrarMenu {
    private String nombre;
    private List<MostrarMenu> items = new ArrayList<>();

    public Menu(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(MostrarMenu item) {
        items.add(item);
    }

    public void eliminar(MostrarMenu item) {
        items.remove(item);
    }

    @Override
    public void mostrar() {
        System.out.println("MENÚ: " + nombre);
        for (MostrarMenu item : items) {
            item.mostrar();
        }
    }
}
