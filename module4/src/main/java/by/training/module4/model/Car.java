package by.training.module4.model;

public class Car extends Vehicle {

    private int seatNumber;


    public Car(int number, int weight, VehicleType vehicleType, String name, int seatNumber) {
        super(number, weight, vehicleType, name);
        this.seatNumber = seatNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "seatNumber=" + seatNumber +
                "} " + super.toString();
    }
}
