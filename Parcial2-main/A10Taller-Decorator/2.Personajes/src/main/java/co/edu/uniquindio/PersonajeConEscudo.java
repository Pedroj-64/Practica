package co.edu.uniquindio;

public class PersonajeConEscudo extends PersonajeDecorator{
    public PersonajeConEscudo(CaracteristicasPersonaje caracteristicas) {
        super(caracteristicas);
    }

    @Override
    public void agregarCaracteristica(String caracteristica) {
        personaje.agregarCaracteristica(caracteristica);
        System.out.println("Ahora el personaje tiene un escudo.");
    }
}
