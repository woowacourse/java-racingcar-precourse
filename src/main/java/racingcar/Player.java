package racingcar;

import java.util.Scanner;

public class Player {
    private final Scanner scanner;
    private String carName;
    private String tryNumber;

    public Player(Scanner scanner) {
        this.scanner = scanner;
        this.carName = "";
        this.tryNumber = "";
    }

    public String inputCarName() {
        carName = scanner.nextLine();
        return carName;
    }

    public String inputTryNumber() {
        tryNumber = scanner.nextLine();
        return tryNumber;
    }
}
