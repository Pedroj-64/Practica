package co.edu.uniquindio;

public class PDF implements Exportador {
    @Override
    public void exportarReporte(String reporte) {
        System.out.println("Exportando a PDF:\n" + reporte);
    }
}
