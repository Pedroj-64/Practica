package co.edu.uniquindio;

public class Main {
    public static void main(String[] args) {

        BancoTradicional bancoTradicional = new BancoTradicional();

        BancoNuevo bancoNuevo = new BancoAdaptador(bancoTradicional);

        bancoNuevo.procesarPago(1.575);
    }
}