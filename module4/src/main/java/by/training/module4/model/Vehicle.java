package by.training.module4.model;

import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class Vehicle extends Thread {

    private static final Logger LOGGER = Logger.getLogger(Vehicle.class);
    private int number;
    private String name;
    private int weight;
    private VehicleType vehicleType;
    private int vehicleState = 0;
    private Ferry2 ferry;

    public Vehicle(int number, int weight, VehicleType vehicleType, String name) {
        this.number = number;
        this.weight = weight;
        this.vehicleType = vehicleType;
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    public void waitForDepart() {
        this.vehicleState = 1;
    }

    public void depart() {
        this.vehicleState = 2;
    }

    public void setFerry(Ferry2 ferry) {
        this.ferry = ferry;
    }

    @Override
    public void run() {
        LOGGER.info("car Run begin.." + " Vehicle state: " + vehicleState);

        while (vehicleState != 2) {
            boolean load = ferry.tryLoad(this);
            try {
                TimeUnit.SECONDS.sleep(5);
                if (!load) {
                    TimeUnit.SECONDS.sleep(5);
                }
            } catch (InterruptedException e) {
                throw new IllegalStateException();
            }
            LOGGER.info("car Run WHILE end.. vehicleState: " + vehicleState);
        }
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                "} " ;
    }
}
