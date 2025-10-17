package co.edu.uniquindio.composite;

/**
 * Clase hoja (Leaf) en el patrón Composite.
 * Representa un archivo que no tiene hijos.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class Archivo extends ComponenteArchivo {
    
    private long tamanio; // Tamaño en bytes
    private String tipo;  // Tipo de archivo (documento, imagen, etc.)
    
    /**
     * Constructor para Archivo.
     * 
     * @param nombre El nombre del archivo sin extensión
     * @param extension La extensión del archivo (ej. txt, pdf, jpg)
     * @param ruta La ruta del archivo
     * @param tamanio El tamaño del archivo en bytes
     * @param tipo El tipo del archivo (documento, imagen, etc.)
     */
    public Archivo(String nombre, String extension, String ruta, long tamanio, String tipo) {
        super(nombre, extension, ruta);
        this.tamanio = tamanio;
        this.tipo = tipo;
    }
    
    @Override
    public void mostrar(int indentacion) {
        String indent = getIndentacion(indentacion);
        System.out.println(indent + "📄 " + getNombreCompleto() + " (" + formatearTamanio(tamanio) + ", " + tipo + ")");
    }
    
    @Override
    public long calcularTamanio() {
        return tamanio;
    }
    
    /**
     * Formatea el tamaño en bytes a una representación legible (KB, MB, etc.).
     * 
     * @param bytes Tamaño en bytes
     * @return Cadena formateada con el tamaño y su unidad
     */
    private String formatearTamanio(long bytes) {
        if (bytes < 1024) {
            return bytes + " bytes";
        } else if (bytes < 1024 * 1024) {
            return String.format("%.2f KB", bytes / 1024.0);
        } else if (bytes < 1024 * 1024 * 1024) {
            return String.format("%.2f MB", bytes / (1024.0 * 1024.0));
        } else {
            return String.format("%.2f GB", bytes / (1024.0 * 1024.0 * 1024.0));
        }
    }
    
    /**
     * Obtiene el tipo de archivo.
     * 
     * @return El tipo de archivo
     */
    public String getTipo() {
        return tipo;
    }
}