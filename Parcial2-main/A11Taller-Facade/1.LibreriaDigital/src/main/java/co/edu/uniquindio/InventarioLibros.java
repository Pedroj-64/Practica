package co.edu.uniquindio;

import java.util.ArrayList;
import java.util.List;

/**
 * Módulo que gestiona el inventario:
 * agregar, eliminar y buscar libros.
 */
public class InventarioLibros {
    private List<Libro> libros = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro agregado: " + libro.getTitulo());
    }

    public Libro buscarPorTitulo(String titulo) {
        return libros.stream()
                .filter(l -> l.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }

    public List<Libro> getLibros() {
        return libros;
    }
}
