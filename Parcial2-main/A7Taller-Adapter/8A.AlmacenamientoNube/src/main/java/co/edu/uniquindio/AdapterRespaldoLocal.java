package co.edu.uniquindio;

public class AdapterRespaldoLocal implements IRespaldo{
    private RespaldoLocal respaldoLocal;

    public AdapterRespaldoLocal(RespaldoLocal respaldoLocal){
        this.respaldoLocal = respaldoLocal;
    }

    @Override
    public void subirArchivo(String archivo) {
        System.out.println("Usando Adaptador...");
        respaldoLocal.guardarEnDisco(archivo);
    }
}
