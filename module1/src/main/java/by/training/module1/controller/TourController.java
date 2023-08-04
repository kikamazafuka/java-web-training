package by.training.module1.controller;

import by.training.module1.builder.Builder;
import by.training.module1.entity.Tour;
import by.training.module1.builder.TourBuilderFactory;
import by.training.module1.entity.TourType;
import by.training.module1.parser.DataReader;
import by.training.module1.parser.LineParser;
import by.training.module1.service.SortByPrice;
import by.training.module1.service.TourOfferService;
import by.training.module1.validator.FileValidator;
import by.training.module1.validator.TourValidator;
import by.training.module1.validator.TourValidatorFactory;
import by.training.module1.validator.ValidationResult;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class TourController {


    private TourOfferService service;
    private FileValidator fileValidator;
    private DataReader reader;
    private LineParser parser;
    private TourValidatorFactory validatorFactory;
    private TourBuilderFactory builderFactory;

    private Logger LOGGER = Logger.getLogger(TourController.class);

    public TourController(TourOfferService service, FileValidator fileValidator,
                          DataReader reader, LineParser parser,
                          TourValidatorFactory validatorFactory,
                          TourBuilderFactory builderFactory) {
        this.service = service;
        this.fileValidator = fileValidator;
        this.reader = reader;
        this.parser = parser;
        this.validatorFactory = validatorFactory;
        this.builderFactory = builderFactory;
    }

    public void readFile(String path) throws IOException {

        LOGGER.info("Reading File " + path);
        ValidationResult fileValidationResult = fileValidator.validateFile(path);

        if (fileValidationResult.isValid()) {
            List<String> fileLines = reader.getData(path);

            for (String line : fileLines) {
                Map<String, String> data = parser.parseLine(line);
                ValidationResult typeVR = TourValidator.validateTourType(data);

                if (typeVR.isValid()) {
                    TourType tourType = validatorFactory.getTourType(data);
                    Builder tourBuilder = builderFactory.createTour(tourType);
                    Tour tour = tourBuilder.build(data);
                    service.addTour(tour);

                    TourValidator validator = validatorFactory.getByType(tourType);
                    ValidationResult dataVR = validator.validate(data);
                    if (dataVR.isValid()) {
                        Builder tourBuilder1 = builderFactory.createTour(tourType);
                        Tour tour1 = tourBuilder1.build(data);
                        service.addTour(tour1);
                    } else {
                        LOGGER.info(" data " + dataVR);
                    }
                } else {
                    LOGGER.info("type "  +typeVR);
                }
            }
        } else {
            LOGGER.warn("File: "+ fileValidationResult);
        }
       }

    public List<Tour> getTour() {
        List<Tour> list = this.service.getTours();
        LOGGER.info("Method getTours: " + list);
        return list;
    }


    public List<Tour> sortByPrice() {
        Comparator<Tour> comparator = new SortByPrice();
        List<Tour> list = this.service.sortBy(comparator);
        for (Tour t : list) {
            LOGGER.info("Sorted by price: " + t);
        }
        return list;
    }
}
