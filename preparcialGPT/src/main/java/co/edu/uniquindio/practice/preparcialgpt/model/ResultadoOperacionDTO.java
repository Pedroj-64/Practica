package co.edu.uniquindio.practice.preparcialgpt.model;

/**
 * Data Transfer Object para el resultado de operaciones
 */
public class ResultadoOperacionDTO {
    private boolean exito;
    private String mensaje;
    private String idResultado;

    public ResultadoOperacionDTO(boolean exito, String mensaje, String idResultado) {
        this.exito = exito;
        this.mensaje = mensaje;
        this.idResultado = idResultado;
    }

    public boolean isExito() {
        return exito;
    }

    public void setExito(boolean exito) {
        this.exito = exito;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(String idResultado) {
        this.idResultado = idResultado;
    }
}