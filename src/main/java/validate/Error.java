package validate;

/**
 * @author yhh1056
 * @since 2020/12/06
 */
public abstract class Error {
    private static final String ERROR = "[ERROR] ";

    public void throwMessage(String exceptionMessage) {
        throw new IllegalArgumentException(ERROR + exceptionMessage);
    }
}
