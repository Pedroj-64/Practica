package co.edu.uniquindio.facade;

/**
 * Clase del subsistema que gestiona los pagos.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class ProcesadorPagos {
    
    /**
     * Procesa un pago con tarjeta de crédito.
     * 
     * @param numeroTarjeta Número de tarjeta de crédito
     * @param nombreTitular Nombre del titular de la tarjeta
     * @param fechaExpiracion Fecha de expiración de la tarjeta
     * @param cvv Código de seguridad CVV
     * @param monto Monto a pagar
     * @return true si el pago fue procesado exitosamente, false en caso contrario
     */
    public boolean procesarPagoTarjeta(String numeroTarjeta, String nombreTitular, 
                                    String fechaExpiracion, String cvv, double monto) {
        System.out.println("Procesando pago con tarjeta de crédito");
        System.out.println("  Titular: " + nombreTitular);
        System.out.println("  Tarjeta: " + enmascararNumeroTarjeta(numeroTarjeta));
        System.out.println("  Monto: $" + monto);
        
        // Simulamos el procesamiento del pago
        boolean exitoso = true;
        
        if (exitoso) {
            System.out.println("  Pago procesado exitosamente");
        } else {
            System.out.println("  Error al procesar el pago");
        }
        
        return exitoso;
    }
    
    /**
     * Procesa un pago con PayPal.
     * 
     * @param correoElectronico Correo electrónico de la cuenta PayPal
     * @param contrasena Contraseña de la cuenta PayPal
     * @param monto Monto a pagar
     * @return true si el pago fue procesado exitosamente, false en caso contrario
     */
    public boolean procesarPagoPayPal(String correoElectronico, String contrasena, double monto) {
        System.out.println("Procesando pago con PayPal");
        System.out.println("  Cuenta: " + correoElectronico);
        System.out.println("  Monto: $" + monto);
        
        // Simulamos el procesamiento del pago
        boolean exitoso = true;
        
        if (exitoso) {
            System.out.println("  Pago procesado exitosamente");
        } else {
            System.out.println("  Error al procesar el pago");
        }
        
        return exitoso;
    }
    
    /**
     * Genera un recibo de pago.
     * 
     * @param idTransaccion ID de la transacción
     * @param monto Monto del pago
     * @param fecha Fecha del pago
     * @return Recibo en formato de texto
     */
    public String generarRecibo(String idTransaccion, double monto, String fecha) {
        System.out.println("Generando recibo para transacción " + idTransaccion);
        
        StringBuilder recibo = new StringBuilder();
        recibo.append("=== RECIBO DE PAGO ===\n");
        recibo.append("ID Transacción: ").append(idTransaccion).append("\n");
        recibo.append("Fecha: ").append(fecha).append("\n");
        recibo.append("Monto: $").append(String.format("%.2f", monto)).append("\n");
        recibo.append("=====================");
        
        return recibo.toString();
    }
    
    /**
     * Enmascara un número de tarjeta de crédito por seguridad.
     * 
     * @param numeroTarjeta Número de tarjeta a enmascarar
     * @return Número de tarjeta enmascarado
     */
    private String enmascararNumeroTarjeta(String numeroTarjeta) {
        if (numeroTarjeta == null || numeroTarjeta.length() < 4) {
            return "Número inválido";
        }
        
        String ultimos4 = numeroTarjeta.substring(numeroTarjeta.length() - 4);
        return "XXXX-XXXX-XXXX-" + ultimos4;
    }
}