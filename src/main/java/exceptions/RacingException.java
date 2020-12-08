package exceptions;

public class RacingException extends Exception {
    private final String ERROR_MESSAGE = "[ERROR] ";

    public RacingException (String msg) {
        System.out.println(ERROR_MESSAGE + msg);
    }
}
