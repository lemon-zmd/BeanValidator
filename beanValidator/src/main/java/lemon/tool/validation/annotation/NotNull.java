package lemon.tool.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import lemon.tool.validation.violation.NullViolationCheck;
import lemon.tool.validation.violation.ViolationCheckPoints;


/**
 * the not null annotation.
 * it uses {@link NullViolationCheck} to keep bean validated.
 * @author 28851451
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@CheckPoints(ViolationCheckPoints.NOT_NULL)
public @interface NotNull {
    String message() default "property [{0}] is not allowed to be NULL.";
}
