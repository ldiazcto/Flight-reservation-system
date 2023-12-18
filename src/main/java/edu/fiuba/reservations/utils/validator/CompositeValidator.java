package edu.fiuba.reservations.utils.validator;

import edu.fiuba.reservations.utils.enums.Exception;
import java.util.ArrayList;
import java.util.List;

public final class CompositeValidator<T> implements Validator<T> {
    private final List<Validator<T>> validators;

    public CompositeValidator(List<Validator<T>> validators) {
        this.validators = validators;
    }

    public List<Exception> validate(T data, List<String> fieldNames) {
        ArrayList<Exception> exceptions = new ArrayList();

        validators.forEach(validator ->
            exceptions.addAll(validator.validate(data, fieldNames))
        );

        return exceptions;
    }
}
