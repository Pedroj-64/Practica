package co.edu.uniquindio.practice.preparcialgpt.model.adapter;

import co.edu.uniquindio.practice.preparcialgpt.model.dto.HorarioDTO;
import co.edu.uniquindio.practice.preparcialgpt.model.singleton.AppConfig;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Adaptador que lee horarios desde un archivo CSV
 * Adapter en el patrón Adapter
 */
public class CsvHorarioAdapter implements ProveedorHorarioPort {
    
    private final String rutaArchivo;
    private final List<String> errores;
    private List<HorarioDTO> horariosCache;
    private String resumen;
    
    public CsvHorarioAdapter(String rutaArchivo) {
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
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            int lineaNum = 0;
            int exitosas = 0;
            
            // Leer encabezado
            linea = br.readLine();
            lineaNum++;
            
            if (linea == null) {
                errores.add("El archivo CSV está vacío");
                resumen = "Carga fallida: archivo vacío";
                return horarios;
            }
            
            // Procesar datos
            while ((linea = br.readLine()) != null) {
                lineaNum++;
                
                try {
                    String[] campos = linea.split(",");
                    
                    if (campos.length < 6) {
                        errores.add("Línea " + lineaNum + ": faltan campos (se esperaban 6, se encontraron " + campos.length + ")");
                        continue;
                    }
                    
                    String idServicio = campos[0].trim();
                    String nombreServicio = campos[1].trim();
                    
                    LocalDateTime fechaHora;
                    try {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AppConfig.getInstance().getFormatoFechaHora());
                        fechaHora = LocalDateTime.parse(campos[2].trim(), formatter);
                    } catch (DateTimeParseException e) {
                        errores.add("Línea " + lineaNum + ": formato de fecha inválido: " + campos[2]);
                        continue;
                    }
                    
                    int capacidad;
                    try {
                        capacidad = Integer.parseInt(campos[3].trim());
                        if (capacidad <= 0) {
                            errores.add("Línea " + lineaNum + ": capacidad inválida (debe ser mayor que cero): " + capacidad);
                            continue;
                        }
                    } catch (NumberFormatException e) {
                        errores.add("Línea " + lineaNum + ": capacidad no es un número válido: " + campos[3]);
                        continue;
                    }
                    
                    String instructor = campos[4].trim();
                    
                    boolean activo;
                    try {
                        activo = Boolean.parseBoolean(campos[5].trim());
                    } catch (Exception e) {
                        errores.add("Línea " + lineaNum + ": estado no válido (debe ser true o false): " + campos[5]);
                        continue;
                    }
                    
                    HorarioDTO horario = new HorarioDTO(idServicio, nombreServicio, fechaHora, capacidad, instructor, activo);
                    horarios.add(horario);
                    exitosas++;
                    
                } catch (Exception e) {
                    errores.add("Línea " + lineaNum + ": error al procesar: " + e.getMessage());
                }
            }
            
            this.resumen = "Carga completada. " + exitosas + " horarios cargados. " + 
                          errores.size() + " errores encontrados.";
            
        } catch (IOException e) {
            errores.add("Error al leer el archivo: " + e.getMessage());
            this.resumen = "Error al leer el archivo CSV";
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