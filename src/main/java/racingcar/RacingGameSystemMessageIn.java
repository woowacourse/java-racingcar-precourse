package racingcar;

import java.util.Scanner;

public class RacingGameSystemMessageIn {

    private final Scanner scanner;

    public RacingGameSystemMessageIn(final Scanner scanner) {
        this.scanner = scanner;
    }

    public String submitCarNames() {
        return scanner.nextLine();
    }

    public String submitTimes() {
        return scanner.nextLine();
    }
}
