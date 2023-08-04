package by.training.module4.builder;

import by.training.module4.model.Ferry2;

import java.util.Map;

public class FerryBuilder {


    public Ferry2 buildFerry(Map<String, String> validateMap) {
        int maxLoad = Integer.parseInt(validateMap.get("maxLoad"));
        return new Ferry2(maxLoad);
    }
}
