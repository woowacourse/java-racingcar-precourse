package racingcar;

import java.util.Scanner;

public class Player {

    private final Scanner scanner;

    public Player(final Scanner scanner) {
        this.scanner = scanner;
    }

    public String getInput() {
        return scanner.nextLine();
    }

}
