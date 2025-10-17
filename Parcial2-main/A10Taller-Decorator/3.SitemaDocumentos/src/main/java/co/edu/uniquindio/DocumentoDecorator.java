package co.edu.uniquindio;

public class DocumentoDecorator implements FuncionAdicional {
    protected FuncionAdicional documento;

    public DocumentoDecorator(FuncionAdicional documento) {
        this.documento = documento;
    }

    @Override
    public void mostrar() {
        documento.mostrar();
    }
}
