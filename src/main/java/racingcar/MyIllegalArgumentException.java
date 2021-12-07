package racingcar;

public class MyIllegalArgumentException extends IllegalArgumentException {
    public MyIllegalArgumentException(String message) {
        super(String.format("[ERROR] %s", message));
    }
}
