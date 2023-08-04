package by.training.module1.entity;

import java.util.Objects;

public class ExcursionTour extends Tour {


    private boolean freeExcursion;
    private ExcursionType excursionType;



    public ExcursionTour(TourType tourType, int tourDuration,
                         Transport transport,
                         Food foodType,
                         boolean freeExcursion,
                         ExcursionType excursionType,
                         int tourPrice) {
        super(tourType, tourDuration, transport, foodType, tourPrice);
        this.freeExcursion = freeExcursion;
        this.excursionType = excursionType;
    }




    public boolean isFreeExcursion() {
        return freeExcursion;
    }

    public void setFreeExcursion(boolean freeExcursion) {
        this.freeExcursion = freeExcursion;
    }

    public ExcursionType getExcursionType() {
        return excursionType;
    }

    public void setExcursionType(ExcursionType excursionType) {
        this.excursionType = excursionType;
    }

    @Override
    public String toString() {
        return "ExcursionTour{" +
                "freeExcursion= " + freeExcursion +
                ", duration: " + super.getTourDuration() +
                ", transport= " + super.getTransport() +
                ", foodType= " + super.getFoodType() +
                ", price= " + super.getPrice() +
                ", excursionType= " + excursionType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExcursionTour tour = (ExcursionTour) o;
        return freeExcursion == tour.freeExcursion &&
                excursionType == tour.excursionType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(freeExcursion, excursionType);
    }
}
