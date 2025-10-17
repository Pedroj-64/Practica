package co.edu.uniquindio;

public class Proyector extends Dispositivo{
    public String nombre;

    public Proyector(Controlar controlarDispositivo, String nombre){
        super(controlarDispositivo);
        this.nombre=nombre;
    }

    @Override
    public void controlador() {
        controlarDispositivo.controlarDispositivo(nombre);
    }
}
