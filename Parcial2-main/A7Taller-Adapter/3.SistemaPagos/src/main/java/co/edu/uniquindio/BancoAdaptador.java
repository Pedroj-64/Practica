package co.edu.uniquindio;

public class BancoAdaptador implements BancoNuevo {
    private BancoTradicional bancoTradicional;

    public BancoAdaptador(BancoTradicional bancoTradicional) {
        this.bancoTradicional = bancoTradicional;
    }

    @Override
    public void procesarPago(double monto) {
        System.out.println("Procesando pago mediante adaptador del banco tradicional...");
        bancoTradicional.realizarTransferencia(monto);
    }
}
