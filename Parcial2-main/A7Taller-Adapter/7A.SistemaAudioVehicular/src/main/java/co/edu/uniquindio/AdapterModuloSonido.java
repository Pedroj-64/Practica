package co.edu.uniquindio;

public class AdapterModuloSonido implements IMultimedia{
    private ModuloSonido moduloSonido;

    public AdapterModuloSonido(ModuloSonido moduloSonido){
        this.moduloSonido = moduloSonido;
    }


    @Override
    public void reproducirAudio(String pista) {
        System.out.println("Usando adaptador...");
        moduloSonido.playCD(pista);
    }
}
