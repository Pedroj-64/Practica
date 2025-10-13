package modelReproductor;

public class ReproductorAdapter implements IReproductor{

    private ReproductorAntiguo reproductorAntiguo;

    public ReproductorAdapter(ReproductorAntiguo reproductorAntiguo) {
        this.reproductorAntiguo = reproductorAntiguo;
    }

    @Override
    public void reproducir(String cancion) {
        reproductorAntiguo.reproducirMP3(cancion);
    }



}
