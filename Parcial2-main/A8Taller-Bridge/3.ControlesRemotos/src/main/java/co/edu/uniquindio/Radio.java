package co.edu.uniquindio;

public class Radio extends Dispositivo{
    public String nombre;

    public Radio(Controlar controlarDispositivo, String nombre){
        super(controlarDispositivo);
        this.nombre=nombre;
    }

    @Override
    public void controlador() {
        controlarDispositivo.controlarDispositivo(nombre);
    }
}
