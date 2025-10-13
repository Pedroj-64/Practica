package modelBridge;

public class Ventas extends Reporte{

    public Ventas(IFormato formato) {
        super(formato);
    }

    @Override
    public void generarReporte(String nombreArchivo) {
        System.out.println("Generando reporte de Ventas...");
        formato.exportar(nombreArchivo);
    }
}
