package co.edu.uniquindio;

/**
 * ==========================================
 * 💡 Clase: Main
 * ------------------------------------------
 * En lugar de interactuar directamente con varios módulos (inventario,
 * ventas y recomendaciones), el cliente usa solo la clase `LibreriaFacade`
 * para realizar todas las operaciones.
 * ==========================================
 */
public class Main {
    public static void main(String[] args) {

        // Crear la fachada
        LibreriaFacade libreria = new LibreriaFacade();

        // Agregar libros al inventario (usar los 5 parámetros: titulo, autor, categoria, precio, popularidad)
        libreria.agregarLibro(new Libro("Cien años de soledad", "Gabriel García Márquez", "Realismo mágico", 45000.0, 10));
        libreria.agregarLibro(new Libro("El Principito", "Antoine de Saint-Exupéry", "Infantil", 25000.0, 9));
        libreria.agregarLibro(new Libro("1984", "George Orwell", "Ciencia ficción", 38000.0, 8));

        // Buscar un libro por título
        System.out.println("\nBUSCAR LIBRO");
        libreria.buscarLibro("El Principito");

        // Comprar un libro (la fachada coordina inventario y ventas)
        System.out.println("\nCOMPRAR LIBRO");
        libreria.comprarLibro("1984", 2);

        // Recomendar libros por categoría
        System.out.println("\nRECOMENDACIONES");
        libreria.recomendarLibro("Realismo mágico");

        // Intentar comprar un libro no existente (ejemplo de manejo)
        System.out.println("\nINTENTAR COMPRA INEXISTENTE");
        libreria.comprarLibro("El código Da Vinci", 1);
    }
}

