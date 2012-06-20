package lemon.tool.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import lemon.tool.validation.violation.ViolationCheckPoints;

/**
 * you can give a pattern as the constraint for one field.
 * it uses {@link StringPattern} to keep bean validated.
 * @author 28851451
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@CheckPoints(ViolationCheckPoints.STRING_PATTERN)
public @interface StringPattern {
    public String value();
    public String message() default "property [{0}] is not following the pattern.";
}
