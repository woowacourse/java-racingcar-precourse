package racingcar.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputCarNames() {
        return scanner.nextLine();
    }

    public String inputAttemptNumber() {
        return scanner.nextLine();
    }
}

