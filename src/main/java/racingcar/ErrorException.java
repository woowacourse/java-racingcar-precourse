package racingcar;

public class ErrorException extends IllegalArgumentException {

    private static final String EXCEPTION_PRIFIX = "[ERROR]";

    public ErrorException(String message){
        super(EXCEPTION_PRIFIX + message);
    }


}
