package exception;

public class NonNumberRoundException extends InvalidInputException {

    private final String MESSAGE = "시도 횟수는 숫자여야 한다.";

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
