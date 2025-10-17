package co.edu.uniquindio.practice.preparcialgpt.model;

import java.time.LocalDate;

/**
 * Data Transfer Object para la información de reservas
 */
public class ReservaDTO {
    private LocalDate fecha;
    private String hora;
    private String servicio;
    private String cliente;
    private String estado;

    public ReservaDTO(LocalDate fecha, String hora, String servicio, String cliente, String estado) {
        this.fecha = fecha;
        this.hora = hora;
        this.servicio = servicio;
        this.cliente = cliente;
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}