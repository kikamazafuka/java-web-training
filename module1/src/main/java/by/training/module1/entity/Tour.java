package by.training.module1.entity;

import java.util.Objects;

public class Tour {

    private int tourDuration;
    private Transport transport;
    private Food foodType;
    private int price;
    private TourType tourType;


    public Tour(TourType tourType, int tourDuration, Transport transport, Food foodType, int price) {
        this.tourDuration = tourDuration;
        this.transport = transport;
        this.foodType = foodType;
        this.price = price;
        this.tourType = tourType;
    }



    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



    public int getTourDuration() {
        return tourDuration;
    }

    public void setTourDuration(int tourDuration) {
        this.tourDuration = tourDuration;
    }


    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }


    public Food getFoodType() {
        return foodType;
    }

    public void setFoodType(Food foodType) {
        this.foodType = foodType;
    }

    public TourType getTourType() {
        return tourType;
    }

    public void setTourType(TourType tourType) {
        this.tourType = tourType;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "tourDuration=" + tourDuration +
                ", transport=" + transport +
                ", foodType=" + foodType +
                ", price=" + price +
                ", tourType=" + tourType +
                '}';
    }

}
