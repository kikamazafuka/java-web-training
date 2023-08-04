package by.training.module4.builder;

import by.training.module4.model.Car;
import by.training.module4.model.Vehicle;
import by.training.module4.model.VehicleType;
import org.apache.log4j.Logger;

import java.util.Map;

public class CarBuilder implements VehicleBuilder {
    private static Logger LOGGER = Logger.getLogger(CarBuilder.class);

    @Override
    public Vehicle build(Map<String, String> vehicleData) {
        LOGGER.info( "Building Map... "+"File " );
        int number = Integer.parseInt(vehicleData.get("number"));
        String name = vehicleData.get("name");
        int weight = Integer.parseInt(vehicleData.get("weight"));
        int seatNumber = Integer.parseInt(vehicleData.get("seatNumber"));
        VehicleType vehicleType = VehicleType.valueOf(vehicleData.get("type").toUpperCase());
        return new Car(number, weight,vehicleType,name,seatNumber);
    }
}
