package co.edu.uniquindio.practice.preparcialgpt.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Representa un cliente del centro deportivo FitHub+
 */
public class Cliente {
    
    private final String id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private List<Reserva> historialReservas;
    
    public Cliente(String nombre, String apellido, String email, String telefono) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.historialReservas = new ArrayList<>();
    }
    
    public String getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public List<Reserva> getHistorialReservas() {
        return new ArrayList<>(historialReservas);
    }
    
    public void agregarReserva(Reserva reserva) {
        if (reserva != null) {
            historialReservas.add(reserva);
        }
    }
    
    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + id + '\'' +
                ", nombreCompleto='" + getNombreCompleto() + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}