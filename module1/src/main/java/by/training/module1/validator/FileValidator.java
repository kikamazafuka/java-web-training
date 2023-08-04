package by.training.module1.validator;

import by.training.module1.parser.DataReader;
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

            vr.addErrorMsg("104", "File not found");
            LOGGER.error("File not found");
        }
        if(file.length() == 0){
            vr.addErrorMsg("105", "File is empty.");
            return vr;
        }
        
        return vr;
    }
}
