package exceptions;

public class InvalidInputException extends IllegalArgumentException {

    private static final String HEADER = "[ERROR] ";
    private String message = null;

    public InvalidInputException() {
        super();
    }

    public InvalidInputException(String s) {
        message = s;
    }

    @Override
    public String getMessage() {
        return HEADER + message;
    }
}
