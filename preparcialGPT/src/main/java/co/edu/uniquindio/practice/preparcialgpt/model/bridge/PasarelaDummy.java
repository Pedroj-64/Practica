package co.edu.uniquindio.practice.preparcialgpt.model.bridge;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementación de una pasarela de pago simulada para pruebas
 * Implementador Concreto en el patrón Bridge
 */
public class PasarelaDummy implements PasarelaPago {
    
    private final Map<String, Double> transacciones;
    private boolean rechazarTodo;
    
    public PasarelaDummy() {
        this(false);
    }
    
    public PasarelaDummy(boolean rechazarTodo) {
        transacciones = new HashMap<>();
        this.rechazarTodo = rechazarTodo;
    }

    @Override
    public boolean autorizar(String idTransaccion, double monto, String referencia) {
        if (rechazarTodo || monto <= 0) {
            System.out.println("PasarelaDummy: Transacción rechazada para " + referencia);
            return false;
        }
        
        System.out.println("PasarelaDummy: Autorización exitosa para " + idTransaccion + " por $" + monto);
        transacciones.put(idTransaccion, monto);
        return true;
    }

    @Override
    public boolean capturar(String idTransaccion, double monto) {
        if (rechazarTodo || !transacciones.containsKey(idTransaccion) || transacciones.get(idTransaccion) < monto) {
            return false;
        }
        
        System.out.println("PasarelaDummy: Captura exitosa para " + idTransaccion + " por $" + monto);
        return true;
    }

    @Override
    public boolean anular(String idTransaccion) {
        if (rechazarTodo || !transacciones.containsKey(idTransaccion)) {
            return false;
        }
        
        System.out.println("PasarelaDummy: Anulación exitosa para " + idTransaccion);
        transacciones.remove(idTransaccion);
        return true;
    }

    @Override
    public boolean reembolsar(String idTransaccion, double monto, String motivo) {
        if (rechazarTodo || !transacciones.containsKey(idTransaccion) || transacciones.get(idTransaccion) < monto) {
            return false;
        }
        
        System.out.println("PasarelaDummy: Reembolso exitoso para " + idTransaccion + 
                          " por $" + monto + " - Motivo: " + motivo);
        
        // Actualizar el monto de la transacción
        transacciones.put(idTransaccion, transacciones.get(idTransaccion) - monto);
        
        // Si el reembolso es total, eliminar la transacción
        if (transacciones.get(idTransaccion) <= 0) {
            transacciones.remove(idTransaccion);
        }
        
        return true;
    }
    
    /**
     * Configura si todas las transacciones deben ser rechazadas
     * @param rechazarTodo true para rechazar todas las transacciones
     */
    public void setRechazarTodo(boolean rechazarTodo) {
        this.rechazarTodo = rechazarTodo;
    }

    @Override
    public String getNombre() {
        return "PasarelaDummy";
    }
}