package by.training.module1.entity;


import java.util.Optional;
import java.util.stream.Stream;

public enum TourType {
    CRUISE, SHOPPING, EXCURSION;

    public static Optional<TourType> fromString(String type) {
        return Stream.of(TourType.values()).filter(t -> t.name().equalsIgnoreCase(type)).findFirst();
    }



}
