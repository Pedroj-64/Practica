package co.edu.uniquindio;

public class PersonajeConEspada extends PersonajeDecorator{
    public PersonajeConEspada(CaracteristicasPersonaje personaje) {
        super(personaje);
    }

    @Override
    public void agregarCaracteristica(String caracteristica) {
        personaje.agregarCaracteristica(caracteristica);
        System.out.println("Ahora el personaje tiene una espada.");
    }
}
