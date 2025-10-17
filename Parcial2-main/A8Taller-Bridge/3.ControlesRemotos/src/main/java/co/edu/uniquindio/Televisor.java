package co.edu.uniquindio;

public class Televisor extends Dispositivo{
    String nombre;

    public Televisor(Controlar controlarDispositivo,String nombre){
        super(controlarDispositivo);
        this.nombre=nombre;
    }

    @Override
    public void controlador() {
       controlarDispositivo.controlarDispositivo(nombre);
    }
}
