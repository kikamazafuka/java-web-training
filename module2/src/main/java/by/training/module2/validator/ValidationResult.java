package by.training.module2.validator;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class ValidationResult {


    private Logger LOGGER = Logger.getLogger(ValidationResult.class);
    private Map<String, String> vResult = new HashMap<>();

    public ValidationResult() {

    }


    public Map<String, String> getvResult() {
        return vResult;
    }

    public boolean isValid() {
        LOGGER.info("Validation result, isValid");
        if (vResult.isEmpty()) {
            return true;
        }
        return false;
    }

    public void addErrorMsg(String key, String value) {
        vResult.put(key, value);
    }


}
