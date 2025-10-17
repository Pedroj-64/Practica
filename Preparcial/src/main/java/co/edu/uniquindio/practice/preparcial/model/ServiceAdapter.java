package co.edu.uniquindio.practice.preparcial.model;

import co.edu.uniquindio.practice.preparcial.interfaces.ServiceComponent;
import co.edu.uniquindio.practice.preparcial.interfaces.ServiceEspecialiced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Implementación del patrón Adapter para adaptar operaciones complejas de servicios
 * Esta clase implementa ServiceEspecialiced y realiza operaciones especializadas
 * sobre colecciones de ServiceComponent
 */
public class ServiceAdapter implements ServiceEspecialiced {
    
    @Override
    public List<String> OrdenarPorNombreAlfabeticamente(List<String> lista) {
        if (lista == null || lista.isEmpty()) {
            return new ArrayList<>();
        }
        
        // Crear una copia para no modificar la original
        List<String> resultado = new ArrayList<>(lista);
        Collections.sort(resultado);
        return resultado;
    }

    @Override
    public List<String> OrdenarPorPrecioMayorAMenor(List<String> lista) {
        // En una implementación real, los strings probablemente contendrían información de precios
        // Aquí simulamos que extraemos el precio de cada string y ordenamos
        if (lista == null || lista.isEmpty()) {
            return new ArrayList<>();
        }
        
        List<String> resultado = new ArrayList<>(lista);
        // Ordenar suponiendo que los strings tienen formato "nombre:precio"
        Collections.sort(resultado, (s1, s2) -> {
            try {
                int precio1 = extraerPrecio(s1);
                int precio2 = extraerPrecio(s2);
                return Integer.compare(precio2, precio1); // Mayor a menor
            } catch (Exception e) {
                return 0; // En caso de error, mantener orden
            }
        });
        
        return resultado;
    }

    @Override
    public ServiceComponent buscarServicioPorNombre(String nombre, List<ServiceComponent> lista) {
        if (nombre == null || lista == null) {
            return null;
        }
        
        for (ServiceComponent servicio : lista) {
            if (nombre.equalsIgnoreCase(servicio.getNombre())) {
                return servicio;
            }
        }
        
        return null;
    }
    
    // Método auxiliar para extraer precio de un string con formato "nombre:precio"
    private int extraerPrecio(String str) {
        try {
            if (str.contains(":")) {
                String precioStr = str.split(":")[1].trim();
                return Integer.parseInt(precioStr);
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }
}