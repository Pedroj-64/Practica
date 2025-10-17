package co.edu.uniquindio;

public class DocumentoFormato extends DocumentoDecorator {
    public String formato;

    public DocumentoFormato(FuncionAdicional documento, String formato) {
        super(documento);
        this.formato = formato;
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("Documento con formato: " + formato);
    }
}
