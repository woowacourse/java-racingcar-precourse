package exceptions;

public class InvalidInputException extends IllegalArgumentException {

    private static final String HEADER = "[ERROR] ";
    private static final String MESSAGE = "";

    public InvalidInputException() {
        super();
    }

    public InvalidInputException(String s) {
        super(s);
    }

    @Override
    public String getMessage() {
        return HEADER + MESSAGE;
    }
}
