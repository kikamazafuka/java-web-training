package by.training.module1.builder;

import by.training.module1.entity.Tour;

import java.util.Map;

public interface Builder {

    Tour build(Map<String, String> tourString);

}
