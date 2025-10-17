package co.edu.uniquindio;

public class Main {
    public static void main(String[] args) {
        //Documento Base
        FuncionAdicional d1 = new DocumentoBase("Parcial I");

        //Agregar Vainas
        d1 = new DocumentoFormato(d1, "PDF");
        d1 = new DocumentoEncriptado(d1);
        d1 = new DocumentoComprimido(d1);


        d1.mostrar();
    }
}