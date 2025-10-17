package co.edu.uniquindio;

public class ReproductorAdaptador implements ReproductorNuevo {
    private ReproductorViejo reproductorViejo;

    public ReproductorAdaptador(ReproductorViejo reproductorViejo) {
        this.reproductorViejo = reproductorViejo;
    }

    @Override
    public void reproducir(String archivo) {
        reproductorViejo.playMp3(archivo);
    }
}
