package racingcar;

public class ErrorMessage {
    private ErrorMessage() {
    }

    public static String getMessage(String message) {
        return String.format("[ERROR] %s", message);
    }
}
