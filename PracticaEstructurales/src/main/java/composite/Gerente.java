package composite;

import java.util.List;

public class Gerente implements  Empleado{

    private String nombre;
    private String apellido;
    private String departamento;
    private List<Empleado> empleados;


    public Gerente(String nombre, String apellido, String departamento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.departamento = departamento;
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }



    public void detalle(String prefijo) {
        System.out.println(prefijo + "Gerente: " + nombre + " " + apellido + ", Departamento: " + departamento);
    }
}
