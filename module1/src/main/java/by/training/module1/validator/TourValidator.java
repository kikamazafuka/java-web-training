package by.training.module1.validator;

import java.util.Map;

public class TourValidator {


    public static final String TOUR_TYPE_KEY = "tourType";
    public static final String TOUR_DURATION_KEY = "duration";
    private static final String TRANSPORT_KEY = "transport";
    private static final String PRICE_KEY = "price";
    private static final String FOOD_KEY = "food";



    public static ValidationResult validateTourType(Map<String,String> info) {
        ValidationResult result = new ValidationResult();
        String type = info.get(TOUR_TYPE_KEY);
        if (type == null) {
            result.addErrorMsg(TOUR_TYPE_KEY, "Type error");

        }
        return result;
     }


    public ValidationResult validate(Map<String,String> info){
        ValidationResult result = new ValidationResult();

        String duration = info.get(TOUR_DURATION_KEY);
        if (duration == null){
            result.addErrorMsg(TOUR_DURATION_KEY, "Duration error");
        } else {
            int durationInt;
            durationInt = Integer.parseInt(duration);
                if (durationInt < 0) {
                    result.addErrorMsg(TOUR_DURATION_KEY, "Tour duration is less than 0");
                }
        }

        String transport = info.get(TRANSPORT_KEY);
        if (transport == null){
            result.addErrorMsg(TRANSPORT_KEY, "Transport error");
        } else {


            }


        String price = info.get(PRICE_KEY);
        if (price == null){
            result.addErrorMsg(PRICE_KEY, "Price error");
        } else {
            int priceInt = Integer.parseInt(price);
            if (priceInt < 0) {
                result.addErrorMsg(PRICE_KEY, "Tour duration is less than 0");
            }
        }


        String food = info.get(FOOD_KEY);
        if (food == null) {
            result.addErrorMsg(FOOD_KEY, "Type error");

        }

        return result;
    }
}
