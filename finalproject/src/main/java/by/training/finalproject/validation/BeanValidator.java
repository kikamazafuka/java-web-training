package by.training.finalproject.validation;

import lombok.extern.log4j.Log4j;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Log4j
public abstract class BeanValidator<T> {

    private Validator validator;
    protected Set<ConstraintViolation<T>> constraintViolations;

    protected BeanValidator() {
        this.validator= Validation.buildDefaultValidatorFactory().getValidator();
    }

    public final boolean validate(T t) {
        constraintViolations = validator.validate(t);
        return constraintViolations.isEmpty();
    }

    public final List<String> getConstraintViolations() {
        List<String> violations = new ArrayList<String>();
        for (ConstraintViolation<T> violation : constraintViolations ) {
            violations.add(violation.getMessage());
        }
        return violations;
    }
}
