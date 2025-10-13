package modelReproductor;

public class ReproductorModernoAdapter implements IReproductor {

    ReproductorModerno reproductorModerno;

    public ReproductorModernoAdapter(ReproductorModerno reproductorModerno) {
        this.reproductorModerno = reproductorModerno;
    }

    @Override
    public void reproducir(String cancion) {
        reproductorModerno.reproducirMusica(cancion);
    }
}
