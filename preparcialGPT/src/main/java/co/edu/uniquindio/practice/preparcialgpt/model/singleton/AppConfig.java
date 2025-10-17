package co.edu.uniquindio.practice.preparcialgpt.model.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase de configuración global de la aplicación
 * Implementa el patrón Singleton
 */
public class AppConfig {
    
    // Instancia única de la clase
    private static AppConfig instance;
    
    // Configuraciones de la aplicación
    private Map<String, String> configuraciones;
    
    /**
     * Constructor privado para evitar instanciación externa
     */
    private AppConfig() {
        configuraciones = new HashMap<>();
        cargarConfiguracionesDefecto();
    }
    
    /**
     * Obtiene la instancia única de la configuración
     * @return Instancia de AppConfig
     */
    public static synchronized AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }
    
    /**
     * Carga las configuraciones por defecto
     */
    private void cargarConfiguracionesDefecto() {
        // Rutas de archivos
        configuraciones.put("ruta_csv_horarios", "data/horarios.csv");
        configuraciones.put("ruta_json_horarios", "data/horarios.json");
        
        // Formatos
        configuraciones.put("formato_fecha_hora", "yyyy-MM-dd HH:mm");
        configuraciones.put("formato_moneda", "#,##0.00");
        
        // Valores por defecto
        configuraciones.put("pasarela_defecto", "PasarelaDummy");
        configuraciones.put("iva", "0.19");
        configuraciones.put("max_sesiones_cliente", "3");
    }
    
    /**
     * Establece una configuración
     * @param clave Clave de la configuración
     * @param valor Valor de la configuración
     */
    public void setConfiguracion(String clave, String valor) {
        configuraciones.put(clave, valor);
    }
    
    /**
     * Obtiene una configuración
     * @param clave Clave de la configuración
     * @return Valor de la configuración o null si no existe
     */
    public String getConfiguracion(String clave) {
        return configuraciones.get(clave);
    }
    
    /**
     * Obtiene una configuración con un valor por defecto
     * @param clave Clave de la configuración
     * @param valorDefecto Valor por defecto si la clave no existe
     * @return Valor de la configuración o el valor por defecto
     */
    public String getConfiguracion(String clave, String valorDefecto) {
        return configuraciones.getOrDefault(clave, valorDefecto);
    }
    
    /**
     * Obtiene el formato de fecha y hora
     * @return Formato de fecha y hora
     */
    public String getFormatoFechaHora() {
        return configuraciones.getOrDefault("formato_fecha_hora", "yyyy-MM-dd HH:mm");
    }
    
    /**
     * Obtiene la ruta del archivo CSV de horarios
     * @return Ruta del archivo
     */
    public String getRutaCsvHorarios() {
        return configuraciones.getOrDefault("ruta_csv_horarios", "data/horarios.csv");
    }
    
    /**
     * Obtiene la ruta del archivo JSON de horarios
     * @return Ruta del archivo
     */
    public String getRutaJsonHorarios() {
        return configuraciones.getOrDefault("ruta_json_horarios", "data/horarios.json");
    }
    
    /**
     * Obtiene la pasarela de pago por defecto
     * @return Nombre de la pasarela por defecto
     */
    public String getPasarelaDefecto() {
        return configuraciones.getOrDefault("pasarela_defecto", "PasarelaDummy");
    }
    
    /**
     * Obtiene el valor del IVA
     * @return Valor del IVA como double
     */
    public double getIva() {
        try {
            return Double.parseDouble(configuraciones.getOrDefault("iva", "0.19"));
        } catch (NumberFormatException e) {
            return 0.19;
        }
    }
}