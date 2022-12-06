package uaemex.ia.exception;

public class AgenteException  extends Exception{
    public AgenteException(){}

    public AgenteException(String message){
        super(message);
    }

    public AgenteException(String message, Throwable cause) {
        super(message, cause);
    }

    public AgenteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
