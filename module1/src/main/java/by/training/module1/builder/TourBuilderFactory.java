package by.training.module1.builder;

import by.training.module1.entity.TourType;

public class TourBuilderFactory {

    public Builder createTour(TourType typeOfTour){
        switch (typeOfTour){
            case EXCURSION: return new ExcursionTourBuilder();
            case SHOPPING: return new ShoppingTourBuilder();
            case CRUISE: return new CruiseTourBuilder();

            default: throw new IllegalArgumentException();

        }
    }

}

