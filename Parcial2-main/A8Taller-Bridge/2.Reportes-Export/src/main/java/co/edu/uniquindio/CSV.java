package co.edu.uniquindio;

public class CSV implements Exportador {
    @Override
    public void exportarReporte(String reporte) {
        System.out.println("\nExportando a CSV:\n" + reporte);
    }
}
