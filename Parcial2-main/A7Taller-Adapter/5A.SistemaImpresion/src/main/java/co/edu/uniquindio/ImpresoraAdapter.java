package co.edu.uniquindio;

public class ImpresoraAdapter implements ISoftwareModerno {
    private ImpresoraAntigua impresoraAntigua;

public ImpresoraAdapter(ImpresoraAntigua impresoraAntigua) {
    this.impresoraAntigua = impresoraAntigua;
}

    @Override
    public void imprimirDocumento(String archivo) {
        impresoraAntigua.printFile(archivo + "  -> USANDO ADAPTADOR" );
    }
}
