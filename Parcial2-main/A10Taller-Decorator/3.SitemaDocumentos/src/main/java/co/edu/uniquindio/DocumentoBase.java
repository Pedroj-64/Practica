package co.edu.uniquindio;

public class DocumentoBase implements  FuncionAdicional {
    public String contenido;

    public DocumentoBase(String contenido) {
        this.contenido = contenido;
    }


    @Override
    public void mostrar() {
        System.out.println("Documento Base: " + contenido);
    }
}
