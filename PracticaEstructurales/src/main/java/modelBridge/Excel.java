package modelBridge;

public class Excel implements IFormato{

    @Override
    public void exportar(String nombreArchivo) {
        System.out.println("Exportando " + nombreArchivo + " en formato Excel");
    }
}
