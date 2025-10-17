package co.edu.uniquindio.composite;

/**
 * Clase de demostración para el patrón Composite.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class CompositeDemo {
    
    public static void main(String[] args) {
        System.out.println("===== DEMOSTRACIÓN DEL PATRÓN COMPOSITE =====\n");
        
        // Crear una estructura de archivos y directorios
        System.out.println("Creando estructura de archivos y directorios...\n");
        
        // Directorio raíz: Mis Documentos
        Directorio misDocumentos = new Directorio("Mis Documentos", "/usuarios/usuario");
        
        // Subdirectorio: Universidad
        Directorio universidad = new Directorio("Universidad", "/usuarios/usuario/Mis Documentos");
        
        // Archivos en Universidad
        Archivo tesis = new Archivo("Tesis Final", "pdf", "/usuarios/usuario/Mis Documentos/Universidad", 2500000, "Documento");
        Archivo horario = new Archivo("Horario Semestre", "xlsx", "/usuarios/usuario/Mis Documentos/Universidad", 350000, "Hoja de Cálculo");
        
        // Subdirectorio dentro de Universidad: Proyectos
        Directorio proyectos = new Directorio("Proyectos", "/usuarios/usuario/Mis Documentos/Universidad");
        
        // Archivos en Proyectos
        Archivo proyecto1 = new Archivo("Proyecto Programación", "zip", "/usuarios/usuario/Mis Documentos/Universidad/Proyectos", 4500000, "Comprimido");
        Archivo proyecto2 = new Archivo("Informe Final", "docx", "/usuarios/usuario/Mis Documentos/Universidad/Proyectos", 1800000, "Documento");
        
        // Subdirectorio: Fotos
        Directorio fotos = new Directorio("Fotos", "/usuarios/usuario/Mis Documentos");
        
        // Archivos en Fotos
        Archivo foto1 = new Archivo("Vacaciones", "jpg", "/usuarios/usuario/Mis Documentos/Fotos", 2800000, "Imagen");
        Archivo foto2 = new Archivo("Graduación", "png", "/usuarios/usuario/Mis Documentos/Fotos", 3200000, "Imagen");
        
        // Archivos directos en Mis Documentos
        Archivo notasPersonales = new Archivo("Notas Personales", "txt", "/usuarios/usuario/Mis Documentos", 15000, "Texto");
        Archivo presupuesto = new Archivo("Presupuesto Anual", "xlsx", "/usuarios/usuario/Mis Documentos", 450000, "Hoja de Cálculo");
        
        // Construir la estructura jerárquica
        proyectos.agregar(proyecto1);
        proyectos.agregar(proyecto2);
        
        universidad.agregar(tesis);
        universidad.agregar(horario);
        universidad.agregar(proyectos);
        
        fotos.agregar(foto1);
        fotos.agregar(foto2);
        
        misDocumentos.agregar(universidad);
        misDocumentos.agregar(fotos);
        misDocumentos.agregar(notasPersonales);
        misDocumentos.agregar(presupuesto);
        
        // Mostrar la estructura completa
        System.out.println("Mostrando la estructura completa del sistema de archivos:");
        misDocumentos.mostrar(0);
        
        // Demostrar cálculo de tamaño
        System.out.println("\nTamaño de varios componentes:");
        System.out.println("- Archivo 'Tesis Final.pdf': " + formatearTamanio(tesis.calcularTamanio()));
        System.out.println("- Directorio 'Proyectos': " + formatearTamanio(proyectos.calcularTamanio()));
        System.out.println("- Directorio 'Universidad': " + formatearTamanio(universidad.calcularTamanio()));
        System.out.println("- Directorio raíz 'Mis Documentos': " + formatearTamanio(misDocumentos.calcularTamanio()));
        
        // Demostrar navegación por la estructura
        System.out.println("\nNavegando por la estructura:");
        System.out.println("Contenido de 'Universidad':");
        universidad.getHijos().forEach(hijo -> System.out.println("- " + hijo.getNombreCompleto()));
        
        // Modificar la estructura
        System.out.println("\nModificando la estructura...");
        
        // Añadir un nuevo archivo a Universidad
        Archivo nuevoArchivo = new Archivo("Examen Final", "pdf", "/usuarios/usuario/Mis Documentos/Universidad", 1200000, "Documento");
        universidad.agregar(nuevoArchivo);
        
        // Eliminar un archivo de Fotos
        System.out.println("Eliminando 'Vacaciones.jpg' de Fotos");
        fotos.eliminar(foto1);
        
        // Mostrar la estructura actualizada
        System.out.println("\nEstructura actualizada:");
        misDocumentos.mostrar(0);
        
        System.out.println("\n===== FIN DE LA DEMOSTRACIÓN =====");
    }
    
    /**
     * Formatea el tamaño en bytes a una representación legible (KB, MB, etc.).
     * 
     * @param bytes Tamaño en bytes
     * @return Cadena formateada con el tamaño y su unidad
     */
    private static String formatearTamanio(long bytes) {
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
}