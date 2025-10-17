package co.edu.uniquindio;

public abstract class Vehiculo {
    protected String marca;
    protected String tipoVehiculo;
    protected IMotorAcciones motor;

    public Vehiculo(String marca, String tipoVehiculo, IMotorAcciones motor) {
        this.marca = marca;
        this.tipoVehiculo = tipoVehiculo;
        this.motor = motor;
    }

    public abstract void accionarVehiculo();
}
