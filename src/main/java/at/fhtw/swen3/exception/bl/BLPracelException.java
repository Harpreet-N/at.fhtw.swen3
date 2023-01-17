package at.fhtw.swen3.exception.bl;

public class BLPracelException extends BLExceptionBase {
    public static final String ERROR_MESSAGE = "Invalid %s address: %s";

    public BLPracelException(String message) {
        super(String.format(ERROR_MESSAGE, message));
    }

}
