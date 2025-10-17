package co.edu.uniquindio;

import java.util.ArrayList;
import java.util.List;

public class Gerente implements Empleado{
    private String nombre;
    private List<Empleado> empleados = new ArrayList<Empleado>();
    public Gerente(String nombre) {
        this.nombre = nombre;
    }

    public void agregarEmpleado(Empleado empleado){
        empleados.add(empleado);
    }

    public void eliminarEmpleado(Empleado empleado){
        empleados.remove(empleado);
    }

    @Override
    public void mostrarEmpleado(String prefijo) {
        System.out.println(prefijo + "👔 " + nombre);
        for (Empleado empleado : empleados) {
            empleado.mostrarEmpleado(prefijo + "    ");
        }
    }
}
