package co.edu.uniquindio.practice.preparcialgpt.model.dto;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * DTO (Data Transfer Object) que representa un horario de un servicio
 */
public class HorarioDTO {
    
    private String idServicio;
    private String nombreServicio;
    private LocalDateTime fechaHora;
    private int capacidad;
    private String instructor;
    private boolean activo;
    
    public HorarioDTO() {
    }
    
    public HorarioDTO(String idServicio, String nombreServicio, LocalDateTime fechaHora, int capacidad, 
                     String instructor, boolean activo) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.fechaHora = fechaHora;
        this.capacidad = capacidad;
        this.instructor = instructor;
        this.activo = activo;
    }

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HorarioDTO that = (HorarioDTO) o;
        return Objects.equals(idServicio, that.idServicio) &&
               Objects.equals(fechaHora, that.fechaHora);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idServicio, fechaHora);
    }
    
    @Override
    public String toString() {
        return nombreServicio + " - " + fechaHora;
    }
}