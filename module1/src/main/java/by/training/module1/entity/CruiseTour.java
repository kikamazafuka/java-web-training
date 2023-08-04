package by.training.module1.entity;

import java.util.Objects;

public class CruiseTour extends Tour{

    private BoatType boatType;


    public CruiseTour(TourType tourType, int tourDuration, Transport transport, Food foodType, int price,  BoatType boatType) {
        super(tourType, tourDuration, transport, foodType, price );
        this.boatType = boatType;
    }

    public BoatType getBoatType() {
        return boatType;
    }

    public void setBoatType(BoatType boatType) {
        this.boatType = boatType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CruiseTour that = (CruiseTour) o;
        return boatType == that.boatType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(boatType);
    }

    @Override
    public String toString() {
        return "CruiseTour{" +
                "boatType=" + boatType +
                "} " + super.toString();
    }
}
