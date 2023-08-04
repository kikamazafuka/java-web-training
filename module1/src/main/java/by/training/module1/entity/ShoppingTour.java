package by.training.module1.entity;

import java.util.Objects;

public class ShoppingTour extends Tour{

    private String destanation;



    //public ShoppingTour(String destanation) {
      //  this.destanation = destanation;
    //}


    public ShoppingTour(TourType tourType, int tourDuration, Transport transport, Food foodType, int price, String destanation) {
        super(tourType, tourDuration, transport, foodType, price);
        this.destanation = destanation;
    }



    public String getDestanation() {
        return destanation;
    }

    public void setDestanation(String destanation) {
        this.destanation = destanation;
    }

    @Override
    public String toString() {
        return "ShoppingTour{" +
                "destanation='" + destanation + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingTour that = (ShoppingTour) o;
        return Objects.equals(destanation, that.destanation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destanation);
    }
}
