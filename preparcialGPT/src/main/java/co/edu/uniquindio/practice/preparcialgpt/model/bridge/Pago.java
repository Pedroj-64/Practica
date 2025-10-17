package co.edu.uniquindio.practice.preparcialgpt.model.bridge;

import java.util.UUID;

/**
 * Abstracción en el patrón Bridge
 * Clase base para todos los tipos de pago
 */
public abstract class Pago {
    
    protected PasarelaPago pasarela;
    protected String idTransaccion;
    
    public Pago(PasarelaPago pasarela) {
        this.pasarela = pasarela;
        this.idTransaccion = UUID.randomUUID().toString();
    }
    
    /**
     * Procesa el pago por el monto indicado
     * @param monto Monto a pagar
     * @return true si el pago fue exitoso, false en caso contrario
     */
    public abstract boolean procesar(double monto);
    
    /**
     * Cancela un pago previamente realizado
     * @return true si la cancelación fue exitosa, false en caso contrario
     */
    public boolean cancelar() {
        return pasarela.anular(idTransaccion);
    }
    
    /**
     * Devuelve el monto pagado
     * @param monto Monto a devolver
     * @param motivo Motivo de la devolución
     * @return true si la devolución fue exitosa, false en caso contrario
     */
    public boolean devolver(double monto, String motivo) {
        return pasarela.reembolsar(idTransaccion, monto, motivo);
    }
    
    /**
     * Cambia la pasarela de pago usada
     * @param nuevaPasarela Nueva pasarela a utilizar
     */
    public void cambiarPasarela(PasarelaPago nuevaPasarela) {
        this.pasarela = nuevaPasarela;
    }
    
    /**
     * Obtiene el ID de la transacción
     * @return ID único de la transacción
     */
    public String getIdTransaccion() {
        return idTransaccion;
    }
    
    /**
     * Obtiene la pasarela de pago utilizada
     * @return La pasarela de pago
     */
    public PasarelaPago getPasarela() {
        return pasarela;
    }
}