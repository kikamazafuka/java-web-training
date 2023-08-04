package by.training.module4.builder;

import by.training.module4.model.Truck;
import by.training.module4.model.Vehicle;
import by.training.module4.model.VehicleType;

import java.util.Map;

public class TruckBuilder implements VehicleBuilder {
    @Override
    public Vehicle build(Map<String, String> vehicleData) {
        int number = Integer.parseInt(vehicleData.get("number"));
        String name = vehicleData.get("name");
        int weight = Integer.parseInt(vehicleData.get("weight"));
        int carryingCapacity = Integer.parseInt(vehicleData.get("carryingCapacity"));
        VehicleType vehicleType = VehicleType.TRUCK;
        return new Truck(number, weight,vehicleType,name,carryingCapacity);
    }
}
