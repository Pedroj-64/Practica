package co.edu.uniquindio.practice.preparcialgpt.model.bridge;

/**
 * Implementación concreta del refinamiento para pago con tarjeta
 * Abstracción Refinada en el patrón Bridge
 */
public class PagoTarjeta extends Pago {
    
    private String numeroTarjeta;
    private String nombreTitular;
    private String fechaExpiracion;
    private String codigoSeguridad;
    private TipoTarjeta tipoTarjeta;
    
    public PagoTarjeta(PasarelaPago pasarela, String numeroTarjeta, String nombreTitular, 
                       String fechaExpiracion, String codigoSeguridad, TipoTarjeta tipoTarjeta) {
        super(pasarela);
        this.numeroTarjeta = numeroTarjeta;
        this.nombreTitular = nombreTitular;
        this.fechaExpiracion = fechaExpiracion;
        this.codigoSeguridad = codigoSeguridad;
        this.tipoTarjeta = tipoTarjeta;
    }

    @Override
    public boolean procesar(double monto) {
        // Validar datos de la tarjeta
        if (!validarDatosTarjeta()) {
            return false;
        }
        
        // Enmascarar el número de tarjeta para la referencia
        String referencia = enmascararTarjeta();
        
        // Intentar autorización y captura en la pasarela
        boolean autorizado = pasarela.autorizar(idTransaccion, monto, referencia);
        
        if (autorizado) {
            return pasarela.capturar(idTransaccion, monto);
        }
        
        return false;
    }
    
    private boolean validarDatosTarjeta() {
        // En una aplicación real, aquí se validaría el número de tarjeta con algoritmo de Luhn,
        // la fecha de expiración, el código de seguridad, etc.
        
        // Validación simple para este ejemplo
        return numeroTarjeta != null && numeroTarjeta.length() >= 15 &&
               fechaExpiracion != null && fechaExpiracion.length() >= 5 &&
               codigoSeguridad != null && codigoSeguridad.length() >= 3;
    }
    
    private String enmascararTarjeta() {
        if (numeroTarjeta == null || numeroTarjeta.length() < 4) {
            return "****";
        }
        
        return "**** **** **** " + numeroTarjeta.substring(numeroTarjeta.length() - 4);
    }
    
    // Getters y setters
    
    public String getNumeroTarjeta() {
        return enmascararTarjeta();
    }
    
    public String getNombreTitular() {
        return nombreTitular;
    }
    
    public TipoTarjeta getTipoTarjeta() {
        return tipoTarjeta;
    }
    
    // Enumeración para tipos de tarjeta
    public enum TipoTarjeta {
        VISA("Visa"),
        MASTERCARD("MasterCard"),
        AMEX("American Express");
        
        private final String nombre;
        
        TipoTarjeta(String nombre) {
            this.nombre = nombre;
        }
        
        @Override
        public String toString() {
            return nombre;
        }
    }
}