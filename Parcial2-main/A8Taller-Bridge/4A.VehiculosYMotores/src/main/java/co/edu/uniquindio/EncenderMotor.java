package co.edu.uniquindio;

public class EncenderMotor implements IMotorAcciones {

    @Override
    public void accionarMotor(String marca, String tipoVehiculo) {
        System.out.println("Encendiendo motor del " + tipoVehiculo + " " + marca);
    }
}
