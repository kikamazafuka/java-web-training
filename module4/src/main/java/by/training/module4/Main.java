package by.training.module4;

import by.training.module4.builder.FerryBuilder;
import by.training.module4.builder.VehicleBuilderFactory;
import by.training.module4.controller.FerryController;
import by.training.module4.controller.VehicleController;
import by.training.module4.model.Vehicle;
import by.training.module4.model.Ferry2;
import by.training.module4.parser.DataReader;
import by.training.module4.parser.LineParser;
import by.training.module4.validator.FileValidator;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final String VEHICLE_PATH = "vehicles.txt";
    private static final String FERRY_PATH= "ferry.txt";
    private static final Logger LOGGER = Logger.getLogger(Main.class);


    public static void main(String[] args) throws InterruptedException {

        FileValidator fileValidator = new FileValidator();
        DataReader reader = new DataReader();
        LineParser parser = new LineParser();
        VehicleBuilderFactory vehicleBuilderFactory = new VehicleBuilderFactory();
        FerryBuilder ferryBuilder = new FerryBuilder();
        VehicleController vehicleController = new VehicleController(fileValidator, reader, parser, vehicleBuilderFactory);
        FerryController ferryController = new FerryController(fileValidator, reader, parser, ferryBuilder);
        ClassLoader classLoader = Main.class.getClassLoader();
        String carsPath = new File(classLoader.getResource(VEHICLE_PATH).getFile()).getAbsolutePath();
        String ferryPath = new File(classLoader.getResource(FERRY_PATH).getFile()).getAbsolutePath();
        List<Vehicle> vehicles = vehicleController.readVehicles(carsPath);

        Ferry2 ferry = ferryController.readFerry(ferryPath);

        ferry.start();

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (Vehicle vehicle : vehicles) {
            vehicle.setFerry(ferry);
            executorService.submit(vehicle);
        }

        executorService.shutdown();
    }
}
