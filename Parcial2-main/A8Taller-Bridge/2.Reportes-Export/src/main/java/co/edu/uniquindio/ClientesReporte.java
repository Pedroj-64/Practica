package co.edu.uniquindio;

public class ClientesReporte extends Reporte{
    public String nombre;

    public ClientesReporte(Exportador exportador, String nombre) {
        super(exportador);
        this.nombre = nombre;
    }

    @Override
    public void generarReporte() {
        exportador.exportarReporte(nombre);
    }
}
