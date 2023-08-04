package by.training.module4.builder;

import by.training.module4.model.Vehicle;

import java.util.Map;

public interface VehicleBuilder {
    Vehicle build(Map<String, String> vehicleData);
}
