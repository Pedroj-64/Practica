package modelBridge;

public class Inventario extends Reporte {

    public Inventario(IFormato formato) {
        super(formato);
    }

    @Override
    public void generarReporte(String nombreArchivo) {
        System.out.println("Generando reporte de Inventario...");
        formato.exportar(nombreArchivo);
    }
}
