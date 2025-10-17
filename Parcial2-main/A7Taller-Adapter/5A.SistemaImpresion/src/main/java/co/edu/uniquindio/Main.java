package co.edu.uniquindio;

public class Main {
    public static void main(String[] args) {

    //Dispositivo Viejo
    ImpresoraAntigua hp2007 = new ImpresoraAntigua();

    //Adaptador
    ISoftwareModerno iSoftwareModerno = new ImpresoraAdapter(hp2007);

    //Usar como si fuera nuevo
    iSoftwareModerno.imprimirDocumento("Parcial.PDF");

    }
}