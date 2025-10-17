package co.edu.uniquindio.practice.preparcialgpt.model.dto;

/**
 * DTO (Data Transfer Object) para encapsular el resultado de una operación
 */
public class ResultadoOperacionDTO {
    
    private final boolean exito;
    private final String mensaje;
    private final double total;
    private final String idTransaccion;
    
    private ResultadoOperacionDTO(boolean exito, String mensaje, double total, String idTransaccion) {
        this.exito = exito;
        this.mensaje = mensaje;
        this.total = total;
        this.idTransaccion = idTransaccion;
    }
    
    public static ResultadoOperacionDTO exitoso(String mensaje, double total, String idTransaccion) {
        return new ResultadoOperacionDTO(true, mensaje, total, idTransaccion);
    }
    
    public static ResultadoOperacionDTO fallido(String mensaje) {
        return new ResultadoOperacionDTO(false, mensaje, 0, null);
    }

    public boolean isExito() {
        return exito;
    }

    public String getMensaje() {
        return mensaje;
    }

    public double getTotal() {
        return total;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }
    
    @Override
    public String toString() {
        if (exito) {
            return "Operación exitosa: " + mensaje + " | Total: $" + total + 
                  (idTransaccion != null ? " | ID: " + idTransaccion : "");
        } else {
            return "Error: " + mensaje;
        }
    }
}