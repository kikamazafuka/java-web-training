package by.training.module4.builder;

import by.training.module4.model.VehicleType;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.Optional;

public class VehicleBuilderFactory {
    private static final Logger LOGGER = Logger.getLogger(VehicleBuilderFactory.class);


    public VehicleBuilder createVehicle(VehicleType vehicleType){
        LOGGER.info("Create vehicle...");
        switch (vehicleType){
            case CAR: return new CarBuilder();
            case TRUCK: return new TruckBuilder();
            default: {
                LOGGER.error("VehicleBuilderFactory exception");
                throw new IllegalArgumentException();
            }

        }
    }
    public VehicleType getVehicleType(Map<String,String> data) {
        String typeStr = data.get("type");
        Optional<VehicleType> type = VehicleType.fromString(typeStr);
        return type.get();
    }
}
