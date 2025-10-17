package co.edu.uniquindio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Subsistema 1: Menú
 * Administra los platos disponibles, permite buscarlos y listarlos ordenados.
 */
class Menu {
    private List<Plato> platos = new ArrayList<>();

    public void agregarPlato(Plato plato) {
        platos.add(plato);
    }

    public Plato buscarPlato(String nombre) {
        for (Plato p : platos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) return p;
        }
        return null;
    }

    public List<Plato> obtenerMenuOrdenadoPorPrecio() {
        List<Plato> ordenados = new ArrayList<>(platos);
        ordenados.sort(Comparator.comparingDouble(Plato::getPrecio));
        return ordenados;
    }
}
