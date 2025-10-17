package co.edu.uniquindio;

public class Auto extends Vehiculo {
    public Auto(String marca, IMotorAcciones motor) {
        super(marca, "Moto", motor);
    }

    @Override
    public void accionarVehiculo() {
        System.out.println("Accionando Auto...");
        motor.accionarMotor(marca, tipoVehiculo);
    }
}
