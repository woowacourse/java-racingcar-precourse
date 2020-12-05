package exception;

public class InvalidInputException extends RuntimeException {

    private final String HEADER = "[ERROR] ";

    public String getHEADER() {
        return HEADER;
    }
}

