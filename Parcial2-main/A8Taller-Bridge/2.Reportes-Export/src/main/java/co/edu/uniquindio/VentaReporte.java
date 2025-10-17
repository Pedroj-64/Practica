package co.edu.uniquindio;

public class VentaReporte extends Reporte{
    public String nombre;

    public VentaReporte(Exportador exportador, String nombre){
        super(exportador);
        this.nombre=nombre;
    }
    @Override
    public void generarReporte() {
        exportador.exportarReporte(nombre);

    }
}
