package co.edu.uniquindio;

public abstract class Reporte {
    protected Exportador exportador; //Este es el puente

    public  Reporte(Exportador exportador) {
        this.exportador = exportador;
    }

    public abstract void generarReporte();
}
