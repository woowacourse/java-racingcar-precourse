package Exception;

public class RoundNumTypeException extends Exception{
    private static final String ERROR_TAG = "[Error]";
    private static final String TYPE_NOT_NUM = " 시도 횟수는 숫자여야 한다.";

    public RoundNumTypeException() {
        super(ERROR_TAG + TYPE_NOT_NUM);
    }
}
