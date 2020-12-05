package exceptions.customExceptions;

public class NotValidInputException extends IllegalArgumentException {

    private static final String ERROR = "[ERROR] ";

    public NotValidInputException() {}
    public NotValidInputException(String message) {
        super(ERROR + message);
    }
}
