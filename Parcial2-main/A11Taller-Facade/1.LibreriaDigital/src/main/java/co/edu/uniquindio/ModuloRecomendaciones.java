package co.edu.uniquindio;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Módulo que genera recomendaciones
 * según categoría o popularidad.
 */
public class ModuloRecomendaciones {

    public List<Libro> recomendarPorCategoria(List<Libro> libros, String categoria) {
        return libros.stream()
                .filter(l -> l.getCategoria().equalsIgnoreCase(categoria))
                .sorted(Comparator.comparingInt(Libro::getPopularidad).reversed())
                .collect(Collectors.toList());
    }
}
