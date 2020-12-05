package exception;

public class EmptyCarNameException extends InvalidInputException {

    private final String MESSAGE = "이름은 공백일 수 없다.";

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
