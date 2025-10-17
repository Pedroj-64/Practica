package co.edu.uniquindio.practice.preparcial.model;

/**
 * Clase DTO (Data Transfer Object) que representa un horario
 * Se utiliza para transferir datos de horarios entre diferentes capas
 */
public class HorarioDTO {
    private String dia;
    private String horaInicio;
    private String horaFin;
    private int capacidad;
    private String actividad;
    
    public HorarioDTO() {
        // Constructor por defecto
    }
    
    public HorarioDTO(String dia, String horaInicio, String horaFin, int capacidad, String actividad) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.capacidad = capacidad;
        this.actividad = actividad;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }
    
    @Override
    public String toString() {
        return "Horario [dia=" + dia + ", hora=" + horaInicio + "-" + horaFin + 
               ", actividad=" + actividad + ", capacidad=" + capacidad + "]";
    }
}