package co.edu.uniquindio;

public class Main {
    public static void main(String[] args) {

        Gerente g1 = new Gerente("Gerente Pepito");
        Gerente g2 = new Gerente("Gerente Lucas");
        Gerente g3 = new Gerente("Gerente Santiago");
        Trabajador t1 = new Trabajador("Trabajador Peter");
        Trabajador t2 = new Trabajador("Trabajador Jose");
        Trabajador t3 = new Trabajador("Trabajador Roberto");
        Trabajador t4 = new Trabajador("Trabajador Luisa");


        g1.agregarEmpleado(t1);
        g1.agregarEmpleado(t2);
        g1.agregarEmpleado(g2);
        g2.agregarEmpleado(t4);
        g2.agregarEmpleado(g3);
        g3.agregarEmpleado(t3);


        g1.mostrarEmpleado("");
    }
}