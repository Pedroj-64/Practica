package co.edu.uniquindio;

public class Main {
    public static void main(String[] args) {

        Plato plato1 = new Plato("Pizza");
        Plato plato2 = new Plato("Burrito");
        Menu menu1 = new Menu("COMIDA SARBOSA");
        Menu submenu1 = new Menu("BEBIDAS");
        Plato plato3 = new Plato("Coca-Cola");
        Plato plato4 = new Plato("Limonada");

        menu1.agregar(plato1);
        menu1.agregar(plato2);
        menu1.agregar(submenu1);
        submenu1.agregar(plato3);
        submenu1.agregar(plato4);


        menu1.mostrar();
    }
}