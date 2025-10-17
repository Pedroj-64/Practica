package co.edu.uniquindio;

public class AdapterBilletera implements ISistemaDePago{
    private Billetera billetera;

    public AdapterBilletera(Billetera billetera){
        this.billetera = billetera;
    }

    @Override
    public void procesarPago(double monto) {
        System.out.println("Usando Adaptador para procesar pago...");
        billetera.enviarTokens(monto);
    }
}
