package co.edu.uniquindio;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Representa un libro dentro de la librería.
 * Lombok genera getters, setters, toString y constructor.
 */
@Data
@AllArgsConstructor

public class Libro {
    private String titulo;
    private String autor;
    private String categoria;
    private double precio;
    private int popularidad;
}

