package by.training.module4.model;

import java.util.Optional;
import java.util.stream.Stream;

public enum VehicleType {
    CAR, TRUCK;

    public static Optional<VehicleType> fromString(String type) {
        return Stream.of(VehicleType.values()).filter(t -> t.name().equalsIgnoreCase(type)).findFirst();
    }
}
