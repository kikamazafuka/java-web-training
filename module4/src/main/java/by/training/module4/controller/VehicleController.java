package by.training.module4.controller;

import by.training.module4.builder.VehicleBuilder;
import by.training.module4.builder.VehicleBuilderFactory;
import by.training.module4.model.Vehicle;
import by.training.module4.model.VehicleType;
import by.training.module4.parser.DataReader;
import by.training.module4.parser.LineParser;
import by.training.module4.validator.FileValidator;
import by.training.module4.validator.ValidationResult;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VehicleController {
    private static Logger LOGGER = Logger.getLogger(VehicleController.class);

    private FileValidator fileValidator;
    private DataReader dataReader;
    private LineParser parser;
    private VehicleBuilderFactory vehicleBuilderFactory;

    public VehicleController(FileValidator fileValidator, DataReader dataReader,
                             LineParser parser, VehicleBuilderFactory vehicleBuilderFactory) {
        this.fileValidator = fileValidator;
        this.dataReader = dataReader;
        this.parser = parser;
        this.vehicleBuilderFactory = vehicleBuilderFactory;
    }

    public List<Vehicle> readVehicles(String path) {
        ValidationResult vr = fileValidator.validateFile(path);

        if (!vr.isValid()) {
            LOGGER.error("File " + path + " is not valid");
        }
        LOGGER.info("File " + path + " is valid");
        List<String> vehicleList = dataReader.getData(path);
        LOGGER.info( "End of reading data "+"File " + path+" vehicle list "+ vehicleList.size());

        List<Vehicle> vehicles = new ArrayList<>();

        for (String vehicle : vehicleList) {
            Map<String, String> vehicleMap = parser.parseLine(vehicle);
            LOGGER.info( "Building Map... "+"File " + path +" \n" + "map size "+vehicleMap.size()
                    + vehicleMap.keySet()+" get type "+ vehicleMap.get("type")
                    +" \ncantains key " + vehicleMap.containsKey("type")
                    +" cantains value " + vehicleMap.containsValue("CAR") + ""+ vehicleMap.values() );
            VehicleType vehicleType = vehicleBuilderFactory.getVehicleType(vehicleMap);
            VehicleBuilder builder = vehicleBuilderFactory.createVehicle(vehicleType);
            vehicles.add(builder.build(vehicleMap));
        }
        return vehicles;
    }
}
