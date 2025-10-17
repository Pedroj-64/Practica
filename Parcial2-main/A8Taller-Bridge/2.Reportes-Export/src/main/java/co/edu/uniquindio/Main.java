package co.edu.uniquindio;

public class Main {
    public static void main(String[] args) {

        Exportador PDF = new PDF();
        Exportador Excel = new Excel();
        Exportador CSV = new CSV();


        InventarioReporte Reporte1 = new InventarioReporte(PDF, "Inventario de Empresa");
        ClientesReporte Reporte2 = new ClientesReporte(CSV, "Clientes de Bogotá");
        VentaReporte Reporte3 = new VentaReporte(Excel, "Ventas Enero");

        Reporte1.generarReporte();
        Reporte2.generarReporte();
        Reporte3.generarReporte();
    }
}