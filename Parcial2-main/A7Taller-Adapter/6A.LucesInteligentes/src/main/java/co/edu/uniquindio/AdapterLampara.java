package co.edu.uniquindio;

public class AdapterLampara implements IDomotica{
    private LamparaTradicional lampara;

    public AdapterLampara(LamparaTradicional lampara){
        this.lampara = lampara;
    }

    @Override
    public void encenderDispositivo(String nombre) {
        System.out.println("Usando Adaptador...");
        lampara.activarInterruptor(nombre);
    }
}
