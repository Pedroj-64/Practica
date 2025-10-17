package co.edu.uniquindio.practice.preparcialgpt.model.bridge;

/**
 * Interfaz implementador para el patrón Bridge
 * Define las operaciones básicas que una pasarela de pago debe implementar
 */
public interface PasarelaPago {
    
    /**
     * Autoriza un pago por el monto especificado
     * @param idTransaccion ID único de la transacción
     * @param monto Monto a autorizar
     * @param referencia Referencia de la transacción (puede ser número de tarjeta, cuenta, etc.)
     * @return true si la autorización fue exitosa, false en caso contrario
     */
    boolean autorizar(String idTransaccion, double monto, String referencia);
    
    /**
     * Captura un pago previamente autorizado
     * @param idTransaccion ID único de la transacción
     * @param monto Monto a capturar (puede ser menor o igual al autorizado)
     * @return true si la captura fue exitosa, false en caso contrario
     */
    boolean capturar(String idTransaccion, double monto);
    
    /**
     * Anula una transacción previa
     * @param idTransaccion ID único de la transacción a anular
     * @return true si la anulación fue exitosa, false en caso contrario
     */
    boolean anular(String idTransaccion);
    
    /**
     * Reembolsa una transacción previa
     * @param idTransaccion ID único de la transacción original
     * @param monto Monto a reembolsar
     * @param motivo Motivo del reembolso
     * @return true si el reembolso fue exitoso, false en caso contrario
     */
    boolean reembolsar(String idTransaccion, double monto, String motivo);
    
    /**
     * Obtiene el nombre de la pasarela de pago
     * @return Nombre de la pasarela
     */
    String getNombre();
}