package co.edu.uniquindio.practice.preparcial.model;

import co.edu.uniquindio.practice.preparcial.interfaces.ProveedorHorarioPort;
import java.util.ArrayList;
import java.util.List;

public class JsonHorarioAdapter implements ProveedorHorarioPort {
    
    private String rutaArchivo;
    
    public JsonHorarioAdapter(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }
    
    @Override
    public List<HorarioDTO> cargarHorarios() {
       
        System.out.println("Cargando horarios desde JSON: " + rutaArchivo);
        
        List<HorarioDTO> horarios = new ArrayList<>();
        
        
        return horarios;
    }
}