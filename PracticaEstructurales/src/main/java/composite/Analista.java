package composite;

public class Analista implements  Empleado{

    private String nombre;
    private String apellido;
    private String puesto;

    public Analista(String nombre, String apellido, String puesto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.puesto = puesto;
    }

    @Override
    public void detalle(String prefijo) {
        System.out.println(prefijo + "Analista: " + nombre + " " + apellido + ", Puesto: " + puesto);
    }
}
