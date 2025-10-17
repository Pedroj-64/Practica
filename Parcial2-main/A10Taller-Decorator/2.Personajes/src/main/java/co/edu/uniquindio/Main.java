package co.edu.uniquindio;

public class Main {
    public static void main(String[] args) {

        // Personaje base
        CaracteristicasPersonaje personaje = new PersonajeBase();

        // Agregar decoradores
        personaje = new PersonajeConEspada(personaje);
        personaje = new PersonajeConEscudo(personaje);
        personaje = new PersonajeConArmadura(personaje);

        // Agregar a Personaje
        personaje.agregarCaracteristica("Reparte Puñal");
    }
}
