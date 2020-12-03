package view;

import java.util.Scanner;

public class ConsoleView {
    public static final String ERROR_INPUT_MUST_DIGIT_MSG = "[ERROR] 시도 횟수는 숫자여야 한다.";
    private final Scanner scanner;

    public ConsoleView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void println(String message) {
        System.out.println(message);
    }

    public String inputNextLine() {
        return scanner.nextLine();
    }

    public int inputNextInt() {
        try {
            return Integer.parseInt(inputNextLine());
        } catch (java.lang.NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INPUT_MUST_DIGIT_MSG);
        }
    }
}
