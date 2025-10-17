package co.edu.uniquindio;

public class Main {
    public static void main(String[] args) {
        Componente c1 = new Componente("Botón");
        Componente c2 = new Componente("Campo de Texto");
        Componente c3 = new Componente("Etiqueta");

        Panel p1 = new Panel("Panel Principal");
        Panel p2 = new Panel("Panel Secundario");

        p1.agregarComponente(c1);
        p1.agregarComponente(c2);
        p1.agregarComponente(p2);
        p2.agregarComponente(c3);

        p1.mostrar("");
    }
}