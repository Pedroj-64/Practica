package co.edu.uniquindio;

public class Main {
    public static void main(String[] args) {
        // Implementaciones del motor
        IMotorAcciones encender = new EncenderMotor();
        IMotorAcciones apagar = new ApagarMotor();
        IMotorAcciones acelerar = new AcelerarMotor();

        // Vehículos que usan diferentes motores (puente)
        Vehiculo camion = new Camion("Chevrolet", acelerar);
        Vehiculo moto = new Moto("Yamaha", apagar);

        // Accionando los vehículos
        camion.accionarVehiculo();
        moto.accionarVehiculo();
    }

}