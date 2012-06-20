package lemon.tool.validation.violation;

import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lemon.tool.validation.annotation.StringPattern;
import lemon.tool.validation.exception.CTDataValidationException;

/**
 * check the {@link StringPattern} constraint.
 * @author 28851451
 *
 */
public class StringPatternViolationCheck implements IViolationCheck<StringPattern>{

    public void check(String methodName, Object PropertyValue, StringPattern annotation) throws CTDataValidationException {
       if(null != PropertyValue) {
           if (!(PropertyValue instanceof String)) {
               return ;
           }
            String str = (String) PropertyValue;
            Pattern pattern = Pattern.compile(annotation.value());
            Matcher matcher = pattern.matcher(str);
            if(!matcher.matches()) {
                throw new CTDataValidationException(MessageFormat.format(annotation.message(), methodName));
            }
        }
    }

}
