package co.edu.uniquindio;

public class Trabajador implements Empleado {
    public String nombre;

    public Trabajador(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void mostrarEmpleado(String prefijo) {
        System.out.println(prefijo + "👷 " + nombre);
    }
}
