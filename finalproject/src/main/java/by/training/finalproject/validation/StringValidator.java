package by.training.finalproject.validation;

public class StringValidator {

    public static boolean validate(String value) {
        return !(value == null || value.isEmpty());
    }
}

