package co.edu.uniquindio;

public class InventarioReporte extends Reporte{
    public String nombre;

    public InventarioReporte(Exportador exportador, String nombre) {
        super(exportador);
        this.nombre = nombre;
    }

    @Override
    public void generarReporte() {
        exportador.exportarReporte(nombre);
    }
}
