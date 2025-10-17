package co.edu.uniquindio;

public class PersonajeConArmadura extends PersonajeDecorator{
    public PersonajeConArmadura(CaracteristicasPersonaje personaje) {
        super(personaje);
    }

    @Override
    public void agregarCaracteristica(String caracteristica) {
        personaje.agregarCaracteristica(caracteristica);
        System.out.println("Ahora el personaje tiene una armadura re mela.");
    }
}
