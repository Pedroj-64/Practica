package co.edu.uniquindio.practice.preparcial.model;

import co.edu.uniquindio.practice.preparcial.interfaces.ProveedorHorarioPort;
import java.util.ArrayList;
import java.util.List;

/**
 * Adaptador que implementa ProveedorHorarioPort para leer horarios desde un CSV
 * Este es un ejemplo de implementación del patrón Adapter
 */
public class CsvHorarioAdapter implements ProveedorHorarioPort {
    
    private String rutaArchivo;
    
    public CsvHorarioAdapter(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }
    
    @Override
    public List<HorarioDTO> cargarHorarios() {
        // En una implementación real, aquí leeríamos un archivo CSV
        // Como es un ejemplo, generamos datos de prueba
        System.out.println("Cargando horarios desde CSV: " + rutaArchivo);
        
        List<HorarioDTO> horarios = new ArrayList<>();
        
        // Simular lectura de datos CSV
        horarios.add(new HorarioDTO("Lunes", "08:00", "10:00", 20, "Yoga"));
        horarios.add(new HorarioDTO("Martes", "14:00", "16:00", 15, "Spinning"));
        horarios.add(new HorarioDTO("Miércoles", "17:00", "19:00", 10, "Zumba"));
        
        return horarios;
    }
}