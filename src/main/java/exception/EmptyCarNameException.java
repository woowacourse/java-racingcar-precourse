package exception;

public class EmptyCarNameException extends InvalidInputException {

    @Override
    public String getMessage() {
        return "이름은 공백일 수 없다.";
    }
}
