package exception;

public class MoveCountNotOverZeroException extends IllegalArgumentException{
    public MoveCountNotOverZeroException() {
        System.out.println("[Error] 시도 횟수는 0 이상 숫자여야 한다.");
    }
}
