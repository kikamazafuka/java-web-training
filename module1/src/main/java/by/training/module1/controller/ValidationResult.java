package by.training.module1.controller;


import java.util.HashMap;
import java.util.Map;

public class ValidationResult {


    private Map<String, String> vResult = new HashMap<>();

    public ValidationResult() {

    }

  /*
    public ValidationResult(Map<String, String> vr) {
    this.vResult = vr;
    }
    */

    public Map<String, String> getvResult() {
        return vResult;
    }

    public boolean isValid() {
        if (vResult == null) {
            return true;
        }
        return false;
    }

    public void setValidationResult(String key, String value) {
        vResult.put(key, value);
    }


}
