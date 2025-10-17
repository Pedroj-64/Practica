package co.edu.uniquindio.practice.preparcial.interfaces;

import java.util.List;

public interface ServiceEspecialiced {

    public List<String> OrdenarPorNombreAlfabeticamente(List<String> lista);
    public List<String> OrdenarPorPrecioMayorAMenor(List<String> lista);
    public ServiceComponent buscarServicioPorNombre(String nombre, List<ServiceComponent> lista);

}
