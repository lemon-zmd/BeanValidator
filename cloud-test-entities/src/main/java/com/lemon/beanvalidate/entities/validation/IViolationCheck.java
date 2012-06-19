package com.sony.cloudtest.entities.validation;

import java.lang.annotation.Annotation;
import com.sony.cloudtest.entities.exception.CTDataValidationException;

/**
 * the violation check class.
 * it will check if the property followed its constraint.
 * @author 28851451
 *
 * @param <T>
 */
public interface IViolationCheck<T extends Annotation> {

    /**
     * check if the object violates the annotation's constraint.
     * @param propertyValue the property value.
     * @param annotation the associated annotation on the field.
     * @throws CTDataValidationException if any constraint is violated.
     */
    void check(String methodName, Object propertyValue, T annotation) throws CTDataValidationException;
}
