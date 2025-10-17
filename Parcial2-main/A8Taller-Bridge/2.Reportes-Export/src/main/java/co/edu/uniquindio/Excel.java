package co.edu.uniquindio;

public class Excel implements Exportador {
    @Override
    public void exportarReporte(String reporte) {
            System.out.println("\nExportando a Excel:\n" + reporte);
    }
}
