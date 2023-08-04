package by.training.module4.model;

public class Truck extends Vehicle {

    private int carryingCapacity;

    public Truck(int number, int weight, VehicleType vehicleType, String name, int carryingCapacity) {
        super(number, weight,  vehicleType, name);
        this.carryingCapacity = carryingCapacity;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "carryingCapacity=" + carryingCapacity +
                "} " + super.toString();
    }
}
