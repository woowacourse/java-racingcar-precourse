package utils;

public class EmptyCarException extends RuntimeException{
    private static final String MESSAGE = "[ERROR] 참가한 Car 가 없습니다.";

    public EmptyCarException() {
        super(MESSAGE);
    }

    public EmptyCarException(String message) {
        super(message);
    }
}
