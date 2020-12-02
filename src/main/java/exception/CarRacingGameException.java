package exception;

public class CarRacingGameException extends IllegalArgumentException {

    private final String errorHeader = "[ERROR] ";

    public String getErrorHeader() {
        return errorHeader;
    }
}
