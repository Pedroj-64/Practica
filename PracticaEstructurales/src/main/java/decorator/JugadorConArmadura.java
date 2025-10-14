package decorator;

public class JugadorConArmadura extends JugadorDecorator {

    public JugadorConArmadura(IJugador jugador) {
        super(jugador);
    }

    @Override
    public void detellesEquipo() {
        super.detellesEquipo();
        System.out.println("Con Armadura");
    }
}
