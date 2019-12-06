package exception;

public class InvalidInputException extends IllegalArgumentException {

    public InvalidInputException() {
        super();
    }

    public InvalidInputException(String errorMessage) {
        super(errorMessage);
    }
}
