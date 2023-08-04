package by.training.module1.controller;

import org.apache.log4j.Logger;

import java.io.File;

public class FileValidator {


    private static final Logger LOGGER = Logger.getLogger(DataReader.class);

    public ValidationResult validateFile(String path) {
        ValidationResult vr = new ValidationResult();
        File file = new File(path);
        if (file.exists()) {
            LOGGER.info("File exist");
        } else {

            vr.setValidationResult("404", "File not found");
            LOGGER.info("File not found");
        }
        
        return vr;
    }
}
