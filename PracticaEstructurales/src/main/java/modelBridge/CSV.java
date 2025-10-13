package modelBridge;

public class CSV implements IFormato{

    @Override
    public void exportar(String nombreArchivo) {
        System.out.println("Exportando " + nombreArchivo + " en formato CSV");
    }
}
