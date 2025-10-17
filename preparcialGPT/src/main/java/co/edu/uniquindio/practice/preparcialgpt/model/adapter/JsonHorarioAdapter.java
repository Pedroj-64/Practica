package co.edu.uniquindio.practice.preparcialgpt.model.adapter;

import co.edu.uniquindio.practice.preparcialgpt.model.dto.HorarioDTO;
import co.edu.uniquindio.practice.preparcialgpt.model.singleton.AppConfig;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Adaptador que lee horarios desde un archivo JSON
 * Adapter en el patrón Adapter
 */
public class JsonHorarioAdapter implements ProveedorHorarioPort {
    
    private final String rutaArchivo;
    private final List<String> errores;
    private List<HorarioDTO> horariosCache;
    private String resumen;
    
    public JsonHorarioAdapter(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        this.errores = new ArrayList<>();
        this.resumen = "";
    }

    @Override
    public List<HorarioDTO> cargarHorarios() {
        if (horariosCache != null) {
            return new ArrayList<>(horariosCache);
        }
        
        List<HorarioDTO> horarios = new ArrayList<>();
        errores.clear();
        
        try (FileReader reader = new FileReader(rutaArchivo)) {
            // Nota: En un proyecto real, usaríamos una biblioteca JSON como Jackson o Gson
            // Por simplicidad, aquí solo simulamos la carga de JSON
            // En una implementación real, sería algo como:
            // ObjectMapper mapper = new ObjectMapper();
            // JsonNode rootNode = mapper.readTree(reader);
            
            // Simulación de carga de datos para el propósito de este ejercicio
            horarios.add(new HorarioDTO("S001", "Yoga", 
                        LocalDateTime.now().plusDays(1).withHour(10).withMinute(0),
                        15, "Juan Pérez", true));
            
            horarios.add(new HorarioDTO("S002", "Spinning", 
                        LocalDateTime.now().plusDays(1).withHour(14).withMinute(30),
                        20, "María Gómez", true));
            
            horarios.add(new HorarioDTO("S003", "Pilates", 
                        LocalDateTime.now().plusDays(2).withHour(16).withMinute(0),
                        12, "Carlos Rodríguez", true));
            
            this.resumen = "Carga simulada completada. " + horarios.size() + " horarios cargados. " + 
                          errores.size() + " errores encontrados.";
            
        } catch (IOException e) {
            errores.add("Error al leer el archivo: " + e.getMessage());
            this.resumen = "Error al leer el archivo JSON";
        }
        
        this.horariosCache = new ArrayList<>(horarios);
        return horarios;
    }

    @Override
    public boolean verificarDisponibilidad(String idServicio, String fechaStr) {
        if (horariosCache == null) {
            cargarHorarios();
        }
        
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AppConfig.getInstance().getFormatoFechaHora());
            LocalDateTime fecha = LocalDateTime.parse(fechaStr, formatter);
            
            for (HorarioDTO horario : horariosCache) {
                if (horario.getIdServicio().equals(idServicio) && 
                    horario.getFechaHora().equals(fecha) &&
                    horario.isActivo() && 
                    horario.getCapacidad() > 0) {
                    return true;
                }
            }
        } catch (DateTimeParseException e) {
            errores.add("Formato de fecha inválido: " + fechaStr);
        }
        
        return false;
    }

    @Override
    public List<String> getErrores() {
        return new ArrayList<>(errores);
    }

    @Override
    public String getResumenCarga() {
        return resumen;
    }
}