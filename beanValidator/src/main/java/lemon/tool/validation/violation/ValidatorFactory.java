package lemon.tool.validation.violation;

import java.lang.annotation.Annotation;

import lemon.tool.validation.annotation.CheckPoints;

/**
 * the validation factory to create violation check points.
 * @author 28851451
 *
 */
public class ValidatorFactory {
    private ValidatorFactory() {}

    /**
     * find violation checkpoints by the annotation.
     * @param anno
     * @return
     */
    public static <T extends Annotation> IViolationCheck<T> findViolationCheckPoint(T anno) {
        if(null != anno) {
            CheckPoints cp = anno.annotationType().getAnnotation(CheckPoints.class);
            if(null != cp) {
                return (IViolationCheck<T>) createViolationCheck(cp.value()[0]);
            }
        }
        return null;
    }
    
    private static IViolationCheck<? extends Annotation> createViolationCheck(ViolationCheckPoints checkPoint) {
        switch (checkPoint) {
            case NOT_NULL:
                return new NullViolationCheck();
            case STRING_PATTERN:
                return new StringPatternViolationCheck();
        }
        return null;
    }
}
