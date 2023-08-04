package by.training.module1.entity;

import java.util.Optional;
import java.util.stream.Stream;

public enum Food {
    ROOMONLY, HALFBOARD, ALLINCLUSIVE;

    public static Optional<Food> fromString(String type) {

        return Stream.of(Food.values())
                .filter(t -> t.name().equalsIgnoreCase(type))
                .findFirst();
    }
}
