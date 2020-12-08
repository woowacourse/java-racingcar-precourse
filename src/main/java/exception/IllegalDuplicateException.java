package exception;

public class IllegalDuplicateException extends IllegalArgumentException {
    private static final String message = "[ERROR] 자동차 이름은 중복될 수 없습니다.";

    public IllegalDuplicateException() {
        super(message);
        System.out.println(message);
    }
}
