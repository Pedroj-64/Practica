package co.edu.uniquindio;

public class Moto extends Vehiculo {
    public Moto(String marca, IMotorAcciones motor) {
        super(marca, "Moto", motor);
    }

    @Override
    public void accionarVehiculo() {
        System.out.println("\nAccionando moto...");
        motor.accionarMotor(marca, tipoVehiculo);
    }
}
