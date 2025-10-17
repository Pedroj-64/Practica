package co.edu.uniquindio;

public class ApagarMotor implements IMotorAcciones{
    @Override
    public void accionarMotor(String marca, String tipoVehiculo) {
        System.out.println("Apagando motor del " + tipoVehiculo + " " + marca);
    }
}
