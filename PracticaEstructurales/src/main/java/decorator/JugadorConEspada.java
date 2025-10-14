package decorator;

public class JugadorConEspada extends JugadorDecorator {

    public JugadorConEspada(IJugador jugador) {
        super(jugador);
    }

    @Override
    public void detellesEquipo() {
        super.detellesEquipo();
        System.out.println("Con espada");
    }
}
