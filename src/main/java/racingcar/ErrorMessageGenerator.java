package racingcar;

public class ErrorMessageGenerator {
    private static final String format = "[ERROR] %s";

    public static String generateErrorMessage(String message) {
        return String.format(format, message);
    }
}
