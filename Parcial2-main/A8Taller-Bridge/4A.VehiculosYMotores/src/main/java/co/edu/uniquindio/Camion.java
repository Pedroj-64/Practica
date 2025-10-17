package co.edu.uniquindio;

public class Camion extends Vehiculo{

    public Camion(String marca, IMotorAcciones motor) {
        super(marca, "Camión", motor);
    }

    @Override
    public void accionarVehiculo() {
        System.out.println("Accionando vehículo pesado...");
        motor.accionarMotor(marca, tipoVehiculo);
    }
}
