package modelBridge;

public abstract class  Reporte {

    protected IFormato formato;

    public Reporte(IFormato formato) {
        this.formato = formato;
    }

    public abstract void generarReporte(String nombreArchivo);
}
