package composite;

public class Desarrollador implements Empleado {

    private String nombre;
    private String apellido;
    private String puesto;

    public Desarrollador(String nombre, String apellido, String puesto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.puesto = puesto;
    }

    @Override
    public void detalle(String prefijo) {
        System.out.println(prefijo + "Desarrollador: " + nombre + " " + apellido + ", Puesto: " + puesto);
    }

}
