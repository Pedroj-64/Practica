package co.edu.uniquindio;

public class PersonajeBase implements CaracteristicasPersonaje {

    @Override
    public void agregarCaracteristica(String caracteristica) {
        System.out.println("Agregando caracteristicas al Personaje: " + caracteristica);
    }
}
