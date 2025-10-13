import modelBridge.*;
import modelReproductor.*;

public class App {


    public static void main(String[] args) {
        System.out.println("Hello, World!");
        reproducirMusica();
        reporteVentas.generarReporte("Reporte_Ventas.csv");
        reporteInventario.generarReporte("Reporte_Inventario.xlsx");
    }


    //IMPLEMENTACION DE ADAPTER
    static ReproductorAntiguo reproductorAntiguo= new ReproductorAntiguo();
    static IReproductor reproductorAdapter= new ReproductorAdapter(reproductorAntiguo);
    static ReproductorModerno reproductorModernoReal= new ReproductorModerno();
    static IReproductor reproductorModerno = new ReproductorModernoAdapter(reproductorModernoReal);

   public static void reproducirMusica(){
       reproductorAdapter.reproducir("Starway to heaven");
       reproductorModerno.reproducir("Imagine");
   }

   //IMPLEMENTACION DE BRIDGE

    static IFormato csv = new CSV();
    static IFormato excel = new Excel();
    static IFormato pdf = new PDF();

    static Reporte reporteVentas= new Ventas(csv);
    static Reporte reporteInventario= new Inventario(excel);



}
