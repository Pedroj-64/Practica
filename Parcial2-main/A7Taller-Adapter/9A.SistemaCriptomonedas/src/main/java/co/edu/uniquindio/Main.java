package co.edu.uniquindio;

public class Main {
    public static void main(String[] args) {

        //Dispositivo Viejo
        Billetera wallet1 = new Billetera();

        //Adaptador para usar Billetera Antigua con metodo nuevo en el Sistema
        ISistemaDePago AdapterWallet = new AdapterBilletera(wallet1);

        //Usar con metodo nuevo
        AdapterWallet.procesarPago(18);
    }
}