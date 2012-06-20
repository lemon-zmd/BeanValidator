package lemon.tool.validation.violation;

import java.text.MessageFormat;

import lemon.tool.validation.annotation.NotNull;
import lemon.tool.validation.exception.CTDataValidationException;

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
