package exception;

public class InvalidCarNameException extends InvalidInputException {

    @Override
    public String getMessage() {
        return "이름은 5자 이하만 가능하다.";
    }
}
