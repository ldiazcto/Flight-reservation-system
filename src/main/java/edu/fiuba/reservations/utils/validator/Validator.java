package edu.fiuba.reservations.utils.validator;

import edu.fiuba.reservations.utils.enums.Exception;

import java.util.List;

public interface Validator<T> {
    List<Exception> validate(T data, List<String> fieldNames);
}
