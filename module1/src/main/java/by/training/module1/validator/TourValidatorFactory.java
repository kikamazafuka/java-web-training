package by.training.module1.validator;

import by.training.module1.entity.TourType;

import java.util.Map;
import java.util.Optional;

public class TourValidatorFactory {
    public TourValidator getByType(TourType type){
        switch(type){
            case EXCURSION: return new ExcursionTourValidator();
            case CRUISE: return new CruiseTourValidator();
            case SHOPPING: return new ShoppingTourValidator();
            default: throw new IllegalArgumentException();
        }
    }
    public TourType getTourType(Map<String,String> data) {
        String typeStr = data.get(TourValidator.TOUR_TYPE_KEY);
        Optional<TourType> type = TourType.fromString(typeStr);
        return type.get();
    }
}
