package co.edu.uniquindio;

/**
 * Clase que representa un plato disponible en el menú.
 * Cada plato tiene nombre, tipo (entrada, principal, postre...) y precio.
 */
class Plato {
    private String nombre;
    private String tipo;
    private double precio;

    public Plato(String nombre, String tipo, double precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ") - $" + precio;
    }
}
