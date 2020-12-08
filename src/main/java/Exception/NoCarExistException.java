package Exception;

public class NoCarExistException extends Exception{
    private static final String ERROR_TAG = "[Error]";
    private static final String INVAlID_INPUT_MESSAGE = "You should input at least one car name";

    public NoCarExistException() {
        super(ERROR_TAG + INVAlID_INPUT_MESSAGE);
    }
}
