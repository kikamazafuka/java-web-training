package by.training.module1.entity;



public class TourFactory {

    public Tour createTour(TourType typeOfTour){
        switch (typeOfTour){
         /*   case EXCURSION: return new ExcursionTour();
            case SHOPPING: return new ShoppingTour();
            case CRUISE: return new CruiseTour();*/

            default: throw new IllegalArgumentException();

        }
    }

}



