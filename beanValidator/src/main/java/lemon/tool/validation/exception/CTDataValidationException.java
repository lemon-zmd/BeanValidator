package lemon.tool.validation.exception;

/**
 * this is the data validation exception.
 * it will be thrown once any of field violates it's check point.
 * @author 28851451
 *
 */
public class CTDataValidationException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = -2755053318356671505L;

    /**
     * the error cause.
     */
    private String errorMessage;


    public CTDataValidationException(String errMsg) {
        super(errMsg);
        this.errorMessage = errMsg;
    }

    /**
     * return the formated error cause.
     */
    public String toString() {
        return errorMessage;
    }

}
