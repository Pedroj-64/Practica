package co.edu.uniquindio;

public class DocumentoEncriptado extends DocumentoDecorator{
    public DocumentoEncriptado(FuncionAdicional documento) {
        super(documento);
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("Documento encriptado.");
    }


}
