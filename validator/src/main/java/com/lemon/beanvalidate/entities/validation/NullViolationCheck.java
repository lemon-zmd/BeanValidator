package com.sony.cloudtest.entities.validation;

import java.text.MessageFormat;

import com.sony.cloudtest.entities.annotation.NotNull;
import com.sony.cloudtest.entities.exception.CTDataValidationException;

/**
 * check the {@link NotNull} constraint.
 * @author 28851451
 *
 */
public class NullViolationCheck implements IViolationCheck<NotNull>{

    public void check(String methodName, Object propertyValue, NotNull annotation) throws CTDataValidationException {
        if(null == propertyValue) {
            throw new CTDataValidationException(MessageFormat.format(annotation.message(), methodName));
        }
    }

}
