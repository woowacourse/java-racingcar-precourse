package exception;

public class IllegalLengthException extends IllegalArgumentException {

    private static final String message = "[ERROR] 자동차 이름의 길이는 5자 이하만 가능합니다.";

    public IllegalLengthException() {
        super(message);
        System.out.println(message);
    }
}
