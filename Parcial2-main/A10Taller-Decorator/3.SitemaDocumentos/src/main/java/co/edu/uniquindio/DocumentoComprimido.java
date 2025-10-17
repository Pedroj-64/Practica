package co.edu.uniquindio;

public class DocumentoComprimido extends DocumentoDecorator {
    public DocumentoComprimido(FuncionAdicional documento) {
        super(documento);
    }

    public void mostrar() {
        super.mostrar();
        System.out.println("Documento Comprimido.");
    }
}
