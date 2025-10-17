package co.edu.uniquindio;

/** Patrón Singleton: solo puede existir una instancia de Configuracion */
public class Configuracion {
    private static Configuracion instancia;
    private String nombreSistema;

    private Configuracion(String nombreSistema) {
        this.nombreSistema = nombreSistema;
    }

    public static Configuracion getInstancia() {
        if (instancia == null) {
            instancia = new Configuracion("Sistema UQ");
            System.out.println("✅ Configuración creada por primera vez.");
        }
        return instancia;
    }

    public void mostrar() {
        System.out.println("Configuración activa: " + nombreSistema);
    }
}
