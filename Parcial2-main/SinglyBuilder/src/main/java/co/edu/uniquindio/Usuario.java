package co.edu.uniquindio;

/** Patrón Builder: permite crear usuarios paso a paso */
public class Usuario {
    private String nombre;
    private String rol;

    private Usuario(Builder builder) {
        this.nombre = builder.nombre;
        this.rol = builder.rol;
    }

    public void mostrar() {
        System.out.println("👤 " + nombre + " - Rol: " + rol);
    }

    /** Builder interno */
    public static class Builder {
        private String nombre;
        private String rol;

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setRol(String rol) {
            this.rol = rol;
            return this;
        }

        public Usuario build() {
            return new Usuario(this);
        }
    }
}
