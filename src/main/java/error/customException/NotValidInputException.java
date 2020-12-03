package error.customException;

public class NotValidInputException extends Exception {

    private static final String ERROR = "[ERROR] ";

    public NotValidInputException() {}
    public NotValidInputException(String message) {
        super(ERROR + message);
    }
}
