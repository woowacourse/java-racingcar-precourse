package exceptions;

public class InvalidInputException extends IllegalArgumentException {

    private static final String HEADER = "[ERROR] ";
    private static final String MESSAGE = "";

    @Override
    public String getMessage() {
        return HEADER + MESSAGE;
    }
}
