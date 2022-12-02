package racingcar.view;

public class OutputView {
    private final String ERROR_PREFIX = "[ERROR] ";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printErrorMessage(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

    public void printCurrent(String current) {
        System.out.println(current);
    }
}
