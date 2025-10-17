package co.edu.uniquindio;

/**
 * Subsistema 2: Clientes
 * Maneja los clientes registrados del restaurante.
 */
class Cliente {
    private String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre; }

    public String getNombre() {
        return nombre; }

    @Override
    public String toString() {
        return "Cliente: " + nombre;
    }
}
