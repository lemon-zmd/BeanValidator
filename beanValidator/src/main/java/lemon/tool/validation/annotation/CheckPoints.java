package lemon.tool.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import lemon.tool.validation.violation.ViolationCheckPoints;

/**
 * the check points annotation.
 * it is annotation type, points out the related violation check we want to use.
 * @author 28851451
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface CheckPoints {
    public ViolationCheckPoints[] value();
}
