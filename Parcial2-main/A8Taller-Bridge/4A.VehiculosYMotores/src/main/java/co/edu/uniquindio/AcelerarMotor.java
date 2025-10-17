package co.edu.uniquindio;

public class AcelerarMotor implements IMotorAcciones{
    @Override
    public void accionarMotor(String marca, String tipoVehiculo) {
        System.out.println("Acelerando motor del " + tipoVehiculo + " " + marca);
    }

}
