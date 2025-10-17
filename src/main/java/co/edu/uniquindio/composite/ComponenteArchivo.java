package co.edu.uniquindio.composite;

/**
 * Componente (Component) en el patrón Composite.
 * Define la interfaz para todos los objetos en la composición, tanto para hojas como para compuestos.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public abstract class ComponenteArchivo {
    
    protected String nombre;
    protected String extension;
    protected String ruta;
    
    /**
     * Constructor para ComponenteArchivo.
     * 
     * @param nombre El nombre del componente
     * @param extension La extensión del archivo (puede ser vacía para directorios)
     * @param ruta La ruta del archivo o directorio
     */
    public ComponenteArchivo(String nombre, String extension, String ruta) {
        this.nombre = nombre;
        this.extension = extension;
        this.ruta = ruta;
    }
    
    /**
     * Muestra la información del componente.
     * Debe ser implementado por subclases.
     * 
     * @param indentacion Nivel de indentación para la visualización en árbol
     */
    public abstract void mostrar(int indentacion);
    
    /**
     * Calcula el tamaño del componente en bytes.
     * Debe ser implementado por subclases.
     * 
     * @return Tamaño total en bytes
     */
    public abstract long calcularTamanio();
    
    /**
     * Añade un componente hijo.
     * Implementación predeterminada que lanza excepción, debe ser sobrescrita por compuestos.
     * 
     * @param componente El componente hijo a añadir
     * @throws UnsupportedOperationException Si el componente no soporta añadir hijos
     */
    public void agregar(ComponenteArchivo componente) {
        throw new UnsupportedOperationException("No se pueden agregar componentes a este tipo de elemento");
    }
    
    /**
     * Elimina un componente hijo.
     * Implementación predeterminada que lanza excepción, debe ser sobrescrita por compuestos.
     * 
     * @param componente El componente hijo a eliminar
     * @throws UnsupportedOperationException Si el componente no soporta eliminar hijos
     */
    public void eliminar(ComponenteArchivo componente) {
        throw new UnsupportedOperationException("No se pueden eliminar componentes de este tipo de elemento");
    }
    
    /**
     * Obtiene un componente hijo por su índice.
     * Implementación predeterminada que lanza excepción, debe ser sobrescrita por compuestos.
     * 
     * @param indice Índice del componente a obtener
     * @return El componente hijo en el índice especificado
     * @throws UnsupportedOperationException Si el componente no soporta obtener hijos
     */
    public ComponenteArchivo obtenerHijo(int indice) {
        throw new UnsupportedOperationException("Este tipo de elemento no tiene hijos");
    }
    
    /**
     * Genera una cadena de espacios para la indentación visual.
     * 
     * @param nivel Nivel de indentación
     * @return Cadena con espacios para la indentación
     */
    protected String getIndentacion(int nivel) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nivel; i++) {
            sb.append("    "); // 4 espacios por nivel
        }
        return sb.toString();
    }
    
    /**
     * Obtiene el nombre del componente.
     * 
     * @return El nombre del componente
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Obtiene la ruta del componente.
     * 
     * @return La ruta del componente
     */
    public String getRuta() {
        return ruta;
    }
    
    /**
     * Obtiene el nombre completo del componente (nombre + extensión).
     * 
     * @return El nombre completo del componente
     */
    public String getNombreCompleto() {
        if (extension != null && !extension.isEmpty()) {
            return nombre + "." + extension;
        } else {
            return nombre;
        }
    }
}