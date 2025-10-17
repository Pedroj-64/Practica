package co.edu.uniquindio;

public class PersonajeDecorator implements CaracteristicasPersonaje {
    protected CaracteristicasPersonaje personaje;

    public PersonajeDecorator(CaracteristicasPersonaje personaje) {
        this.personaje = personaje;
    }

    @Override
    public void agregarCaracteristica(String caracteristica) {
        personaje.agregarCaracteristica(caracteristica);
    }
}
