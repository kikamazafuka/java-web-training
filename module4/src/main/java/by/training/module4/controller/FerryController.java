package by.training.module4.controller;

import by.training.module4.builder.FerryBuilder;
import by.training.module4.model.Ferry2;
import by.training.module4.parser.DataReader;
import by.training.module4.parser.LineParser;
import by.training.module4.validator.FileValidator;
import by.training.module4.validator.ValidationResult;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

public class FerryController {
    private static Logger LOGGER = Logger.getLogger(FerryController.class);

    private FileValidator fileValidator;
    private DataReader reader;
    private LineParser parser;
    private FerryBuilder ferryBuilder;

    public FerryController(FileValidator fileValidator, DataReader reader, LineParser parser, FerryBuilder ferryBuilder) {
        this.fileValidator = fileValidator;
        this.reader = reader;
        this.parser = parser;
        this.ferryBuilder = ferryBuilder;
    }

    public Ferry2 readFerry(String path) {
        ValidationResult vr = fileValidator.validateFile(path);

        if (!vr.isValid()) {
            LOGGER.error("File " + path + " is not valid");
        }

        List<String> ferryStringList = reader.getData(path);

        Map<String, String> ferryMap = parser.parseLine(ferryStringList.get(0));
        return ferryBuilder.buildFerry(ferryMap);

    }
}
