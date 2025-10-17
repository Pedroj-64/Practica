package co.edu.uniquindio.practice.preparcialgpt.model.bridge;

/**
 * Implementación concreta del refinamiento para pago con PSE (débito)
 * Abstracción Refinada en el patrón Bridge
 */
public class PagoPSE extends Pago {
    
    private String banco;
    private String numeroCuenta;
    private String tipoPersona;
    private String documento;
    
    public PagoPSE(PasarelaPago pasarela, String banco, String numeroCuenta,
                  String tipoPersona, String documento) {
        super(pasarela);
        this.banco = banco;
        this.numeroCuenta = numeroCuenta;
        this.tipoPersona = tipoPersona;
        this.documento = documento;
    }

    @Override
    public boolean procesar(double monto) {
        // Validar datos de la cuenta
        if (!validarDatos()) {
            return false;
        }
        
        // Crear referencia para la pasarela
        String referencia = "PSE-" + banco + "-" + documento;
        
        // Intentar autorización y captura en la pasarela
        boolean autorizado = pasarela.autorizar(idTransaccion, monto, referencia);
        
        if (autorizado) {
            return pasarela.capturar(idTransaccion, monto);
        }
        
        return false;
    }
    
    private boolean validarDatos() {
        // Validación simple para este ejemplo
        return banco != null && !banco.isEmpty() &&
               numeroCuenta != null && !numeroCuenta.isEmpty() &&
               documento != null && !documento.isEmpty();
    }
    
    public String getBanco() {
        return banco;
    }
    
    public void setBanco(String banco) {
        this.banco = banco;
    }
    
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    
    public String getTipoPersona() {
        return tipoPersona;
    }
    
    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
}