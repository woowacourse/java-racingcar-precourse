package exception;

public class MoveCountNotIntegerException extends IllegalArgumentException {
    public MoveCountNotIntegerException() {
        System.out.println("[Error] 시도 횟수는 숫자여야 한다.");
    }
}
