package exception;

public class ZeroRoundException extends InvalidInputException {

    private final String MESSAGE = "시도 횟수는 1회 이상이어야 한다.";

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
