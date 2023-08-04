package by.training.module1.entity;

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

