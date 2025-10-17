package co.edu.uniquindio.practice.preparcialgpt.model.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * DTO (Data Transfer Object) para encapsular la información necesaria para una reserva
 */
public class ReservaDTO {
    
    private String clienteId;
    private String servicioId;
    private String fecha;
    private String hora;
    private String[] extrasIds;
    private String metodoPago;
    private String referenciaPago;
    
    // Campos adicionales para el dashboard
    private String cliente;
    private String servicio;
    private String estado;
    
    public ReservaDTO() {
    }
    
    public ReservaDTO(String clienteId, String servicioId, String fecha, String hora) {
        this.clienteId = clienteId;
        this.servicioId = servicioId;
        this.fecha = fecha;
        this.hora = hora;
    }
    
    /**
     * Constructor para visualización en dashboard
     * @param localDate Fecha de la reserva
     * @param hora Hora de la reserva
     * @param servicio Nombre del servicio
     * @param cliente Nombre del cliente
     * @param estado Estado de la reserva
     */
    public ReservaDTO(LocalDate localDate, String hora, String servicio, String cliente, String estado) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.fecha = localDate.format(formatter);
        this.hora = hora;
        this.servicio = servicio;
        this.cliente = cliente;
        this.estado = estado;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getServicioId() {
        return servicioId;
    }

    public void setServicioId(String servicioId) {
        this.servicioId = servicioId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String[] getExtrasIds() {
        return extrasIds;
    }

    public void setExtrasIds(String[] extrasIds) {
        this.extrasIds = extrasIds;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getReferenciaPago() {
        return referenciaPago;
    }

    public void setReferenciaPago(String referenciaPago) {
        this.referenciaPago = referenciaPago;
    }
    
    // Getters y setters para campos adicionales
    
    public String getCliente() {
        return cliente;
    }
    
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    public String getServicio() {
        return servicio;
    }
    
    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
}