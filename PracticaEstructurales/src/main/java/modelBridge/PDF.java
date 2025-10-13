package modelBridge;

public class PDF implements IFormato{

    @Override
    public void exportar(String nombreArchivo) {
        System.out.println("Exportando " + nombreArchivo + " en formato PDF");
    }
}
