package co.edu.uniquindio.practice.preparcialgpt.model.bridge;

/**
 * Implementación concreta del refinamiento para pago en efectivo
 * Abstracción Refinada en el patrón Bridge
 */
public class PagoEfectivo extends Pago {
    
    private String referencia;
    
    public PagoEfectivo(PasarelaPago pasarela) {
        super(pasarela);
        this.referencia = "EFE-" + idTransaccion.substring(0, 8);
    }

    @Override
    public boolean procesar(double monto) {
        // Para efectivo, simplemente generamos una referencia de pago 
        // y realizamos una autorización
        
        boolean autorizado = pasarela.autorizar(idTransaccion, monto, referencia);
        
        if (autorizado) {
            return pasarela.capturar(idTransaccion, monto);
        }
        
        return false;
    }
    
    /**
     * Obtiene la referencia de pago para mostrar al cliente
     * @return Referencia de pago
     */
    public String getReferencia() {
        return referencia;
    }
}