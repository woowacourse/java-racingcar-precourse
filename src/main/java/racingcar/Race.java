package racingcar;

import java.util.Scanner;

public class Race {
    private final Scanner scanner;

    public Race(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        nameInput();
        attemptNumberInput();
        carsMoveProcess();
        printWinner();
    }


}
