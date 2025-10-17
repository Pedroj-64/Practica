package co.edu.uniquindio;

import java.util.List;

/**
 * ==========================================
 * 💡 Clase: LibreriaFacade
 * ------------------------------------------*
 * 👉 Propósito:
 * Simplificar el acceso a múltiples módulos internos
 * (Inventario, Ventas y Recomendaciones) mediante una única interfaz.
 *
 * El cliente (Main) no necesita conocer cómo funcionan los módulos internos,
 * solo usa los métodos de esta fachada.
 * ==========================================
 */
public class LibreriaFacade {

    // Módulos internos que la fachada coordina
    private final InventarioLibros inventario = new InventarioLibros();
    private final ModuloVentas ventas = new ModuloVentas();
    private final ModuloRecomendaciones recomendaciones = new ModuloRecomendaciones();

    /**
     * 🔍 Busca un libro en el inventario por título.
     * Si lo encuentra, lo muestra; si no, informa que no existe.
     */
    public void buscarLibro(String titulo) {
        Libro libro = inventario.buscarPorTitulo(titulo);
        System.out.println(
                libro != null
                        ? "📖 Libro encontrado: " + libro
                        : "❌ Libro no encontrado: " + titulo
        );
    }

    /**
     * 💰 Permite comprar un libro existente del inventario.
     * Usa el módulo de ventas para calcular el total y aplicar descuentos.
     */
    public void comprarLibro(String titulo, int cantidad) {
        Libro libro = inventario.buscarPorTitulo(titulo);
        if (libro == null) {
            System.out.println("❌ No se puede comprar, libro no existe en el inventario.");
            return;
        }

        double total = ventas.calcularTotal(libro, cantidad);
        System.out.println("✅ Compra realizada: " + cantidad + " x " + libro.getTitulo() + " = $" + total);
    }

    /**
     * 📚 Genera recomendaciones de libros según una categoría.
     * Utiliza el módulo de recomendaciones para ordenarlos por popularidad.
     */
    public void recomendarLibro(String categoria) {
        List<Libro> lista = recomendaciones.recomendarPorCategoria(inventario.getLibros(), categoria);
        System.out.println("\n📚 Recomendaciones para la categoría '" + categoria + "':");
        if (lista.isEmpty()) {
            System.out.println("No hay libros disponibles en esta categoría.");
        } else {
            lista.forEach(System.out::println);
        }
    }

    /**
     * ➕ Método auxiliar: agrega un libro al inventario.
     * (Normalmente esto lo haría un módulo de administración).
     */
    public void agregarLibro(Libro libro) {
        inventario.agregarLibro(libro);
    }
}


