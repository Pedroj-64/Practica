package co.edu.uniquindio.practice.preparcialgpt.model.bridge;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementación de la pasarela de pago para MercadoPago
 * Implementador Concreto en el patrón Bridge
 */
public class MercadoPagoGateway implements PasarelaPago {
    
    private final Map<String, Double> transacciones;
    
    public MercadoPagoGateway() {
        transacciones = new HashMap<>();
    }

    @Override
    public boolean autorizar(String idTransaccion, double monto, String referencia) {
        // Simulación de autorización exitosa para la mayoría de los casos
        // En una implementación real, se conectaría a la API de MercadoPago
        
        if (monto <= 0) {
            return false;
        }
        
        // Simulación de rechazo aleatorio para algunas transacciones
        if (Math.random() < 0.1) {
            System.out.println("MercadoPago: Transacción rechazada por el banco emisor para " + referencia);
            return false;
        }
        
        System.out.println("MercadoPago: Autorización exitosa para " + idTransaccion + " por $" + monto);
        transacciones.put(idTransaccion, monto);
        return true;
    }

    @Override
    public boolean capturar(String idTransaccion, double monto) {
        // Verificar que la transacción exista y tenga suficientes fondos
        if (!transacciones.containsKey(idTransaccion) || transacciones.get(idTransaccion) < monto) {
            return false;
        }
        
        System.out.println("MercadoPago: Captura exitosa para " + idTransaccion + " por $" + monto);
        return true;
    }

    @Override
    public boolean anular(String idTransaccion) {
        if (!transacciones.containsKey(idTransaccion)) {
            return false;
        }
        
        System.out.println("MercadoPago: Anulación exitosa para " + idTransaccion);
        transacciones.remove(idTransaccion);
        return true;
    }

    @Override
    public boolean reembolsar(String idTransaccion, double monto, String motivo) {
        if (!transacciones.containsKey(idTransaccion) || transacciones.get(idTransaccion) < monto) {
            return false;
        }
        
        System.out.println("MercadoPago: Reembolso exitoso para " + idTransaccion + 
                          " por $" + monto + " - Motivo: " + motivo);
        
        // Actualizar el monto de la transacción
        transacciones.put(idTransaccion, transacciones.get(idTransaccion) - monto);
        
        // Si el reembolso es total, eliminar la transacción
        if (transacciones.get(idTransaccion) <= 0) {
            transacciones.remove(idTransaccion);
        }
        
        return true;
    }

    @Override
    public String getNombre() {
        return "MercadoPago";
    }
}