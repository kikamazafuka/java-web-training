package by.training.module1.validator;

import java.util.Map;

public class ExcursionTourValidator extends TourValidator{
    private static final String EXCURSION_TYPE_KEY = "excursion";

    /* Some code */

    @Override
    public ValidationResult validate(Map<String,String> data){
        ValidationResult vr = super.validate(data);
        String type = data.get(EXCURSION_TYPE_KEY);
        if (type == null){
            vr.addErrorMsg(EXCURSION_TYPE_KEY, "Type error");
        }

        /*Some code*/

        return vr;
    }
}
