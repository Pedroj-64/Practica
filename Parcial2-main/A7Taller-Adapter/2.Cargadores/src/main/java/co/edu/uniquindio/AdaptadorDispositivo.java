package co.edu.uniquindio;

public class AdaptadorDispositivo implements DispositivoNuevo {
    private DispositivoViejo dispositivoViejo;

    public AdaptadorDispositivo(DispositivoViejo dispositivo) {
        this.dispositivoViejo = dispositivo;
    }

    @Override
    public void cargarUSB(String dispositivo) {
        dispositivoViejo.cargarConCableRedondo("Adaptador en: " + dispositivo);
    }
}
