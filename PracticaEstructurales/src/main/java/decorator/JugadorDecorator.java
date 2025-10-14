package decorator;

public class JugadorDecorator implements IJugador {

    protected IJugador jugador;

    public JugadorDecorator(IJugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public void detellesEquipo() {
        jugador.detellesEquipo();
    }
}
