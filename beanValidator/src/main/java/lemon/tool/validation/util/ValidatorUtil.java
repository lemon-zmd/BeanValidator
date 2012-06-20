package lemon.tool.validation.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import lemon.tool.validation.exception.CTDataValidationException;
import lemon.tool.validation.violation.IViolationCheck;
import lemon.tool.validation.violation.ValidatorFactory;

/**
 * the validate utility class.
 * it will validate whether the all of the object's field follows the rule.
 * @author 28851451
 *
 */
public class ValidatorUtil {

    private ValidatorUtil() {}

    /**
     * validate the object to see if there is any violation.
     * @param obj the object we need validate.
     * @throws CTDataValidationException if any field violate it's constraint.
     */
    public static <T> void  validate(T obj) throws CTDataValidationException {
        try {
            BeanInfo bi = Introspector.getBeanInfo(obj.getClass(), Object.class);
            PropertyDescriptor[] pds = bi.getPropertyDescriptors();
            for (PropertyDescriptor pd : pds) {
                validate(pd, obj);
            }
//            MethodDescriptor[] mds = bi.getMethodDescriptors();
//            for(MethodDescriptor md : mds) {
//                Method method = md.getMethod();
//                if(method.getParameterTypes().length == 0 && method.getAnnotations().length > 0) {
//                    validate(md, obj);
//                }
//            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * validate the getter method for the field.
     * @param md
     * @param obj
     * @throws CTDataValidationException
     */
    @Deprecated
    private static boolean validate(MethodDescriptor md, Object obj) throws CTDataValidationException {
        // get the method.
        Method method = md.getMethod();
        if (method.getParameterAnnotations().length > 0 ){
            return true;
        }
        if(null != method && method.getAnnotations().length > 0) {// ignore if the method has no annotation.
            try {
                // obtain the value by call the getter method.
                Object fieldValue = method.invoke(obj, null);
                for(Annotation ano : method.getAnnotations()) {
                    // create the violation checkpoint by the annotation.
                    IViolationCheck<Annotation> check = ValidatorFactory.findViolationCheckPoint(ano);
                    //do the check to see if it violate something.
                    if(null != check) {
                        check.check(md.getDisplayName(), fieldValue, ano);
                    }
                }
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        
        return true;
    }

    /**
     * validate the property.
     * @param pd the property to be validated.
     * @param obj the whole object.
     * @return 
     * @throws CTDataValidationException if the field is not following any constraint.
     */
    private static <T> void validate(PropertyDescriptor pd, T obj) throws CTDataValidationException {
        // get field name.
        String fieldName = pd.getName();
        if(null != fieldName) {
            try {
                // obtain the value by call its getter method.
                Object fieldValue = pd.getReadMethod().invoke(obj, null);
                Field field = findField(obj.getClass(), fieldName);
                if (null != field && field.getAnnotations().length > 0) {
                    // loop the annotations for the field.
                    for (Annotation ano : field.getAnnotations()) {
                        // create the violation checkpoint by the annotation.
                        IViolationCheck<Annotation> check = ValidatorFactory.findViolationCheckPoint(ano);
                        // do the check to see if it violate something.
                        check.check(fieldName, fieldValue, ano);
                    }
                }
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * find the field by the field name.
     * if not found , search its super class until the {@link Object} class.
     * @param clazz
     * @param fieldName
     * @return
     * @throws SecurityException
     * @throws NoSuchFieldException
     */
    private static Field findField(Class<?> clazz, String fieldName) throws SecurityException, NoSuchFieldException {
        while(clazz != Object.class) {
            for (Field field : clazz.getDeclaredFields()) {
                if(fieldName.equals(field.getName())) {
                    return field;
                }
            }
            clazz = clazz.getSuperclass();
        }
        return null;
    }

}
